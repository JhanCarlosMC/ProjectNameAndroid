package com.projectname.applicationanme.navigation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.projectname.applicationanme.APP;
import com.projectname.applicationanme.R;
import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.presentation.viewmodels.ViewModel;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.applicationanme.presentation.viewparts.ViewPart;
import com.projectname.applicationanme.presentation.viewparts.formloginvp.FormLoginVP;

public class DesktopVP extends AppCompatActivity implements ViewVP{

    //External_context
    APP app = APP.getInstance();
    UIManager uiManager;
    //ViewPart ownedByViewViewPart;

    //external_context-ViewModels
    ViewModel viewModel;
    DesktopVM desktopVM;
    FormLoginVM formLoginVM;

    //Internal_context
    Boolean isRendered;
    String idViewPart;
    Context theContext;
    View theView;

    //Internal_context-ViewParts
    DesktopVP desktopVP;
    FormLoginVP formLoginVP;


    //Internal_context-Widgets
    BottomNavigationView navigationButton;
    Handler theHandler;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    public void implementarModelo() {

        /*[]=============================== Formulario de Control de implementarModelo() =============================[]*/
        //  [x] aplica,  []---> setThis;
        setDesktopVP(this);

        //---------------------------------actualizar la información interna del viewpart----------------------------------------------------------------------------
        //  [x] aplica,  //actualizar el viewPart  esto es para invocar la actualizacion de los handlers o recyclers, etc. updateViewPart();
        updateViewPartContext();
        //---------------------------------actualizar la información interna del viewpart----------------------------------------------------------------------------

        //---------------------------------Crear hijos--------------------------------------------------------------------------------------------------------
        //  [x] aplica,  []---> crear los hijos viewPart de la pantalla [solamnete la creacion desde el recurso]: tipoWidget newWidget = findViewById(R.id.nombreWidgetEnElLayout);
        FormLoginVP newFormLoginVP = new FormLoginVP();

        //---------------------------------Crear hijos--------------------------------------------------------------------------------------------------------

        //---------------------------------Enlazar hijos--------------------------------------------------------------------------------------------------------
        //  [x] aplica,  //enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando: sethijo(newHijo);
        setFormLoginVP(newFormLoginVP);

        //  [x] aplica,  //enlazar los hijos con su padre (clase que se esta implementando - "this"): newHijo.setOwnedByVP(this);
        newFormLoginVP.setOwnedByVP(this);

        //---------------------------------Enlazar hijos--------------------------------------------------------------------------------------------------------

        //---------------------------------Enlazar ViewModels con ViewParts-----------------------------------------------------------------------------------------
        //  [x] aplica,  //enlazar a cada hijo viewPart su respectivo viewModel:  newHijoViewPart.setViewModel(getContenedorHijoVM());
        setViewModel(getDesktopVM());
        //newContenedorFormularioHomeViewPart.setViewModel(getContenedorFormularioHomeVM());
        newFormLoginVP.setViewModel(getFormLoginVM());
        ;

        //  [x] aplica,  //enlazar cada viewModel de cada hijo a el mismo:  getContenedorHijoVM().setViewPart(newHijoViewPart);
        getViewModel().setViewPart(this);

        getFormLoginVM().setViewPart(newFormLoginVP);


        //---------------------------------Enlazar ViewModels con ViewParts-----------------------------------------------------------------------------------------


        //---------------------------------Configurar id's de la viewpart-----------------------------------------------------------------------------------------
        //  [x] aplica,  //configurar el idViewPart de la viewPart: setIdViewPart(getOwnedByVP().getIdViewPart() + ":Tipo<Hijo>");
        //setIdViewPart("paneldecontrolViewPart");
        setIdViewPart("destopvp");//--> Solo para la ViewPart que se carga de primera

        //  [x] aplica,regsitrar ids hijos
        /*
        newContenedorFormularioHomeViewPart.setIdViewPart("HomeUI_F");
        newContenedorFormularioAjustesViewPart.setIdViewPart("SettingUI_F");
        newContenedorFormDenunciaViewPart.setIdViewPart("DenunciaUI_F");
        newContenedorListaMisDenunciasViewPart.setIdViewPart("MisDenunciasUI_F");

        newContenedorFormReservaViewPart.setIdViewPart("ReservaUI_F");
        */
        newFormLoginVP.setIdViewPart("LoginUI");

        //---------------------------------Configurar id's de la viewpart-----------------------------------------------------------------------------------------

        //---------------------------------configurar la view de los hijos-----------------------------------------------------------------------------------------
        //  [] aplica,  //configurar la view de los hijos: newHijo.setTheView(rootView.findViewById(R.id.hijo);
        //---------------------------------configurar la view de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------implementarModelo de los hijos-----------------------------------------------------------------------------------------
        //  [] aplica,  //implementar el modelo de los hijos: newHijo.implementarModelo();
        /*       newContenedorFormularioHomeViewPart.implementarModelo();
                newContenedorFormularioAjustesViewPart.implementarModelo();
                newContenedorFormDenunciaViewPart.implementarModelo();
                newContenedorListaMisDenunciasViewPart.implementarModelo();*/
        //---------------------------------implementarModelo de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------registrar viewpart de los hijos-----------------------------------------------------------------------------------------
        //  [x] aplica,  //registrar el viewPart de los hijos: getTheUIManager().registrarViewPart(newHijo.getIIdViewPart(), newHijo);
        //getUIManager().registrarViewPart(newContenedorFormularioHomeViewPart, "HomeUI_F");
        getUIManager().registrarViewPart(newFormLoginVP, "LoginUI");

        //---------------------------------registrar viewpart de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------Implementar los widgets de la ViewPart-----------------------------------------------------------------------------------------
        //  [x] aplica,  []---> crear los widgets de la pantalla [solamente la creacion desde el recurso]: tipoWidget newWidget = findViewById(R.id.nombreWidgetEnElLayout);
        implementarWidgets();
        //---------------------------------Implementar los widgets de la ViewPart-----------------------------------------------------------------------------------------


        //---------------------------------montar los eventos de la interfaz-----------------------------------------------------------------------------------------
        //  [x] aplica,  //montar los eventos de los widgets (listener = onclick(), keyPressed(), etc
        montarEventos();
        //---------------------------------montar los eventos de la interfaz-----------------------------------------------------------------------------------------

        //---------------------------------obtener los datos del viewModel desde el domain----------------------------------------------------------------------------
        //  [] aplica,  //actualizar el formulario viewModel desde el Domain: updateViewModel();  esto no debe afectar el estado del dialogo
        //   updateViewModel();
        //---------------------------------obtener los datos del viewModel desde el domain----------------------------------------------------------------------------

        //---------------------------------montar el automata de la interfaz-----------------------------------------------------------------------------------------
        //  [] aplica,  //inicializar el automata: getViewModel().actualizarMaquina("iniciarViewModel");
        getUIManager().navigationMachine("control");
        String action = getUIManager().navigationMachine("home");
        //---------------------------------montar el automata de la interfaz-----------------------------------------------------------------------------------------

        //---------------------------------enlazar el handler con la viewModel de la viewpart------------------------------------------------------------------------
        //  [] aplica,  //enlazar  el handler con la viewModel,  esto es para tener acceso a los widgets de la viewpart desde cualquier lugar;
        //  getViewModel().setTheHandler(theHandler);  //es necesario crear el handler en esta clase e inicializar los metodos set y get para dicho handler!
        //---------------------------------registrar  el handler de la viewpart-------------------------------------------------------------------------------------

        /*[]=============================== Formulario de Control de implementarModelo() =============================[]*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //---------------------------------Capturar el contexto grafico de la ViewPart-----------------------------------------------------------------------------------------
        //  [x] aplica,  []---> invocar_super():   [super.super.onCreate(savedInstanceState); [AppCompatActivity]] o  [super.onActivityCreated(savedInstanceState); [Fragment]]
        super.onCreate(savedInstanceState);
        //  [x] aplica,  []---> solicitar la creacion de widgets(): setContentView(R.layout.nombrePantallaEnElLayout);
        setContentView(R.layout.activity_main);
        //---------------------------------Capturar el contexto grafico de la ViewPart-----------------------------------------------------------------------------------------

        //---------------------------------Implementar el modelo------------------------------------------------------------------------------------------------------------
        implementarModelo();
        //---------------------------------Implementar el modelo------------------------------------------------------------------------------------------------------------

        //open viewpart defautl
        ViewVP nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
        if (nextNavigationVP != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, (Fragment) nextNavigationVP).commit();
        }

    }

    private void implementarWidgets() {

        navigationButton = (BottomNavigationView) findViewById(R.id.nav_view);
        //BottomNavigationViewHelper.disableShiftMode(navigationButton);
        navigationButton.setItemIconTintList(null);

    }

    private void montarEventos() {

        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        item.setChecked(true);
                        String action = getUIManager().navigationMachine("home");
                        ViewVP nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
                        if (nextNavigationVP != null)
                            selectedFragment = (Fragment) nextNavigationVP;
                        break;

                    case R.id.navigation_login:
                        item.setChecked(true);
                        TextView txtclose;
                        Button btnFollow;
                        action = getUIManager().navigationMachine("login");
                        nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
                        if (nextNavigationVP != null)
                            selectedFragment = (Fragment) nextNavigationVP;

                        break;

                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, selectedFragment).commit();
                }

                return false;
            }

        };
        navigationButton.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }


    public String getIdViewPart() {
        return idViewPart;
    }

    public void setOwnedByVP(ViewVP newViewVP) {

    }


    public ViewVP getOwnedByVP() {
        return null;
    }

    public UIManager getUIManager() {
        return uiManager;
    }

    public void updateViewPartContext() {
        //-----------------------------------------------------
        //obtener el contexto:view
        //obtener la view de la viewpart
        /*        View rootView = ((Activity)this).getWindow().getDecorView().findViewById(android.R.id.content);
                View v = rootView.findViewById(R.id.panel_control);
            //setear la view
                setTheView(v);
        *///obtener el contexto:view
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto:context
        //obtener el contexto de la viewpart
        /*        Context c;
                //c = DenunciaAplicacion.getContext();
                c = this;
            //setear el contexto
                setTheContext(c);  // en este caso, esta viewpart obtiene el contexto inicial de la app montado por el sistema
        *///obtener el contexto:context
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto:modelFactoryModel
        //obtener el modelFactoryModel  de la viewpart
        APP appFactory = APP.getInstance();
        //setear el modelFactoryModel
        setApp(appFactory);
        //obtener el contexto:modelFactoryModel
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto:uiManager
        //obtener el uiManager de la viewpart
        UIManager uim = getApp().getTheUIManager();
        //setear la uiManager
        setUiManager(uim);
        //obtener el contexto:uiManager
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto:contenedorPanelControlVM
        //obtener el contenedorPanelControlVM de la viewpart
        DesktopVM deskvm = getApp().getDesktopVM();
        //setear la contenedorPanelControlVM
        setDesktopVM(deskvm);
        //obtener el contexto:contenedorPanelControlVM
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto:contenedorFormularioHomevVM
        //obtener el contenedorFormularioHomevVM de la viewpart
        FormLoginVM flvm = getApp().getFormLoginVM();
        //setear la contenedorFormularioHomevVM
        setFormLoginVM(flvm);
        //obtener el contexto:contenedorFormularioHomevVM

        //-----------------------------------------------------
        //-----------------------------------------------------
        //montar el handler
        //crear el handler
        Handler h = new Handler() {


        };
        //setear el handler
        setTheHandler(h);
        //montar el handler
        //-----------------------------------------------------
        //-----------------------------------------------------
        setRendered(true);
        //-----------------------------------------------------

    }

