package com.projectname.trackingreserva.kernel;

import com.projectname.trackingreserva.navigation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP newViewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
