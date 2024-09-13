package com.projectname.appestructurada.presentation.viewmodels.cntdenunciavm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.R;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntinformacionadicionalvm.CntInformacionAdicionalVM;
import com.projectname.appestructurada.presentation.viewmodels.cnttiporesiduovm.CntTipoResiduoVM;
import com.projectname.appestructurada.presentation.viewmodels.cntvolumenresiduovm.CntVolumenResiduoVM;

public class CntDenunciaVM extends ViewModel {
    //Hijos
    CntVolumenResiduoVM cntVolumenResiduoVM;
    CntTipoResiduoVM cntTipoResiduoVM;
    CntInformacionAdicionalVM cntInformacionAdicionalVM;

    //Elementos
    private final MutableLiveData<String> labelTitleToolbar;
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
//    private MutableLiveData<String> labelVolumenResiduoFeedback = new MutableLiveData<>();


    private final MutableLiveData<String> labelTipoResiduoFeedback;
    private final MutableLiveData<String> labelInformacionAdicionalFeedback;

    public CntDenunciaVM() {
        Log.e("CntDenunciaVM", "Entro en el constructor");
        labelTitleToolbar = new MutableLiveData<>();
        labelTitleToolbar.setValue("Denuncia");

        labelContexto = new MutableLiveData<>();
        labelContexto.setValue("Envianos tus denuncias para conseguir un ordenamiento ambiental sostenible");

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

        labelTipoResiduoFeedback = new MutableLiveData<>();
        labelTipoResiduoFeedback.setValue("Completar");

        labelInformacionAdicionalFeedback = new MutableLiveData<>();
        labelInformacionAdicionalFeedback.setValue("Completar");

    }

    public void implementModel() {
        //Instanciar Hijos --> HijoVM newHijo = new HijoVM();
        CntVolumenResiduoVM newCntVolumenResiduoVM = new CntVolumenResiduoVM();
        CntTipoResiduoVM newCntTipoResiduoVM = new CntTipoResiduoVM();
        CntInformacionAdicionalVM newCntInformacionAdicionalVM = new CntInformacionAdicionalVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setCntVolumenResiduoVM(newCntVolumenResiduoVM);
        setCntTipoResiduoVM(newCntTipoResiduoVM);
        setCntInformacionAdicionalVM(newCntInformacionAdicionalVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newCntVolumenResiduoVM.setOwnedBy(this);
        newCntTipoResiduoVM.setOwnedBy(this);
        newCntInformacionAdicionalVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newCntVolumenResiduoVM.setTheUIManager(getTheUIManager());
        newCntTipoResiduoVM.setTheUIManager(getTheUIManager());
        newCntInformacionAdicionalVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newCntVolumenResiduoVM.setIdViewModel(getIdViewModel() + ":CntVolumenResiduoVM");
        newCntTipoResiduoVM.setIdViewModel(getIdViewModel()+":CntTipoResiduoVM");
        newCntInformacionAdicionalVM.setIdViewModel(getIdViewModel()+":CntInformacionAdicionalVM");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newCntVolumenResiduoVM.implementModel();
        newCntTipoResiduoVM.implementModel();
        newCntInformacionAdicionalVM.implementModel();

        //Registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);
        getTheUIManager().registerViewModel(newCntVolumenResiduoVM.getIdViewModel(), newCntVolumenResiduoVM);
        getTheUIManager().registerViewModel(newCntTipoResiduoVM.getIdViewModel(), newCntTipoResiduoVM);
        getTheUIManager().registerViewModel(newCntInformacionAdicionalVM.getIdViewModel(), newCntInformacionAdicionalVM);

    }

    public MutableLiveData<String> getLabelTitleToolbar() {
        return labelTitleToolbar;
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

    public CntVolumenResiduoVM getCntVolumenResiduoVM() {
        return cntVolumenResiduoVM;
    }

    public void setCntVolumenResiduoVM(CntVolumenResiduoVM cntVolumenResiduoVM) {
        this.cntVolumenResiduoVM = cntVolumenResiduoVM;
    }

    public CntTipoResiduoVM getCntTipoResiduoVM() {
        return cntTipoResiduoVM;
    }

    public void setCntTipoResiduoVM(CntTipoResiduoVM cntTipoResiduoVM) {
        this.cntTipoResiduoVM = cntTipoResiduoVM;
    }

    public CntInformacionAdicionalVM getCntInformacionAdicionalVM() {
        return cntInformacionAdicionalVM;
    }

    public void setCntInformacionAdicionalVM(CntInformacionAdicionalVM cntInformacionAdicionalVM) {
        this.cntInformacionAdicionalVM = cntInformacionAdicionalVM;
    }
//
//    // Método para actualizar el valor
//    public void updateVolumenResiduoFeedback(String feedback) {
//        labelVolumenResiduoFeedback.setValue(feedback);
//    }
//
//    public LiveData<String> getLabelVolumenResiduoFeedback() {
//        return labelVolumenResiduoFeedback;
//    }
}
