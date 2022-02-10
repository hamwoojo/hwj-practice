package net.hwj.practice.model;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiInterface {
    @GET
    Call<ResponseBody> getUrl(@Url String url);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @POST
    Call<ResponseBody> postUrlByXml(@Url String url, @Header("Authorization") String token, @Body RequestBody requestBody);

    @POST
    Call<ResponseBody> postEmail(@Url String url, @Body RequestBody requestBody);

    @Headers({"Content-Type: application/xml; charset=utf-8"})
    @GET
    Call<ResponseBody> getResources(@Url String url, @Header("Authorization") String token);
}
