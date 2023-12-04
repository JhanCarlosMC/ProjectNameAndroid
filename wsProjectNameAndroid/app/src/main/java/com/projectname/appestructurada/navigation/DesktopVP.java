package com.projectname.appestructurada.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.R;
import com.projectname.appestructurada.data.ViewVP;
import com.projectname.appestructurada.logic.Logic;
import com.projectname.appestructurada.presentation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;
import com.projectname.appestructurada.presentation.viewmodels.cnthomevm.CntHomeVM;
import com.projectname.appestructurada.presentation.viewparts.cntdenunciavp.CntDenunciaVP;
import com.projectname.appestructurada.presentation.viewparts.cntloginvp.CntLoginVP;
import com.projectname.appestructurada.presentation.viewparts.cnthomevp.CntHomeVP;

public class DesktopVP extends AppCompatActivity implements ViewVP {

    //External_context
    APP app = APP.getInstance();
    UIManager uiManager;
    //ViewPart ownedByViewViewPart;

    //external_context-ViewModels
    ViewModel viewModel;
    DesktopVM desktopVM;
    CntLoginVM cntLoginVM;
    CntHomeVM cntHomeVM;
    CntDenunciaVM cntDenunciaVM;

    //Internal_context
    Boolean isRendered;
    String idViewPart;
    Context theContext;
    View theView;

    //Internal_context-ViewParts
    DesktopVP desktopVP;
    CntLoginVP cntLoginVP;
    CntHomeVP cntHomeVP;
    CntDenunciaVP cntDenunciaVP;

