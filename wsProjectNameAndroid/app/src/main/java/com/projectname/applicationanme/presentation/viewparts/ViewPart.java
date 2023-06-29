package com.projectname.applicationanme.presentation.viewparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.navigation.UIManager;

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