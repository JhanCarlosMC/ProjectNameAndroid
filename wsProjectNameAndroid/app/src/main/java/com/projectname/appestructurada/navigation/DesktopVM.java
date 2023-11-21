package com.projectname.appestructurada.navigation;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.formdenunciavm.FormDenunciaVM;
import com.projectname.appestructurada.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.appestructurada.presentation.viewmodels.formhomevm.FormHomeVM;

public class DesktopVM extends ViewModel {

    private FormLoginVM formLoginVM;
    private FormHomeVM formHomeVM;
    private FormDenunciaVM formDenunciaVM;

    public void implementModel() {
        //Instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        FormLoginVM newFormLoginVM = new FormLoginVM();
        FormHomeVM newFormHomeVM = new FormHomeVM();
        FormDenunciaVM newFormDenunciaVM = new FormDenunciaVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setFormLoginVM(newFormLoginVM);
        setHomeVM(newFormHomeVM);
        setDenunciaVM(newFormDenunciaVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newFormLoginVM.setOwnedBy(this);
        newFormHomeVM.setOwnedBy(this);
        newFormDenunciaVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newFormLoginVM.setTheUIManager(getTheUIManager());
        newFormHomeVM.setTheUIManager(getTheUIManager());
        newFormDenunciaVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newFormLoginVM.setIdViewModel(getIdViewModel() + ":LoginViewModel");
        newFormHomeVM.setIdViewModel(getIdViewModel() + ":HomeViewModel");
        newFormDenunciaVM.setIdViewModel(getIdViewModel() + "DenunciaViewModel");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newFormLoginVM.implementModel();
        newFormHomeVM.implementModel();
        newFormDenunciaVM.implementModel();

        //Registrar viewVM

    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }

    public FormHomeVM getHomeVM() {
        return formHomeVM;
    }

    public void setHomeVM(FormHomeVM formHomeVM) {
        this.formHomeVM = formHomeVM;
    }

    public FormDenunciaVM getDenunciaVM() {
        return formDenunciaVM;
    }

    public void setDenunciaVM(FormDenunciaVM formDenunciaVM) {
        this.formDenunciaVM = formDenunciaVM;
    }
}
