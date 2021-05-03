package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class week5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week5);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("I.   \tCUnderstand the concept of iterative statements \n" +
                "II.  \tExecute statements repetitively using while, do while and for\n"+
                "III. \tDevelop a program using while, do while and for \n"+
                "IV. \tDemonstrate how to use and form nested control structures \n");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
        Button button = (Button) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week5.this)

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
                        Intent intent = new Intent(week5.this, prelim_quiz5.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
    public void onBackPressed() {

    }
}
