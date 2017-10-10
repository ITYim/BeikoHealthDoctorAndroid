package com.alensic.beikohealth.doctor.activity;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.dialog.ConfirmDialog;
import com.alensic.beikohealth.doctor.fragment.IndexFragment;
import com.alensic.beikohealth.doctor.fragment.MineFragment;
import com.alensic.beikohealth.doctor.fragment.PatientFragment;
import com.alensic.beikohealth.doctor.fragment.ReferFragment;
import com.alensic.beikohealth.doctor.helper.EventManager;
import com.alensic.beikohealth.doctor.mvp.BaseMvpActivity;
import com.alensic.beikohealth.doctor.mvppresenter.MainPresenter;
import com.alensic.beikohealth.doctor.mvpview.MainView;
import com.yim.base.BaseFragment;

import java.util.List;

import butterknife.BindViews;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView, ConfirmDialog.OnConfirmListener, ConfirmDialog.OnCancelListener {
    private ConfirmDialog mConfirmDialog;
    private IndexFragment mIndexFragment;
    private ReferFragment mReferFragment;
    private PatientFragment mPatientFragment;
    private MineFragment mMineFragment;

    private BaseFragment mLastShowFragment;

    @BindViews({R.id.iv_tab_index, R.id.iv_tab_refer, R.id.iv_tab_patient, R.id.iv_tab_mine})
    List<ImageView> mTabImages;
    @BindViews({R.id.rl_tab_index, R.id.rl_tab_refer, R.id.rl_tab_patient, R.id.rl_tab_mine})
    List<RelativeLayout> mTabLayouts;

    private ImageView mCurrentSelectedTab;

    @Override
    public void initView() {
        mTabImages.get(0).setSelected(true);
        index(); // 默认加载主页
        mCurrentSelectedTab = mTabImages.get(0);
    }

    @Override
    public void initListener() {
        mTabLayouts.get(0).setOnClickListener(this);
        mTabLayouts.get(1).setOnClickListener(this);
        mTabLayouts.get(2).setOnClickListener(this);
        mTabLayouts.get(3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_tab_index:
                if (mCurrentSelectedTab == mTabImages.get(0))
                    break;
                if (mCurrentSelectedTab != null)
                    mCurrentSelectedTab.setSelected(false);
                mCurrentSelectedTab = mTabImages.get(0);
                mCurrentSelectedTab.setSelected(true);
                index();
                break;
            case R.id.rl_tab_refer:
                if (mCurrentSelectedTab == mTabImages.get(1))
                    break;
                if (mCurrentSelectedTab != null)
                    mCurrentSelectedTab.setSelected(false);
                mCurrentSelectedTab = mTabImages.get(1);
                mCurrentSelectedTab.setSelected(true);
                refer();
                break;
            case R.id.rl_tab_patient:
                if (mCurrentSelectedTab == mTabImages.get(2))
                    break;
                if (mCurrentSelectedTab != null)
                    mCurrentSelectedTab.setSelected(false);
                mCurrentSelectedTab = mTabImages.get(2);
                mCurrentSelectedTab.setSelected(true);
                patient();
                break;
            case R.id.rl_tab_mine:
                if (mCurrentSelectedTab == mTabImages.get(3))
                    break;
                if (mCurrentSelectedTab != null)
                    mCurrentSelectedTab.setSelected(false);
                mCurrentSelectedTab = mTabImages.get(3);
                mCurrentSelectedTab.setSelected(true);
                mine();
                break;
        }
    }

    private void index() {
        createIndex();
        if (mIndexFragment.isVisible())  // 防止重复点击
            return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(mIndexFragment);
        if (mLastShowFragment != null) {
            transaction.hide(mLastShowFragment);
        }
        transaction.commit();
        mLastShowFragment = mIndexFragment;  // 记录当前展示的Fragment
    }

    private void refer() {
        createRefer();
        if (mReferFragment.isVisible())  // 防止重复点击
            return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(mReferFragment);
        if (mLastShowFragment != null) {
            transaction.hide(mLastShowFragment);
        }
        transaction.commit();
        mLastShowFragment = mReferFragment;  // 记录当前展示的Fragment
    }

    private void patient() {
        createPatient();
        if (mPatientFragment.isVisible())  // 防止重复点击
            return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(mPatientFragment);
        if (mLastShowFragment != null) {
            transaction.hide(mLastShowFragment);
        }
        transaction.commit();
        mLastShowFragment = mPatientFragment;  // 记录当前展示的Fragment
    }

    private void mine() {
        createMine();
        if (mMineFragment.isVisible())  // 防止重复点击
            return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(mMineFragment);
        if (mLastShowFragment != null) {
            transaction.hide(mLastShowFragment);
        }
        transaction.commit();
        mLastShowFragment = mMineFragment;  // 记录当前展示的Fragment
    }

    private void createIndex() {
        if (mIndexFragment == null) {
            mIndexFragment = new IndexFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, mIndexFragment, "IndexFragment");
            transaction.commit();
        }
    }

    private void createRefer() {
        if (mReferFragment == null) {
            mReferFragment = new ReferFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, mReferFragment, "ReferFragment");
            transaction.commit();
        }
    }

    private void createPatient() {
        if (mPatientFragment == null) {
            mPatientFragment = new PatientFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, mPatientFragment, "PatientFragment");
            transaction.commit();
        }
    }

    private void createMine() {
        if (mMineFragment == null) {
            mMineFragment = new MineFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, mMineFragment, "MineFragment");
            transaction.commit();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mConfirmDialog == null) {
                mConfirmDialog = new ConfirmDialog();
                mConfirmDialog.setContent("确认退出吗？");
                mConfirmDialog.setOnConfirmListener(this);
                mConfirmDialog.setOnCancelListener(this);
            }
            mConfirmDialog.show(getFragmentManager());
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onConfirm(DialogFragment dialog) {
        dialog.dismiss();
        finish();
        return true;
    }

    @Override
    public boolean onCancel(DialogFragment dialog) {
        return false;
    }

    @Override
    protected boolean isSwipe() {
        return false;
    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        EventManager.unregister(this);
        super.onDestroy();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(context, this);
    }
}
