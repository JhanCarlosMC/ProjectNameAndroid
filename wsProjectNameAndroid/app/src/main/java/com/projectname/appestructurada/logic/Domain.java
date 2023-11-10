package com.projectname.appestructurada.logic;

import com.projectname.appestructurada.navigation.UIManager;
import com.projectname.appestructurada.persistence.Persistence;
import com.projectname.appestructurada.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.appestructurada.services.ServiceManager;

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
