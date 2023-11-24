package com.projectname.appestructurada.presentation.viewparts.cnthomevp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.databinding.HomeBinding;
import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.navigation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cnthomevm.CntHomeVM;


public class CntHomeVP extends Fragment implements ViewVP {

    private HomeBinding bindingHome;
    private CntHomeVM cntHomeVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;

    /*Layouts Elements*/
    public TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bindingHome = HomeBinding.inflate(inflater, container, false);
        View root = bindingHome.getRoot();
        cntHomeVM = new ViewModelProvider(this).get(CntHomeVM.class);

        /*Carga de informacion desde la VM a la VP*/
        initComponents();

        // Ocultar la ActionBar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return root;
    }

    private void initComponents() {
        // Inicializar Widgets

        textView = bindingHome.textHome;
        cntHomeVM.getText().observe(getViewLifecycleOwner(), textView::setText);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bindingHome = null;
    }

    public APP getApp() {
        return app;
    }

    public void setApp(APP app) {
        this.app = app;
    }

    public ViewModel getTheViewModel() {
        return theViewModel;
    }

    public void setTheViewModel(ViewModel theViewModel) {
        this.theViewModel = theViewModel;
    }

    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    public String getIdViewPart() {
        return idViewPart;
    }

    public UIManager getUIManager() {
        theUIManager = app.getTheUIManager();
        return theUIManager;
    }
    @Override
    public void setOwnedByVP(DesktopVP desktopVP) {
        ownedByVP = desktopVP;
    }

    @Override
    public ViewVP getOwnedByVP() {
        return ownedByVP;
    }



}