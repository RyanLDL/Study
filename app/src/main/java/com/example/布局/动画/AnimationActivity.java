package com.example.布局.动画;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.控件.R;
/*
* 帧动画：
*   1、在drawable中创建animationList
*   2、在布局中将第一步创建的xml设置为背景
*   3、在代码中获取动画资源并启动动画
*补间动画：alpha（透明度）、rotate（旋转）、scale（缩放）、traslate（平移）
*   1、在res中创建anim文件夹
*   2、创建xml文件
*   3、通过加载xml动画设置文件创建Animation对象 Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale);
*   4、通过控件调用startAnimation(animation);
* 属性动画
*
* */
public class AnimationActivity extends AppCompatActivity {
    LinearLayout layout1,layout2,layout3;
    boolean flag=true;
    int i=0;
    String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        layout1=findViewById(R.id.l1);
        layout2=findViewById(R.id.l2);
        //帧动画
        AnimationDrawable animationDrawable= (AnimationDrawable) layout1.getBackground();//获取动画资源
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    animationDrawable.start();
                    flag=false;
                }else {
                    animationDrawable.stop();
                    flag=true;
                }
            }
        });

        //属性动画
//        1、ValueAnimation
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0f,1f);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value= (float) valueAnimator.getAnimatedValue();
                Log.d(TAG, "onAnimationUpdate: "+value);
            }
        });
        valueAnimator.start();
//        2、ObjectAnimation
        TextView textView=findViewById(R.id.tv);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"alpha",0f,1f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
        //监听器
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }
//      补间动画
    public void traslate(View view) {
        //通过加载xml动画设置文件创建Animation对象
        Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.traslate);
        layout2.startAnimation(animation);
    }
    public void scale(View view) {
        //通过加载xml动画设置文件创建Animation对象
        Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale);
        layout2.startAnimation(animation);
    }
    public void rotate(View view) {
        //通过加载xml动画设置文件创建Animation对象
        Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.rotate);
        layout2.startAnimation(animation);
    }
    public void alpha(View view) {
        //通过加载xml动画设置文件创建Animation对象
        Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);
        layout2.startAnimation(animation);
    }

}