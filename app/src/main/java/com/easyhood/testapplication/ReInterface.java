package com.easyhood.testapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 功能：
 * 详细描述：
 * 作者：guan_qi
 * 创建日期：2023-07-17
 */
public interface ReInterface {
//定义了需要实现的方法
    // https://test-admin.woozatop.com/ad/device_current_ad_plan/1E3D79E9E60F3625
    public static String BASE_URL = "https://test-admin.woozatop.com/";
    String urlStr = "ad/device_current_ad_plan/1E3D79E9E60F3625";
    @GET(urlStr)
    public Call<ReModel> getRealtime();

    //dynamic para
    @GET("{type}")
    public Call<ReModel> Dynamic_getData(@Path("type") String types);
}

