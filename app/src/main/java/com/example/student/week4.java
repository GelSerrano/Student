package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class week4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("I.   \tConstruct a Boolean expression that can be used to make decisions \n" +
                "II.  \tPerform decision making using conditional statements\n"+
                "III. \tDevelop a program using conditional statements \n");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
        Button button = (Button) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week4.this)

                        .setTitle("Quiz")
                        .setMessage("Do you want to take a Quiz?")
                        .setPositiveButton("Yes", null )
                        .setNegativeButton("No", null)
                        .show();
                dialog.setCanceledOnTouchOutside(false);
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(week4.this, prelim_quiz4.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
    public void onBackPressed() {

    }
}
