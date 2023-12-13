package com.projectname.appestructurada.presentation.viewmodels.cntvolumenresiduovm;

import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class CntVolumenResiduoVM extends ViewModel {
    //Hijos

    //Elementos
    private final MutableLiveData<String> labelTitleTollbar;
    private final MutableLiveData<String> labelRadioButtonMano;
    private final MutableLiveData<String> labelRadioButtonContenedor;
    private final MutableLiveData<String> labelRadioButtonMasGrande;


    public CntVolumenResiduoVM() {
        labelTitleTollbar = new MutableLiveData<>();
        labelTitleTollbar.setValue("Volumen Residuo");

        labelRadioButtonMano = new MutableLiveData<>();
        labelRadioButtonMano.setValue("Cabe en una Mano");

        labelRadioButtonContenedor = new MutableLiveData<>();
        labelRadioButtonContenedor.setValue("Cabe en un Contenedor");

        labelRadioButtonMasGrande = new MutableLiveData<>();
        labelRadioButtonMasGrande.setValue("Mas Grande");
    }

    public void implementModel() {
        //Instanciar Hijos --> HijoVM newHijo = new HijoVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"

        //Registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);

    }

    public MutableLiveData<String> getLabelTitleTollbar() {
        return labelTitleTollbar;
    }

    public MutableLiveData<String> getLabelRadioButtonMano() {
        return labelRadioButtonMano;
    }

    public MutableLiveData<String> getLabelRadioButtonContenedor() {
        return labelRadioButtonContenedor;
    }

    public MutableLiveData<String> getLabelRadioButtonMasGrande() {
        return labelRadioButtonMasGrande;
    }
}
