package com.alensic.beikohealth.doctor.db;

import android.content.Context;

import com.alensic.beikohealth.doctor.db.gen.DaoMaster;
import com.alensic.beikohealth.doctor.db.gen.DaoSession;
import com.alensic.beikohealth.doctor.db.gen.UserDao;
import com.yim.base.utils.Logger;

import org.greenrobot.greendao.database.Database;

/**
 * @author zym
 * @since 2017-08-09 16:36
 */

public class DBManager {
    private static DBManager instance;
    private static DaoSession mDaoSession;

    public static DBManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("数据库对象未初始化");
        }
        return instance;
    }

    private DBManager() {
    }

    public static void initDatabase(Context context) {
        if (mDaoSession == null) {
            Logger.d("初始化数据库");
            instance = new DBManager();
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "beiko.db");
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
            mDaoSession = daoMaster.newSession();
        }
    }

    public UserDao getUserDao() {
        return mDaoSession.getUserDao();
    }

    public Database getDatabase() {
        return mDaoSession.getDatabase();
    }
}
