package com.projectname.appestructurada.presentation;

import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.domain.Domain;
import com.projectname.appestructurada.navigation.DesktopVM;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewparts.ViewPart;

import java.util.ArrayList;
import java.util.List;

public class UIManager extends ViewModel {
    //Atributos
    private String uiRendered = "NOT_INITIALIZED";
    private String lastUiRendered = " ";
    private String nextNavigationViewPart = " ";
    private String state = "NOT_INITIALIZED";

    private List<ViewPart> listRegisteredScreens;
    private List<ViewModel> listViewModels;
    //Relaciones
    private DesktopVM theDesktopVM;
    private Domain theDomain;

    public void implementModel() {
        //instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        DesktopVM newDesktopVM = new DesktopVM();

        //enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setTheDesktopVM(newDesktopVM);

        //enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        newDesktopVM.setOwnedBy(this);

        //enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newDesktopVM.setTheUIManager(this);

        //configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newDesktopVM.setIdViewModel("DesktopVM");

        //implementar el modelo de los hijos "newHijo.implementarModelo();"
        newDesktopVM.implementModel();

        //registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);
        registerViewModel(newDesktopVM.getIdViewModel(), newDesktopVM);
    }

    public String navigationMachine(final String event) {
        String action = "";
        state = getUiRendered();

        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (state.equals("NOT_INITIALIZED")) {

            if (event.equals("control")) {
                setUiRendered("Desktop_A");
                return action;
            }

        }
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (state.equals("Desktop_A") || state.equals("HomeUI_F") || state.equals("LoginUI_A") || state.equals("DenunciaUI_F")) {

            if (event.equals("login")) {
                setLastUiRendered(getUiRendered());
                setUiRendered("LoginUI_A");
                setNextNavigationViewPart("LoginUI_A");
                return action;
            }

            if (event.equals("home")) {
                setNextNavigationViewPart("HomeUI_F");
                return action;
            }

            if (event.equals("denuncia")) {
                setNextNavigationViewPart("DenunciaUI_F");
                return action;
            }

            if (event.equals("navigateToCategoriaVolumen")) {
                setLastUiRendered("DenunciaUI_F");
                setUiRendered("VolumenUI_A");
                setNextNavigationViewPart("VolumenUI_A");
                return action;
            }

            if (event.equals("navigateToCategoriaTipo")) {
                setLastUiRendered("DenunciaUI_F");
                setUiRendered("TipoUI_A");
                setNextNavigationViewPart("TipoUI_A");
                return action;
            }

            if (event.equals("navigateToCategoriaInformacion")) {
                setLastUiRendered("DenunciaUI_F");
                setUiRendered("InformacionUI_A");
                setNextNavigationViewPart("InformacionUI_A");
                return action;
            }
        }

        if (getUiRendered().equals("LoginUI_A")) {
            if(event.equals("back")){
                setUiRendered(getLastUiRendered());
                setNextNavigationViewPart(getUiRendered());
                return action;
            }
        }

        if (getUiRendered().equals("VolumenUI_A")) {
            if(event.equals("back")){
                setUiRendered(getLastUiRendered());
                setNextNavigationViewPart(getUiRendered());
                return action;
            }
        }

        return action;
    }

    public ViewVP getTheNextNavigationViewPart() {
        for (ViewPart viewPart : getListRegisteredScreens()) {
            if (viewPart.getIdViewPart().equalsIgnoreCase(getNextNavigationViewPart())) {
                return viewPart.getViewPart();
            }
        }
        return null;
    }

    public void registerViewPart(ViewVP newViewPart, String newIdViewPart) {
        ViewPart viewPartRegist = new ViewPart();

        for (ViewPart tmpViewPart : getListRegisteredScreens()) {
            if (tmpViewPart.getIdViewPart().equals(newIdViewPart)) return;
        }
        viewPartRegist.setViewPart(newViewPart);
        viewPartRegist.setIdViewPart(newIdViewPart);
        getListRegisteredScreens().add(viewPartRegist);
    }

    public void registerViewModel(String idViewModel, ViewModel newViewModel) {
        //VERIFICAR CONTENIDO

        for (ViewModel tmpViewModel : getListViewModels()) {
            if (tmpViewModel.getIdViewModel().equals(idViewModel)) return;
        }

        newViewModel.setIdViewModel(idViewModel);
        getListViewModels().add(newViewModel);
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

    public DesktopVM getTheDesktopVM() {
        return theDesktopVM;
    }

    public void setTheDesktopVM(DesktopVM theDesktopVM) {
        this.theDesktopVM = theDesktopVM;
    }

    public Domain getTheDomain() {
        return theDomain;
    }

    public void setTheDomain(Domain theDomain) {
        this.theDomain = theDomain;
    }

    public List<ViewPart> getListRegisteredScreens() {
        if (listRegisteredScreens == null) {
            listRegisteredScreens = new ArrayList<>();
        }
        return listRegisteredScreens;
    }

    public void setListRegisteredScreens(List<ViewPart> listRegisteredScreens) {
        this.listRegisteredScreens = listRegisteredScreens;
    }

    public List<ViewModel> getListViewModels() {
        if (listViewModels == null){
            listViewModels = new ArrayList<>();
        }
        return listViewModels;
    }

    public void setListViewModels(List<ViewModel> listViewModels) {
        this.listViewModels = listViewModels;
    }
}
