package com.projectname.appestructurada.client.presentation.viewmodels.cntvolumenresiduovm;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewparts.cntdenunciavp.CntDenunciaVP;

public class CntVolumenResiduoVM extends ViewModel {
    //Hijos

    //Elementos
    private final MutableLiveData<String> labelTitleTollbar;
    private final MutableLiveData<String> labelRadioButtonMano;
    private final MutableLiveData<String> labelRadioButtonMochila;
    private final MutableLiveData<String> labelRadioButtonAutomovil;
    private final MutableLiveData<String> labelRadioButtonContenedor;
    private final MutableLiveData<String> labelRadioButtonCamion;
    private final MutableLiveData<String> labelRadioButtonMasGrande;
    private final MutableLiveData<String> labelButtonAceptar;
    private String state = "NO_INITIALIZED";

    public CntVolumenResiduoVM() {
        labelTitleTollbar = new MutableLiveData<>();
        labelTitleTollbar.setValue("Volumen Residuo");

        labelRadioButtonMano = new MutableLiveData<>();
        labelRadioButtonMano.setValue("Cabe en una Mano");

        labelRadioButtonMochila = new MutableLiveData<>();
        labelRadioButtonMochila.setValue("Cabe en una Mochila");

        labelRadioButtonAutomovil = new MutableLiveData<>();
        labelRadioButtonAutomovil.setValue("Cabe en un automovil");

        labelRadioButtonContenedor = new MutableLiveData<>();
        labelRadioButtonContenedor.setValue("Cabe en un Contenedor");

        labelRadioButtonCamion = new MutableLiveData<>();
        labelRadioButtonCamion.setValue("Cabe en un camion");

        labelRadioButtonMasGrande = new MutableLiveData<>();
        labelRadioButtonMasGrande.setValue("Mas Grande");

        labelButtonAceptar = new MutableLiveData<>();
        labelButtonAceptar.setValue("Guardar");
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

/**
    public String updateDialogMachine(final String event) {
        String action = "";

        if (getState().trim().equals("NO_INITIALIZED")) {
            if (event.equals("load")) {
                setState("VMLoaded");
                notifyCompletar_action();
                return action;
            }
        }
        if (getState().equals("VMLoaded")) {
            if (event.equals("fill")) {
                setState("Filling");
                return action;
            }
        }

        if (getState().equals("Filling")) {
            if (event.equals("selectItem")) {
//                updateAcceptButton();
//                updateItemSelected();
                return action;
            }
            if (event.equals("accept")) {
//                notifyCompletado();
                setState("Filled");
                return action;
            }
            if (event.equals("back") && radioButtonResiduoSelected != 0) {
//                notifyCompletado();
                setState("Filled");
                return action;
            }
            if (event.equals("back") && radioButtonResiduoSelected == 0) {
                notifyCompletar_action();
                return action;
            }
        }

        if (getState().equals("Filled")) {
            if (event.equals("clear")) {
                notifyCompletar_action();
//                clearViewModel();
                setState("VMLoaded");
                return action;
            }

            if (event.equals("selectItem")) {
                setState("Filling");
//                updateAcceptButton();
//                updateItemSelected();
                return action;
            }
        }

        return action;

    }
*/
    public void notifyCompletar_action() {
        setMsgNavigationButton("Completar");
        //setColorNavigationButton("red");

    }

    public void setMsgNavigationButton(String newMsgnavigationButton){
//        setLabelInformacionAdicionalFeedback(newMsgnavigationButton);

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

    public MutableLiveData<String> getLabelRadioButtonMochila() {
        return labelRadioButtonMochila;
    }

    public MutableLiveData<String> getLabelRadioButtonAutomovil() {
        return labelRadioButtonAutomovil;
    }

    public MutableLiveData<String> getLabelRadioButtonCamion() {
        return labelRadioButtonCamion;
    }

    public MutableLiveData<String> getLabelButtonAceptar() {
        return labelButtonAceptar;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
