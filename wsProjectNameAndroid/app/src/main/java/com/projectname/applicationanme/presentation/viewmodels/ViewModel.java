package com.projectname.applicationanme.presentation.viewmodels;

import com.projectname.applicationanme.kernel.ViewVP;
import com.projectname.applicationanme.navigation.UIManager;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private UIManager theUIManagerVM;
    private static final String ID_VIEW_MODEL_EDEFAULT = " ";
    private String idViewModel = ID_VIEW_MODEL_EDEFAULT;
    private ViewModel ownedBy;
    private List<ViewModel> childs;

    private ViewVP viewPart;


    public UIManager getTheUIManagerVM() {
        return theUIManagerVM;
    }

    public void setTheUIManagerVM(UIManager theUIManagerVM) {
        this.theUIManagerVM = theUIManagerVM;
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

    public ViewVP getViewPart() {
        return viewPart;
    }

    public void setViewPart(ViewVP viewPart) {
        this.viewPart = viewPart;
    }
}
