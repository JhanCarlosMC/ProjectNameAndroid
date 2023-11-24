package com.projectname.appestructurada;

import android.app.Application;

import com.projectname.appestructurada.logic.Domain;
import com.projectname.appestructurada.navigation.DesktopVM;
import com.projectname.appestructurada.navigation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;
import com.projectname.appestructurada.presentation.viewmodels.cnthomevm.CntHomeVM;

//Esta clase hace de "ModelFactory" para el  nodo de cliente en el proyecto
public class APP extends Application {

    //Variables propias
    private UIManager theUIManager;
    private Domain theDomain;

    //Variables de contexto
    DesktopVM desktopVM;
    CntLoginVM cntLoginVM;
    CntHomeVM cntHomeVM;
    CntDenunciaVM cntDenunciaVM;


    //------------------------------  Singleton ------------------------------------------------
    private static class SingletonHolder{
        private final static APP eINSTANCE = new APP();
    }

    // Método para obtener la instancia de nuestra clase
    public static APP getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    //------------------------------  Singleton ------------------------------------------------
    public APP() {
        implementModel();
    }

    public APP implementModel() {
        UIManager newUiManager = getTheUIManager();
        Domain newDomain = getTheDomain();

        if(newUiManager == null){
            newUiManager = new UIManager();
            setTheUIManager(newUiManager);
        }
        if(newDomain == null){
            newDomain = new Domain();
            setTheDomain(newDomain);
        }

        getTheDomain().setTheUIManager(getTheUIManager());
        getTheUIManager().implementModel();
        return this;
    }

    public UIManager getTheUIManager() {
        return theUIManager;
    }

    public void setTheUIManager(UIManager theUIManager) {
        this.theUIManager = theUIManager;
    }

    public Domain getTheDomain() {
        return theDomain;
    }

    public void setTheDomain(Domain theDomain) {
        this.theDomain = theDomain;
    }

    public DesktopVM getDesktopVM() {
        return desktopVM = getTheUIManager().getTheDesktopVM();
    }

    public void setDesktopVM(DesktopVM desktopVM) {
        this.desktopVM = desktopVM;
    }

    public CntLoginVM getFormLoginVM() {
        return cntLoginVM = getDesktopVM().getFormLoginVM();
    }

    public void setFormLoginVM(CntLoginVM cntLoginVM) {
        this.cntLoginVM = cntLoginVM;
    }

    public CntHomeVM getHomeVM() {
        return cntHomeVM = getDesktopVM().getHomeVM();
    }

    public void setHomeVM(CntHomeVM cntHomeVM) {
        this.cntHomeVM = cntHomeVM;
    }

    public CntDenunciaVM getDenunciaVM() {
        return cntDenunciaVM = getDesktopVM().getDenunciaVM();
    }

    public void setDenunciaVM(CntDenunciaVM cntDenunciaVM) {
        this.cntDenunciaVM = cntDenunciaVM;
    }
}
