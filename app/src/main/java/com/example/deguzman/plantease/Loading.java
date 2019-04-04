package com.example.deguzman.plantease;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import cz.msebera.android.httpclient.Header;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;


public class Loading extends AppCompatActivity {
    Button act, sw;
    CircularProgressButton circularProgressButton;
    RingProgressBar progressBar;
    Handler myHandler;

    int progress = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



        progressBar = (RingProgressBar) findViewById(R.id.progress);
        ringProgress();


    }

    public void ringProgress() {
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {

//                AsyncHttpClient client1 = new AsyncHttpClient();
//                client1.setTimeout(70000);
//                client1.get("http://172.20.10.6:8000/start/", new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
///*
//                        onDisplay process = new onDisplay();
//                        process.execute();
//*/
//                        /*deactivate deact = new deactivate();
//                        deact.execute();*/
//                  /*      System.out.println("s");
//                        Intent i = new Intent(AddPlantView.this, ScanActivity.class);
//                        startActivity(i);*/
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//                    }
//
//
//                });
                AsyncHttpClient client1 = new AsyncHttpClient();
                client1.setTimeout(70000);
//                client1.get("http://172.20.10.3:8000/start/", new AsyncHttpResponseHandler() {
                client1.get("http://192.168.1.15:8000/start/", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
/*
                        onDisplay process = new onDisplay();
                        process.execute();
*/
                        /*deactivate deact = new deactivate();
                        deact.execute();*/
                  /*      System.out.println("s");
                        Intent i = new Intent(AddPlantView.this, ScanActivity.class);
                        startActivity(i);*/
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }


                });

                Toast.makeText(Loading.this, "Finish capturing plants!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Loading.this, ScanActivity.class));
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
        Intent intent = getIntent();
        System.out.println(plantactivate.plot_size);

        if(plantactivate.plot_size.equals("1m")){


            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(400);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("2m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(1000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("3m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(1500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("4m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(2000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("5m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(2500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("6m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(3000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("7m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(3500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("8m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(4000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("9m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(4500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("10m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(5000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("11m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(6000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("12m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(6500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("13m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(7000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("14m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(7500);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }else if(plantactivate.plot_size.equals("15m")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(8000);
                            myHandler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
            }
}









