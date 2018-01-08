package com.xyz.lince;

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
}
