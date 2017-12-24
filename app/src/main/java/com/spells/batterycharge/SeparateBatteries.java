package com.spells.batterycharge;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SeparateBatteries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SeparateBatteriesView separateBatteriesView = new SeparateBatteriesView(this);
        separateBatteriesView.setBackgroundColor(Color.WHITE);
        setContentView(separateBatteriesView);
    }
}
