package com.projectname.appestructurada.presentation.viewmodels.cntloginvm;

import android.text.InputType;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;
import com.projectname.appestructurada.presentation.viewmodels.cntdenunciavm.CntDenunciaVM;
import com.projectname.appestructurada.presentation.viewmodels.cnthomevm.CntHomeVM;

public class CntLoginVM extends ViewModel {
    private final MutableLiveData<String> labelTitleToolbar;
    private final MutableLiveData<String> labelUser;
    private final MutableLiveData<String> textUser;
    private final MutableLiveData<String> labelTitleCardView;
    private final MutableLiveData<String> labelPassword;
    private final MutableLiveData<String> textPassword;
    private final MutableLiveData<String> checkBoxRememberme;
    private final MutableLiveData<String> buttonLogin;
    private final MutableLiveData<Integer> inputType;

    public CntLoginVM() {
        labelTitleToolbar = new MutableLiveData<>();
        labelTitleToolbar.setValue("Login");

        labelUser = new MutableLiveData<>();
        labelUser.setValue("User");

        textUser = new MutableLiveData<>();
        textUser.setValue("pepitoperez@example.com");

        labelPassword = new MutableLiveData<>();
        labelPassword.setValue("Password");

        textPassword = new MutableLiveData<>();
        textPassword.setValue("*********");

        labelTitleCardView = new MutableLiveData<>();
        labelTitleCardView.setValue("Login");

        checkBoxRememberme = new MutableLiveData<>();
        checkBoxRememberme.setValue("Remember Me");

        buttonLogin = new MutableLiveData<>();
        buttonLogin.setValue("Login");

        inputType = new MutableLiveData<>();
        inputType.setValue(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public void implementModel() {
        //Instanciar Hijos --> HijoVM newHijo = new HijoVM();

        //Enlazar el padre con sus hijos mediante metodos set de la clase que se esta implementando "sethijo(newHijo);

        //Enlazar los hijos con su padre (clase que se esta implementando - "this") "newHijo.setOwnedBy(this);"

        //Enlazar los hijos con con el UIManager "newHijo.setTheUIManager(getTheUIManager());"

        //Configurar el id de cada hijo  "newHijo.setIdViewModel(getIdViewModel() + ":Tipo<Hijo>");"

        //Implementar el modelo de los hijos "newHijo.implementarModelo();"

        //Registrar el viewModel de los hijos " getTheUIManager().registrarViewModel(newHijo.getIdViewModel(), newHijo);

    }

    public MutableLiveData<String> getLabelTitleToolbar() {
        return labelTitleToolbar;
    }

    public MutableLiveData<String> getLabelTitleCardView() {
        return labelTitleCardView;
    }

    public MutableLiveData<String> getCheckBoxRememberme() {
        return checkBoxRememberme;
    }

    public LiveData<String> getLabelUser() {
        return labelUser;
    }

    public LiveData<String> getTextUser() {
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

    public void setTextPassword(String newPassword) {
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

    public LiveData<Integer> getInputType() {
        return inputType;
    }



    public void resetTexts() {
        textUser.setValue("pepitoperez@example.com");
        textPassword.setValue("*********");
    }

}
