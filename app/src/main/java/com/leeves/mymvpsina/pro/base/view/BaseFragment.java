package com.leeves.mymvpsina.pro.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeves.mymvpsina.mvp.view.impl.MvpFragment;
import com.leeves.mymvpsina.pro.base.presenter.BasePresente;

/**
 * Function:对视图进行缓存
 *
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class BaseFragment<P extends BasePresente> extends MvpFragment<P> {

    @Override
    public P bindPresenter() {
        return null;
    }

    private  View mContentView;
    private boolean isInit;

    public abstract int bindLayoutId();
    public abstract void initContentView(View contentView);

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mContentView == null){
            mContentView = inflater.inflate(bindLayoutId(),container,false);
            initContentView(mContentView);
        }

        ViewGroup parent = (ViewGroup) mContentView.getParent();
        if (parent != null){
            parent.removeView(mContentView);
        }

        return mContentView;
    }

    protected void resetContentView(View contentView){
        ViewGroup viewGroup = (ViewGroup) contentView;
        viewGroup.removeAllViews();
    }

    protected void loadLayout(int layoutId,View v){
        ViewGroup viewGroup = (ViewGroup) v;
        View view = LayoutInflater.from(getContext()).inflate(layoutId,viewGroup,false);

        ViewGroup parent = (ViewGroup) view.getParent();

        if (parent !=null){
            parent.removeAllViews();
        }

        viewGroup.addView(view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isInit){
            isInit = true;
            initData();
        }
    }

    public void initData() {
    }
}
