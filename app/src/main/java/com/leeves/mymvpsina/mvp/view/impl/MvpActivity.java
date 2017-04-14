package com.leeves.mymvpsina.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leeves.mymvpsina.mvp.presenter.MvpPresenter;
import com.leeves.mymvpsina.mvp.view.MvpView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = bindPresenter();
        if (this.presenter != null){
            this.presenter.attachView(this);
        }

    }

    public abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.presenter != null){
            this.presenter.detachView();
            this.presenter = null;
        }
    }
}
