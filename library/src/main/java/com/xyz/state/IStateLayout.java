package com.xyz.state;

import android.support.annotation.LayoutRes;

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
}
