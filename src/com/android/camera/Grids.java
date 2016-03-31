/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.android.camera;

import android.view.View;
import android.graphics.Paint;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.hardware.Camera;

class Grids extends View {
    private Paint mPaint;
    private PhotoModule mPhotoModule;
    
    public Grids(Context context) {
        super(context);
    }
    
    public Grids(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Grids(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
    protected void onDraw(Canvas canvas) {
        if(mPhotoModule == null) {
            return;
        }
        if(mPaint == null) {
            mPaint = new Paint();
        }
        mPaint.setARGB(255, 255, 255, 255);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int previewWidth;
        int previewHeight;
        if(PhotoModule.mParameters != null) {
            previewWidth = PhotoModule.mParameters.getPreviewSize().width;
            previewHeight = PhotoModule.mParameters.getPreviewSize().height;
        } else {
            previewWidth = 1080;
            previewHeight = 1920;
        }
        canvas.translate((float)((width - previewHeight) / 2), (float)((height - previewWidth) / 2));
        width = previewHeight;
        height = previewWidth;
        if(mPhotoModule.mGridsType.equals("ruleofthirds")) {
            canvas.drawLine((float)(width / 3), 0.0f, (float)(width / 3), (float)height, mPaint);
            canvas.drawLine((float)((width * 2) / 3), 0.0f, (float)((width * 2) / 3), (float)height, mPaint);
            canvas.drawLine(0.0f, (float)(height / 3), (float)width, (float)(height / 3), mPaint);
            canvas.drawLine(0.0f, (float)((height * 2) / 3), (float)width, (float)((height * 2) / 3), mPaint);
            return;
        }
        if(mPhotoModule.mGridsType.equals("fourth")) {
            canvas.drawLine((float)(width / 4), 0.0f, (float)(width / 4), (float)height, mPaint);
            canvas.drawLine((float)((width * 2) / 4), 0.0f, (float)((width * 2) / 4), (float)height, mPaint);
            canvas.drawLine((float)((width * 3) / 4), 0.0f, (float)((width * 3) / 4), (float)height, mPaint);
            canvas.drawLine(0.0f, (float)(height / 4), (float)width, (float)(height / 4), mPaint);
            canvas.drawLine(0.0f, (float)((height * 2) / 4), (float)width, (float)((height * 2) / 4), mPaint);
            canvas.drawLine(0.0f, (float)((height * 3) / 4), (float)width, (float)((height * 3) / 4), mPaint);
            return;
        }
        if(mPhotoModule.mGridsType.equals("viewfinder")) {
            canvas.drawLine((float)(width / 2), 0.0f, (float)(width / 2), (float)height, mPaint);
            canvas.drawLine(0.0f, (float)(height / 2), (float)width, (float)(height / 2), mPaint);
            return;
        }
        if(mPhotoModule.mGridsType.equals("diagonals")) {
            canvas.drawLine((float)(width / 4), 0.0f, (float)(width / 4), (float)height, mPaint);
            canvas.drawLine((float)((width * 2) / 4), 0.0f, (float)((width * 2) / 4), (float)height, mPaint);
            canvas.drawLine((float)((width * 3) / 4), 0.0f, (float)((width * 3) / 4), (float)height, mPaint);
            canvas.drawLine(0.0f, (float)(height / 4), (float)width, (float)(height / 4), mPaint);
            canvas.drawLine(0.0f, (float)((height * 2) / 4), (float)width, (float)((height * 2) / 4), mPaint);
            canvas.drawLine(0.0f, (float)((height * 3) / 4), (float)width, (float)((height * 3) / 4), mPaint);
            canvas.drawLine(0.0f, 0.0f, (float)width, (float)height, mPaint);
            canvas.drawLine((float)width, 0.0f, 0.0f, (float)height, mPaint);
        }
    }
    
    public void PreviewChanged() {
        invalidate();
    }
    public void setPhotoModuleObject(PhotoModule photoModule) {
        mPhotoModule = photoModule;
    }
}
