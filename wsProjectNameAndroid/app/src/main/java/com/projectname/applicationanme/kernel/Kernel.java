package com.projectname.applicationanme.kernel;

import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

public class Kernel {
    public static void login(FormLoginVM newFormLoginVM) {
       APIServerClientSide.login(newFormLoginVM);
    }
}
