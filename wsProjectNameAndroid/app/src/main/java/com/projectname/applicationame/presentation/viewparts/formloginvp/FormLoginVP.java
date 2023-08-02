package com.projectname.applicationame.presentation.viewparts.formloginvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.projectname.applicationame.APP;
import com.projectname.applicationame.R;
import com.projectname.applicationame.databinding.LoginFormBinding;
import com.projectname.applicationame.kernel.ViewVP;
import com.projectname.applicationame.navigation.DesktopVP;
import com.projectname.applicationame.navigation.UIManager;
import com.projectname.applicationame.presentation.viewmodels.ViewModel;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

public class FormLoginVP extends Fragment implements ViewVP {
    private com.projectname.applicationame.databinding.LoginFormBinding bindingForm;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        formLoginVM = new ViewModelProvider(this).get(FormLoginVM.class);

        bindingForm = LoginFormBinding.inflate(inflater, container, false);
        View rootForm = bindingForm.getRoot();

        initComponents();
        settingEvents();

        return rootForm;
    }

    private void initComponents(){
        //Inicializar Widgets

        labelUser = bindingForm.cardviewLogin.userInfo.labelUser;
        formLoginVM.getLabelUser().observe(getViewLifecycleOwner(), labelUser::setText);

        textUser = bindingForm.cardviewLogin.userInfo.textUser;
        formLoginVM.getTextUser().observe(getViewLifecycleOwner(), textUser::setHint);

        labelPassword = bindingForm.cardviewLogin.passwordInfo.labelUser;
        formLoginVM.getLabelPassword().observe(getViewLifecycleOwner(), labelPassword::setText);

        textPassword = bindingForm.cardviewLogin.passwordInfo.textUser;
        formLoginVM.getTextPassword().observe(getViewLifecycleOwner(), textPassword::setHint);
        formLoginVM.getInputType().observe(getViewLifecycleOwner(), textPassword::setInputType);

        labelTitleCardView = bindingForm.cardviewLogin.titleCardview;
        formLoginVM.getLabelTittleCardView().observe(getViewLifecycleOwner(), labelTitleCardView::setText);

        checkBoxRememberme = bindingForm.remembermeCheckbox;
        formLoginVM.getCheckBoxRecuerdame().observe(getViewLifecycleOwner(), checkBoxRememberme::setText);

        buttonLogin = bindingForm.buttonLogin;
        formLoginVM.getButtonLogin().observe(getViewLifecycleOwner(), buttonLogin::setText);
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
    public void onDestroyView(){
        super.onDestroyView();
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
