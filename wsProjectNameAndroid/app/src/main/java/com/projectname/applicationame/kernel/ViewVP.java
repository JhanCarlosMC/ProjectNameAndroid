package com.projectname.applicationame.kernel;

import com.projectname.applicationame.navigation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP newViewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
