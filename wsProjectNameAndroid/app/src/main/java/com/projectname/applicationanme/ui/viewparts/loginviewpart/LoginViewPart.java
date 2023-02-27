package com.projectname.applicationanme.ui.viewparts.loginviewpart;

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

import com.projectname.applicationanme.databinding.FragmentLoginBinding;
import com.projectname.applicationanme.databinding.LoginFormBinding;
import com.projectname.applicationanme.ui.viewmodels.loginviewmodel.LoginFormViewModel;

public class LoginViewPart extends Fragment {
    private com.projectname.applicationanme.databinding.LoginFormBinding bindingForm;
    private LoginFormViewModel loginFormViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        loginFormViewModel = new ViewModelProvider(this).get(LoginFormViewModel.class);

        bindingForm = LoginFormBinding.inflate(inflater, container, false);
        View rootForm = bindingForm.getRoot();

        final TextView labelUser = bindingForm.cardviewLogin.userInfo.labelUser;
        loginFormViewModel.getLabelUser().observe(getViewLifecycleOwner(), labelUser::setText);

        final EditText textUser = bindingForm.cardviewLogin.userInfo.textUser;
        loginFormViewModel.getTextUser().observe(getViewLifecycleOwner(), textUser::setHint);

        final TextView labelPassword = bindingForm.cardviewLogin.passwordInfo.labelUser;
        loginFormViewModel.getLabelPassword().observe(getViewLifecycleOwner(), labelPassword::setText);

        final EditText textPassword = bindingForm.cardviewLogin.passwordInfo.textUser;
        loginFormViewModel.getTextPassword().observe(getViewLifecycleOwner(), textPassword::setHint);
        loginFormViewModel.getInputType().observe(getViewLifecycleOwner(), textPassword::setInputType);


        final TextView labelTitleCardView = bindingForm.cardviewLogin.titleCardview;
        loginFormViewModel.getLabelTittleCardView().observe(getViewLifecycleOwner(), labelTitleCardView::setText);

        final CheckBox checkBoxRecuerdame = bindingForm.recuerdameCheckbox;
        loginFormViewModel.getCheckBoxRecuerdame().observe(getViewLifecycleOwner(), checkBoxRecuerdame::setText);

        final Button buttonLogin = bindingForm.buttonLogin;
        loginFormViewModel.getButtonLogin().observe(getViewLifecycleOwner(), buttonLogin::setText);

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
}
