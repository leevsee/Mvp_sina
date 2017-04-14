package com.leeves.mymvpsina.mvp.presenter;

import com.leeves.mymvpsina.mvp.view.MvpView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public interface MvpPresenter<V extends MvpView> {

    //绑定View层
    void attachView(V view);

    //接触绑定
    void detachView();
}
