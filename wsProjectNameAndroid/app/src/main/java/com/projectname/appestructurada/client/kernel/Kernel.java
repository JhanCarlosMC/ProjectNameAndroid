package com.projectname.appestructurada.client.kernel;

import com.projectname.appestructurada.client.presentation.viewmodels.cntloginvm.CntLoginVM;

public class Kernel {
    public static void login(CntLoginVM newCntLoginVM) {
       APIServerClientSide.login(newCntLoginVM);
    }
}
