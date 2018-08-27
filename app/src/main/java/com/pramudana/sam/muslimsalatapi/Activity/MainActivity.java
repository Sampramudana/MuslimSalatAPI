package com.pramudana.sam.muslimsalatapi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pramudana.sam.muslimsalatapi.R;

public class MainActivity extends AppCompatActivity {

    TextView shubuh, shurooq, dzuhur, ashar, maghrib, isya, state, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
