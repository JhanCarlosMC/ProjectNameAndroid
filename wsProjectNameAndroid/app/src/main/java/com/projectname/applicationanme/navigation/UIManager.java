package com.projectname.applicationanme.navigation;

import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.logic.Domain;
import com.projectname.applicationanme.presentation.viewmodels.ViewModel;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.applicationanme.presentation.viewparts.ViewPart;
import com.projectname.applicationanme.presentation.viewparts.formloginvp.FormLoginVP;

import java.util.List;

public class UIManager extends ViewModel {
    //Va la navegacion

    private static final String UI_RENDERED_EDEFAULT = "WITHOUTUI";
    private String uiRendered = UI_RENDERED_EDEFAULT;
    private static final String LAST_UI_RENDERED_EDEFAULT = " ";
    private String lastUiRendered = LAST_UI_RENDERED_EDEFAULT;
    private static final String NEXT_NAVIGATION_VIEW_PART_EDEFAULT = " ";
    private String nextNavigationViewPart = NEXT_NAVIGATION_VIEW_PART_EDEFAULT;
    private DesktopVM desktop_VM;
    private FormLoginVM formLoginVM;
    private Domain theDomain;
    private List<ViewPart> listRegisteredScreens;

    public void implementarModelo() {
        //instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        DesktopVM newDesktopVM = new DesktopVM();

        //enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setDesktop_VM(newDesktopVM);

        //enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        //---------CAMBIAR ESTE METODO PARA QUE RECIBA ES UNA CLASE VIEWMODEL GENERICO POR PARAMETRO-------------------------
        newDesktopVM.setOwnedBy(this);

        //enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newDesktopVM.setUIManagerViewModel(this);

        //configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newDesktopVM.setIdViewModel("DesktopVM");

        //implementar el modelo de los hijos "newHijo.implementarModelo();"
        newDesktopVM.implementarModelo();

        //registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);
        registrarViewModel(newDesktopVM, newDesktopVM.getIdViewModel());
    }

    private void registrarViewModel(DesktopVM newDesktopVM, String idViewModel) {
        //
    }

    public String navigationMachine(final String evento) {
        String action = "";
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (getUiRendered().equals("WITHOUTUI")) {

            if (evento.equals("control")) {
                setUiRendered("ControlPanel_A");
                return action;
            }

        }
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (getUiRendered().equals("ControlPanel_A") || getUiRendered().equals("HomeUI")
                || getUiRendered().equals("DenunciarUI_F") || getUiRendered().equals("DenunciasUI_F")
                || getUiRendered().equals("CuentaUI_F")
                || getUiRendered().equals("ReservarUI_F")) {

            if (evento.equals("home")) {
                setNextNavigationViewPart("HomeUI_F");
                return action;
            }
            if (evento.equals("denunciar")) {
                setNextNavigationViewPart("DenunciarUI_F");
                return action;
            }

            if (evento.equals("reservar")) {
                setNextNavigationViewPart("ReservarUI_F");
                return action;
            }


            if (evento.equals("login")) {
                setLastUiRendered("ControlPanel_A");
                setUiRendered("LoginUserUI_A");
                setNextNavigationViewPart("LoginUserUI_A");
                return action;
            }

        }
        return action;

    }

    public String getUiRendered() {
        return uiRendered;
    }

    public String getLastUiRendered() {
        return lastUiRendered;
    }

    public String getNextNavigationViewPart() {
        return nextNavigationViewPart;
    }

    public void setUiRendered(String uiRendered) {
        this.uiRendered = uiRendered;
    }

    public void setLastUiRendered(String lastUiRendered) {
        this.lastUiRendered = lastUiRendered;
    }

    public void setNextNavigationViewPart(String nextNavigationViewPart) {
        this.nextNavigationViewPart = nextNavigationViewPart;
    }

    public FormLoginVM getFormLoginVM() {
        return formLoginVM;
    }

    public void setFormLoginVM(FormLoginVM formLoginVM) {
        this.formLoginVM = formLoginVM;
    }

    public DesktopVM getDesktop_VM() {
        return desktop_VM;
    }

    public void setDesktop_VM(DesktopVM desktop_VM) {
        this.desktop_VM = desktop_VM;
    }

    public Domain getTheDomain() {
        return theDomain;
    }

    public void setTheDomain(Domain theDomain) {
        this.theDomain = theDomain;
    }

    public List<ViewPart> getListRegisteredScreens() {
        return listRegisteredScreens;
    }

    public void setListRegisteredScreens(List<ViewPart> listRegisteredScreens) {
        this.listRegisteredScreens = listRegisteredScreens;
    }

    public ViewVP getTheNextNavigationViewPart() {
        for (ViewPart viewPart : getListRegisteredScreens()) {
            if (viewPart.getIdViewPart().equalsIgnoreCase(getNextNavigationViewPart())) {
                return viewPart.getViewPart();
            }
        }
        return null;
    }

    public void registrarViewPart(ViewVP newViewPart, String newIdViewPart) {
        ViewPart viewPartRegist = new ViewPart();

        for(ViewPart tmpViewPart : getListRegisteredScreens()){
            if(tmpViewPart.getIdViewPart().equals(newIdViewPart)) return;
        }
        viewPartRegist.setViewPart(newViewPart);
        viewPartRegist.setIdViewPart(newIdViewPart);
        getListRegisteredScreens().add(viewPartRegist);
    }
}
