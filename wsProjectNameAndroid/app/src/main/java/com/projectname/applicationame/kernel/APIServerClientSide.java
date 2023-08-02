package com.projectname.applicationame.kernel;

import android.util.Log;

import com.projectname.applicationame.logic.User;
import com.projectname.applicationame.presentation.viewmodels.formloginvm.FormLoginVM;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIServerClientSide {

    private static final String url = "https://script.google.com/macros/";
    public static APIServerWebServer serviceAPIServerClientSide = null;

    public static APIServerWebServer getServices(){
        if(serviceAPIServerClientSide == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            serviceAPIServerClientSide =retrofit.create(APIServerWebServer.class);
        }
        return serviceAPIServerClientSide;
    }

    public static void login(FormLoginVM newFormLoginVM){
        String password = newFormLoginVM.getTextPassword().getValue();
        String user = newFormLoginVM.getTextUser().getValue();

        User newUser = new User();
        newUser.setPassword(password);
        newUser.setNameUser(user);
        //----------
        RequestGoogle requestData = new RequestGoogle();
        requestData.setCommand("create");
        requestData.setEntityName("Users");

        requestData.setEntity(newUser);

        Call<Void> callerApi = APIServerClientSide.getServices().login(requestData);
        callerApi.enqueue(new retrofit2.Callback<Void>() {
            @Override
            public void onResponse(retrofit2.Call<Void> call, retrofit2.Response<Void> response) {
                Object a= response.body();
                Log.e("Service", String.valueOf(a));
            }
            @Override
            public void onFailure(retrofit2.Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Log.e("Kernel","user: "+ user +"\nPassword: " + password);
    }
}
