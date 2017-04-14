package com.leeves.mymvpsina.pro.base.presenter;

import android.content.Context;

import com.leeves.mymvpsina.mvp.presenter.impl.MvpBasePresenter;
import com.leeves.mymvpsina.mvp.view.MvpView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class BasePresente<V extends MvpView> extends MvpBasePresenter<V> {

    private Context mContext;

    public BasePresente(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }
}
