package com.projectname.appestructurada.presentation.viewparts.denunciavp;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.R;
import com.projectname.appestructurada.databinding.DenunciaFormBinding;
import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.navigation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.formdenunciavm.FormDenunciaVM;

public class FormDenunciaVP extends Fragment implements ViewVP {

    private DenunciaFormBinding bindingDenuncia;
    private FormDenunciaVM formDenunciaVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;

    /*Layouts Elements*/
    public TextView labelContexto;
    public TextView labelVolumenResiduo;
    public TextView labelVolumenResiduoSeleccionado;
    public TextView labelTipoResiduo;
    public TextView labelTipoResiduoSeleccionado;
    public TextView labelInformacionAdicional;
    public TextView labelInformacionAdicionalSeleccionado;
    public TextView labelTipoDenuncia;
    public RadioButton radioButtonPublica;
    public RadioButton radioButtonAnonima;
    public CheckBox checkBoxTerminosCondiciones;
    public TextView labelVerTerminosCondiciones;
    public TextView labelVolumenResiduoFeedback;
    public TextView labelTipoResiduoFeedback;
    public TextView labelInformacionAdicionalFeedback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        formDenunciaVM = new ViewModelProvider(this).get(FormDenunciaVM.class);
        bindingDenuncia = DenunciaFormBinding.inflate(inflater, container, false);
        View root = bindingDenuncia.getRoot();

        /*Carga de informacion desde la VM a la VP*/
        initComponents();
        settingEvents();

        //COMO NOMBRAR ESTA SECCION(PONERLO DENTRO DE OTRO METODO O PUEDE IR EN SETTINGSEVENTS)
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        requireActivity().setTitle("Denuncia");

        //indica que el Fragment tiene opciones de menú
        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_ver_mas, menu);

        // Obtén el ícono del menú que deseas tintar
        MenuItem item = menu.findItem(R.id.action_ver_mas);
        Drawable icon = item.getIcon();

        // Tinta el ícono con el color deseado
        if (icon != null) {
            icon.setColorFilter(ContextCompat.getColor(requireContext(), R.color.white), PorterDuff.Mode.SRC_IN);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void settingEvents() {
    }

    private void initComponents() {
        // Inicializar Widgets
        labelContexto = bindingDenuncia.contextoDenuncia;
        formDenunciaVM.getLabelContexto().observe(this, labelContexto::setText);

        labelVolumenResiduo = bindingDenuncia.fragmentVolumenResiduo.textviewCartTittle;
        formDenunciaVM.getLabelVolumenResiduo().observe(this, labelVolumenResiduo::setText);

        labelVolumenResiduoSeleccionado = bindingDenuncia.fragmentVolumenResiduo.textviewCartSeleccionado;
        formDenunciaVM.getLabelVolumenResiduoSeleccionado().observe(this, labelVolumenResiduoSeleccionado::setText);

            labelVolumenResiduoFeedback = bindingDenuncia.fragmentVolumenResiduo.cartFeedback;
            formDenunciaVM.getLabelVolumenResiduoFeedback().observe(this, labelVolumenResiduoFeedback::setText);
            formDenunciaVM.getLabelVolumenResiduoFeedbackColor().observe(this, labelVolumenResiduoFeedback::setTextColor);
            labelVolumenResiduoFeedback.setTextColor(getResources().getColor(R.color.colorRojo));

        labelTipoResiduo = bindingDenuncia.fragmentTipoResiduo.textviewCartTittle;
        formDenunciaVM.getLabelTipoResiduo().observe(this, labelTipoResiduo::setText);

        labelTipoResiduoSeleccionado = bindingDenuncia.fragmentTipoResiduo.textviewCartSeleccionado;
        formDenunciaVM.getLabelTipoResiduoSeleccionado().observe(this, labelTipoResiduoSeleccionado::setText);

            labelTipoResiduoFeedback = bindingDenuncia.fragmentTipoResiduo.cartFeedback;
            formDenunciaVM.getLabelTipoResiduoFeedback().observe(this,labelTipoResiduoFeedback::setText);

        labelInformacionAdicional = bindingDenuncia.fragmentInformacionAdicional.textviewCartTittle;
        formDenunciaVM.getLabelInformacionAdicional().observe(this, labelInformacionAdicional::setText);

        labelInformacionAdicionalSeleccionado = bindingDenuncia.fragmentInformacionAdicional.textviewCartSeleccionado;
        formDenunciaVM.getLabelInformacionAdicionalSeleccionado().observe(this, labelInformacionAdicionalSeleccionado::setText);

            labelInformacionAdicionalFeedback = bindingDenuncia.fragmentInformacionAdicional.cartFeedback;
            formDenunciaVM.getLabelInformacionAdicionalFeedback().observe(this,labelInformacionAdicionalFeedback::setText);

        labelTipoDenuncia = bindingDenuncia.fragmentTipoDenuncia.textviewCartTittle;
        formDenunciaVM.getLabelTipoDenuncia().observe(this,labelTipoDenuncia::setText);

        radioButtonPublica = bindingDenuncia.fragmentTipoDenuncia.radioGroupOptionUno;
        formDenunciaVM.getRadioLabelPublica().observe(this,radioButtonPublica::setText);

        radioButtonAnonima = bindingDenuncia.fragmentTipoDenuncia.radioGroupOptionDos;
        formDenunciaVM.getRadioLabelAnonima().observe(this,radioButtonAnonima::setText);

        checkBoxTerminosCondiciones = bindingDenuncia.fragmentTerminosCondicionesDenuncia.checkboxTerminosCondiciones;
        formDenunciaVM.getCheckBoxTerminosCondiciones().observe(this, checkBoxTerminosCondiciones::setText);

        labelVerTerminosCondiciones = bindingDenuncia.fragmentTerminosCondicionesDenuncia.verTerminosCondiciones;
        formDenunciaVM.getLabelVerTerminosCondiciones().observe(this, labelVerTerminosCondiciones::setText);

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

    @Override
    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    @Override
    public String getIdViewPart() {
        return idViewPart;
    }

    @Override
    public void setOwnedByVP(DesktopVP desktopVP) {
        ownedByVP = desktopVP;
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
