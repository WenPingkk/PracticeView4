package com.hencoder.hencoderpracticedraw4;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by YinZeTong on 2017/11/13.
 */

public class TestDemoActivity extends Activity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(iv, "rotationX", 0.0F, 2160.0F);
        rotationX.setDuration(10000);
        rotationX.start();
    }
}
