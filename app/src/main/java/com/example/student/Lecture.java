package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Lecture extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        LinearLayout week1 = (LinearLayout) findViewById(R.id.week1);
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek1();
            }


        });
        LinearLayout week2 = (LinearLayout)findViewById(R.id.week2);
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek2();
            }
        });
        LinearLayout week3 = (LinearLayout) findViewById(R.id.week3);
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek3();
            }


        });
        LinearLayout week4 = (LinearLayout) findViewById(R.id.week4);
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek4();
            }


        });
        LinearLayout week5 = (LinearLayout) findViewById(R.id.week5);
        week5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeek5();
            }


        });
    }
    private void openWeek1() {
        Intent intent = new Intent(this, week1.class);
        startActivity(intent);
    }
    private void openWeek2() {
        Intent intent = new Intent(this, Week2.class);
        startActivity(intent);
    }

    private void openWeek3() {
        Intent intent = new Intent(this, Week3.class);
        startActivity(intent);
    }
    private void openWeek4() {
        Intent intent = new Intent(this, week4.class);
        startActivity(intent);
    }
    private void openWeek5() {
        Intent intent = new Intent(this, week5.class);
        startActivity(intent);
    }
    public void onBackPressed() {

    }
}
