package com.projectname.appestructurada.presentation.viewparts.cntinformacionadicionalvp;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.databinding.ActivityInformacionAdicionalBinding;
import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.presentation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntinformacionadicionalvm.CntInformacionAdicionalVM;

public class CntInformacionAdicionalVP extends AppCompatActivity implements ViewVP {

    private ActivityInformacionAdicionalBinding bindingInformacionAdicional;
    private CntInformacionAdicionalVM cntInformacionAdicionalVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;
    private View view;


    /*Layouts Elements*/
    public TextView labelTitleToolbar;
    public TextView labelUbicacionActual;
    public TextView labelFechaDenuncia;
    public TextView labelDescripcion;
    public TextView labelFotografia;
    public RelativeLayout imgBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingInformacionAdicional = bindingInformacionAdicional.inflate(getLayoutInflater());
        View root = bindingInformacionAdicional.getRoot();
        setContentView(root);

        cntInformacionAdicionalVM = new ViewModelProvider(this).get(CntInformacionAdicionalVM.class);

        initComponents();
        settingEvents();

        // Ocultar la ActionBar
        getSupportActionBar().hide();
    }

    private void initComponents() {
        // Inicializar Widgets
        labelTitleToolbar = bindingInformacionAdicional.txtTitleToolbar;
        cntInformacionAdicionalVM.getLabelTitleToolbar().observe(this, labelTitleToolbar::setText);

        labelUbicacionActual = bindingInformacionAdicional.txtCartTitleUbicacionActual;
        cntInformacionAdicionalVM.getLabelUbicacionActual().observe(this,labelUbicacionActual::setText);

        labelFechaDenuncia = bindingInformacionAdicional.txtCartTitleFechaActual;
        cntInformacionAdicionalVM.getLabelFechaDenuncia().observe(this,labelFechaDenuncia::setText);

        labelDescripcion = bindingInformacionAdicional.txtCartTitleDescripcion;
        cntInformacionAdicionalVM.getLabelDescripcion().observe(this,labelDescripcion::setText);

        labelFotografia = bindingInformacionAdicional.txtCartTitleFotografia;
        cntInformacionAdicionalVM.getLabelDescripcion().observe(this,labelFotografia::setText);

        imgBack = bindingInformacionAdicional.actionToolbarAtras;
    }

    public void settingEvents() {
        //Antiguo montarEventos()
        getImgBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getUIManager().navigationMachine("back");
    }

    @Override
    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    @Override
    public String getIdViewPart() {
        return idViewPart;
    }

    @Override
    public void setOwnedByVP(ViewVP viewVP) {
        ownedByVP = viewVP;
    }

    @Override
    public ViewVP getOwnedByVP() {
        return ownedByVP;
    }

    @Override
    public UIManager getUIManager() {
        theUIManager = app.getTheUIManager();
        return theUIManager;
    }
    public RelativeLayout getImgBack() {
        return imgBack;
    }
}
