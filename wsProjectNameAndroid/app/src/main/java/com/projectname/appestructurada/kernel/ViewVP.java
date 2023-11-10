package com.projectname.appestructurada.kernel;

import com.projectname.appestructurada.navigation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP newViewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
