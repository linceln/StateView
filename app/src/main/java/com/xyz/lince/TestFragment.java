package com.xyz.lince;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.state.IState;
import com.xyz.state.S;

/**
 * 2018/1/5.
 */
public class TestFragment extends Fragment implements IState {

    private S s;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        s = S.initFragment(view, new DefaultStateLayout(), this);
        return s.getStateView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        s.empty();
    }

    @Override
    public void onEmpty(View empty) {
    }

    @Override
    public void onRetry(View retry) {
        retry.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar make = Snackbar.make(v, v.getId() + "", Snackbar.LENGTH_SHORT);
                make.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        make.dismiss();
                    }
                }).show();
            }
        });
    }

    @Override
    public void onLoad(View load) {

    }
}
