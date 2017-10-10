package com.alensic.beikohealth.doctor.fragment;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.mvp.BaseMvpFragment;
import com.alensic.beikohealth.doctor.mvppresenter.PatientPresenter;
import com.alensic.beikohealth.doctor.mvpview.PatientView;

/**
 * @author zym
 * @since 2017-08-31 10:22
 */
public class PatientFragment extends BaseMvpFragment<PatientPresenter> implements PatientView{

    @Override
    public int layoutId() {
        return R.layout.fragment_patient;
    }

    @Override
    public PatientPresenter createPresenter() {
        return new PatientPresenter(context, this);
    }
}
