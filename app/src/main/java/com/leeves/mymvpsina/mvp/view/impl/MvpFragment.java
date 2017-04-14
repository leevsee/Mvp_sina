package com.leeves.mymvpsina.mvp.view.impl;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leeves.mymvpsina.mvp.presenter.MvpPresenter;
import com.leeves.mymvpsina.mvp.view.MvpView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class MvpFragment<P extends MvpPresenter> extends Fragment implements MvpView {
    private P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.presenter = bindPresenter();
        if (presenter != null) {
            this.presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            this.presenter.detachView();
            presenter = null;
        }
    }
}
