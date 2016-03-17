package com.drawthink.carcare.presenter.impl;

import com.drawthink.carcare.data.vo.User;
import com.drawthink.carcare.model.UserModel;
import com.drawthink.carcare.model.impl.UserModelImpl;
import com.drawthink.carcare.presenter.WelcomePresenter;
import com.drawthink.carcare.utils.DebugLog;
import com.drawthink.carcare.view.listener.WelcomeViewListener;
import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
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
@RxLogSubscriber
public class WelcomePresenterImpl implements WelcomePresenter {

    @Override
    public void getUser(WelcomeViewListener listener) {

        UserModel model = new UserModelImpl();
        model.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<Response<User>, Observable<User>>() {
            @Override
            public Observable<User> call(Response<User> userResponse) {
                return Observable.just(userResponse.body());
            }
        }).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                DebugLog.wtf("net work error -->"+e.getMessage());
            }

            @Override
            public void onNext(User user) {
                DebugLog.wtf("net work success -->");
            }
        });
    }
}
