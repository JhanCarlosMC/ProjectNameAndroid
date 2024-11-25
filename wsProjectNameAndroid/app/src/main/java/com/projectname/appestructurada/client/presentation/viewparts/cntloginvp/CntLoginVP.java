package com.projectname.appestructurada.client.presentation.viewparts.cntloginvp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.client.APP;
import com.projectname.appestructurada.databinding.ActivityLoginBinding;
import com.projectname.appestructurada.client.kernel.ViewVP;
import com.projectname.appestructurada.client.navigation.DesktopVP;
import com.projectname.appestructurada.client.presentation.UIManager;
import com.projectname.appestructurada.client.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.client.presentation.viewmodels.cntloginvm.CntLoginVM;

public class CntLoginVP extends AppCompatActivity implements ViewVP {
    private ActivityLoginBinding bindingLogin;
    private CntLoginVM cntLoginVM;
    private ViewVP ownedByVP;
    private APP app = APP.getInstance();
    private UIManager theUIManager;
    private String idViewPart;
    private ViewModel theViewModel;

    /*Layouts Elements*/
    private TextView labelTitleToolbar;
    private TextView labelUser;
    private EditText textUser;
    private TextView labelPassword;
    private EditText textPassword;
    private TextView labelTitleCardView;
    private CheckBox checkBoxRememberme;
    private Button buttonLogin;
    private RelativeLayout imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLogin = bindingLogin.inflate(getLayoutInflater());
        View root = bindingLogin.getRoot();
        setContentView(root);

        cntLoginVM = new ViewModelProvider(this).get(CntLoginVM.class);

        initComponents();
        settingEvents();

        // Ocultar la ActionBar
        getSupportActionBar().hide();
    }

    private void initComponents() {
        // Inicializar Widgets
        labelTitleToolbar = bindingLogin.txtTitleToolbar;
        cntLoginVM.getLabelTitleToolbar().observe(this, labelTitleToolbar::setText);

        labelUser = bindingLogin.includeLoginUser.txtTitle;
        cntLoginVM.getLabelUser().observe(this, labelUser::setText);

        textUser = bindingLogin.includeLoginUser.etInput;
        cntLoginVM.getTextUser().observe(this, textUser::setHint);

        labelPassword = bindingLogin.includeLoginPassword.txtTitle;
        cntLoginVM.getLabelPassword().observe(this, labelPassword::setText);

        textPassword = bindingLogin.includeLoginPassword.etInput;
        cntLoginVM.getTextPassword().observe(this, textPassword::setHint);
        cntLoginVM.getInputType().observe(this, textPassword::setInputType);

        labelTitleCardView = bindingLogin.txtTitleCardview;
        cntLoginVM.getLabelTittleCardView().observe(this, labelTitleCardView::setText);

        checkBoxRememberme = bindingLogin.remembermeCheckbox;
        cntLoginVM.getCheckBoxRecuerdame().observe(this, checkBoxRememberme::setText);

        buttonLogin = bindingLogin.btnLogin;
        cntLoginVM.getButtonLogin().observe(this, buttonLogin::setText);

        imgBack = bindingLogin.actionToolbarAtras;
    }

    public void settingEvents() {
        //Antiguo montarEventos()

        getButtonLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxRememberme.isChecked()) {
                    //setButtonLogin("Pass");
                    CntLoginVM newCntLoginVM = cntLoginVM;

                    newCntLoginVM.setTextUser(textUser.getText().toString());
                    newCntLoginVM.setTextPassword(textPassword.getText().toString());

                    //Log.e("onClick: FormLoginVP", "Info: "+formLoginVM.getTextUser().getValue());
                    DesktopVP.login(newCntLoginVM);

                    textUser.setText(null);
                    textPassword.setText(null);
                    cntLoginVM.resetTexts();
                }else{
                    mostrarAlerta();
                }
            }
        });

        getImgBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
    private void mostrarAlerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Debe completar todos campos del formulario")
                .setTitle("Alerta")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getUIManager().navigationMachine("back");

//        CntLoginVM newCntLoginVM = getCntLoginVM();
//        getCntLoginVM().updateDialogMachine("back");

//        if (!newCntLoginVM.getState().equals("Completado")){
//
//        }
//        setCntLoginVM(newCntLoginVM);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bindingLogin = null;
    }

    public APP getApp() {
        return app;
    }

    public void setApp(APP app) {
        this.app = app;
    }

    @Override
    public UIManager getUIManager() {
        theUIManager = app.getTheUIManager();
        return theUIManager;
    }

    public CntLoginVM getCntLoginVM() {
        cntLoginVM = app.getCntLoginVM();
        return cntLoginVM;
    }

    public void setCntLoginVM(CntLoginVM cntLoginVM) {
        app.setCntLoginVM(cntLoginVM);
    }

    public ViewModel getTheViewModel() {
        return theViewModel;
    }

    public void setTheViewModel(ViewModel theViewModel) {
        this.theViewModel = theViewModel;
    }

    @Override
    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    @Override
    public String getIdViewPart() {
        return idViewPart;
    }

    @Override
    public void setOwnedByVP(ViewVP viewVP) {
        ownedByVP = viewVP;
    }

    @Override
    public ViewVP getOwnedByVP() {
        return ownedByVP;
    }


    public Button getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(String buttonLogin) {
        this.buttonLogin.setText(buttonLogin);
    }

    public TextView getLabelUser() {
        return labelUser;
    }

    public void setLabelUser(TextView labelUser) {
        this.labelUser = labelUser;
    }

    public EditText getTextUser() {
        return textUser;
    }

    public void setTextUser(EditText textUser) {
        this.textUser = textUser;
    }

    public TextView getLabelPassword() {
        return labelPassword;
    }

    public void setLabelPassword(TextView labelPassword) {
        this.labelPassword = labelPassword;
    }

    public EditText getTextPassword() {
        return textPassword;
    }

    public void setTextPassword(EditText textPassword) {
        this.textPassword = textPassword;
    }

    public TextView getLabelTitleCardView() {
        return labelTitleCardView;
    }

    public void setLabelTitleCardView(TextView labelTitleCardView) {
        this.labelTitleCardView = labelTitleCardView;
    }

    public CheckBox getCheckBoxRememberme() {
        return checkBoxRememberme;
    }

    public void setCheckBoxRememberme(CheckBox checkBoxRememberme) {
        this.checkBoxRememberme = checkBoxRememberme;
    }

    public void setButtonLogin(Button buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public RelativeLayout getImgBack() {
        return imgBack;
    }

    public void setImgBack(RelativeLayout imgBack) {
        this.imgBack = imgBack;
    }
}
