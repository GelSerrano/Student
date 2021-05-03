package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class lecture1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture1);
        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        CardView lecture = (CardView) findViewById(R.id.lecture2);
        LinearLayout midterm = (LinearLayout) findViewById(R.id.midterm);
        midterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        LinearLayout prelim = (LinearLayout) findViewById(R.id.prelim);
        prelim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }


        });
        LinearLayout finals = (LinearLayout)findViewById(R.id.finals);
        finals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });


    }
    private void openActivity1() {
        Intent intent = new Intent(this,Lecture.class);
        startActivity(intent);
    }
    private void openActivity2(){
        Intent intent = new Intent(this,lecture_midterm.class);
        startActivity(intent);
    }
    private void openActivity3(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void openActivity4(){
        Intent intent = new Intent(this,lecture_finals.class);
        startActivity(intent);

    }
    public void onBackPressed() {

    }
}
