package com.projectname.appestructurada.client.logic;

import com.projectname.appestructurada.client.domain.Domain;
import com.projectname.appestructurada.client.presentation.viewmodels.cntloginvm.CntLoginVM;

public class Logic {
    public static void login(CntLoginVM newCntLoginVM) {
        Domain.login(newCntLoginVM);
    }

}
