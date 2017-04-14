package com.leeves.mymvpsina.pro.base.model;

import android.content.Context;

import com.leeves.mymvpsina.mvp.model.impl.MvpBaseModel;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public abstract class BaseModel extends MvpBaseModel {
    private Context mContext;

    public BaseModel(Context context) {
        mContext = context;
    }

    public Context getContext(){
        return mContext;
    }
}
