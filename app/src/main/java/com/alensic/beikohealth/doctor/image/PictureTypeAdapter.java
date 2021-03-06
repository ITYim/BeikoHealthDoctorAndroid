package com.alensic.beikohealth.doctor.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.alensic.beikohealth.doctor.R;
import com.alensic.beikohealth.doctor.adapter.BaseRecycleViewAdapter;
import com.alensic.beikohealth.doctor.adapter.BaseViewHolder;

import java.util.List;

/**
 * @author zym
 * @since 2017-08-11 18:00
 */

public class PictureTypeAdapter extends BaseRecycleViewAdapter<String> {

    public PictureTypeAdapter(Context context, @NonNull List<String> data) {
        super(context, data, R.layout.adapter_picture_type);
    }

    @Override
    public void onBindView(BaseViewHolder holder, String item, int position) {
        ((TextView) holder.itemView).setText(item);
    }
}
