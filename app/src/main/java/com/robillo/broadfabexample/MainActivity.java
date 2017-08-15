package com.robillo.broadfabexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.robillo.broadfab.BroadFab;

public class MainActivity extends AppCompatActivity {

    BroadFab fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = new BroadFab(this);
    }
}
