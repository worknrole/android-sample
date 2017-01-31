package com.worknrole.sample.realusage.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by worknrole on 25/01/17.
 */

public class GyphyView extends LinearLayout {

    public GyphyView(Context context) {
        super(context);
    }

    public GyphyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GyphyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GyphyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
