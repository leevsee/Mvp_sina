package com.leeves.mymvpsina.mvp.view;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public interface MvpLceView<M> extends MvpView {

    //用于显示进度条(下拉刷新,上拉加载更多)
    void showLoading(boolean isPullToRefresh);

    //显示视图
    void showContent();

    //处理异常接口方法
    void showError(Exception e, boolean isPullToRefresh);

    //绑定数据
    void showData(M data);
}
