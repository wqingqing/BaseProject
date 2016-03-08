package com.drawthink.carcare.model.impl;

import com.drawthink.carcare.data.http.carcare.CarCareRetrofitClient;
import com.drawthink.carcare.data.http.carcare.servers.UserServer;
import com.drawthink.carcare.data.http.carcare.vo.User;
import com.drawthink.carcare.model.UserModel;

import retrofit2.Response;
import rx.Observable;

/**
 * <b>类名称：</b> UserModelImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:11<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class UserModelImpl implements UserModel{

    @Override
    public Observable<Response<User>> getUser(){
        UserServer userServer = CarCareRetrofitClient.getRetrofit().create(UserServer.class);
        return userServer.getUser("56c2c40d77ce6f9a3c73a09e");
    }
}
