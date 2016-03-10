package com.drawthink.carcare.data.http.carcare;

import com.drawthink.carcare.data.http.CustomerOkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.covert.fastjson.FastJsonConverterFactory;

/**
 * <b>类名称：</b> CarCareRetrofitClient <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:21<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class CarCareRetrofitClient {
    private static final String BASE_URL="http://192.168.0.46:8080";

    private static Retrofit retrofit ;

    private CarCareRetrofitClient(){

    }

    private static void create(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(CustomerOkHttpClient.getClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            create();
        }
        return retrofit;
    }
}
