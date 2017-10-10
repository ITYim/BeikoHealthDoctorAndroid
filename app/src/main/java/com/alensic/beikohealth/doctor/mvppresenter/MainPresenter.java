package com.alensic.beikohealth.doctor.mvppresenter;

import android.content.Context;

import com.alensic.beikohealth.doctor.mvp.BasePresenter;
import com.alensic.beikohealth.doctor.mvp.BaseView;
import com.alensic.beikohealth.doctor.mvpview.MainView;

/**
 * @author zym
 * @since 2017-08-08 14:13
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(Context context, BaseView mvpView) {
        super(context, mvpView);
    }
}
