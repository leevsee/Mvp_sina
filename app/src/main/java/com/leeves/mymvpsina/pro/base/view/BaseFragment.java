package com.leeves.mymvpsina.pro.base.view;

import com.leeves.mymvpsina.mvp.view.impl.MvpFragment;
import com.leeves.mymvpsina.pro.base.presenter.BasePresente;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class BaseFragment<P extends BasePresente> extends MvpFragment<P> {

    @Override
    public P bindPresenter() {
        return null;
    }
}
