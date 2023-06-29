package com.projectname.applicationanme.kernel;

import android.util.Log;

import com.projectname.applicationanme.logic.User;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

import retrofit2.Call;

public class Kernel {
    public static void login(FormLoginVM newFormLoginVM) {
       APIServerClientSide.Login(newFormLoginVM);
    }
}
