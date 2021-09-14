package com.example.vezba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class AbsBegginerDetail2 extends AppCompatActivity {
    private static final long START_TIME_IN_MS = 25000;

    private TextView timerCountDown;
    private Button buttonStartResetNext;

    private CountDownTimer countDownTimer;

    private boolean timerRunning;

    private long timeLeftInMillis = START_TIME_IN_MS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_begginer_detail2);

        timerCountDown = findViewById(R.id.timer);
        buttonStartResetNext = findViewById(R.id.button_start_reset_next);

        buttonStartResetNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(timerRunning){
                    resetTimer();
                }else{
                    startTimer();
                }
            }
        });
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUnilFinished){
                timeLeftInMillis = millisUnilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish(){
                timerRunning = false;
                buttonStartResetNext.setText("START");
            }
        }.start();
        timerRunning = true;
        buttonStartResetNext.setText("RESET");

    }

    private void resetTimer(){
        timeLeftInMillis = START_TIME_IN_MS;
        updateCountDownText();
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timerCountDown.setText(timeLeftFormatted);
    }

    public void ClickBackToAbsExercise(View view){
        MainActivity.redirectActivity(this, AbsBegginerActivity.class);
    }

    public void ClickNextExercise(View view){
        MainActivity.redirectActivity(this, AbsBegginerDetail.class);
    }
}