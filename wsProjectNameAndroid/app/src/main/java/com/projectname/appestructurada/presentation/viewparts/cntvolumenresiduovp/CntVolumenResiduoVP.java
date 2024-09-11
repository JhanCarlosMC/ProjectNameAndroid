package com.projectname.appestructurada.presentation.viewparts.cntvolumenresiduovp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.databinding.ActivityVolumenResiduoBinding;
import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.presentation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntvolumenresiduovm.CntVolumenResiduoVM;

public class CntVolumenResiduoVP extends AppCompatActivity implements ViewVP {
    private ActivityVolumenResiduoBinding bindingVolumenResiduo;
    private CntVolumenResiduoVM cntVolumenResiduoVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;
    private View view;

    /*Layouts Elements*/
    public TextView labelTitleTollbar;
    public RadioButton labelRadioButtonMano;
    public RadioButton labelRadioButtonMochila;
    public RadioButton labelRadioButtonAutomovil;
    public RadioButton labelRadioButtonContenedor;
    public RadioButton labelRadioButtonCamion;
    public RadioButton labelRadioButtonMasGrande;
    public RelativeLayout imgBack;
    public RadioGroup listVolumenResiduo;

    //Propios
    int resourceRadioButton;
    RadioButton radioButtonSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingVolumenResiduo = bindingVolumenResiduo.inflate(getLayoutInflater());
        View root = bindingVolumenResiduo.getRoot();
        setContentView(root);

        cntVolumenResiduoVM = new ViewModelProvider(this).get(CntVolumenResiduoVM.class);

        initComponents();
        settingEvents();

        // Ocultar la ActionBar
        getSupportActionBar().hide();
    }

    private void initComponents() {
        // Inicializar Widgets
        labelTitleTollbar = bindingVolumenResiduo.txtTitleToolbar;
        cntVolumenResiduoVM.getLabelTitleTollbar().observe(this, labelTitleTollbar::setText);

        labelRadioButtonMano = bindingVolumenResiduo.includeOptionMano.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonMano().observe(this, labelRadioButtonMano::setText);

        labelRadioButtonMochila = bindingVolumenResiduo.includeOptionMochila.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonMochila().observe(this, labelRadioButtonMochila::setText);

        labelRadioButtonAutomovil = bindingVolumenResiduo.includeOptionAutomovil.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonAutomovil().observe(this, labelRadioButtonAutomovil::setText);

        labelRadioButtonContenedor = bindingVolumenResiduo.includeOptionContenedor.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonContenedor().observe(this, labelRadioButtonContenedor::setText);

        labelRadioButtonCamion = bindingVolumenResiduo.includeOptionCamion.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonCamion().observe(this, labelRadioButtonCamion::setText);

        labelRadioButtonMasGrande = bindingVolumenResiduo.includeOptionMasGrande.rbOption;
        cntVolumenResiduoVM.getLabelRadioButtonMasGrande().observe(this, labelRadioButtonMasGrande::setText);

        imgBack = bindingVolumenResiduo.actionToolbarAtras;
    }

    public void settingEvents() {
        //Antiguo montarEventos()
        getImgBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
/*
        getListVolumenResiduo().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                onCheckedChangeListener(view, i);
            }
        });
*/
    }

    private void onCheckedChangeListener(View view, int i) {

        resourceRadioButton = i;
        radioButtonSelected = findViewById(i);

        //* Evento de la viewPart donde se conmuta la maquina
//        getCntVolumenResiduoVM().updateDialogMachine("selectItem");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getUIManager().navigationMachine("back");
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public ViewModel getTheViewModel() {
        return theViewModel;
    }

    public void setTheViewModel(ViewModel theViewModel) {
        this.theViewModel = theViewModel;
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

    public RadioGroup getListVolumenResiduo() {
        return listVolumenResiduo;
    }

    public void setListVolumenResiduo(RadioGroup listVolumenResiduo) {
        this.listVolumenResiduo = listVolumenResiduo;
    }

    public CntVolumenResiduoVM getCntVolumenResiduoVM() {
        return cntVolumenResiduoVM = app.getCntVolumenResiduoVM();
    }

    public void setCntVolumenResiduoVM(CntVolumenResiduoVM cntVolumenResiduoVM) {
        app.setCntVolumenResiduoVM(cntVolumenResiduoVM);
    }
}
