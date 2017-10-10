package com.alensic.beikohealth.doctor.base;

import android.content.Context;

/**
 * @author zym
 * @since 2017-08-25 18:49
 */
public class GlobalParams {

    public static Context getContext() {
        return BeikoDoctorApplication.getInstance();
    }

    public static BeikoDoctorApplication getApplication() {
        return BeikoDoctorApplication.getInstance();
    }

}
