package com.projectname.applicationanme.logic;

import com.projectname.applicationanme.navigation.UIManager;
import com.projectname.applicationanme.persistence.Persistence;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.applicationanme.services.ServiceManager;

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
