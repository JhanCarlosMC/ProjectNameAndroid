package com.projectname.applicationanme.kernel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Admin on 23/07/2018.
 */

public interface APIServerWebServer {
    @Headers({"Content-Type: application/json"})
    @POST("s/AKfycbwUFMCG5K8DHfYpiCiRmJUsWkfAby93QJffgQ61w9ZkYcR3392Le0Zm8J6qP2xrtG1BzQ/exec")
    Call <Void> login(@Body RequestGoogle requestBody);

    //  @Headers({"Content-Type: application/json"})
    //@GET("denuncias")
    //Call<List<Denuncia>> getDenuncias(@Header("x-access-token") String userkey);

}
