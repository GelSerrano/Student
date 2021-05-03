package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class lecture_midterm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_midterm);

        LinearLayout week7 = (LinearLayout) findViewById(R.id.week7);
        week7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        LinearLayout week8 = (LinearLayout) findViewById(R.id.week8);
        week8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivty8();
            }
        });
        LinearLayout week9 = (LinearLayout) findViewById(R.id.week9);
        week9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivty9();
            }
        });
        LinearLayout week10 = (LinearLayout) findViewById(R.id.week10);
        week10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivty10();
            }
        });
        LinearLayout week11 = (LinearLayout) findViewById(R.id.week11);
        week11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivty11();
            }
        });

    }

    private void openActivity7(){
        Intent intent = new Intent(this,week7.class);
        startActivity(intent);
    }
    private void openActivty8(){
        Intent intent = new Intent(this,week8.class);
        startActivity(intent);
    }
    private void openActivty9(){
        Intent intent = new Intent(this,week9.class);
        startActivity(intent);
    }
    private void openActivty10(){
        Intent intent = new Intent(this,week10.class);
        startActivity(intent);
    }
    private void openActivty11(){
        Intent intent = new Intent(this,week11.class);
        startActivity(intent);
    }

}
