package com.hencoder.hencoderpracticedraw4.sample;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.hencoder.hencoderpracticedraw4.R;

public class Sample13CameraRotateHittingFaceView extends View {
    private float degree;
    private Matrix mMatrix;
    private ObjectAnimator mAnimator;
    private Bitmap mBitmap;
    private Paint mPaint;
    private Point mPoint;

    public Sample13CameraRotateHittingFaceView(Context context) {
        super(context);
    }

    public Sample13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    {
        mPaint = new Paint();
        mPoint = new Point(200, 50);
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,mBitmap.getWidth()*2,mBitmap.getHeight()*2,true);
        mBitmap.recycle();
        mBitmap = scaledBitmap;
        mAnimator = ObjectAnimator.ofFloat(this,"degree",0.0f,360.0f);
        mAnimator.setDuration(5000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setInterpolator(new LinearInterpolator());
        mMatrix = new Matrix();
    }
    @SuppressWarnings("unused")
    public void setDegree(float degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mBitmapWidth = mBitmap.getWidth();
        int mBitmapHeight = mBitmap.getHeight();
        int centerX = mPoint.x + mBitmapWidth / 2;
        int centerY = mPoint.y + mBitmapHeight / 2;
        Camera camera = new Camera();

        camera.save();
        mMatrix.reset();
        camera.rotateX(degree);
        camera.getMatrix(mMatrix);
        camera.restore();
        mMatrix.preTranslate(-centerX,-centerY);
        mMatrix.postTranslate(centerX,centerY);
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap,mPoint.x, mPoint.y,mPaint);
        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimator.end();
    }
}
