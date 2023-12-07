package com.projectname.appestructurada.presentation.viewparts.cntloginvp;

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
import com.projectname.appestructurada.databinding.ActivityLoginBinding;
import com.projectname.appestructurada.data.ViewVP;
import com.projectname.appestructurada.navigation.DesktopVP;
import com.projectname.appestructurada.presentation.UIManager;
import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;

public class CntLoginVP extends AppCompatActivity implements ViewVP {
    private ActivityLoginBinding bindingLogin;
    private CntLoginVM cntLoginVM;
    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager theUIManager;
    String idViewPart;
    ViewModel theViewModel;

    /*Layouts Elements*/
    public TextView labelTitleToolbar;
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
        bindingLogin = bindingLogin.inflate(getLayoutInflater());
        View rootForm = bindingLogin.getRoot();
        setContentView(rootForm);

        cntLoginVM = new ViewModelProvider(this).get(CntLoginVM.class);

        initComponents();
        settingEvents();

        // Ocultar la ActionBar
        getSupportActionBar().hide();
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
        labelTitleToolbar = bindingLogin.includeToolbarLogin.txtTitleToolbar;
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
