package com.xyz.state;

import android.view.View;
import android.view.ViewGroup;

/**
 * 2018/1/5.
 */
public class S {

    private StateView stateView;

    public StateView getStateView() {
        if (stateView == null) {
            throw new NullPointerException("Not initialized");
        }
        return stateView;
    }

    public static S initFragment(View view, IStateLayout stateLayout, IState state) {
        S s = new S();
        s.initInFragment(view, stateLayout, state);
        return s;
    }

    public static S init(View view, IStateLayout stateLayout, IState state) {
        S s = new S();
        s.initView(view, stateLayout, state);
        return s;
    }

    public void empty() {
        if (stateView == null) {
            throw new NullPointerException("Not initialized");
        }
        stateView.empty();
    }

    public void retry() {
        if (stateView == null) {
            throw new NullPointerException("Not initialized");
        }
        stateView.retry();
    }

    public void load() {
        if (stateView == null) {
            throw new NullPointerException("Not initialized");
        }
        stateView.load();
    }

    public void content() {
        if (stateView == null) {
            throw new NullPointerException("Not initialized");
        }
        stateView.content();
    }

    private void initInFragment(View view, IStateLayout stateLayout, IState state) {
        stateView = new StateView(view.getContext());
        stateView.setStateLayout(view, stateLayout, state);
        stateView.content();
    }

    private void initView(View view, IStateLayout stateLayout, IState state) {
        ViewGroup parent = (ViewGroup) view.getParent();
        int index = 0;
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i) == view) {
                // 找到view在parent中的位置
                index = i;
                break;
            }
        }

        // 将原来的 view 替换为 StateView
        parent.removeView(view);

        stateView = new StateView(view.getContext());
        stateView.setStateLayout(view, stateLayout, state);
        stateView.content();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        parent.addView(stateView, index, lp);
    }
}