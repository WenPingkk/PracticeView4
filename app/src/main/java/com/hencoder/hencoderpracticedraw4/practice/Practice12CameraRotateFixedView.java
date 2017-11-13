package com.hencoder.hencoderpracticedraw4.practice;

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
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private Camera mCamera;
    private Matrix mMatrix;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mCamera = new Camera();
        mMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int center1X = point1.x + bitmapWidth / 2;
        int center1Y = point1.y + bitmapHeight / 2;
        int center2X = point2.x + bitmapWidth / 2;
        int center2Y = point2.y + bitmapHeight / 2;

        mCamera.save();
        mMatrix.reset();
        mCamera.rotateX(30);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-center1X,-center1Y);
        mMatrix.postTranslate(center1X,center1Y);
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

//        mCamera.save();
//        mMatrix.reset();
//        mCamera.rotateY(30);
//        mCamera.getMatrix(mMatrix);
//        mCamera.restore();
//        mMatrix.preTranslate(-center2X,-center2Y);
//        mMatrix.postTranslate(center2X,center2Y);
//        canvas.save();
//        canvas.concat(mMatrix);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

        mCamera.save();
        mMatrix.reset();
        mCamera.rotateY(30);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-center2X,-center2Y);
        mMatrix.postTranslate(center2X,center2Y);
        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap,point2.x,point2.y,paint);
        canvas.restore();
    }
}
