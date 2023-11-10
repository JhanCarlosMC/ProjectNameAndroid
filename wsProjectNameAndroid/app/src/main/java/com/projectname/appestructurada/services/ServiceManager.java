package com.projectname.appestructurada.services;

import com.projectname.appestructurada.kernel.Kernel;
import com.projectname.appestructurada.presentation.viewmodels.formloginvm.FormLoginVM;

public class ServiceManager {
    public static void login(FormLoginVM newFormLoginVM) {
        Kernel.login(newFormLoginVM);
    }
}
