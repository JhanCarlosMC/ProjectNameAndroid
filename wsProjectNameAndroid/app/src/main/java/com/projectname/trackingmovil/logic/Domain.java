package com.projectname.trackingmovil.logic;

import com.projectname.trackingmovil.navigation.UIManager;
import com.projectname.trackingmovil.persistence.Persistence;
import com.projectname.trackingmovil.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.trackingmovil.services.ServiceManager;

public class Domain {

    private UIManager theUIManager;
    private Persistence thePersistence;

    public static void login(FormLoginVM newFormLoginVM) {
        ServiceManager.login(newFormLoginVM);
    }

    public static void tracking(String fechaDispositivo, String horaDispositivo, String movil, double latitud, double longitud) {
        ServiceManager.tracking(fechaDispositivo, horaDispositivo, movil, latitud, longitud);
    }

    public UIManager getTheUIManager() {
        return theUIManager;
    }

    public void setTheUIManager(UIManager theUIManager) {
        this.theUIManager = theUIManager;
    }

    public Persistence getThePersistence() {
        return thePersistence;
    }

    public void setThePersistence(Persistence thePersistence) {
        this.thePersistence = thePersistence;
    }
}
