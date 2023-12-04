package com.projectname.appestructurada.domain;

import com.projectname.appestructurada.data.Kernel;
import com.projectname.appestructurada.presentation.UIManager;
import com.projectname.appestructurada.persistence.Persistence;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;

public class Domain {

    private UIManager theUIManager;
    private Persistence thePersistence;

    public static void login(CntLoginVM newCntLoginVM) {
        Kernel.login(newCntLoginVM);
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
