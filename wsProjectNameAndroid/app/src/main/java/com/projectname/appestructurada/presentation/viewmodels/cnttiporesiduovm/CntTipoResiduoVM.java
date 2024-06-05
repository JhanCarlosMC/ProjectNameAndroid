package com.projectname.appestructurada.presentation.viewmodels.cnttiporesiduovm;

import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class CntTipoResiduoVM extends ViewModel {

    private final MutableLiveData<String> labelTitleToolbar;
    private final MutableLiveData<String> labelCheckBoxEnvases;
    private final MutableLiveData<String> labelCheckBoxCarton;
    private final MutableLiveData<String> labelCheckBoxBolsas;
    private final MutableLiveData<String> labelCheckBoxElectronicos;
    private final MutableLiveData<String> labelCheckBoxBaterias;
    private final MutableLiveData<String> labelCheckBoxNeumaticos;
    private final MutableLiveData<String> labelCheckBoxMedicamentos;
    private final MutableLiveData<String> labelCheckBoxEscombros;
    private final MutableLiveData<String> labelCheckBoxVarios;

    public CntTipoResiduoVM() {

        labelTitleToolbar = new MutableLiveData<>();
        labelTitleToolbar.setValue("Tipo de Residuo");

        labelCheckBoxEnvases = new MutableLiveData<>();
        labelCheckBoxEnvases.setValue("Envases");

        labelCheckBoxCarton = new MutableLiveData<>();
        labelCheckBoxCarton.setValue("Carton");

        labelCheckBoxBolsas = new MutableLiveData<>();
        labelCheckBoxBolsas.setValue("Bolsas");

        labelCheckBoxElectronicos = new MutableLiveData<>();
        labelCheckBoxElectronicos.setValue("Electricos y Electronicos");

        labelCheckBoxBaterias = new MutableLiveData<>();
        labelCheckBoxBaterias.setValue("Pilas y Baterias");

        labelCheckBoxNeumaticos = new MutableLiveData<>();
        labelCheckBoxNeumaticos.setValue("Neumaticos");

        labelCheckBoxMedicamentos = new MutableLiveData<>();
        labelCheckBoxMedicamentos.setValue("Medicamentos");

        labelCheckBoxEscombros = new MutableLiveData<>();
        labelCheckBoxEscombros.setValue("Escombros");

        labelCheckBoxVarios = new MutableLiveData<>();
        labelCheckBoxVarios.setValue("Varios");
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
    public MutableLiveData<String> getLabelTitleToolbar() {
        return labelTitleToolbar;
    }

    public MutableLiveData<String> getLabelCheckBoxEnvases() {
        return labelCheckBoxEnvases;
    }

    public MutableLiveData<String> getLabelCheckBoxCarton() {
        return labelCheckBoxCarton;
    }

    public MutableLiveData<String> getLabelCheckBoxBolsas() {
        return labelCheckBoxBolsas;
    }

    public MutableLiveData<String> getLabelCheckBoxElectronicos() {
        return labelCheckBoxElectronicos;
    }

    public MutableLiveData<String> getLabelCheckBoxBaterias() {
        return labelCheckBoxBaterias;
    }

    public MutableLiveData<String> getLabelCheckBoxNeumaticos() {
        return labelCheckBoxNeumaticos;
    }

    public MutableLiveData<String> getLabelCheckBoxMedicamentos() {
        return labelCheckBoxMedicamentos;
    }

    public MutableLiveData<String> getLabelCheckBoxEscombros() {
        return labelCheckBoxEscombros;
    }

    public MutableLiveData<String> getLabelCheckBoxVarios() {
        return labelCheckBoxVarios;
    }
}
