package com.drawthink.carcare.model;

import com.drawthink.carcare.data.vo.User;

import retrofit2.Response;
import rx.Observable;

/**
 * <b>类名称：</b> UserModel <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 下午3:10<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface UserModel {
    Observable<Response<User>> getUser();
}
