package com.lyecdevelopers.learncomputers.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.walkthrough.WalkthroughActivity;


public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        handler=new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SplashActivity.this, WalkthroughActivity.class);
            startActivity(intent);
            finish();
        },1000);
    }
}