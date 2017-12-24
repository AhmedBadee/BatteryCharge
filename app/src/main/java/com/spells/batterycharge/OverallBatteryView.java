package com.spells.batterycharge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class OverallBatteryView extends View {

    private Paint paintBattery;
    private Paint paintCap;
    private Paint paintCharge;

    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.f;

    private void init() {
        paintBattery = new Paint();
        paintBattery.setColor(0x99212121);
        paintBattery.setStyle(Paint.Style.STROKE);
        paintBattery.setStrokeWidth(4);

        paintCap = new Paint();
        paintCap.setColor(0x99212121);
        paintCap.setStyle(Paint.Style.FILL);
        paintCap.setStrokeWidth(4);
        paintCap.setTextSize(40);

        paintCharge = new Paint();
        paintCharge.setColor(0x9900BFA5);
        paintCharge.setStyle(Paint.Style.FILL);
        paintCharge.setStrokeWidth(4);
    }

    public OverallBatteryView(Context context) {
        super(context);
        scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        init();
    }

    public OverallBatteryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        init();
    }

    public OverallBatteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.scale(scaleFactor, scaleFactor);

        float width = (float) getWidth();
        float height = (float) getHeight();

        float start_x = (width / 2) - 100;
        float start_y = (height / 2) - 200;

        float start_x_cap = (width / 2) - 50;
        float start_y_cap = (height / 2) - 230;

        canvas.drawRoundRect(start_x, start_y, start_x + 200, start_y + 400, 4, 4, paintBattery);
        canvas.drawRoundRect(start_x_cap, start_y_cap, start_x_cap + 100, start_y_cap + 30, 4, 4, paintCap);
        canvas.drawRoundRect(start_x, start_y + 120, start_x + 200, start_y + 400, 4, 4, paintCharge);
        canvas.drawText("70%", start_x + 220, start_y + 120, paintCap);
        canvas.drawText("1000 mA", start_x + 20, start_y + 450, paintCap);

        Log.e("WIDTH", String.valueOf(width));
        Log.e("HEIGHT", String.valueOf(height));

        canvas.restore();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            scaleFactor *= detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            invalidate();

            Log.e("SCALE_FACTOR", String.valueOf(scaleFactor));

            return true;
        }
    }
}
