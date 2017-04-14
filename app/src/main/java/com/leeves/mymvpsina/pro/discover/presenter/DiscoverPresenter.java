package com.leeves.mymvpsina.pro.discover.presenter;

import android.content.Context;

import com.leeves.mymvpsina.pro.base.presenter.BasePresente;
import com.leeves.mymvpsina.pro.base.view.BaseView;
import com.leeves.mymvpsina.pro.discover.model.DiscoverModel;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public class DiscoverPresenter extends BasePresente<BaseView> {

    private DiscoverModel mDiscoverModel;

    public DiscoverPresenter(Context context) {
        super(context);
        mDiscoverModel = new DiscoverModel(context) ;
    }
}
