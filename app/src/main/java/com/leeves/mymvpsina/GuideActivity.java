package com.leeves.mymvpsina;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeves.mymvpsina.views.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public class GuideActivity extends Activity {

    private List<Integer> mImageList;

    private List<ImageView> mImageViewList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //配置布局
        setContentView(R.layout.activity_guide);

        initImageList();
        initView();
    }

    /**
     *
     */
    private void initImageList() {
        mImageList = new ArrayList<>();
        //添加图片
        mImageList.add(R.mipmap.surprise_background_default);
        mImageList.add(R.mipmap.surprise_background_grass);
        mImageList.add(R.mipmap.surprise_background_roof);
        mImageList.add(R.mipmap.surprise_background_window);

        mImageViewList = new ArrayList<>();
        for (Integer idRes : mImageList) {
            //创建显示图片的视图
            ImageView imageView = new ImageView(this);
            //添加到mImageViewList
            mImageViewList.add(imageView);
        }
    }

    /**
     *
     */
    private void initView() {
        //1.初始化ViewPager分页组件,同时配置Adapter数据
        //ViewPager:系统组件
        ViewPager viewpager = (ViewPager) findViewById(R.id.view_pager);
        viewpager.setAdapter(new GuideAdapter(this,mImageList,mImageViewList));

        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        //绑定页码
        circleIndicator.setViewPager(viewpager);

        //点击开始进入界面
        //绑定textView
        final TextView tv_guide = (TextView) findViewById(R.id.tv_guide);
        tv_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
            }
        });
        //判断是否最后一页，出现 点击进入 主页的字
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //判断图片数量
                if (position == mImageList.size() - 1) {
                    tv_guide.setVisibility(View.VISIBLE);
                } else {
                    tv_guide.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * PagerAdapter数据
     * 创建并且显示每一个分页
     */
    public static class GuideAdapter extends PagerAdapter {

        private Context mcontext;
        private List<Integer> mImageList;
        private List<ImageView> mImageViewList;

        public GuideAdapter(Context context, List<Integer> imageList, List<ImageView> imageViewList) {
            this.mcontext = context;
            this.mImageList = imageList;
            this.mImageViewList = imageViewList;
        }

        //返回要滑动的VIew的个数
        @Override
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //做了两件事，第一：将当前视图添加到container中，第二：返回当前View
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = mImageViewList.get(position);
            //绑定图片资源
            imageView.setImageResource(mImageList.get(position));
            //填充视图,超过的部分我就截取掉---而且图片不变形,保持原样
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //绑定视图
            container.addView(imageView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }

        //从当前container中删除指定位置（position）的View
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mImageViewList.get(position));
        }
    }
}
