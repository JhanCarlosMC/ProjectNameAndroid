package com.projectname.applicationame.presentation.viewmodels.formloginvm;

import android.text.InputType;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.applicationame.presentation.viewmodels.ViewModel;

public class FormLoginVM extends ViewModel {
    private final MutableLiveData<String> labelUser;
    private final MutableLiveData<String> textUser;
    private final MutableLiveData<String> labelTitleCardView;
    private final MutableLiveData<String> labelPassword;
    private final MutableLiveData<String> textPassword;
    private final MutableLiveData<String> checkBoxRememberme;
    private final MutableLiveData<String> buttonLogin;
    private final MutableLiveData<Integer> inputType;

    public FormLoginVM(){
        labelUser = new MutableLiveData<>();
        labelUser.setValue("User");

        textUser = new MutableLiveData<>();
        textUser.setValue("pepitoperez@example.com");

        labelPassword = new MutableLiveData<>();
        labelPassword.setValue("Password");

        textPassword = new MutableLiveData<>();
        textPassword.setValue("*********");

        labelTitleCardView = new MutableLiveData<>();
        labelTitleCardView.setValue("LoginForm");

        checkBoxRememberme = new MutableLiveData<>();
        checkBoxRememberme.setValue("Remember Me");

        buttonLogin = new MutableLiveData<>();
        buttonLogin.setValue("Login");

        inputType = new MutableLiveData<>();
        inputType.setValue(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public LiveData<String> getLabelUser(){
        return labelUser;
    }

    public LiveData<String> getTextUser(){
        return textUser;
    }

    public void setTextUser(String newUser) {
        textUser.setValue(newUser);
    }

    public LiveData<String> getLabelPassword() {
        return labelPassword;
    }


    public LiveData<String> getTextPassword() {
        return textPassword;
    }

    public void setTextPassword(String newPassword){
        textPassword.setValue(newPassword);
    }

    public LiveData<String> getLabelTittleCardView() {
        return labelTitleCardView;
    }

    public LiveData<String> getCheckBoxRecuerdame() {
        return checkBoxRememberme;
    }

    public LiveData<String> getButtonLogin() {
        return buttonLogin;
    }

    public LiveData<Integer> getInputType(){
        return inputType;
    }

    public void implementModel() {
    }

    public void resetTexts(){
        textUser.setValue("pepitoperez@example.com");
        textPassword.setValue("*********");
    }

}
