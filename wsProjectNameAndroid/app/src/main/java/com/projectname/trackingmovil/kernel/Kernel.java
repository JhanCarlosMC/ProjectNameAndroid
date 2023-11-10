package com.projectname.trackingmovil.kernel;

import com.projectname.trackingmovil.presentation.viewmodels.formloginvm.FormLoginVM;

public class Kernel {
    public static void login(FormLoginVM newFormLoginVM) {
       APIServerClientSide.login(newFormLoginVM);
    }

    public static void tracking(String fechaDispositivo, String horaDispositivo, String movil, double latitud, double longitud) {
        APIServerClientSide.tracking(fechaDispositivo, horaDispositivo, movil, latitud, longitud);
    }
}
