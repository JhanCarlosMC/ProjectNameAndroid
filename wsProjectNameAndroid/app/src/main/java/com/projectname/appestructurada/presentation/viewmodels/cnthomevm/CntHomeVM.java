package com.projectname.appestructurada.presentation.viewmodels.cnthomevm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projectname.appestructurada.presentation.viewmodels.ViewModel;

public class CntHomeVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public CntHomeVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void implementModel() {
    }

}