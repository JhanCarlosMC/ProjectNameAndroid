package com.projectname.applicationanme;

import com.projectname.applicationanme.logic.Domain;
import com.projectname.applicationanme.navigation.DesktopVM;
import com.projectname.applicationanme.navigation.UIManager;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

//Esta clase hace de "ModelFactory" para el  nodo de cliente en el proyecto
public class APP {

    private UIManager theUIManager;
    private Domain theDomain;
    DesktopVM desktopVM;
    FormLoginVM formLoginVM;


    //------------------------------  Singleton ------------------------------------------------
    private static class SingletonHolder{
        private final static APP eINSTANCE = new APP();
    }

    // Método para obtener la instancia de nuestra clase
    public static APP getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    //------------------------------  Singleton ------------------------------------------------

    public APP implementarModelo() {
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
        getTheUIManager().implementarModelo();
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
        return desktopVM;
    }

    public void setDesktopVM(DesktopVM desktopVM) {
        this.desktopVM = desktopVM;
    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }
}
