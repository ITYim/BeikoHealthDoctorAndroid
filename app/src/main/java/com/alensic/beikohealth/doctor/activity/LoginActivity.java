package com.alensic.beikohealth.doctor.activity;

import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.mvp.BaseMvpActivity;
import com.alensic.beikohealth.doctor.db.entity.User;
import com.alensic.beikohealth.doctor.mvppresenter.LoginPresenter;
import com.alensic.beikohealth.doctor.mvpview.LoginView;
import com.beiko.health.doctor.db.gen.UserDao;
import com.yim.base.utils.Logger;
import com.yim.base.utils.StatusBarUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 登录
 * @author zym
 * @since 2017-08-08 14:10
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {
    @BindView(R.id.rl_root)
    RelativeLayout rl_root;
    @BindView(R.id.btn_wechat_login)
    Button btn_wechat_login;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.et_phone_input)
    EditText et_phone_input;
    @BindView(R.id.et_auth_code)
    EditText et_auth_code;
    @BindView(R.id.tv_treaty)
    TextView tv_treaty;
    private UserDao mUserDao;

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        StatusBarUtils.darkenStatusBarColor(this);
        setViewGroupPaddingTop(rl_root);
        SpannableStringBuilder sb = new SpannableStringBuilder(tv_treaty.getText());
        sb.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.main_theme)), 13, tv_treaty.getText().toString().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_treaty.setText(sb);
    }

    @Override
    public void initListener() {
        setViewClickListener(btn_wechat_login);
        setViewClickListener(btn_login);
    }

    @Override
    public void fetchData() {
//        mUserDao = DBManager.getInstance().getUserDao();
        List<User> users = mUserDao.loadAll();
        if (users == null || users.isEmpty()) {
            Logger.d("user数据为空");
            return;
        }
        for (User user : users) {
            Logger.d(user.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_wechat_login:

                break;
            case R.id.btn_login:
//                User user = new User();
//                user.setName(et_phone_input.getText().toString());
//                user.setAge(Integer.parseInt(et_auth_code.getText().toString()));
//                long id = mUserDao.insert(user);
//                Logger.d("insert id is " + id);
                break;
        }
    }

    public void close(View v) {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.login_out);
    }

    @Override
    protected boolean isSwipe() {
        return false;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this, this);
    }
}
