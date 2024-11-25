package com.projectname.appestructurada.client.navigation;

import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntloginvm.CntLoginVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cnthomevm.CntHomeVM;

public class DesktopVM extends ViewModel {

    private CntLoginVM theCntLoginVM;
    private CntHomeVM theCntHomeVM;
    private CntDenunciaVM theCntDenunciaVM;

    public void implementModel() {
        //Instanciar Hijos --> HijoVM newHijo = new HijoVM();
        CntLoginVM newCntLoginVM = new CntLoginVM();
        CntHomeVM newCntHomeVM = new CntHomeVM();
        CntDenunciaVM newCntDenunciaVM = new CntDenunciaVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setCntLoginVM(newCntLoginVM);
        setCntHomeVM(newCntHomeVM);
        setCntDenunciaVM(newCntDenunciaVM);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newCntLoginVM.setOwnedBy(this);
        newCntHomeVM.setOwnedBy(this);
        newCntDenunciaVM.setOwnedBy(this);

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newCntLoginVM.setTheUIManager(getTheUIManager());
        newCntHomeVM.setTheUIManager(getTheUIManager());
        newCntDenunciaVM.setTheUIManager(getTheUIManager());

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newCntLoginVM.setIdViewModel(getIdViewModel() + ":CntLoginVM");
        newCntHomeVM.setIdViewModel(getIdViewModel() + ":CntHomeVM");
        newCntDenunciaVM.setIdViewModel(getIdViewModel() + ":CntDenunciaVM");

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"
        newCntLoginVM.implementModel();
        newCntHomeVM.implementModel();
        newCntDenunciaVM.implementModel();

        //Registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);
        getTheUIManager().registerViewModel(newCntLoginVM.getIdViewModel(), newCntLoginVM);
        getTheUIManager().registerViewModel(newCntHomeVM.getIdViewModel(), newCntHomeVM);
        getTheUIManager().registerViewModel(newCntDenunciaVM.getIdViewModel(), newCntDenunciaVM);
    }

    public CntLoginVM getCntLoginVM() {
        return theCntLoginVM;
    }

    public void setCntLoginVM(CntLoginVM cntLoginVM) {
        this.theCntLoginVM = cntLoginVM;
    }

    public CntHomeVM getCntHomeVM() {
        return theCntHomeVM;
    }

    public void setCntHomeVM(CntHomeVM cntHomeVM) {
        this.theCntHomeVM = cntHomeVM;
    }

    public CntDenunciaVM getCntDenunciaVM() {
        return theCntDenunciaVM;
    }

    public void setCntDenunciaVM(CntDenunciaVM cntDenunciaVM) {
        this.theCntDenunciaVM = cntDenunciaVM;
    }
}
