package com.drawthink.carcare;

import android.app.Application;
import android.content.Context;

import com.drawthink.carcare.config.GlideImageLoader;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.io.File;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * <b>类名称：</b> CarCareApplication <br/>
 * <b>类描述：</b> 汽车保养项目Application<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月07日 上午10:34<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class CarCareApplication extends Application {

    private static RefWatcher refWatcher;
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        mContext = this;
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        FlowManager.init(this);
        configGalleryFinal();
        configCustomerCrashHandler();
    }

    private void configCustomerCrashHandler() {
        CustomActivityOnCrash.install(this);
    }

    /**
     * 配置GalleryFinal
     */
    private void configGalleryFinal() {
        //设置主题
        //ThemeConfig.CYAN
        ThemeConfig theme = new ThemeConfig.Builder()
                .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .setCropHeight(200)
                .setCropWidth(200)
                .build();

        //配置imageloader
        ImageLoader imageloader = new GlideImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, theme)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }

    /**
     * 获取leakcanary watcher 对象
     * @return leakcanary watcher 对象
     */
    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

}
