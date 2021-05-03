package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class lecture_finals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_finals);

        LinearLayout week13 = (LinearLayout)findViewById(R.id.week13);
        week13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity13();
            }
        });
        LinearLayout week14 = (LinearLayout)findViewById(R.id.week14);
        week14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity14();
            }
        });
        LinearLayout week15 = (LinearLayout)findViewById(R.id.week15);
        week15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity15();
            }
        });
        LinearLayout week16 = (LinearLayout)findViewById(R.id.week16);
        week16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity16();
            }
        });
    }
    private void openActivity13(){
        Intent intent = new Intent(this,week13.class);
        startActivity(intent);
    }
    private void openActivity14(){
        Intent intent = new Intent(this,week14.class);
        startActivity(intent);
    }
    private void openActivity15(){
        Intent intent = new Intent(this,week15.class);
        startActivity(intent);

    }
    private void openActivity16(){
        Intent intent = new Intent(this, week16.class);
        startActivity(intent);
    }
    public void onBackPressed() {

    }
}