    public APP getApp() {
        return app;
    }

    public void setApp(APP app) {
        this.app = app;
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
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

    public Boolean getRendered() {
        return isRendered;
    }

    public void setRendered(Boolean rendered) {
        isRendered = rendered;
    }

    public Context getTheContext() {
        return theContext;
    }

    public void setTheContext(Context theContext) {
        this.theContext = theContext;
    }

    public View getTheView() {
        return theView;
    }

    public void setTheView(View theView) {
        this.theView = theView;
    }

    public DesktopVP getDesktopVP() {
        return desktopVP;
    }

    public void setDesktopVP(DesktopVP desktopVP) {
        this.desktopVP = desktopVP;
    }

    public FormLoginVP getFormLoginVP() {
        return formLoginVP;
    }

    public void setFormLoginVP(FormLoginVP formLoginVP) {
        this.formLoginVP = formLoginVP;
    }

    public BottomNavigationView getNavigationButton() {
        return navigationButton;
    }

    public void setNavigationButton(BottomNavigationView navigationButton) {
        this.navigationButton = navigationButton;
    }

    public Handler getTheHandler() {
        return theHandler;
    }

    public void setTheHandler(Handler theHandler) {
        this.theHandler = theHandler;
    }

    public BottomNavigationView.OnNavigationItemSelectedListener getmOnNavigationItemSelectedListener() {
        return mOnNavigationItemSelectedListener;
    }

    public void setmOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener) {
        this.mOnNavigationItemSelectedListener = mOnNavigationItemSelectedListener;
    }


}
