package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {
    private Path path = new Path();
    private Paint paint = new Paint();
    private Canvas extraCanvas;
    private Bitmap extraBitmap;
    private Paint canvasPaint = new Paint(Paint.DITHER_FLAG);
    private int currentColor = Color.BLACK;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing() {
        paint.setColor(currentColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        extraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        extraCanvas = new Canvas(extraBitmap);
        extraCanvas.drawColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(extraBitmap, 0, 0, canvasPaint);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                extraCanvas.drawPath(path, paint);
                path.reset();
                break;
        }

        invalidate();
        return true;
    }

    public void setColor(int color) {
        currentColor = color;
        paint.setColor(currentColor);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setStrokeWidth(float width) {
        paint.setStrokeWidth(width);
    }

    public void setEraserMode(boolean isEraser) {
        if (isEraser) {
            paint.setColor(Color.WHITE);
            paint.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            paint.setColor(currentColor);
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void clearCanvas() {
        extraCanvas.drawColor(Color.WHITE);
        invalidate();
    }
}
