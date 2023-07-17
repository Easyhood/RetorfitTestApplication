package com.easyhood.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleForRetrofit();

    }

    private void simpleForRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ReInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();//创建Retrofit实体类
        //baseUrl有着格式的规范

        //创建接口实现类
        ReInterface simpleInterface = retrofit.create(ReInterface.class);
        //通过接口实现类返回Call对象
        Call<ReModel> myCall = simpleInterface.getRealtime();

        //通过Call执行请求--与Okhttp不同，Retrofit的回调中可以直接刷新UI，这是它比Okhttp更优秀的一点
        myCall.enqueue(new Callback<ReModel>() {
            @Override
            public void onResponse(Call<ReModel> call, Response<ReModel> response) {
                ReModel data = response.body();//通过response获取序列化后的数据(因为之前已经添加了GsonConvert)
                // Toast.makeText(MainActivity.this, data.timezone, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "guanqi onResponse: data = " + data.data);
            }
            @Override
            public void onFailure(Call<ReModel> call, Throwable t) {
                // Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "guanqi onFailure: Error! call = " + call);
                Log.d(TAG, "guanqi onFailure: Error! Throwable = " + t);
            }
        });

    }

}