package com.projectname.applicationame.logic;

import com.projectname.applicationame.navigation.UIManager;
import com.projectname.applicationame.persistence.Persistence;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.applicationame.services.ServiceManager;

public class Domain {

    private UIManager theUIManager;
    private Persistence thePersistence;

    public static void login(FormLoginVM newFormLoginVM) {
        ServiceManager.login(newFormLoginVM);
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
