package com.projectname.appestructurada.logic;

import com.projectname.appestructurada.domain.Domain;
import com.projectname.appestructurada.presentation.viewmodels.cntloginvm.CntLoginVM;

public class Logic {
    public static void login(CntLoginVM newCntLoginVM) {
        Domain.login(newCntLoginVM);
    }

}
