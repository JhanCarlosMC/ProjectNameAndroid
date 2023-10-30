package com.projectname.applicationame.presentation.viewparts.trackingvp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.applicationame.databinding.TrackingFormBinding;
import com.projectname.applicationame.navigation.DesktopVP;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GPSTracking extends AppCompatActivity implements LocationListener {

    //Atributos de la actividad
    private TrackingFormBinding binding;
    public TextView labelGPS;

    //Elementos del GPS
    final String TAG = "GPS";
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;
    LocationManager locationManager;
    Location loc;

    boolean isGPS = false;
    boolean isNetwork = false;
    boolean canGetLocation = true;
    ArrayList<String> permissions = new ArrayList<>();
    ArrayList<String> permissionsToRequest;
    ArrayList<String> permissionsRejected = new ArrayList<>();

    private Handler handler = new Handler();
    private int intervalo = 5000; // Intervalo de tiempo en milisegundos (1 segundo en este caso)
    private Runnable runnable;

    private static final int PERMISSION_REQUEST_CODE = 123;

    double latitud;
    double longitud;

    String horaDispositivo;
    String fechaDispositivo;
    String nombreUsuarioLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate
        binding = TrackingFormBinding.inflate(getLayoutInflater());
        View rootSecond = binding.getRoot();
        setContentView(rootSecond);

        // Verificar y solicitar permisos si es necesario
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION},
                    PERMISSION_REQUEST_CODE);
        }

        //Obtener informacion de la actividad anterior
        Intent intent = getIntent();

                // Comprobar si la intención contiene datos extras (extras)
        if (intent.hasExtra("editTextValue")) {
                // Obtener el valor del EditText de la Activity anterior
            nombreUsuarioLogin = intent.getStringExtra("editTextValue");
        }

        //Accion del button ---> para ejecutar el metodo de captura de ubicacion
        binding.buttonTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ejecutar obtner ubicacion una vez
                initGPS();

                // Obtener Fecha y Hora
                obtenerDate();

                String estadoReserva = "Solicitada";
                DesktopVP.trackingUser(fechaDispositivo, horaDispositivo, nombreUsuarioLogin, latitud, longitud, estadoReserva);
            }
        });

    }

    private void obtenerDate() {
        // Obtener la fecha y hora actual
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        // Formatear la fecha y hora en un formato deseado
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        horaDispositivo = hora.format(date);
        fechaDispositivo = fecha.format(date);
    }

    private void initGPS() {
        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        isGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (!isGPS && !isNetwork) {
            Log.d(TAG, "Connection off");
            showSettingsAlert();
            getLastLocation();
        } else {
            //Log.d(TAG, "Connection on");
            // check permissions
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (permissionsToRequest.size() > 0) {
                    requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                            ALL_PERMISSIONS_RESULT);
                    Log.d(TAG, "Permission requests");
                    canGetLocation = false;
                }
            }
            // get location
            getLocation();
        }
    }

    private void getLocation() {
        try {
            if (canGetLocation) {
                // getting network status
                boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                //Log.d(TAG, "Can get location");
                if (isGPS) {
                    // from GPS
                    //Log.d(TAG, "GPS on");
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                    if (locationManager != null) {
                        loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (loc != null) {
                            updateUI(loc);
                            return;
                        }

                    }
                }
                if (loc == null && isNetwork) {
                    // from Network Provider
                    Log.d(TAG, "NETWORK_PROVIDER on");
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

                    if (locationManager != null) {
                        loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (loc != null)
                            updateUI(loc);
                    }
                }
                if (loc == null) {

                    updateUI(loc);
                }
            } else {
                Log.d(TAG, "Can't get location");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private void updateUI(Location loc) {
        //Log.d(TAG, "updateUI");
        labelGPS = binding.textviewTracking;
        labelGPS.setText(obtenerDireccion(loc));
    }

    private String obtenerDireccion(Location loc) {
        String lugar = "No disponible";


        if (loc != null) {

            latitud = loc.getLatitude();
            longitud = loc.getLongitude();
//es_CO
            Locale locale;
            locale = Locale.forLanguageTag("es_CO");
//            String pais = "";
//            String departamento = "";
//            String ciudad = "";
//            String calle = "";
            Address returnedAddress;

            Geocoder geocoder = new Geocoder(this, locale);
            try {
                List<Address> addresses = geocoder.getFromLocation(latitud, longitud, 1);

                if (addresses != null) {
                    returnedAddress = addresses.get(0);
                    StringBuilder strReturnedAddress = new StringBuilder("Address:\n");

                    returnedAddress.getAddressLine(0);
                    String lugarAux = returnedAddress.getAddressLine(0);


                    if (lugarAux.isEmpty()) {
                        lugar = "No disponible";
                    } else {
                        lugar = lugarAux;
                    }

                } else {
                    lugar = "Lat:" + loc.getLatitude() + ", Long:" + loc.getLongitude();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                lugar = "Lat:" + loc.getLatitude() + ", Long:" + loc.getLongitude();

            }

            String latitude = String.valueOf(loc.getLatitude());
            Log.e(TAG, "---------------------------------------------Actualizacion GPS------------------------------------------- ");
            Log.e(TAG, "obtenerDireccion: " + latitud);
            Log.e(TAG, "obtenerDireccion: " + longitud);

        }

        Log.e(TAG, "obtenerDireccion: " + lugar);

        return lugar;
    }

    private void getLastLocation() {
        try {
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, false);
            if (provider != null) {
                Location location = locationManager.getLastKnownLocation(provider);
                Log.d(TAG, provider);
                Log.d(TAG, location == null ? "NO LastLocation" : location.toString());

            }

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("GPS is not Enabled!");
        alertDialog.setMessage("Do you want to turn on GPS?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @Override
    public void onLocationChanged(Location location) {
        //Log.d(TAG, "onLocationChanged");
        updateUI(location);
    }

    @Override
    public void onProviderEnabled(String s) {
        getLocation();
    }

    @Override
    public void onProviderDisabled(String s) {
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }
}
