package com.study.androidrobot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.logging.Handler;

public class Robot extends View {
    private Paint paint;
    private Path path;

    private int widthMode,heightMode;
    private int widthSize,heightSize;
    private int originWidth = 900,originHeight = 800;
    private int widthScale,heightScale;
    private int finalWidth,finalHeight;
    public Robot(Context context) {
        super(context);
    }
    public Robot(Context context, @Nullable AttributeSet attrs) {
        this(context);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        path = new Path();

        dp2px();
    }
    private void dp2px(){
        float scale = getContext().getResources().getDisplayMetrics().density;
        originWidth = (int) (900*scale + 0.5f);
        originHeight = (int) (800*scale + 0.5f);
    }
    private int px2dp(float px){
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) ((px-0.5f)/scale);
    }
    private void drawCirlce(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        path.addCircle(500,400,300, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void cliphead(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.WHITE);
        path.addRect(200,300,800,700, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void leftEye(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.WHITE);
        path.addCircle(400,200,20, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void rightEye(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.WHITE);
        path.addCircle(600,200,20, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void earCircle(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        //  设置抗锯齿效果
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        path.addCircle(350,50,10, Path.Direction.CCW);

        canvas.drawPath(path,paint);
        //  保存canvas状态，通过平移绘制右边耳朵上的圆
        canvas.save();
        canvas.translate(300,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    private void earRect(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        //  设置抗锯齿效果
        paint.setAntiAlias(true);
        path.addRect(0,0,20,90, Path.Direction.CCW);
        /*
        *   注：canvas.save()与canvas.restore()可以看做是一对方法，在绘制前先将画笔状态保存，
        *       在绘制完成之后需要用restore方法将画笔状态恢复，否则在这之后的所有绘制都会被接下来的
        *       代码所影响（这里表现为旋转之后再平移）
        * */
        canvas.save();
        /*
        *   注：需要注意顺序问题，如果想实现先平移再旋转的效果，
        *       需要先写旋转再写平移。即顺序与实际效果相反
        * */
        //  平移到指定位置
        canvas.translate(357,30);
        //  将方形以（10,50）为圆形旋转45度
        canvas.rotate(150,10,50);
        canvas.drawPath(path,paint);
        canvas.restore();
        //  保存canvas状态，然后利用旋转和平移来绘制右边耳朵的矩形
        canvas.save();
        canvas.translate(618,40);
        canvas.rotate(30,10,50);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    //
    private void bellyRect(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        path.addRect(215,350,785,550, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void bodyRect(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        path.addRoundRect(215,500,785,850,50,50, Path.Direction.CCW);
        canvas.drawPath(path,paint);
    }
    private void handsTopCircle(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        path.addCircle(150,400,50, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(700,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    private void handsBottomCircle(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        path.addCircle(150,720,50, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(700,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    private void handsRect(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);   //抗锯齿
        path.addRect(100,400,200,720, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(700,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    private void legsRect(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);   //抗锯齿
        path.addRect(300,850,400,1050, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(300,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    private void legsCircle(Canvas canvas,Paint paint,Path path){
        paint.reset();
        path.reset();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);   //抗锯齿
        path.addCircle(350,1050,50, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.save();
        canvas.translate(300,0);
        canvas.drawPath(path,paint);
        canvas.restore();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCirlce(canvas,paint,path);
        cliphead(canvas,paint,path);
        leftEye(canvas,paint,path);
        rightEye(canvas,paint,path);
        earCircle(canvas,paint,path);
        earRect(canvas,paint,path);
        bellyRect(canvas,paint,path);
        bodyRect(canvas,paint,path);
        handsTopCircle(canvas,paint,path);
        handsBottomCircle(canvas,paint,path);
        handsRect(canvas,paint,path);
        legsRect(canvas,paint,path);
        legsCircle(canvas,paint,path);
    }
    private String TAG = "Robot";
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // AT_MOST:即xml中wrap_content，EXACTLY：match_parent

        //  1.确认宽度的绘制比例     2.确定控件宽度大小
        if (widthMode == MeasureSpec.AT_MOST){
            finalWidth = originWidth;
            widthScale = 1;
        }else if (widthMode == MeasureSpec.EXACTLY){
            widthScale = widthSize/originWidth;
            finalWidth = widthSize;
        }else{
            widthScale = 1;
            finalWidth = originWidth;
        }

        //  1.确认高度绘制比例      2.确定控件高度大小
        if (heightMode == MeasureSpec.AT_MOST){
            finalHeight = originHeight;
            heightScale = 1;
        }else if (heightMode == MeasureSpec.EXACTLY){
            heightScale = heightSize/originHeight;
            finalHeight = heightSize;
        }else{
            heightScale = 1;
            finalHeight = originHeight;
        }
        //  测量完成后调用该方法对数据进行返回，即测量结果在此方法被调用后才会生效
        setMeasuredDimension(finalWidth,finalHeight);
    }
}
