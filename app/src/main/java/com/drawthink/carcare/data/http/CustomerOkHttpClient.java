package com.drawthink.carcare.data.http;

import android.text.TextUtils;

import com.drawthink.carcare.CarCareApplication;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * <b>类名称：</b> CustomerOkHttpClient <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:24<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class CustomerOkHttpClient {

    public static OkHttpClient client;

    private CustomerOkHttpClient(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static void create(){
        int maxCacheSize = 10*1024*1024;
        Cache cache = new Cache(CarCareApplication.getContext().getCacheDir(),maxCacheSize);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String cacheControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(cacheControl)) {
                    cacheControl = "public, max-age=60 ,max-stale=2419200";
                }
                return response.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            }
        };

        // add your other interceptors …
        // add logging as last interceptor
        client = new OkHttpClient.Builder()
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(logging)
                .cache(cache)
                .build();
    }

    public static OkHttpClient getClient(){
        if(client == null){
            create();
        }
        return client;
    }

}
