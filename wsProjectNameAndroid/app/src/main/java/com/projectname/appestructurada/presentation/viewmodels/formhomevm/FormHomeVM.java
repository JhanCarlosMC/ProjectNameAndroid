package com.projectname.appestructurada.presentation.viewmodels.formhomevm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class FormHomeVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public FormHomeVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void implementModel() {
    }

}