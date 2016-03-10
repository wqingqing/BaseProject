package com.drawthink.carcare.presenter.impl;

import android.os.Debug;

import com.drawthink.carcare.data.vo.User;
import com.drawthink.carcare.model.UserModel;
import com.drawthink.carcare.model.impl.UserModelImpl;
import com.drawthink.carcare.presenter.WelcomePresenter;
import com.drawthink.carcare.utils.DebugLog;
import com.drawthink.carcare.view.listener.WelcomeViewListener;
import com.raizlabs.android.dbflow.sql.language.Select;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <b>类名称：</b> WelcomePresenterImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月08日 上午10:02<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class WelcomePresenterImpl implements WelcomePresenter {

    @Override
    public void getUser(WelcomeViewListener listener) {
        UserModel model = new UserModelImpl();
        model.getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugLog.wtf(e.getMessage());
                DebugLog.wtf("current Thread name is --->"+Thread.currentThread().getName());
            }

            @Override
            public void onNext(Response<User> userResponse) {
                DebugLog.wtf("save before"+new Select().from(User.class).queryList().size());

                DebugLog.w(userResponse.body().getId());
                DebugLog.wtf("current Thread name is --->"+Thread.currentThread().getName());
                userResponse.body().save();

                DebugLog.wtf("save after"+new Select().from(User.class).queryList().size());
            }
        });
    }
}
