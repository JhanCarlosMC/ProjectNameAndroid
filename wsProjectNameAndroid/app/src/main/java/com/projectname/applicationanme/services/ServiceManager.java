package com.projectname.applicationanme.services;

import com.projectname.applicationanme.kernel.Kernel;
import com.projectname.applicationanme.presentation.viewmodels.formloginvm.FormLoginVM;

public class ServiceManager {
    public static void login(FormLoginVM newFormLoginVM) {
        Kernel.login(newFormLoginVM);
    }
}
