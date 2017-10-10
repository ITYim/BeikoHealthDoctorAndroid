package com.alensic.beikohealth.doctor.fragment;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.mvp.BaseMvpFragment;
import com.alensic.beikohealth.doctor.mvppresenter.MinePresenter;
import com.alensic.beikohealth.doctor.mvpview.MineView;

/**
 * @author zym
 * @since 2017-08-31 10:22
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineView{

    @Override
    public int layoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter(context, this);
    }
}
