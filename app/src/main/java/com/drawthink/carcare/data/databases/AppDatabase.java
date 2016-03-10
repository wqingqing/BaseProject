package com.drawthink.carcare.data.databases;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * <b>类名称：</b> AppDatabase <br/>
 * <b>类描述：</b> 数据库类<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年03月09日 下午3:33<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Database(name=AppDatabase.NAME,version = AppDatabase.VERSION)
public class AppDatabase {
    //数据库名称
    public static final String NAME = "AppDatabase";
    //数据库版本号，这里修改2
    public static final int VERSION = 1;
}
