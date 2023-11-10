package com.projectname.trackingreserva.logic;

import com.projectname.trackingreserva.navigation.UIManager;
import com.projectname.trackingreserva.persistence.Persistence;
import com.projectname.trackingreserva.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.trackingreserva.services.ServiceManager;

public class Domain {

    private UIManager theUIManager;
    private Persistence thePersistence;

    public static void login(FormLoginVM newFormLoginVM) {
        ServiceManager.login(newFormLoginVM);
    }

    public static void trackingUser(String fechaDispositivo, String horaDispositivo, String userName, double latitud, double longitud, String estadoReserva) {
        ServiceManager.trackingUser(fechaDispositivo, horaDispositivo, userName, latitud, longitud, estadoReserva);
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
