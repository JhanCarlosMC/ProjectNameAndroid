package com.projectname.applicationanme.presentation.viewparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.navigation.UIManager;

public class ViewPart {

    private static final AppCompatActivity ACTIVITY_EDEFAULT = null;
    private AppCompatActivity activity = ACTIVITY_EDEFAULT;

    private static final Fragment FRAGMENT_EDEFAULT = null;
    private Fragment fragment = FRAGMENT_EDEFAULT;

    private static final String ID_VIEW_PART_EDEFAULT = " ";

    private String idViewPart = ID_VIEW_PART_EDEFAULT;

    void setOwnedByVP(ViewPart newViewPart) {
    }

    ViewPart getOwnedByVP() {
        return null;
    }

    UIManager getUIManager() {
        return null;
    }


    private static final ViewVP VIEW_PART_EDEFAULT = null;
    private ViewVP viewPart = VIEW_PART_EDEFAULT;

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

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
