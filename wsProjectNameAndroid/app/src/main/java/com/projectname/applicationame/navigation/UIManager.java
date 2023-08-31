package com.projectname.applicationame.navigation;

import com.projectname.applicationame.kernel.ViewVP;
import com.projectname.applicationame.logic.Domain;
import com.projectname.applicationame.presentation.viewmodels.ViewModel;
import com.projectname.applicationame.presentation.viewparts.ViewPart;

import java.util.ArrayList;
import java.util.List;

public class UIManager extends ViewModel {
    //Atributos
    private String uiRendered = "WITHOUTUI";
    private String lastUiRendered = " ";
    private String nextNavigationViewPart = " ";

    //Relaciones
    private DesktopVM theDesktopVM;
    private DesktopVP theDesktopVP;
    private Domain theDomain;
    private List<ViewPart> listRegisteredScreens;

    public void implementModel() {
        //instanciar Hijos
        //OLD -> ContenedorLoginViewModel newContenedorLoginViewModel = racional.app.denuncia.denuncia.denuncia.ui.contenedorformulariologinvm.ContenedorformulariologinvmFactory.eINSTANCE.createContenedorFormularioLoginVM();
        DesktopVM newDesktopVM = new DesktopVM();

        //enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);
        setTheDesktopVM(newDesktopVM);

        //enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"
        //---------CAMBIAR ESTE METODO PARA QUE RECIBA ES UNA CLASE VIEWMODEL GENERICO POR PARAMETRO-------------------------
        newDesktopVM.setOwnedBy(this);

        //enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"
        newDesktopVM.setTheUIManager(this);

        //configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"
        newDesktopVM.setIdViewModel("DesktopVM");

        //implementar el modelo de los hijos "newHijo.implementarModelo();"
        newDesktopVM.implementModel();

        //registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);
//        registrarViewModel(newDesktopVM, newDesktopVM.getIdViewModel());
    }

//    private void registrarViewModel(DesktopVM newDesktopVM, String idViewModel) {
//
//    }

    public String navigationMachine(final String evento) {
        String action = "";
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (getUiRendered().equals("WITHOUTUI")) {

            if (evento.equals("control")) {
                setUiRendered("LoginUI");
                return action;
            }

        }
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        if (getUiRendered().equals("LoginUI")) {

            if (evento.equals("login")) {
                setUiRendered("LoginUI");
                setNextNavigationViewPart("LoginUI");
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

        for(ViewPart tmpViewPart : getListRegisteredScreens()){
            if(tmpViewPart.getIdViewPart().equals(newIdViewPart)) return;
        }
        viewPartRegist.setViewPart(newViewPart);
        viewPartRegist.setIdViewPart(newIdViewPart);
        getListRegisteredScreens().add(viewPartRegist);
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
        if (listRegisteredScreens == null){
            listRegisteredScreens = new ArrayList<>();
        }
        return listRegisteredScreens;
    }

    public void setListRegisteredScreens(List<ViewPart> listRegisteredScreens) {
        this.listRegisteredScreens = listRegisteredScreens;
    }
}
