package com.projectname.appestructurada.data;

import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.presentation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(DesktopVP desktopVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
