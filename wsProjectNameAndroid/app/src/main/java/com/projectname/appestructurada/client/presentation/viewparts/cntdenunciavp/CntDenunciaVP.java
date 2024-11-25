package com.projectname.appestructurada.client.presentation.viewparts.cntdenunciavp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.client.APP;
import com.projectname.appestructurada.R;
import com.projectname.appestructurada.databinding.FragmentDenunciaBinding;
import com.projectname.appestructurada.client.kernel.ViewVP;
import com.projectname.appestructurada.client.presentation.UIManager;
import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntinformacionadicionalvm.CntInformacionAdicionalVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cnttiporesiduovm.CntTipoResiduoVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntvolumenresiduovm.CntVolumenResiduoVM;
import com.projectname.appestructurada.client.presentation.viewparts.cntinformacionadicionalvp.CntInformacionAdicionalVP;
import com.projectname.appestructurada.client.presentation.viewparts.cnttiporesiduovp.CntTipoResiduoVP;
import com.projectname.appestructurada.client.presentation.viewparts.cntvolumenresiduovp.CntVolumenResiduoVP;

public class CntDenunciaVP extends Fragment implements ViewVP {

    //Varibales de Binding
    private FragmentDenunciaBinding bindingDenuncia;
    private CntDenunciaVM cntDenunciaVM;

    //Variables de Relaciones
    private ViewVP ownedByVP;
    private APP app = APP.getInstance();
    private UIManager theUIManager;
    private String idViewPart;
    private ViewModel theViewModel;

    private View view;

    //varibales contenedor viewmodel
    private CntVolumenResiduoVP cntVolumenResiduoVP;
    private CntVolumenResiduoVM cntVolumenResiduoVM;
    private CntTipoResiduoVM cntTipoResiduoVM;
    private CntTipoResiduoVP cntTipoResiduoVP;
    private CntInformacionAdicionalVM cntInformacionAdicionalVM;
    private CntInformacionAdicionalVP cntInformacionAdicionalVP;

    //Layouts Elements
    private TextView labelTitleToolbar;
    private TextView labelContexto;
    private TextView labelVolumenResiduo;
    private TextView labelVolumenResiduoSeleccionado;
    private TextView labelTipoResiduo;
    private TextView labelTipoResiduoSeleccionado;
    private TextView labelInformacionAdicional;
    private TextView labelInformacionAdicionalSeleccionado;
    private TextView labelTipoDenuncia;
    private TextView labelVerTerminosCondiciones;
    private TextView labelVolumenResiduoFeedback;
    private TextView labelTipoResiduoFeedback;
    private TextView labelInformacionAdicionalFeedback;
    private LinearLayout cartVolumenResiduo;
    private LinearLayout cartTipoResiduo;
    private LinearLayout cartInformacionAdicional;
    private RadioButton radioButtonPublica;
    private RadioButton radioButtonAnonima;
    private CheckBox checkBoxTerminosCondiciones;
    private TextView label;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        cntDenunciaVM = new ViewModelProvider(this).get(CntDenunciaVM.class);
        bindingDenuncia = FragmentDenunciaBinding.inflate(inflater, container, false);
        View root = bindingDenuncia.getRoot();


        /*Carga de informacion desde la VM a la VP*/
        implementModel();
        Log.e("cntDenunciaVP: ", "cntVolumenResiduoVMData: " + app.getTheUIManager().getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM().getLabelRadioButtonMasGrande().getValue());

