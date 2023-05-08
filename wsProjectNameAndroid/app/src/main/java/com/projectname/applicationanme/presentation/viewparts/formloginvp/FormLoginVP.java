package com.projectname.applicationanme.presentation.viewparts.formloginvp;

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

import com.projectname.applicationanme.APP;
import com.projectname.applicationanme.databinding.LoginFormBinding;
import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.navigation.DesktopVP;
import com.projectname.applicationanme.navigation.UIManager;
import com.projectname.applicationanme.presentation.viewmodels.ViewModel;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

public class FormLoginVP extends Fragment implements ViewVP {
    private com.projectname.applicationanme.databinding.LoginFormBinding bindingForm;
    private FormLoginVM formLoginVM;

    ViewVP ownedByVP;
    APP app = APP.getInstance();
    UIManager uiManager;
    String idViewPart;
    ViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        formLoginVM = new ViewModelProvider(this).get(FormLoginVM.class);

        bindingForm = LoginFormBinding.inflate(inflater, container, false);
        View rootForm = bindingForm.getRoot();

        final TextView labelUser = bindingForm.cardviewLogin.userInfo.labelUser;
        formLoginVM.getLabelUser().observe(getViewLifecycleOwner(), labelUser::setText);

        final EditText textUser = bindingForm.cardviewLogin.userInfo.textUser;
        formLoginVM.getTextUser().observe(getViewLifecycleOwner(), textUser::setHint);

        final TextView labelPassword = bindingForm.cardviewLogin.passwordInfo.labelUser;
        formLoginVM.getLabelPassword().observe(getViewLifecycleOwner(), labelPassword::setText);

        final EditText textPassword = bindingForm.cardviewLogin.passwordInfo.textUser;
        formLoginVM.getTextPassword().observe(getViewLifecycleOwner(), textPassword::setHint);
        formLoginVM.getInputType().observe(getViewLifecycleOwner(), textPassword::setInputType);

        final TextView labelTitleCardView = bindingForm.cardviewLogin.titleCardview;
        formLoginVM.getLabelTittleCardView().observe(getViewLifecycleOwner(), labelTitleCardView::setText);

        final CheckBox checkBoxRememberme = bindingForm.remembermeCheckbox;
        formLoginVM.getCheckBoxRecuerdame().observe(getViewLifecycleOwner(), checkBoxRememberme::setText);

        final Button buttonLogin = bindingForm.buttonLogin;
        formLoginVM.getButtonLogin().observe(getViewLifecycleOwner(), buttonLogin::setText);

        return rootForm;
    }

//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        bindingForm.userInfo.buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                loginTestViewModel.setTextUser("Ingrese el correo");
////                NavHostFragment.findNavController(LoginViewPart.this)
////                        .navigate(R.id.action_Login_to_SecondFragment);
//            }
//        });
//    }

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
}
