package com.drawthink.carcare.data.http;

import okhttp3.OkHttpClient;
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
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // add your other interceptors …
        // add logging as last interceptor
        client =new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    public static OkHttpClient getClient(){
        if(client == null){
            create();
        }
        return client;
    }

}
