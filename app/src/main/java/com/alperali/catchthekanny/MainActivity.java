    package com.alperali.catchthekanny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

    public class MainActivity extends AppCompatActivity {
Handler handler;
Runnable runnable;
TextView textView;
TextView scoreText;
ImageView imageView;
ImageView imageView1;
ImageView imageView2;
ImageView imageView3;
ImageView imageView4;
ImageView imageView5;
ImageView imageView6;
ImageView imageView7;
ImageView imageView8;
ImageView imageView9;
ImageView imageView10;
ImageView imageView11;
ImageView[] imageViews;
        int number=0;
        int Score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.LeftTime);
        scoreText = findViewById(R.id.ScoreText);
        imageView=findViewById(R.id.imageView);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        imageView10=findViewById(R.id.imageView10);
        imageView11=findViewById(R.id.imageView11);


        imageViews=new ImageView[]{
                imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11
        };
        for(ImageView image : imageViews)
        {
            image.setVisibility(View.INVISIBLE);
        }
        CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                textView.setText("Time: " + l / 1000);
            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                imageViews[number].setVisibility(View.INVISIBLE);
                AlertDialog.Builder alerDialog = new AlertDialog.Builder(MainActivity.this);
                alerDialog.setTitle("Restart the game?");
                alerDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alerDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerDialog.show();
            }
        }.start();
        hideImages();
    }
    public void CatchTheKanny(View view)
    {
        Score++;
        scoreText.setText("Score: " + Score);

    }
    public void hideImages()
    {
        handler = new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                imageViews[number].setVisibility(View.INVISIBLE);
                Random random=new Random();
                number = random.nextInt(11);
                imageViews[number].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,400);
            }
        };
        handler.post(runnable);


    }
}