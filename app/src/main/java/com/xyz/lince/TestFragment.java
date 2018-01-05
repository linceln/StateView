package com.xyz.lince;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.state.StateManager;
import com.xyz.state.StateView;

/**
 * 2018/1/5.
 */
public class TestFragment extends Fragment {

    private StateView mStateView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return StateManager.initInFragment(view, new DefaultStateLayout());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStateView = (StateView) view;
        mStateView.empty();
    }
}