        return root;
    }
    public void implementModel(){

        //Instanciar
        CntVolumenResiduoVP newCntVolumenResiduoVP = new CntVolumenResiduoVP();
        CntTipoResiduoVP newCntTipoResiduoVP = new CntTipoResiduoVP();
        CntInformacionAdicionalVP newCntInformacionAdicionalVP = new CntInformacionAdicionalVP();

        //Enlazar hijos
        setCntVolumenResiduoVP(newCntVolumenResiduoVP);
        setCntTipoResiduoVP(newCntTipoResiduoVP);
        setCntInformacionAdicionalVP(newCntInformacionAdicionalVP);

//        //Enlazar padres hijos
        newCntVolumenResiduoVP.setOwnedByVP(this);
        Log.e("Ref Data NUll", "implementModel: newCntVolumenResiduoVP " + newCntVolumenResiduoVP.toString());
//
//        Log.e("Ref Data NUll", "implementModel: view " + view.findViewById(R.id.activity_volumen_residuo));
//        //Enlazar contexto
//        newCntVolumenResiduoVP.setView(view.findViewById(R.id.activity_volumen_residuo));
//
//        //Enlazar viewModels
        newCntVolumenResiduoVP.setTheViewModel(getCntVolumenResiduoVM());
//
//        //Enlazar viewModels hijos con viewPart
        getCntVolumenResiduoVM().setTheViewPart(newCntVolumenResiduoVP);
//
//        //Generar id
        setIdViewPart(getOwnedByVP().getIdViewPart() + ":CntDenunciaVP");

        //Invocar implementar modelo hijos
//        newCntVolumenResiduoVP.implementModel();

        //Inicializando componentes
        initComponents();

        //montar eventos
        settingEvents();

//        //update views

    }
    private void initComponents() {
        // Inicializar Widgets
        labelTitleToolbar = bindingDenuncia.txtTitleToolbar;
        cntDenunciaVM.getLabelTitleToolbar().observe(this,labelTitleToolbar::setText);

        labelContexto = bindingDenuncia.txtContext;
        cntDenunciaVM.getLabelContexto().observe(this, labelContexto::setText);

        labelVolumenResiduo = bindingDenuncia.includeVolumenResiduo.txtCartTitle;
        cntDenunciaVM.getLabelVolumenResiduo().observe(this, labelVolumenResiduo::setText);

        labelVolumenResiduoSeleccionado = bindingDenuncia.includeVolumenResiduo.txtSelected;
        cntDenunciaVM.getLabelVolumenResiduoSeleccionado().observe(this, labelVolumenResiduoSeleccionado::setText);

            labelVolumenResiduoFeedback = bindingDenuncia.includeVolumenResiduo.txtFeedback;
            cntDenunciaVM.getLabelVolumenResiduoFeedback().observe(this, labelVolumenResiduoFeedback::setText);
//            cntDenunciaVM.getLabelVolumenResiduoFeedbackColor().observe(this, labelVolumenResiduoFeedback::setTextColor);
            labelVolumenResiduoFeedback.setTextColor(getResources().getColorStateList(R.color.color_ic_orientacion));

        labelTipoResiduo = bindingDenuncia.includeTipoResiduo.txtCartTitle;
        cntDenunciaVM.getLabelTipoResiduo().observe(this, labelTipoResiduo::setText);

        labelTipoResiduoSeleccionado = bindingDenuncia.includeTipoResiduo.txtSelected;
        cntDenunciaVM.getLabelTipoResiduoSeleccionado().observe(this, labelTipoResiduoSeleccionado::setText);

            labelTipoResiduoFeedback = bindingDenuncia.includeTipoResiduo.txtFeedback;
            cntDenunciaVM.getLabelTipoResiduoFeedback().observe(this,labelTipoResiduoFeedback::setText);
            labelTipoResiduoFeedback.setTextColor(getResources().getColorStateList(R.color.color_ic_orientacion));

        labelInformacionAdicional = bindingDenuncia.includeInformacionAdicional.txtCartTitle;
        cntDenunciaVM.getLabelInformacionAdicional().observe(this, labelInformacionAdicional::setText);

        labelInformacionAdicionalSeleccionado = bindingDenuncia.includeInformacionAdicional.txtSelected;
        cntDenunciaVM.getLabelInformacionAdicionalSeleccionado().observe(this, labelInformacionAdicionalSeleccionado::setText);

            labelInformacionAdicionalFeedback = bindingDenuncia.includeInformacionAdicional.txtFeedback;
            cntDenunciaVM.getLabelInformacionAdicionalFeedback().observe(this,labelInformacionAdicionalFeedback::setText);
            labelInformacionAdicionalFeedback.setTextColor(getResources().getColorStateList(R.color.color_ic_orientacion));

        labelTipoDenuncia = bindingDenuncia.txtCartTitleRadio;
        cntDenunciaVM.getLabelTipoDenuncia().observe(this,labelTipoDenuncia::setText);

        radioButtonPublica = bindingDenuncia.rbOptionOne;
        cntDenunciaVM.getRadioLabelPublica().observe(this,radioButtonPublica::setText);

        radioButtonAnonima = bindingDenuncia.rbOptionTwo;
        cntDenunciaVM.getRadioLabelAnonima().observe(this,radioButtonAnonima::setText);

        checkBoxTerminosCondiciones = bindingDenuncia.cbxCheckbox;
        cntDenunciaVM.getCheckBoxTerminosCondiciones().observe(this, checkBoxTerminosCondiciones::setText);

        labelVerTerminosCondiciones = bindingDenuncia.txtText;
        cntDenunciaVM.getLabelVerTerminosCondiciones().observe(this, labelVerTerminosCondiciones::setText);

        cartVolumenResiduo = bindingDenuncia.includeVolumenResiduo.llCart;
        cartTipoResiduo = bindingDenuncia.includeTipoResiduo.llCart;
        cartInformacionAdicional = bindingDenuncia.includeInformacionAdicional.llCart;
    }
    private void settingEvents() {

        getCartVolumenResiduo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickVolumenResiduo(view);
            }
        });

        getCartTipoResiduo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickTipoResiduo(view);
            }
        });

        getCartInformacionAdicional().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInformacionAdicional(view);
            }
        });



