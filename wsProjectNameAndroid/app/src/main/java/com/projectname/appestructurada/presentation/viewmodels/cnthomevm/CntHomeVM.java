package com.projectname.appestructurada.presentation.viewmodels.cnthomevm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class CntHomeVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public CntHomeVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
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

}