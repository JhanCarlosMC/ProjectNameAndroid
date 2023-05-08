package com.projectname.applicationanme.kernel;

import com.projectname.applicationanme.navigation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP newViewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
