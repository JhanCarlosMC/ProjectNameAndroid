package com.projectname.appestructurada.kernel;

import com.projectname.appestructurada.presentation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP viewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
