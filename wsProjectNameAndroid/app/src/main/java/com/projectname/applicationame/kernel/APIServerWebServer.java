package com.projectname.applicationame.kernel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIServerWebServer {
    @Headers({"Content-Type: application/json"})
    @POST("s/AKfycbzauO5eXzJCEZd15dbRZxOknUMVL4RgdGUnW02tZYrSbLDI3uq6oPaZiwiPOdiVtPbukQ/exec")
    Call <Void> login(@Body RequestGoogle requestBody);

}
