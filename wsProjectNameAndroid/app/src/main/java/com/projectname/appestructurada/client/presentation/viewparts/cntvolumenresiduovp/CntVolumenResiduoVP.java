package com.projectname.appestructurada.client.presentation.viewparts.cntvolumenresiduovp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.client.APP;
import com.projectname.appestructurada.R;
import com.projectname.appestructurada.databinding.ActivityVolumenResiduoBinding;
import com.projectname.appestructurada.client.kernel.ViewVP;
import com.projectname.appestructurada.client.presentation.UIManager;
import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntvolumenresiduovm.CntVolumenResiduoVM;
import com.projectname.appestructurada.client.presentation.viewparts.cntdenunciavp.CntDenunciaVP;

public class CntVolumenResiduoVP extends AppCompatActivity implements ViewVP {
    private ActivityVolumenResiduoBinding bindingVolumenResiduo;
    private CntVolumenResiduoVM cntVolumenResiduoVM;
//    private CntDenunciaVM cntDenunciaVM;
private ViewVP ownedByVP;
    private APP app = APP.getInstance();
    private UIManager theUIManager;
    private String idViewPart;
    private ViewModel theViewModel;
    private View view;

    /*Layouts Elements*/
    private TextView labelTitleTollbar;
    private RadioButton labelRadioButtonMano;
    private RadioButton labelRadioButtonMochila;
    private RadioButton labelRadioButtonAutomovil;
    private RadioButton labelRadioButtonContenedor;
    private RadioButton labelRadioButtonCamion;
    private RadioButton labelRadioButtonMasGrande;
    private RelativeLayout imgBack;
    private RadioGroup radioGroupVolumenResiduo;
    private Button btnAceptarVolumenResiduo;

    //Propios
    private int resourceRadioButton;
    private RadioButton radioButtonSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingVolumenResiduo = bindingVolumenResiduo.inflate(getLayoutInflater());
        View root = bindingVolumenResiduo.getRoot();
        setContentView(root);

//        cntVolumenResiduoVM = new ViewModelProvider(this).get(CntVolumenResiduoVM.class);
        cntVolumenResiduoVM = app.getCntVolumenResiduoVM();

//        cntDenunciaVM = new ViewModelProvider(this).get(CntDenunciaVM.class);

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

        btnAceptarVolumenResiduo = bindingVolumenResiduo.btnAceptarVolumenResiduo;
        cntVolumenResiduoVM.getLabelButtonAceptar().observe(this, btnAceptarVolumenResiduo::setText);

        imgBack = bindingVolumenResiduo.actionToolbarAtras;

        radioGroupVolumenResiduo = bindingVolumenResiduo.rgListVolumenResiduo;
    }

    public void settingEvents() {
        //Antiguo montarEventos()
        getImgBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Escucha cambios en el RadioGroup
        getRadioGroupVolumenResiduo().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onCheckedChangeListener( group, checkedId);
            }
        });

        getBtnAceptarVolumenResiduo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                labelRadioButtonMasGrande.setText("MUY GRANDEEEE");
                getCntVolumenResiduoVM().getLabelRadioButtonMasGrande().setValue("MUY GRANDEEEE");
//                cntVolumenResiduoVM.getLabelRadioButtonMasGrande().setValue("MUY GRANDEEEE");

//                cntDenunciaVM.getLabelVolumenResiduoFeedback().setValue("Completadoooo");
//                cntDenunciaVM.updateVolumenResiduoFeedback("Completado");

//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("result_key", "Completado");
//                setResult(RESULT_OK, resultIntent);
//                finish(); // Cierra la Activity y regresa al Fragment
                Log.e("onBackPressed: ", "cntVolumenResiduoVMData: " + app.getTheUIManager().getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM().getLabelRadioButtonMasGrande().getValue());

                getUIManager().navigationMachine("back");
            }
        });
    }

    private void onCheckedChangeListener(View view, int i) {
        // Activa el botón cuando se selecciona un RadioButton
        btnAceptarVolumenResiduo.setEnabled(true);
        btnAceptarVolumenResiduo.setBackgroundTintList(getResources().getColorStateList(R.color.color_ic_promocion));



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

    public RadioGroup getRadioGroupVolumenResiduo() {
        return radioGroupVolumenResiduo;
    }

    public void setRadioGroupVolumenResiduo(RadioGroup radioGroupVolumenResiduo) {
        this.radioGroupVolumenResiduo = radioGroupVolumenResiduo;
    }

    public Button getBtnAceptarVolumenResiduo() {
        return btnAceptarVolumenResiduo;
    }

    public void setBtnAceptarVolumenResiduo(Button btnAceptarVolumenResiduo) {
        this.btnAceptarVolumenResiduo = btnAceptarVolumenResiduo;
    }

    public CntVolumenResiduoVM getCntVolumenResiduoVM() {
        return cntVolumenResiduoVM = app.getCntVolumenResiduoVM();
    }

    public void setCntVolumenResiduoVM(CntVolumenResiduoVM cntVolumenResiduoVM) {
        app.setCntVolumenResiduoVM(cntVolumenResiduoVM);
    }
}
