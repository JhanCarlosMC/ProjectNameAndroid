package com.projectname.appestructurada.client.presentation.viewparts.cnttiporesiduovp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.client.APP;
import com.projectname.appestructurada.databinding.ActivityTipoResiduoBinding;
import com.projectname.appestructurada.client.kernel.ViewVP;
import com.projectname.appestructurada.client.presentation.UIManager;
import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewmodels.cnttiporesiduovm.CntTipoResiduoVM;

public class CntTipoResiduoVP extends AppCompatActivity implements ViewVP {
    private ActivityTipoResiduoBinding bindingTipoResiduo;
    private CntTipoResiduoVM cntTipoResiduoVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;
    private View view;

    /*Layouts Elements*/
    public TextView labelTitleToolbar;
    public CheckBox labelCheckBoxEnvases;
    public CheckBox labelCheckBoxCarton;
    public CheckBox labelCheckBoxBolsas;
    public CheckBox labelCheckBoxElectronicos;
    public CheckBox labelCheckBoxBaterias;
    public CheckBox labelCheckBoxNeumaticos;
    public CheckBox labelCheckBoxMedicamentos;
    public CheckBox labelCheckBoxEscombros;
    public CheckBox labelCheckBoxVarios;
    public RelativeLayout imgBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingTipoResiduo = bindingTipoResiduo.inflate(getLayoutInflater());
        View root = bindingTipoResiduo.getRoot();
        setContentView(root);

        cntTipoResiduoVM = new ViewModelProvider(this).get(CntTipoResiduoVM.class);

        initComponents();
        settingEvents();

        // Ocultar la ActionBar
        getSupportActionBar().hide();
    }

    private void initComponents() {
        // Inicializar Widgets
        labelTitleToolbar = bindingTipoResiduo.txtTitleToolbar;
        cntTipoResiduoVM.getLabelTitleToolbar().observe(this, labelTitleToolbar::setText);

        labelCheckBoxCarton = bindingTipoResiduo.includeOptionCarton.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxCarton().observe(this,labelCheckBoxCarton::setText);

        labelCheckBoxEnvases = bindingTipoResiduo.includeOptionEnvases.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxEnvases().observe(this,labelCheckBoxEnvases::setText);

        labelCheckBoxBolsas = bindingTipoResiduo.includeOptionBolsas.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxBolsas().observe(this,labelCheckBoxBolsas::setText);

        labelCheckBoxElectronicos = bindingTipoResiduo.includeOptionElectronicos.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxElectronicos().observe(this,labelCheckBoxElectronicos::setText);

        labelCheckBoxBaterias = bindingTipoResiduo.includeOptionBaterias.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxBaterias().observe(this,labelCheckBoxBaterias::setText);

        labelCheckBoxNeumaticos = bindingTipoResiduo.includeOptionNeumaticos.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxNeumaticos().observe(this,labelCheckBoxNeumaticos::setText);

        labelCheckBoxMedicamentos = bindingTipoResiduo.includeOptionMedicamentos.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxMedicamentos().observe(this,labelCheckBoxMedicamentos::setText);

        labelCheckBoxEscombros = bindingTipoResiduo.includeOptionEscombros.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxEscombros().observe(this,labelCheckBoxEscombros::setText);

        labelCheckBoxVarios = bindingTipoResiduo.includeOptionVarios.cbxSelection;
        cntTipoResiduoVM.getLabelCheckBoxVarios().observe(this,labelCheckBoxVarios::setText);

        imgBack = bindingTipoResiduo.actionToolbarAtras;
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
