package com.projectname.applicationame.presentation.viewparts;

import com.projectname.applicationame.kernel.ViewVP;

public class ViewPart {
    private String idViewPart = " ";
    private ViewVP viewPart = null;

    public ViewVP getViewPart() {
        return viewPart;
    }
    public void setViewPart(ViewVP viewPart) {
        this.viewPart = viewPart;
    }
    public String getIdViewPart() {
        return idViewPart;
    }
    public void setIdViewPart(String idViewPart) {
        this.idViewPart = idViewPart;
    }
}