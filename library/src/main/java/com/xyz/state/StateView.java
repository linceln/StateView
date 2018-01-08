package com.xyz.state;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 空页面、重试页面、缓冲页面
 * 2018/1/5.
 */
public class StateView extends FrameLayout {

    private View mLoad;
    private View mEmpty;
    private View mRetry;
    private View mNormal;
    private LayoutInflater mInflater;

    public StateView(@NonNull Context context) {
        this(context, null, 0);
    }

    public StateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mInflater = LayoutInflater.from(context);
    }

    public void setStateLayout(View view, IStateLayout stateLayout, IState state) {
        if (view == null) {
            throw new IllegalArgumentException("View cannot be null");
        }
        if (stateLayout == null) {
            throw new IllegalArgumentException("IStateLayout cannot be null");
        }
        mNormal = view;
        mLoad = mInflater.inflate(stateLayout.getLoadLayout(), this, false);
        mEmpty = mInflater.inflate(stateLayout.getEmptyLayout(), this, false);
        mRetry = mInflater.inflate(stateLayout.getRetryLayout(), this, false);
        state.onEmpty(mEmpty);
        state.onRetry(mRetry);
        state.onLoad(mLoad);
        addView(mNormal);
        addView(mLoad);
        addView(mEmpty);
        addView(mRetry);
    }

    public void empty() {
        mLoad.setVisibility(View.GONE);
        mEmpty.setVisibility(View.VISIBLE);
        mRetry.setVisibility(View.GONE);
        mNormal.setVisibility(View.GONE);
    }

    public void retry() {
        mLoad.setVisibility(View.GONE);
        mEmpty.setVisibility(View.GONE);
        mRetry.setVisibility(View.VISIBLE);
        mNormal.setVisibility(View.GONE);
    }

    public void load() {
        mLoad.setVisibility(View.VISIBLE);
        mEmpty.setVisibility(View.GONE);
        mRetry.setVisibility(View.GONE);
        mNormal.setVisibility(View.GONE);
    }

    public void content() {
        mLoad.setVisibility(View.GONE);
        mEmpty.setVisibility(View.GONE);
        mRetry.setVisibility(View.GONE);
        mNormal.setVisibility(View.VISIBLE);
    }

/*    public void setLoadLayout(View view) {
        mLoad = view;
    }

    public void setLoadLayout(@LayoutRes int layoutRes) {
        mLoad = mInflater.inflate(layoutRes, this, false);
    }

    public void setEmptyLayout(View view) {
        mEmpty = view;
    }

    public void setEmptyLayout(@LayoutRes int layoutRes) {
        mEmpty = mInflater.inflate(layoutRes, this, false);
    }

    public void setRetryLayout(View view) {
        mRetry = view;
    }

    public void setRetryLayout(@LayoutRes int layoutRes) {
        mRetry = mInflater.inflate(layoutRes, this, false);
    }*/
}