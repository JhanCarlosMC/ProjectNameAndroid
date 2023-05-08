package com.projectname.applicationanme.navigation;

import com.projectname.applicationanme.presentation.viewmodels.ViewModel;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

public class DesktopVM extends ViewModel {

    private FormLoginVM formLoginVM;

    public void implementarModelo() {
        //Instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        FormLoginVM newFormLoginVM = new FormLoginVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setFormLoginVM(newFormLoginVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newFormLoginVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newFormLoginVM.setUIManagerViewModel(this);

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newFormLoginVM.setIdViewModel("LoginViewModel");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newFormLoginVM.implementarModelo();

        //Registrar viewVM

    }

    public void setIdViewModel(String desktopViewModel) {
    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }

    public void setUIManagerViewModel(UIManager uiManager) {
    }

    public void setOwnedBy(UIManager uiManager) {
    }
}
