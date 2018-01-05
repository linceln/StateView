package com.xyz.state;

import android.view.View;
import android.view.ViewGroup;

/**
 * 2018/1/5.
 */
public class StateManager {

    public static View initInFragment(View view, IStateLayout stateLayout) {
        StateView stateView = new StateView(view.getContext());
        stateView.setStateLayout(view, stateLayout);
        stateView.content();
        return stateView;
    }

    public static StateView initInActivity(View view, IStateLayout stateLayout) {
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

        StateView stateView = new StateView(view.getContext());
        stateView.setStateLayout(view, stateLayout);
        stateView.content();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        parent.addView(stateView, index, lp);

        return stateView;
    }
}
