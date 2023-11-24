package com.projectname.appestructurada.navigation;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;
import com.projectname.appestructurada.presentation.viewmodels.cnthomevm.CntHomeVM;

public class DesktopVM extends ViewModel {

    private CntLoginVM theCntLoginVM;
    private CntHomeVM theCntHomeVM;
    private CntDenunciaVM theCntDenunciaVM;

    public void implementModel() {
        //Instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        CntLoginVM newCntLoginVM = new CntLoginVM();
        CntHomeVM newCntHomeVM = new CntHomeVM();
        CntDenunciaVM newCntDenunciaVM = new CntDenunciaVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setFormLoginVM(newCntLoginVM);
        setHomeVM(newCntHomeVM);
        setDenunciaVM(newCntDenunciaVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newCntLoginVM.setOwnedBy(this);
        newCntHomeVM.setOwnedBy(this);
        newCntDenunciaVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newCntLoginVM.setTheUIManager(getTheUIManager());
        newCntHomeVM.setTheUIManager(getTheUIManager());
        newCntDenunciaVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newCntLoginVM.setIdViewModel(getIdViewModel() + ":LoginViewModel");
        newCntHomeVM.setIdViewModel(getIdViewModel() + ":HomeViewModel");
        newCntDenunciaVM.setIdViewModel(getIdViewModel() + "DenunciaViewModel");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newCntLoginVM.implementModel();
        newCntHomeVM.implementModel();
        newCntDenunciaVM.implementModel();

        //Registrar viewVM

    }

    public CntLoginVM getFormLoginVM() {
        return theCntLoginVM;
    }

    public void setFormLoginVM(CntLoginVM cntLoginVM) {
        this.theCntLoginVM = cntLoginVM;
    }

    public CntHomeVM getHomeVM() {
        return theCntHomeVM;
    }

    public void setHomeVM(CntHomeVM cntHomeVM) {
        this.theCntHomeVM = cntHomeVM;
    }

    public CntDenunciaVM getDenunciaVM() {
        return theCntDenunciaVM;
    }

    public void setDenunciaVM(CntDenunciaVM cntDenunciaVM) {
        this.theCntDenunciaVM = cntDenunciaVM;
    }
}
