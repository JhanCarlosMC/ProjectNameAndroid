package com.projectname.applicationanme.logic;

import com.projectname.applicationanme.navigation.UIManager;
import com.projectname.applicationanme.persistence.Persistence;

public class Domain {

    private UIManager theUIManager;
    private Persistence thePersistence;

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
