package com.projectname.applicationame.kernel;

import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

public class Kernel {
    public static void login(FormLoginVM newFormLoginVM) {
       APIServerClientSide.login(newFormLoginVM);
    }

    public static void trackingUser(String fechaDispositivo, String horaDispositivo, String userName, double latitud, double longitud, String estadoReserva) {
        APIServerClientSide.trackingUser(fechaDispositivo, horaDispositivo, userName, latitud, longitud, estadoReserva);
    }
}
