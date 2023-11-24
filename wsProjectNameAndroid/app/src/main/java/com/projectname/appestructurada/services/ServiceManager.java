package com.projectname.appestructurada.services;

import com.projectname.appestructurada.kernel.Kernel;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;

public class ServiceManager {
    public static void login(CntLoginVM newCntLoginVM) {
        Kernel.login(newCntLoginVM);
    }
}
