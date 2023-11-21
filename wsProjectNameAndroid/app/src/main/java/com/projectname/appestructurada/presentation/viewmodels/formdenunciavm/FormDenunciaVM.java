package com.projectname.appestructurada.presentation.viewmodels.formdenunciavm;

import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.R;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class FormDenunciaVM extends ViewModel {

    private final MutableLiveData<String> labelContexto;
    private final MutableLiveData<String> labelVolumenResiduo;
    private final MutableLiveData<String> labelVolumenResiduoSeleccionado;
    private final MutableLiveData<String> labelTipoResiduo;
    private final MutableLiveData<String> labelTipoResiduoSeleccionado;
    private final MutableLiveData<String> labelInformacionAdicional;
    private final MutableLiveData<String> labelInformacionAdicionalSeleccionado;
    private final MutableLiveData<String> labelTipoDenuncia;
    private final MutableLiveData<String> radioLabelPublica;
    private final MutableLiveData<String> radioLabelAnonima;
    private final MutableLiveData<String> checkBoxTerminosCondiciones;
    private final MutableLiveData<String> labelVerTerminosCondiciones;
    private final MutableLiveData<String> labelVolumenResiduoFeedback;
    private final MutableLiveData<Integer> labelVolumenResiduoFeedbackColor;
    private final MutableLiveData<String> labelTipoResiduoFeedback;
    private final MutableLiveData<String> labelInformacionAdicionalFeedback;

    public FormDenunciaVM() {
        labelContexto = new MutableLiveData<>();
        labelContexto.setValue("Selecciona la ruta y en la ubicacion en la cual quieres viajar");

        labelVolumenResiduo = new MutableLiveData<>();
        labelVolumenResiduo.setValue("Volumen Residuo");

        labelVolumenResiduoSeleccionado = new MutableLiveData<>();
        labelVolumenResiduoSeleccionado.setValue("Seleccione el volumen del residuo");

        labelTipoResiduo = new MutableLiveData<>();
        labelTipoResiduo.setValue("Tipo Residuo");

        labelTipoResiduoSeleccionado = new MutableLiveData<>();
        labelTipoResiduoSeleccionado.setValue("Seleccione los tipos de residuo");

        labelInformacionAdicional = new MutableLiveData<>();
        labelInformacionAdicional.setValue("Informacion Adicional");

        labelInformacionAdicionalSeleccionado = new MutableLiveData<>();
        labelInformacionAdicionalSeleccionado.setValue("Complete la informacion adicional");

        labelTipoDenuncia = new MutableLiveData<>();
        labelTipoDenuncia.setValue("Tipo de Denuncia");

        radioLabelPublica = new MutableLiveData<>();
        radioLabelPublica.setValue("Publica");

        radioLabelAnonima = new MutableLiveData<>();
        radioLabelAnonima.setValue("Anonima");

        checkBoxTerminosCondiciones = new MutableLiveData<>();
        checkBoxTerminosCondiciones.setValue("Acepto terminos y condiciones");

        labelVerTerminosCondiciones = new MutableLiveData<>();
        labelVerTerminosCondiciones.setValue("(Ver)");

        labelVolumenResiduoFeedback = new MutableLiveData<>();
        labelVolumenResiduoFeedback.setValue("Completar");

        labelVolumenResiduoFeedbackColor = new MutableLiveData<>();
        labelVolumenResiduoFeedbackColor.setValue(R.color.colorRojo);

        labelTipoResiduoFeedback = new MutableLiveData<>();
        labelTipoResiduoFeedback.setValue("Completar");

        labelInformacionAdicionalFeedback = new MutableLiveData<>();
        labelInformacionAdicionalFeedback.setValue("Completar");

    }

    public void implementModel() {
    }

    public MutableLiveData<String> getLabelVolumenResiduo() {
        return labelVolumenResiduo;
    }

    public MutableLiveData<String> getLabelVolumenResiduoSeleccionado() {
        return labelVolumenResiduoSeleccionado;
    }

    public MutableLiveData<String> getLabelTipoResiduo() {
        return labelTipoResiduo;
    }

    public MutableLiveData<String> getLabelTipoResiduoSeleccionado() {
        return labelTipoResiduoSeleccionado;
    }

    public MutableLiveData<String> getLabelInformacionAdicional() {
        return labelInformacionAdicional;
    }

    public MutableLiveData<String> getLabelInformacionAdicionalSeleccionado() {
        return labelInformacionAdicionalSeleccionado;
    }

    public MutableLiveData<String> getLabelContexto() {
        return labelContexto;
    }

    public MutableLiveData<String> getRadioLabelPublica() {
        return radioLabelPublica;
    }

    public MutableLiveData<String> getRadioLabelAnonima() {
        return radioLabelAnonima;
    }

    public MutableLiveData<String> getLabelTipoDenuncia() {
        return labelTipoDenuncia;
    }

    public MutableLiveData<String> getCheckBoxTerminosCondiciones() {
        return checkBoxTerminosCondiciones;
    }

    public MutableLiveData<String> getLabelVerTerminosCondiciones() {
        return labelVerTerminosCondiciones;
    }

    public MutableLiveData<String> getLabelVolumenResiduoFeedback() {
        return labelVolumenResiduoFeedback;
    }

    public MutableLiveData<String> getLabelTipoResiduoFeedback() {
        return labelTipoResiduoFeedback;
    }

    public MutableLiveData<String> getLabelInformacionAdicionalFeedback() {
        return labelInformacionAdicionalFeedback;
    }


    public MutableLiveData<Integer> getLabelVolumenResiduoFeedbackColor() {
        return labelVolumenResiduoFeedbackColor;
    }
}
