package com.projectname.appestructurada.client.kernel;

import com.projectname.appestructurada.client.presentation.UIManager;

public interface ViewVP {
    public void setIdViewPart(String newIdViewPart);

    public String getIdViewPart();

    void setOwnedByVP(ViewVP viewVP);

    ViewVP getOwnedByVP();

    UIManager getUIManager();
}