    //Internal_context-Widgets
    BottomNavigationView navigationButton;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    public static void login(CntLoginVM newCntLoginVM) {
        Logic.login(newCntLoginVM);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //---------------------------------Capturar el contexto grafico de la ViewPart-----------------------------------------------------------------------------------------
        //  [x] aplica,  []---> invocar_super():   [super.super.onCreate(savedInstanceState); [AppCompatActivity]] o  [super.onActivityCreated(savedInstanceState); [Fragment]]
        super.onCreate(savedInstanceState);
        //  [x] aplica,  []---> solicitar la creacion de widgets(): setContentView(R.layout.nombrePantallaEnElLayout);
        setContentView(R.layout.activity_main);

        //---------------------------------Implementar el modelo------------------------------------------------------------------------------------------------------------
        implementModel();

        //open viewpart defautl
        ViewVP nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
        if (nextNavigationVP != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, (Fragment) nextNavigationVP).commit();
        }

    }

    public void implementModel() {

        /*[]=============================== Formulario de Control de implementarModelo() =============================[]*/
        //  [x] aplica,  []---> setThis;
        setDesktopVP(this);

        //---------------------------------actualizar la información interna del viewpart----------------------------------------------------------------------------
        //  [x] aplica,  //actualizar el viewPart  esto es para invocar la actualizacion de los handlers o recyclers, etc. updateViewPart();
        updateViewPartContext();
        //---------------------------------actualizar la información interna del viewpart----------------------------------------------------------------------------

        //---------------------------------Crear hijos--------------------------------------------------------------------------------------------------------
        //  [x] aplica,  []---> crear los hijos viewPart de la pantalla [solamnete la creacion desde el recurso]: tipoWidget newWidget = findViewById(R.id.nombreWidgetEnElLayout);
        CntLoginVP newCntLoginVP = new CntLoginVP();
        CntHomeVP newCntHomeVP = new CntHomeVP();
        CntDenunciaVP newCntDenunciaVP = new CntDenunciaVP();

        //---------------------------------Crear hijos--------------------------------------------------------------------------------------------------------

        //---------------------------------Enlazar hijos--------------------------------------------------------------------------------------------------------
        //  [x] aplica,  //enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando: sethijo(newHijo);
        setFormLoginVP(newCntLoginVP);
        setHomeVP(newCntHomeVP);
        setDenunciaVP(newCntDenunciaVP);

        //  [x] aplica,  //enlazar los hijos con su padre (clase que se esta implementando - "this"): newHijo.setOwnedByVP(this);
        newCntLoginVP.setOwnedByVP(this);
        newCntHomeVP.setOwnedByVP(this);
        newCntDenunciaVP.setOwnedByVP(this);

        //---------------------------------Enlazar hijos--------------------------------------------------------------------------------------------------------

        //---------------------------------Enlazar ViewModels con ViewParts-----------------------------------------------------------------------------------------
        //  [x] aplica,  //enlazar a cada hijo viewPart su respectivo viewModel:  newHijoViewPart.setViewModel(getContenedorHijoVM());
        setViewModel(getDesktopVM());
        newCntLoginVP.setTheViewModel(getFormLoginVM());
        newCntHomeVP.setTheViewModel(getHomeVM());
        newCntDenunciaVP.setTheViewModel(getDenunciaVM());

        //  [x] aplica,  //enlazar cada viewModel de cada hijo a el mismo:  getContenedorHijoVM().setViewPart(newHijoViewPart);
        getViewModel().setTheViewPart(this);
        getFormLoginVM().setTheViewPart(newCntLoginVP);
        getHomeVM().setTheViewPart(newCntHomeVP);
        getDenunciaVM().setTheViewPart(newCntDenunciaVP);

        //---------------------------------Enlazar ViewModels con ViewParts-----------------------------------------------------------------------------------------

        //---------------------------------Configurar id's de la viewpart-----------------------------------------------------------------------------------------
        //  [x] aplica,  //configurar el idViewPart de la viewPart: setIdViewPart(getOwnedByVP().getIdViewPart() + ":Tipo<Hijo>");
        setIdViewPart("Desktop_A");//--> Solo para la ViewPart que se carga de primera

        //  [x] aplica,regsitrar ids hijos
        newCntLoginVP.setIdViewPart("LoginUI_A");
        newCntHomeVP.setIdViewPart("HomeUI_F");
        newCntDenunciaVP.setIdViewPart("DenunciaUI_F");

        //---------------------------------Configurar id's de la viewpart-----------------------------------------------------------------------------------------

        //---------------------------------configurar la view de los hijos-----------------------------------------------------------------------------------------
        //  [] aplica,  //configurar la view de los hijos: newHijo.setTheView(rootView.findViewById(R.id.hijo);
        //---------------------------------configurar la view de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------implementarModelo de los hijos-----------------------------------------------------------------------------------------
        //  [] aplica,  //implementar el modelo de los hijos: newHijo.implementarModelo();

        //---------------------------------implementarModelo de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------registrar viewpart de los hijos-----------------------------------------------------------------------------------------
        //  [x] aplica,  //registrar el viewPart de los hijos: getTheUIManager().registrarViewPart(newHijo.getIIdViewPart(), newHijo);
        getUIManager().registerViewPart(newCntLoginVP, "LoginUI_A");
        getUiManager().registerViewPart(newCntHomeVP, "HomeUI_F");
        getUIManager().registerViewPart(newCntDenunciaVP, "DenunciaUI_F");

        //---------------------------------registrar viewpart de los hijos-----------------------------------------------------------------------------------------

        //---------------------------------registrar viewmodel de los hijos-----------------------------------------------------------------------------------------
        //  [x] aplica,  //registrar el viewmodel de los hijos: getTheUIManager().registrarViewModel(newHijo.getIIdViewModel(), newHijo);
        getUIManager().registerViewPart(newCntLoginVP, "LoginUI_A");
        getUiManager().registerViewPart(newCntHomeVP, "HomeUI_F");
        getUIManager().registerViewPart(newCntDenunciaVP, "DenunciaUI_F");

        //---------------------------------registrar viewmodel de los hijos-----------------------------------------------------------------------------------------


        //---------------------------------Implementar los widgets de la ViewPart-----------------------------------------------------------------------------------------
        //  [x] aplica,  []---> crear los widgets de la pantalla [solamente la creacion desde el recurso]: tipoWidget newWidget = findViewById(R.id.nombreWidgetEnElLayout);
        implementWidgets();
        //---------------------------------Implementar los widgets de la ViewPart-----------------------------------------------------------------------------------------

        //---------------------------------montar los eventos de la interfaz-----------------------------------------------------------------------------------------
        //  [x] aplica,  //montar los eventos de los widgets (listener = onclick(), keyPressed(), etc
        settingEvents();
        //---------------------------------montar los eventos de la interfaz-----------------------------------------------------------------------------------------

        //---------------------------------obtener los datos del viewModel desde el domain----------------------------------------------------------------------------
        //  [] aplica,  //actualizar el formulario viewModel desde el Domain: updateViewModel();  esto no debe afectar el estado del dialogo
        //   updateViewModel();
        //---------------------------------obtener los datos del viewModel desde el domain----------------------------------------------------------------------------

        //---------------------------------montar el automata de la interfaz-----------------------------------------------------------------------------------------
        //  [] aplica,  //inicializar el automata: getViewModel().actualizarMaquina("iniciarViewModel");
        getUIManager().navigationMachine("control");
        String action = getUIManager().navigationMachine("home");
        /*        action = getUIManager().navigationMachine("denuncia");*/

        //---------------------------------montar el automata de la interfaz-----------------------------------------------------------------------------------------

        //---------------------------------enlazar el handler con la viewModel de la viewpart------------------------------------------------------------------------
        //  [] aplica,  //enlazar  el handler con la viewModel,  esto es para tener acceso a los widgets de la viewpart desde cualquier lugar;
        //  getViewModel().setTheHandler(theHandler);  //es necesario crear el handler en esta clase e inicializar los metodos set y get para dicho handler!
        //---------------------------------registrar  el handler de la viewpart-------------------------------------------------------------------------------------

        /*[]=============================== Formulario de Control de implementarModelo() =============================[]*/
    }

    private void implementWidgets() {

        navigationButton = (BottomNavigationView) findViewById(R.id.nav_view);
        //BottomNavigationViewHelper.disableShiftMode(navigationButton);  No se necesita por el momento
        navigationButton.setItemIconTintList(null);

    }

    private void settingEvents() {

        mOnNavigationItemSelectedListener = item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {

                case R.id.navigation_login:
                    item.setChecked(true);
                    String action = getUIManager().navigationMachine("login");
                    ViewVP nextNavigationVP = getUIManager().getTheNextNavigationViewPart();

                    Intent intent = new Intent(getApplicationContext(), CntLoginVP.class);
                    startActivity(intent);

                    break;

                case R.id.navigation_home:
                    item.setChecked(true);
                    action = getUIManager().navigationMachine("home");
                    nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
                    if (nextNavigationVP != null)
                        selectedFragment = (Fragment) nextNavigationVP;
                    break;

                case R.id.navigation_denuncia:
                    item.setChecked(true);
                    action = getUIManager().navigationMachine("denuncia");
                    nextNavigationVP = getUIManager().getTheNextNavigationViewPart();
                    if (nextNavigationVP != null)
                        selectedFragment = (Fragment) nextNavigationVP;
                    break;

            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, selectedFragment).commit();
            }

            return false;
        };
        navigationButton.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void updateViewPartContext() {
        ///obtener el contexto:context
        //-----------------------------------------------------
        //-----------------------------------------------------
        //obtener el contexto y set:APP
        APP appFactory = APP.getInstance();
        setApp(appFactory);

        //-----------------------------------------------------
        //obtener el contexto y set:uiManager
        UIManager uim = getApp().getTheUIManager();
        setUiManager(uim);

        //-----------------------------------------------------
        //obtener el contexto y set:desktopVM
        DesktopVM deskvm = getApp().getTheDesktopVM();
        setDesktopVM(deskvm);

        //-----------------------------------------------------
        //obtener el contexto y set:formLoginVM
        CntLoginVM flvm = getApp().getFormLoginVM();
        setFormLoginVM(flvm);

        //-----------------------------------------------------
        //obtener el contexto:homeVM
        CntHomeVM hvm = getApp().getHomeVM();
        //setear la homeVM
        setHomeVM(hvm);

        //-----------------------------------------------------
        //obtener el contexto:denunciaVM
        CntDenunciaVM dvm = getApp().getDenunciaVM();
        //setear la denunciaVM
        setDenunciaVM(dvm);

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

    public CntLoginVM getFormLoginVM() {
        return cntLoginVM;
    }

    public void setFormLoginVM(CntLoginVM cntLoginVM) {
        this.cntLoginVM = cntLoginVM;
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

    public CntLoginVP getFormLoginVP() {
        return cntLoginVP;
    }

    public void setFormLoginVP(CntLoginVP cntLoginVP) {
        this.cntLoginVP = cntLoginVP;
    }

    public BottomNavigationView getNavigationButton() {
        return navigationButton;
    }

    public void setNavigationButton(BottomNavigationView navigationButton) {
        this.navigationButton = navigationButton;
    }

    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    public String getIdViewPart() {
        return idViewPart;
    }

    @Override
    public void setOwnedByVP(DesktopVP desktopVP) {

    }

    public ViewVP getOwnedByVP() {
        return null;
    }

    public UIManager getUIManager() {
        return uiManager;
    }

    public CntHomeVM getHomeVM() {
        return cntHomeVM;
    }

    public void setHomeVM(CntHomeVM cntHomeVM) {
        this.cntHomeVM = cntHomeVM;
    }

    public CntHomeVP getHomeVP() {
        return cntHomeVP;
    }

    public void setHomeVP(CntHomeVP cntHomeVP) {
        this.cntHomeVP = cntHomeVP;
    }

    public CntDenunciaVM getDenunciaVM() {
        return cntDenunciaVM;
    }

    public void setDenunciaVM(CntDenunciaVM cntDenunciaVM) {
        this.cntDenunciaVM = cntDenunciaVM;
    }

    public CntDenunciaVP getDenunciaVP() {
        return cntDenunciaVP;
    }

    public void setDenunciaVP(CntDenunciaVP cntDenunciaVP) {
        this.cntDenunciaVP = cntDenunciaVP;
    }
}
