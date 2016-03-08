package com.drawthink.carcare.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.drawthink.carcare.R;
import com.drawthink.carcare.presenter.WelcomePresenter;
import com.drawthink.carcare.presenter.impl.WelcomePresenterImpl;
import com.drawthink.carcare.utils.ToastUtil;
import com.drawthink.carcare.view.listener.BaseViewListener;
import com.drawthink.carcare.view.listener.WelcomeViewListener;

import java.util.concurrent.TimeUnit;

import mehdi.sakout.dynamicbox.DynamicBox;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * <b>类名称：</b> WelcomeActivity <br/>
 * <b>类描述：</b> 欢迎页<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月07日 上午10:02<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class WelcomeActivity extends AppCompatActivity implements WelcomeViewListener {

    ImageView imageView;
    private LinearLayout welcomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = (ImageView) findViewById(R.id.imageView);
        welcomeLayout = (LinearLayout) findViewById(R.id.welcomeLayout);
        final DynamicBox box = new DynamicBox(this,welcomeLayout);
        box.showLoadingLayout();
//        String internetUrl = "http://img2.3lian.com/2014/f5/158/d/87.jpg";
//        Glide.with(this)
//                .load(internetUrl)
//                .into(imageView);
//        RxView.clicks(imageView).subscribe(new Action1<Void>() {
//            @Override
//            public void call(Void aVoid) {
//                Glide.with(WelcomeActivity.this).load(R.drawable.umeng_socialize_qq_on).into(imageView);
//            }
//        });
//        Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
//            @Override
//            public void call(Long aLong) {
//                box.showInternetOffLayout();
//            }
//        });
//        Observable.timer(6, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
//            @Override
//            public void call(Long aLong) {
//                box.showExceptionLayout();
//            }
//        });
//
//        box.setClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.toast(WelcomeActivity.this, "Click Retry");
//            }
//        });
        WelcomePresenter presenter = new WelcomePresenterImpl();
        presenter.getUser(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
