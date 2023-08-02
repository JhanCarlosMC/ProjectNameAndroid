package com.projectname.applicationame.presentation.viewmodels;

import com.projectname.applicationame.kernel.ViewVP;
import com.projectname.applicationame.navigation.UIManager;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private String idViewModel = " ";
    private UIManager theUIManager;
    private ViewModel ownedBy;
    private List<ViewModel> childs;
    private ViewVP theViewPart;


    public UIManager getTheUIManager() {
        return theUIManager;
    }

    public void setTheUIManager(UIManager theUIManager) {
        this.theUIManager = theUIManager;
    }

    public String getIdViewModel() {
        return idViewModel;
    }

    public void setIdViewModel(String idViewModel) {
        this.idViewModel = idViewModel;
    }

    public ViewModel getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(ViewModel ownedBy) {
        this.ownedBy = ownedBy;
    }

    public List<ViewModel> getChilds() {
        return childs;
    }

    public void setChilds(List<ViewModel> childs) {
        this.childs = childs;
    }

    public ViewVP getTheViewPart() {
        return theViewPart;
    }

    public void setTheViewPart(ViewVP theViewPart) {
        this.theViewPart = theViewPart;
    }
}
