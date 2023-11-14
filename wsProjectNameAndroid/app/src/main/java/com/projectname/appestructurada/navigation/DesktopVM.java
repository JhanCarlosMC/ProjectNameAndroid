package com.projectname.appestructurada.navigation;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.appestructurada.presentation.viewmodels.homevm.HomeVM;

public class DesktopVM extends ViewModel {

    private FormLoginVM formLoginVM;
    private HomeVM homeVM;


    public void implementModel() {
        //Instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        FormLoginVM newFormLoginVM = new FormLoginVM();
        HomeVM newHomeVM = new HomeVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setFormLoginVM(newFormLoginVM);
        setHomeVM(newHomeVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newFormLoginVM.setOwnedBy(this);
        newHomeVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newFormLoginVM.setTheUIManager(getTheUIManager());
        newHomeVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newFormLoginVM.setIdViewModel(getIdViewModel() + ":LoginViewModel");
        newHomeVM.setIdViewModel(getIdViewModel() + ":HomeViewModel");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newFormLoginVM.implementModel();
        newHomeVM.implementarModelo();

        //Registrar viewVM

    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }

    public HomeVM getHomeVM() {
        return homeVM;
    }

    public void setHomeVM(HomeVM homeVM) {
        this.homeVM = homeVM;
    }
}
