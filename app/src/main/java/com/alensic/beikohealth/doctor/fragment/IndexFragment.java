package com.alensic.beikohealth.doctor.fragment;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.mvp.BaseMvpFragment;
import com.alensic.beikohealth.doctor.mvppresenter.IndexPresenter;
import com.alensic.beikohealth.doctor.mvpview.IndexView;

/**
 * @author zym
 * @since 2017-08-31 10:22
 */
public class IndexFragment extends BaseMvpFragment<IndexPresenter> implements IndexView{

    @Override
    public int layoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public IndexPresenter createPresenter() {
        return new IndexPresenter(context, this);
    }
}
