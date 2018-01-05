package com.xyz.lince;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.xyz.state.IStateLayout;

/**
 * 2018/1/5.
 */
public class DefaultStateLayout implements IStateLayout {

    @Override
    public int getEmptyLayout() {
        return R.layout.empty;
    }

    @Override
    public int getRetryLayout() {
        return R.layout.retry;
    }

    @Override
    public int getLoadLayout() {
        return R.layout.load;
    }

    @Override
    public void onEmpty(View empty) {

    }

    @Override
    public void onRetry(View retry) {
        retry.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make(v, v.getId() + "", Snackbar.LENGTH_SHORT);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                }).show();
            }
        });
    }

    @Override
    public void onLoad(View load) {

    }
}
