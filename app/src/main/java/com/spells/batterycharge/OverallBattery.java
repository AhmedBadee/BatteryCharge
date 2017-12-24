package com.spells.batterycharge;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class OverallBattery extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OverallBatteryView overallBatteryView = new OverallBatteryView(this);
        overallBatteryView.setBackgroundColor(Color.WHITE);
        setContentView(overallBatteryView);
        overallBatteryView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.e("TOUCH", "Touched");
        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP) {
            Log.e("TOUCH", "Actioned");
            Intent intent = new Intent(this, SeparateBatteries.class);
            startActivity(intent);
        }

        return true;
    }
}
