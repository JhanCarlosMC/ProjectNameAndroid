package com.projectname.appestructurada.presentation.viewmodels.cntinformacionadicionalvm;

import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class CntInformacionAdicionalVM extends ViewModel {

    //Elementos
    private final MutableLiveData<String> labelTitleToolbar;
    private final MutableLiveData<String> labelUbicacionActual;
    private final MutableLiveData<String> labelFechaDenuncia;
    private final MutableLiveData<String> labelDescripcion;
    private final MutableLiveData<String> labelFotografia;

    public CntInformacionAdicionalVM() {
        labelTitleToolbar = new MutableLiveData<>();
        labelTitleToolbar.setValue("Informacion Adicional");

        labelUbicacionActual = new MutableLiveData<>();
        labelUbicacionActual.setValue("Tu Ubicacion Actual");

        labelFechaDenuncia = new MutableLiveData<>();
        labelFechaDenuncia.setValue("Fecha de la Denuncia");

        labelDescripcion = new MutableLiveData<>();
        labelDescripcion.setValue("Descripcion");

        labelFotografia = new MutableLiveData<>();
        labelFotografia.setValue("Fotografia");
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

    public MutableLiveData<String> getLabelUbicacionActual() {
        return labelUbicacionActual;
    }

    public MutableLiveData<String> getLabelFechaDenuncia() {
        return labelFechaDenuncia;
    }

    public MutableLiveData<String> getLabelDescripcion() {
        return labelDescripcion;
    }

    public MutableLiveData<String> getLabelFotografia() {
        return labelFotografia;
    }
}
