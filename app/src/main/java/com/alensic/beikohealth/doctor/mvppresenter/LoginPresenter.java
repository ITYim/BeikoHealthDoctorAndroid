package com.alensic.beikohealth.doctor.mvppresenter;

import android.content.Context;

import com.alensic.beikohealth.doctor.mvp.BasePresenter;
import com.alensic.beikohealth.doctor.mvp.BaseView;
import com.alensic.beikohealth.doctor.mvpview.LoginView;

/**
 * @author zym
 * @since 2017-08-08 14:13
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(Context context, BaseView mvpView) {
        super(context, mvpView);
    }
}
