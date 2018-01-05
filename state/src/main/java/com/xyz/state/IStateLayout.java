package com.xyz.state;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * 2018/1/5.
 */
public interface IStateLayout {

    @LayoutRes
    int getEmptyLayout();

    @LayoutRes
    int getRetryLayout();

    @LayoutRes
    int getLoadLayout();

    void onEmpty(View empty);

    void onRetry(View retry);

    void onLoad(View load);
}
