package com.xyz.state;

import android.view.View;

/**
 * 2018/1/5.
 */
public interface IState {

    void onEmpty(View empty);

    void onRetry(View retry);

    void onLoad(View load);
}
