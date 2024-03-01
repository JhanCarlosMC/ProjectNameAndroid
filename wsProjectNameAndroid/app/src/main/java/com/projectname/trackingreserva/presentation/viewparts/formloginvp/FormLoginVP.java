package com.projectname.trackingreserva.presentation.viewparts.formloginvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.trackingreserva.APP;
import com.projectname.trackingreserva.databinding.LoginFormBinding;
import com.projectname.trackingreserva.kernel.ViewVP;
import com.projectname.trackingreserva.navigation.DesktopVP;
import com.projectname.trackingreserva.navigation.UIManager;
import com.projectname.trackingreserva.presentation.viewmodels.ViewModel;
import com.projectname.trackingreserva.presentation.viewmodels.formloginvm.FormLoginVM;
import com.projectname.trackingreserva.presentation.viewparts.trackingvp.GPSTracking;

public class FormLoginVP extends AppCompatActivity implements ViewVP {
    private com.projectname.trackingreserva.databinding.LoginFormBinding bindingForm;
    private FormLoginVM formLoginVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager uiManager;
    String idViewPart;
    ViewModel theViewModel;

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
        bindingForm = LoginFormBinding.inflate(getLayoutInflater());
        View rootForm = bindingForm.getRoot();
        setContentView(rootForm);

        formLoginVM = new ViewModelProvider(this).get(FormLoginVM.class);

        initComponents();
        settingEvents();
    }

    private void initComponents() {
        // Inicializar Widgets

        labelUser = bindingForm.cardviewLogin.userInfo.labelUser;
        formLoginVM.getLabelUser().observe(this, labelUser::setText);

        textUser = bindingForm.cardviewLogin.userInfo.textUser;
        formLoginVM.getTextUser().observe(this, textUser::setHint);

        labelPassword = bindingForm.cardviewLogin.passwordInfo.labelUser;
        formLoginVM.getLabelPassword().observe(this, labelPassword::setText);

        textPassword = bindingForm.cardviewLogin.passwordInfo.textUser;
        formLoginVM.getTextPassword().observe(this, textPassword::setHint);
        formLoginVM.getInputType().observe(this, textPassword::setInputType);

        labelTitleCardView = bindingForm.cardviewLogin.titleCardview;
        formLoginVM.getLabelTittleCardView().observe(this, labelTitleCardView::setText);

        checkBoxRememberme = bindingForm.remembermeCheckbox;
        formLoginVM.getCheckBoxRecuerdame().observe(this, checkBoxRememberme::setText);

        buttonLogin = bindingForm.buttonLogin;
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

                    DesktopVP.login(newFormLoginVM);

                    //Mandar Info
                    String userValue = textUser.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), GPSTracking.class);
                    intent.putExtra("editTextValue", userValue);

                    //Cargar Activity
                    startActivity(intent);

                    textUser.setText(null);
                    textPassword.setText(null);
                    formLoginVM.resetTexts();
                }else{
                    mostrarAlerta();
                }
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
    public void onDestroy() {
        super.onDestroy();
        bindingForm = null;
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
        uiManager = app.getTheUIManager();
        return uiManager;
    }
    public void setOwnedByVP(DesktopVP desktopVP) {
        ownedByVP = desktopVP;
    }
    @Override
    public ViewVP getOwnedByVP() {
        return ownedByVP;
    }
    @Override
    public void setOwnedByVP(ViewVP ownedByVP) {
        this.ownedByVP = ownedByVP;
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
