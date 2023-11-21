package com.projectname.appestructurada.presentation.viewparts.loginvp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.appestructurada.APP;
import com.projectname.appestructurada.databinding.LoginFormBinding;
import com.projectname.appestructurada.kernel.ViewVP;
import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.navigation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.formloginvm.FormLoginVM;

public class FormLoginVP extends AppCompatActivity implements ViewVP {
    private com.projectname.appestructurada.databinding.LoginFormBinding bindingLogin;
    private FormLoginVM formLoginVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;

    /*Layouts Elements*/
    public TextView labelUser;
    public EditText textUser;
    public TextView labelPassword;
    public EditText textPassword;
    public TextView labelTitleCardView;
    public CheckBox checkBoxRememberme;
    public Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLogin = LoginFormBinding.inflate(getLayoutInflater());
        View rootForm = bindingLogin.getRoot();
        setContentView(rootForm);

        formLoginVM = new ViewModelProvider(this).get(FormLoginVM.class);

        initComponents();
        settingEvents();

        // Cambiar el título de la actividad
        setTitle("Login");

        // Habilitar el botón de retroceso en el ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Lógica para manejar el clic en el botón de retroceso
                onBackPressed();  // Esta línea es opcional, puedes personalizar la acción
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initComponents() {
        // Inicializar Widgets

        labelUser = bindingLogin.cardviewLogin.userInfo.labelUser;
        formLoginVM.getLabelUser().observe(this, labelUser::setText);

        textUser = bindingLogin.cardviewLogin.userInfo.textUser;
        formLoginVM.getTextUser().observe(this, textUser::setHint);

        labelPassword = bindingLogin.cardviewLogin.passwordInfo.labelUser;
        formLoginVM.getLabelPassword().observe(this, labelPassword::setText);

        textPassword = bindingLogin.cardviewLogin.passwordInfo.textUser;
        formLoginVM.getTextPassword().observe(this, textPassword::setHint);
        formLoginVM.getInputType().observe(this, textPassword::setInputType);

        labelTitleCardView = bindingLogin.cardviewLogin.titleCardview;
        formLoginVM.getLabelTittleCardView().observe(this, labelTitleCardView::setText);

        checkBoxRememberme = bindingLogin.remembermeCheckbox;
        formLoginVM.getCheckBoxRecuerdame().observe(this, checkBoxRememberme::setText);

        buttonLogin = bindingLogin.buttonLogin;
        formLoginVM.getButtonLogin().observe(this, buttonLogin::setText);
    }

    public void settingEvents(){
        //Antiguo montarEventos()

        getButtonLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxRememberme.isChecked()) {
                    //setButtonLogin("Pass");
                    FormLoginVM newFormLoginVM = formLoginVM;

                    newFormLoginVM.setTextUser(textUser.getText().toString());
                    newFormLoginVM.setTextPassword(textPassword.getText().toString());

                    //Log.e("onClick: FormLoginVP", "Info: "+formLoginVM.getTextUser().getValue());
                    DesktopVP.login(newFormLoginVM);

                    textUser.setText(null);
                    textPassword.setText(null);
                    formLoginVM.resetTexts();
                }
            }
        });
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

    public ViewModel getTheViewModel() {
        return theViewModel;
    }

    public void setTheViewModel(ViewModel theViewModel) {
        this.theViewModel = theViewModel;
    }


    public void setIdViewPart(String newIdViewPart) {
        idViewPart = newIdViewPart;
    }

    public String getIdViewPart() {
        return idViewPart;
    }

    public UIManager getUIManager() {
        theUIManager = app.getTheUIManager();
        return theUIManager;
    }

    @Override
    public void setOwnedByVP(DesktopVP desktopVP) {
        ownedByVP = desktopVP;
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
}
