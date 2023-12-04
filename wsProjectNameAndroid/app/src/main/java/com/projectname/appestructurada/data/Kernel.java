package com.projectname.appestructurada.data;

import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;

public class Kernel {
    public static void login(CntLoginVM newCntLoginVM) {
       APIServerClientSide.login(newCntLoginVM);
    }
}