//        getLabelVolumenResiduo()
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            // Obtener los datos del Intent devuelto
            String result = data.getStringExtra("result_key");
        Log.e("CntDenunciaVP", "onActivityResult " + result);
//
//            // Actualizar el Fragment con los datos recibidos
////            cntDenunciaVM.updateVolumenResiduoFeedback(result);
//            cntDenunciaVM.getLabelVolumenResiduoFeedback().setValue(result);
    }


    private void onClickVolumenResiduo(View view) {
        getUIManager().navigationMachine("navigateToCategoriaVolumen");

        if (getUIManager().getUiRendered().equals("VolumenUI_A")){
            Intent intent = new Intent(view.getContext(), getCntVolumenResiduoVP().getClass());

            getView().getContext().startActivity(intent);
        }
    }

    private void onClickTipoResiduo(View view) {
        getUIManager().navigationMachine("navigateToCategoriaTipo");

        if (getUIManager().getUiRendered().equals("TipoUI_A")){
            Intent intent = new Intent(view.getContext(), getCntTipoResiduoVP().getClass());

            getView().getContext().startActivity(intent);
        }
    }

    private void onClickInformacionAdicional(View view) {
        getUIManager().navigationMachine("navigateToCategoriaInformacion");

        if (getUIManager().getUiRendered().equals("InformacionUI_A")){
            Intent intent = new Intent(view.getContext(), getCntInformacionAdicionalVP().getClass());

            getView().getContext().startActivity(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bindingDenuncia = null;
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

    public TextView getLabelVolumenResiduo() {
        return labelVolumenResiduo;
    }

    public void setLabelVolumenResiduo(TextView labelVolumenResiduo) {
        this.labelVolumenResiduo = labelVolumenResiduo;
    }

    public TextView getLabelVolumenResiduoSeleccionado() {
        return labelVolumenResiduoSeleccionado;
    }

    public void setLabelVolumenResiduoSeleccionado(TextView labelVolumenResiduoSeleccionado) {
        this.labelVolumenResiduoSeleccionado = labelVolumenResiduoSeleccionado;
    }

    public TextView getLabelTipoResiduo() {
        return labelTipoResiduo;
    }

    public void setLabelTipoResiduo(TextView labelTipoResiduo) {
        this.labelTipoResiduo = labelTipoResiduo;
    }

    public TextView getLabelTipoResiduoSeleccionado() {
        return labelTipoResiduoSeleccionado;
    }

    public void setLabelTipoResiduoSeleccionado(TextView labelTipoResiduoSeleccionado) {
        this.labelTipoResiduoSeleccionado = labelTipoResiduoSeleccionado;
    }

    public TextView getLabelInformacionAdicional() {
        return labelInformacionAdicional;
    }

    public void setLabelInformacionAdicional(TextView labelInformacionAdicional) {
        this.labelInformacionAdicional = labelInformacionAdicional;
    }

    public TextView getLabelInformacionAdicionalSeleccionado() {
        return labelInformacionAdicionalSeleccionado;
    }

    public void setLabelInformacionAdicionalSeleccionado(TextView labelInformacionAdicionalSeleccionado) {
        this.labelInformacionAdicionalSeleccionado = labelInformacionAdicionalSeleccionado;
    }

    public TextView getLabelContexto() {
        return labelContexto;
    }

    public void setLabelContexto(TextView labelContexto) {
        this.labelContexto = labelContexto;
    }

    public TextView getLabelTipoDenuncia() {
        return labelTipoDenuncia;
    }

    public void setLabelTipoDenuncia(TextView labelTipoDenuncia) {
        this.labelTipoDenuncia = labelTipoDenuncia;
    }

    public RadioButton getRadioButtonPublica() {
        return radioButtonPublica;
    }

    public void setRadioButtonPublica(RadioButton radioButtonPublica) {
        this.radioButtonPublica = radioButtonPublica;
    }

    public RadioButton getRadioButtonAnonima() {
        return radioButtonAnonima;
    }

    public void setRadioButtonAnonima(RadioButton radioButtonAnonima) {
        this.radioButtonAnonima = radioButtonAnonima;
    }

    public CheckBox getCheckBoxTerminosCondiciones() {
        return checkBoxTerminosCondiciones;
    }

    public void setCheckBoxTerminosCondiciones(CheckBox checkBoxTerminosCondiciones) {
        this.checkBoxTerminosCondiciones = checkBoxTerminosCondiciones;
    }

    public TextView getLabelVerTerminosCondiciones() {
        return labelVerTerminosCondiciones;
    }

    public void setLabelVerTerminosCondiciones(TextView labelVerTerminosCondiciones) {
        this.labelVerTerminosCondiciones = labelVerTerminosCondiciones;
    }

    public TextView getLabelVolumenResiduoFeedback() {
        return labelVolumenResiduoFeedback;
    }

    public void setLabelVolumenResiduoFeedback(TextView labelVolumenResiduoFeedback) {
        this.labelVolumenResiduoFeedback = labelVolumenResiduoFeedback;
    }

    public TextView getLabelTipoResiduoFeedback() {
        return labelTipoResiduoFeedback;
    }

    public void setLabelTipoResiduoFeedback(TextView labelTipoResiduoFeedback) {
        this.labelTipoResiduoFeedback = labelTipoResiduoFeedback;
    }

    public TextView getLabelInformacionAdicionalFeedback() {
        return labelInformacionAdicionalFeedback;
    }

    public void setLabelInformacionAdicionalFeedback(TextView labelInformacionAdicionalFeedback) {
        this.labelInformacionAdicionalFeedback = labelInformacionAdicionalFeedback;
    }

    public TextView getLabelTitleToolbar() {
        return labelTitleToolbar;
    }

    public void setLabelTitleToolbar(TextView labelTitleToolbar) {
        this.labelTitleToolbar = labelTitleToolbar;
    }

    public LinearLayout getCartVolumenResiduo() {
        return cartVolumenResiduo;
    }

    public void setCartVolumenResiduo(LinearLayout cartVolumenResiduo) {
        this.cartVolumenResiduo = cartVolumenResiduo;
    }

    public LinearLayout getCartTipoResiduo() {
        return cartTipoResiduo;
    }

    public void setCartTipoResiduo(LinearLayout cartTipoResiduo) {
        this.cartTipoResiduo = cartTipoResiduo;
    }

    public LinearLayout getCartInformacionAdicional() {
        return cartInformacionAdicional;
    }

    public void setCartInformacionAdicional(LinearLayout cartInformacionAdicional) {
        this.cartInformacionAdicional = cartInformacionAdicional;
    }

    public CntVolumenResiduoVP getCntVolumenResiduoVP() {
        return cntVolumenResiduoVP;
    }

    public void setCntVolumenResiduoVP(CntVolumenResiduoVP cntVolumenResiduoVP) {
        this.cntVolumenResiduoVP = cntVolumenResiduoVP;
    }

    public CntVolumenResiduoVM getCntVolumenResiduoVM() {
        cntVolumenResiduoVM = app.getCntVolumenResiduoVM();
        return cntVolumenResiduoVM;
    }

    public void setCntVolumenResiduoVM(CntVolumenResiduoVM cntVolumenResiduoVM) {
        this.cntVolumenResiduoVM = cntVolumenResiduoVM;
    }

    public CntTipoResiduoVM getCntTipoResiduoVM() {
        cntTipoResiduoVM = app.getCntTipoResiduoVM();
        return cntTipoResiduoVM;
    }

    public void setCntTipoResiduoVM(CntTipoResiduoVM cntTipoResiduoVM) {
        this.cntTipoResiduoVM = cntTipoResiduoVM;
    }

    public CntTipoResiduoVP getCntTipoResiduoVP() {
        return cntTipoResiduoVP;
    }

    public void setCntTipoResiduoVP(CntTipoResiduoVP cntTipoResiduoVP) {
        this.cntTipoResiduoVP = cntTipoResiduoVP;
    }

    public CntInformacionAdicionalVM getCntInformacionAdicionalVM() {
        cntInformacionAdicionalVM = app.getCntInformacionAdicionalVM();
        return cntInformacionAdicionalVM;
    }

    public void setCntInformacionAdicionalVM(CntInformacionAdicionalVM cntInformacionAdicionalVM) {
        this.cntInformacionAdicionalVM = cntInformacionAdicionalVM;
    }

    public CntInformacionAdicionalVP getCntInformacionAdicionalVP() {
        return cntInformacionAdicionalVP;
    }

    public void setCntInformacionAdicionalVP(CntInformacionAdicionalVP cntInformacionAdicionalVP) {
        this.cntInformacionAdicionalVP = cntInformacionAdicionalVP;
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
}
