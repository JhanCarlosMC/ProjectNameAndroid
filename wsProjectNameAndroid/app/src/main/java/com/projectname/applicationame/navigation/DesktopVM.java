package com.projectname.applicationame.navigation;

import com.projectname.applicationame.presentation.viewmodels.ViewModel;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

public class DesktopVM extends ViewModel {

    private FormLoginVM formLoginVM;

    public void implementModel() {
        //Instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        FormLoginVM newFormLoginVM = new FormLoginVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setFormLoginVM(newFormLoginVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newFormLoginVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newFormLoginVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newFormLoginVM.setIdViewModel(getIdViewModel() + ":LoginViewModel");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newFormLoginVM.implementModel();

        //Registrar viewVM

    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }
}
