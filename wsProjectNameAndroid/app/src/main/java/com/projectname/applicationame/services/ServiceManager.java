package com.projectname.applicationame.services;

import com.projectname.applicationame.kernel.Kernel;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

public class ServiceManager {
    public static void login(FormLoginVM newFormLoginVM) {
        Kernel.login(newFormLoginVM);
    }
}
