package com.betelgeuse.corp.sprintjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImage = findViewById(R.id.playerID);
        animationDrawable = (AnimationDrawable) myImage.getBackground();
//        Timer timer = new Timer();

//        int[] myImages = new int[]{R.drawable.sonic1, R.drawable.sonic2, R.drawable.sonic3,
//                R.drawable.sonic4, R.drawable.sonic5, R.drawable.sonic6, R.drawable.sonic7, R.drawable.sonic8};
//        final int[] currentImageIndex = {0};
        ImageButton myButton = (ImageButton) findViewById(R.id.start);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Обрабатываем событие касания
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    animationDrawable.start();
//                    timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//                            myImage.setImageResource(myImages[currentImageIndex[0]]);
//                            currentImageIndex[0] = (currentImageIndex[0] + 1) % myImages.length;// Переходим к следующему изображению
////                            Toast.makeText(MainActivity.this, "CLICK", Toast.LENGTH_SHORT).show();
//                        }
//                    }, 0,1000);
//                    new CountDownTimer(100, 100) { // Передаем время в миллисекундах, а также интервал в миллисекундах
//                        @Override
//                        public void onTick(long millisUntilFinished) {
//                            // Загружаем изображение из массива и устанавливаем его в ImageView
//                            myImage.setImageResource(myImages[currentImageIndex[0]]);
//                            currentImageIndex[0] = (currentImageIndex[0] + 1) % myImages.length;// Переходим к следующему изображению
//                            Toast.makeText(MainActivity.this, "CLICK", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFinish() {
//                            // Обработка окончания отсчета времени
//                        }
//                    }.start(); // Запускаем таймер
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    animationDrawable.stop();
                    // Останавливаем таймер
//                    timer.cancel();
                    myButton.setPressed(false);
                }
                return true; // Поглощаем событие
            }
        });
    }
}