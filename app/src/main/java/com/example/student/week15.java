package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class week15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week15);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Intent Learning Outcome (ILO)");
        builder.setMessage("I.   \t\tDemonstrate how to use Layout Managers and add components to a container.   \n" +
                "II.  \t\tUnderstand the different types of layout managers.\n"+
                "III.  \tDesign a system using the right layout manager. \n"+
                "IV.  \tSolve the common problems in using a layout manager.");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();

        Button button = (Button) findViewById(R.id.quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(week15.this)

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
                        Intent intent = new Intent(week15.this, final_quiz15.class);
                        startActivity(intent);
                    }
                });

            }
        });


    }
    public void onBackPressed() {

    }
}
