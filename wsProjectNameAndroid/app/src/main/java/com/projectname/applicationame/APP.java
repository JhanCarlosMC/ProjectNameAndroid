package com.projectname.applicationame;

import android.app.Application;

import com.projectname.applicationame.logic.Domain;
import com.projectname.applicationame.navigation.DesktopVM;
import com.projectname.applicationame.navigation.UIManager;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

//Esta clase hace de "ModelFactory" para el  nodo de cliente en el proyecto
public class APP extends Application {

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

    public FormLoginVM getFormLoginVM() {
        return formLoginVM = getDesktopVM().getFormLoginVM();
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }
}
