package com.leeves.mymvpsina.pro.discover.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeves.mymvpsina.pro.base.view.BaseFragment;
import com.leeves.mymvpsina.pro.discover.presenter.DiscoverPresenter;


/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public class DiscoverFragment extends BaseFragment<DiscoverPresenter> {

    private DiscoverPresenter mDiscoverPresenter;

    //创建对象
    @Override
    public DiscoverPresenter bindPresenter() {
        mDiscoverPresenter = new DiscoverPresenter(getContext());
        return mDiscoverPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
