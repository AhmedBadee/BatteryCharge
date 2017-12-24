package com.spells.batterycharge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SeparateBatteriesView extends View {

    private Paint paintBattery;
    private Paint paintCap;
    private Paint paintCharge;

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

    public SeparateBatteriesView(Context context) {
        super(context);
        init();
    }

    public SeparateBatteriesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SeparateBatteriesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = (float) getWidth();
        float height = (float) getHeight();

        float start_x = 100;
        float start_y = (height / 2) - 200;

        float start_x_cap = 100;
        float start_y_cap = (height / 2) - 230;

        for (int i = 0; i < 4; i++) {
            canvas.drawRoundRect(start_x, start_y, start_x + 200, start_y + 400, 4, 4, paintBattery);
            canvas.drawRoundRect(start_x_cap + 50, start_y_cap, start_x_cap + 150, start_y_cap + 30, 4, 4, paintCap);
            canvas.drawRoundRect(start_x, start_y + 120, start_x + 200, start_y + 400, 4, 4, paintCharge);
            canvas.drawText("70%", start_x + 220, start_y + 120, paintCap);
            canvas.drawText("1000 mA", start_x + 20, start_y + 450, paintCap);
            start_x += 400;
            start_x_cap += 400;
        }

        Log.e("WIDTH", String.valueOf(width));
        Log.e("HEIGHT", String.valueOf(height));
    }
}
