package com.leeves.mymvpsina;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Function:
 * <p>
 * Created by Leeves on 2017/4/14.
 *
 * @author Leeves
 */

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initWelComeAnimator();
        initLogoAnimator();
    }

    private void initWelComeAnimator() {
        ImageView iv_slogan = (ImageView) findViewById(R.id.iv_slogan);
        //属性动画实现
        //第一个参数---target:代表我们要给那个视图添加动画
        //第二个参数---propertyName:代表动画类型
        //第三个参数---动画开始的时候的位置,或者说状态
        //第四个参数---动画结束的时候的位置,或者说状态
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_slogan,"alpha",0.0f,1.0f);
        //动画的时间
        objectAnimator.setDuration(5000);
        //启动动画
        objectAnimator.start();

        //给我们的动画添加监听
        //牵涉到架构设计中的: 适配器模式
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
            }
        });
    }

    private void initLogoAnimator() {
        //给Logo添加动画
        ImageView iv_logo = (ImageView) findViewById(R.id.iv_logo);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(iv_logo,"scaleX",1.0f,1.2f,1.0f);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(iv_logo,"scaleY",1.0f,1.2f,1.0f);
        //通过动画集合组合并且执行动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        //这两个动画同时执行
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        //动画开始
        animatorSet.start();
    }

}
