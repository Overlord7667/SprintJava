package com.betelgeuse.corp.sprintjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] myImages = new int[]{R.drawable.sonic1, R.drawable.sonic2, R.drawable.sonic3,
                R.drawable.sonic4, R.drawable.sonic5, R.drawable.sonic6, R.drawable.sonic7, R.drawable.sonic8};
        final int[] currentImageIndex = {0};
        ImageView myImage = findViewById(R.id.playerID);

        ImageButton myButton = (ImageButton) findViewById(R.id.start);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Обрабатываем событие касания
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    new CountDownTimer(100, 100) { // Передаем время в миллисекундах, а также интервал в миллисекундах
                        @Override
                        public void onTick(long millisUntilFinished) {
                            // Загружаем изображение из массива и устанавливаем его в ImageView
                            myImage.setImageResource(myImages[currentImageIndex[0]]);
                            currentImageIndex[0] = (currentImageIndex[0] + 1) % myImages.length; // Переходим к следующему изображению
                        }

                        @Override
                        public void onFinish() {
                            // Обработка окончания отсчета времени
                        }
                    }.start(); // Запускаем таймер
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Останавливаем таймер
                    myButton.setPressed(false);
                }
                return true; // Поглощаем событие
            }
        });
    }
}