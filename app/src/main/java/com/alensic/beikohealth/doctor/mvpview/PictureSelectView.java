package com.alensic.beikohealth.doctor.mvpview;

import com.alensic.beikohealth.doctor.bean.PhotoInfo;
import com.alensic.beikohealth.doctor.mvp.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zym
 * @since 2017-08-11 10:24
 */

public interface PictureSelectView extends BaseView {

    void showPictures(ArrayList<PhotoInfo> photoInfoList);

    void buildPictureTypes(List<String> types);
}
