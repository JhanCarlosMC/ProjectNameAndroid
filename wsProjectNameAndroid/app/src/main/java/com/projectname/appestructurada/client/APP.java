package com.projectname.appestructurada.client;

import android.app.Application;
import android.util.Log;

import com.projectname.appestructurada.client.domain.Domain;
import com.projectname.appestructurada.client.kernel.Kernel;
import com.projectname.appestructurada.client.logic.Logic;
import com.projectname.appestructurada.client.navigation.DesktopVM;
import com.projectname.appestructurada.client.persistence.Persistence;
import com.projectname.appestructurada.client.presentation.UIManager;
import com.projectname.appestructurada.client.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cnthomevm.CntHomeVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntinformacionadicionalvm.CntInformacionAdicionalVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntloginvm.CntLoginVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cnttiporesiduovm.CntTipoResiduoVM;
import com.projectname.appestructurada.client.presentation.viewmodels.cntvolumenresiduovm.CntVolumenResiduoVM;

//Esta clase hace de "ModelFactory" para el  nodo de cliente en el proyecto
public class APP extends Application {

    //Variables propias
    private UIManager theUIManager;
    private Domain theDomain;
    private Persistence thePersistence;
    private Logic theLogic;
    private Kernel theKernel;

    //Variables de contexto
    private DesktopVM theDesktopVM;
    private CntLoginVM cntLoginVM;
    private CntHomeVM cntHomeVM;
    private CntDenunciaVM cntDenunciaVM;
    private CntVolumenResiduoVM cntVolumenResiduoVM;
    private CntTipoResiduoVM cntTipoResiduoVM;
    private CntInformacionAdicionalVM cntInformacionAdicionalVM;


    //------------------------------  Singleton ------------------------------------------------
    private static class SingletonHolder{
        private final static APP eINSTANCE = new APP();
    }

    // Método para obtener la instancia de nuestra clase
    public static APP getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    //------------------------------  Singleton -------------------------------------------------

    public APP() {
        implementModel();
        Log.e("APP: ", "cntVolumenResiduoVM: " + getTheUIManager().getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM());
        Log.e("APP: ", "cntVolumenResiduoVMData: " + getTheUIManager().getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM().getLabelRadioButtonMasGrande().getValue());
        Log.e("APP: ", "cntVolumenResiduoVMData: " + getTheUIManager().getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM().getLabelRadioButtonMasGrande().getValue());
    }

    public APP implementModel() {
        UIManager newUiManager = getTheUIManager();
        Domain newDomain = getTheDomain();
        Persistence newPersistence = getThePersistence();

        Logic newLogic = getTheLogic();
        Kernel newKernel = getTheKernel();

        if(newUiManager == null){
            newUiManager = new UIManager();
            setTheUIManager(newUiManager);
        }
        if(newDomain == null){
            newDomain = new Domain();
            setTheDomain(newDomain);
        }

        if(newPersistence == null){
            newPersistence = new Persistence();
            setThePersistence(newPersistence);
        }

        if(newLogic == null){
            newLogic = new Logic();
            setTheLogic(newLogic);
        }

        if(newKernel == null){
            newKernel = new Kernel();
            setTheKernel(newKernel);
        }

        getTheDomain().setThePersistence(getThePersistence());
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

    public Persistence getThePersistence() {
        return thePersistence;
    }

    public void setThePersistence(Persistence thePersistence) {
        this.thePersistence = thePersistence;
    }

    public Logic getTheLogic() {
        return theLogic;
    }

    public void setTheLogic(Logic theLogic) {
        this.theLogic = theLogic;
    }

    public Kernel getTheKernel() {
        return theKernel;
    }

    public void setTheKernel(Kernel theKernel) {
        this.theKernel = theKernel;
    }

    public DesktopVM getTheDesktopVM() {
        return theDesktopVM = getTheUIManager().getTheDesktopVM();
    }

    public void setTheDesktopVM(DesktopVM theDesktopVM) {
        this.theDesktopVM = theDesktopVM;
    }

    public CntLoginVM getCntLoginVM() {
        return cntLoginVM = getTheDesktopVM().getCntLoginVM();
    }

    public void setCntLoginVM(CntLoginVM cntLoginVM) {
        this.cntLoginVM = cntLoginVM;
    }

    public CntHomeVM getCntHomeVM() {
        return cntHomeVM = getTheDesktopVM().getCntHomeVM();
    }

    public void setCntHomeVM(CntHomeVM cntHomeVM) {
        this.cntHomeVM = cntHomeVM;
    }

    public CntDenunciaVM getCntDenunciaVM() {
        return cntDenunciaVM = getTheDesktopVM().getCntDenunciaVM();
    }

    public void setCntDenunciaVM(CntDenunciaVM cntDenunciaVM) {
        this.cntDenunciaVM = cntDenunciaVM;
    }

    public CntVolumenResiduoVM getCntVolumenResiduoVM() {
        return cntVolumenResiduoVM = getTheDesktopVM().getCntDenunciaVM().getCntVolumenResiduoVM();
    }

    public void setCntVolumenResiduoVM(CntVolumenResiduoVM cntVolumenResiduoVM) {
        this.cntVolumenResiduoVM = cntVolumenResiduoVM;
    }

    public CntTipoResiduoVM getCntTipoResiduoVM() {
        return cntTipoResiduoVM = getTheDesktopVM().getCntDenunciaVM().getCntTipoResiduoVM();
    }

    public void setCntTipoResiduoVM(CntTipoResiduoVM cntTipoResiduoVM) {
        this.cntTipoResiduoVM = cntTipoResiduoVM;
    }

    public CntInformacionAdicionalVM getCntInformacionAdicionalVM() {
        return cntInformacionAdicionalVM = getTheDesktopVM().getCntDenunciaVM().getCntInformacionAdicionalVM();
    }

    public void setCntInformacionAdicionalVM(CntInformacionAdicionalVM cntInformacionAdicionalVM) {
        this.cntInformacionAdicionalVM = cntInformacionAdicionalVM;
    }
}
