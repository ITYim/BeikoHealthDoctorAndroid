package com.alensic.beikohealth.doctor.fragment;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.mvp.BaseMvpFragment;
import com.alensic.beikohealth.doctor.mvppresenter.ReferPresenter;
import com.alensic.beikohealth.doctor.mvpview.ReferView;

/**
 * @author zym
 * @since 2017-08-31 10:22
 */
public class ReferFragment extends BaseMvpFragment<ReferPresenter> implements ReferView{

    @Override
    public int layoutId() {
        return R.layout.fragment_refer;
    }

    @Override
    public ReferPresenter createPresenter() {
        return new ReferPresenter(context, this);
    }
}
