package com.leeves.mymvpsina.mvp.view.impl;

import com.leeves.mymvpsina.mvp.view.MvpLceView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class MvpBaseLceView<M> implements MvpLceView<M> {
    @Override
    public void showLoading(boolean isPullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean isPullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}
