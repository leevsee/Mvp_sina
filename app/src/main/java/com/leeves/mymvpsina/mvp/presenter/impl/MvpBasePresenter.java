package com.leeves.mymvpsina.mvp.presenter.impl;

import com.leeves.mymvpsina.mvp.presenter.MvpPresenter;
import com.leeves.mymvpsina.mvp.view.MvpView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
