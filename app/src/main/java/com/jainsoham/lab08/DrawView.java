package com.jainsoham.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawView extends View {
    private final Paint circlePaint = new Paint();
    private final Paint rectPaint = new Paint();
    private int circleX = 100;
    private int circleY = 100;
    private float rectY = 1000.0f;
    private int dXcircle = 8;
    private int dYcircle = 8;
    private int dYrect = -5;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        circlePaint.setColor(Color.MAGENTA);
        rectPaint.setColor(Color.BLUE);
        canvas.drawCircle(circleX, circleY, 130.5f, circlePaint);
        canvas.drawRect(0, rectY, getWidth(), rectY + 100, rectPaint);
        circleX += dXcircle;
        circleY += dYcircle;
        rectY += dYrect;
        if (circleX < 100) { dXcircle = Math.abs(dXcircle); }
        if (circleX > getWidth() - 100) { dXcircle = -Math.abs(dXcircle); }
        if (circleY < 100) { dYcircle = Math.abs(dYcircle); }
        if (circleY > getHeight() - 100) { dYcircle = -Math.abs(dYcircle); }
        if (rectY < 500 || rectY > 1500) { dYrect *= -1; }
        if (circleY > rectY - 125) { dYcircle = -Math.abs(dYcircle); }
        invalidate();
    }

    public void setdXcircle(int dXcircle) {
        this.dXcircle = dXcircle;
    }

    public void setdYcircle(int dYcircle) {
        this.dYcircle = dYcircle;
    }
}
