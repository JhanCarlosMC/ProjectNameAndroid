package com.projectname.appestructurada.presentation.viewmodels.homevm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class HomeVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void implementarModelo() {
    }

}