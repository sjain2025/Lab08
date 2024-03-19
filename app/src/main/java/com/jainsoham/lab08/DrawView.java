package com.jainsoham.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawView extends View {
    private final Paint circlePaint = new Paint();
    private Paint linePaint = new Paint();
    private final Paint rectPaint = new Paint();
    private final Paint circlePaint2 = new Paint();
    private final Paint borderPaint = new Paint();
    private final Paint backgroundWhite = new Paint();
    private final Paint backgroundColor = new Paint();
    private int circleX = 150;
    private int circleY = 150;
    private int circle2X = 900;
    private int circle2Y = 150;
    private float rectX = 350.0f;
    private float rectY = 1400.0f;
    private int dXcircle = 20;
    private int dYcircle = 20;
    private int dYcircle2 = 20;
    private int dXcircle2 = -20;

    private boolean isPaused = false;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!isPaused) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_MOVE:
                            rectX = event.getX() - (float) getWidth() / 6;
                            invalidate();
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        backgroundColor.setColor(Color.rgb(230, 193, 177));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), backgroundColor);
        circlePaint.setColor(Color.rgb(248, 128, 88));
        circlePaint2.setColor(Color.WHITE);
        backgroundWhite.setColor(Color.WHITE);
        circlePaint2.setStyle(Paint.Style.STROKE);
        circlePaint2.setStrokeWidth(6);
        circlePaint2.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(3);
        borderPaint.setColor(Color.BLACK);
        rectPaint.setColor(Color.rgb(59, 84, 245));
        linePaint.setStrokeWidth(6);

        canvas.drawCircle(circle2X, circle2Y, 120.5f, backgroundWhite);

        int centerX = circle2X - 60;
        int centerY = circle2Y - 62;
        int radius = 40;
        int sides = 5;
        Path pentagonPath = new Path();
        float angle = (float) (2 * Math.PI / sides);
        pentagonPath.moveTo(centerX + radius, centerY);
        for (int i = 1; i < sides; i++) {
            float x = (float) (centerX + radius * Math.cos(i * angle));
            float y = (float) (centerY + radius * Math.sin(i * angle));
            pentagonPath.lineTo(x, y);
        }
        pentagonPath.close();

        canvas.save();
        canvas.rotate(45, centerX, centerY);
        canvas.drawPath(pentagonPath, linePaint);
        canvas.restore();

        int centerX2 = circle2X + 35;
        int centerY2 = circle2Y - 150;
        Path pentagonPath2 = new Path();
        pentagonPath2.moveTo(centerX2 + radius, centerY2);
        for (int i = 1; i < sides; i++) {
            float x = (float) (centerX2 + radius * Math.cos(i * angle));
            float y = (float) (centerY2 + radius * Math.sin(i * angle));
            pentagonPath2.lineTo(x, y);
        }
        pentagonPath2.close();

        canvas.save();
        canvas.rotate(75, centerX, centerY);
        canvas.drawPath(pentagonPath2, linePaint);
        canvas.restore();

        int centerX3 = circle2X;
        int centerY3 = circle2Y + 50;
        Path pentagonPath3 = new Path();
        pentagonPath3.moveTo(centerX3 + radius, centerY3);
        for (int i = 1; i < sides; i++) {
            float x = (float) (centerX3 + radius * Math.cos(i * angle));
            float y = (float) (centerY3 + radius * Math.sin(i * angle));
            pentagonPath3.lineTo(x, y);
        }
        pentagonPath3.close();

        canvas.save();
        canvas.rotate(30, centerX, centerY);
        canvas.drawPath(pentagonPath3, linePaint);
        canvas.restore();

        canvas.drawLine(centerX - 20, centerY, centerX2 - 110, centerY2 + 205, linePaint);
        canvas.drawLine(centerX, centerY, centerX2 - 15, centerY2 + 140, linePaint);
        canvas.drawLine(centerX2 - 80, centerY2 + 195, centerX3 + 60, centerY3 - 30, linePaint);
        canvas.drawLine(centerX, centerY + 10, centerX + 75, centerY - 60, linePaint);
        canvas.drawLine(centerX2 - 30, centerY2 + 270, centerX3 - 50, centerY3 + 20, linePaint);
        canvas.drawLine(centerX2 + 30, centerY2 + 150, centerX2, centerY2 + 270, linePaint);
        canvas.drawLine(centerX2 + 30, centerY2 + 150, centerX2 + 90, centerY2 + 175, linePaint);
        canvas.drawLine(centerX2 + 30, centerY2 + 150, centerX2 + 5, centerY2 + 30, linePaint);

        canvas.drawCircle(circle2X, circle2Y, 120.5f, circlePaint2);
        canvas.drawRect(rectX, rectY, rectX + (float) getWidth() / 3, rectY + 100.0f, rectPaint);

        canvas.drawCircle(circleX, circleY, 132.5f, borderPaint);
        canvas.drawCircle(circleX, circleY, 130.5f, circlePaint);

        float left = circleX - 130.5f;
        float top = circleY - 300f;
        float right = circleX + 130.5f;
        float bottom = circleY - 60f;

        canvas.drawArc(left, top, right, bottom, 45, 90, false, linePaint);
        canvas.drawArc(left + 20f, top, right - 20f, bottom - 5f, 45, 90, false, circlePaint);

        canvas.drawArc(left, top + 360f, right, bottom + 360f, -135, 90, false, linePaint);
        canvas.drawArc(left + 15f, top + 370f, right - 15f, bottom + 360f, -135, 90, false, circlePaint);

        canvas.drawLine(circleX - 130.5f, circleY, circleX + 130.5f, circleY, linePaint);
        canvas.drawLine(circleX, circleY - 130.5f, circleX, circleY + 130.5f, linePaint);

        if (!isPaused) {
            circleX += dXcircle;
            circleY += dYcircle;

            circle2X += dXcircle2;
            circle2Y += dYcircle2;
            if (circleX < 100) { dXcircle = Math.abs(dXcircle); }
            if (circle2X < 100) { dXcircle2 = Math.abs(dXcircle2); }

            if (circleX > getWidth() - 100) { dXcircle = -Math.abs(dXcircle); }
            if (circle2X > getWidth() - 100) { dXcircle2 = -Math.abs(dXcircle2); }

            if (circleY < 100) { dYcircle = Math.abs(dYcircle); }
            if ((circleY > rectY - 125) && (circleX - rectX < (float) getWidth() / 3) && circleX > rectX) { dYcircle = -Math.abs(dYcircle); }
            if (circleY > rectY + 100.0f) { dYcircle = Math.abs(dYcircle); }

            if (circle2Y < 100) { dYcircle2 = Math.abs(dYcircle2); }
            if ((circle2Y > rectY - 125) && (circle2X - rectX < (float) getWidth() / 3) && circle2X > rectX) { dYcircle2 = -Math.abs(dYcircle2); }
            if (circle2Y > rectY + 100.0f) { dYcircle2 = Math.abs(dYcircle2); }
        }

        invalidate();
    }

    public void setdXcircle(int dXcircle) {
        this.dXcircle = dXcircle;
        this.dXcircle2 = dXcircle;
    }

    public void setdYcircle(int dYcircle) {
        this.dYcircle = dYcircle;
        this.dYcircle2 = dYcircle;
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public void reset() {
        circleX = 150;
        circleY = 150;
        circle2X = 900;
        circle2Y = 150;
        rectX = 350.0f;
        rectY = 1400.0f;
    }
}
