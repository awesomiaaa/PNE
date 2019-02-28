package com.example.deguzman.plantease;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;


public class Loading2 extends AppCompatActivity {
    Button act, sw;
    CircularProgressButton circularProgressButton;
    RingProgressBar progressBar;
    Handler myHandler;

    int progress = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        progressBar = (RingProgressBar) findViewById(R.id.progress);
        ringProgress();


    }

    public void ringProgress() {
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {



                startActivity(new Intent(Loading2.this, ScanActivity.class));
            }
        });
        myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==0){
                    if (progress<100){
                        progress++;
                        progressBar.setProgress(progress);
                    }
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}









