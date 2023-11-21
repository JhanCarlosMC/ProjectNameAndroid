package com.projectname.appestructurada.kernel;

import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.navigation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(DesktopVP desktopVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
