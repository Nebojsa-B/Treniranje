package com.example.vezba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AbsBegginerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_begginer);
    }

    public void ClickBackToHome(View view){
        MainActivity.redirectActivity(this, HomeActivity.class);
    }

    public void ClickAbsBegginerDetail(View view){
        MainActivity.redirectActivity(this, AbsBegginerDetail.class);
    }

    public void ClickAbsBegginerDetail2(View view){
        MainActivity.redirectActivity(this, AbsBegginerDetail2.class);
    }
}