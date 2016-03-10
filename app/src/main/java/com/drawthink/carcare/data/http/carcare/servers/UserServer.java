package com.drawthink.carcare.data.http.carcare.servers;

import com.drawthink.carcare.data.vo.User;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <b>类名称：</b> UserServer <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:32<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface UserServer {

    @GET("/users/{id}")
    Observable<Response<User>> getUser(@Path("id") String id);
}
