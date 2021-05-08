package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class prelim_quiz5 extends AppCompatActivity {

    Button submit;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    long datetime = new Date().getTime();
    ;
    String check;
    String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;
    //    quizmenu qz;
    String childname;
    TextView question1, question2, question3, question4, question5, question6, question7,
            question8, question9, question10, timer;
    RadioGroup q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    Button a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, a4, b4, c4, d4, a5, b5,
            a6, b6, a7, b7;
    Button next1, next2, next3, next4, next5, next6, next7, next8, next9, back2, back3, back4, back5, back6, back7, back8, back9, back10;
    EditText ans8, ans9, ans10;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelim_quiz5);

        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("P_Q5SharedPref",MODE_PRIVATE);
        // Creating an Editor object to edit(write to the file)
        final SharedPreferences.Editor myEdit = sharedPreferences.edit();

        //getDate
        DateTime dt = new DateTime();
        final String currdate = dt.getDate();

        timer = findViewById(R.id.textView10);
        //Button
        submit = findViewById(R.id.submit);
        //RadioGroup
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);
        q10 = findViewById(R.id.q10);
        //RadioButton
        a1 = findViewById(R.id.a1);
        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        d1 = findViewById(R.id.d1);
        a2 = findViewById(R.id.a2);
        b2 = findViewById(R.id.b2);
        c2 = findViewById(R.id.c2);
        d2 = findViewById(R.id.d2);
        a3 = findViewById(R.id.a3);
        b3 = findViewById(R.id.b3);
        c3 = findViewById(R.id.c3);
        d3 = findViewById(R.id.d3);
        a4 = findViewById(R.id.a4);
        b4 = findViewById(R.id.b4);
        c4 = findViewById(R.id.c4);
        d4 = findViewById(R.id.d4);
        a5 = findViewById(R.id.a5);
        b5 = findViewById(R.id.b5);
        a6 = findViewById(R.id.a6);
        b6 = findViewById(R.id.b6);
        a7 = findViewById(R.id.a7);
        b7 = findViewById(R.id.b7);

        //Back and Next
        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q1.setVisibility(View.GONE);
                q2.setVisibility(View.VISIBLE);
            }
        });
        back2 = (Button) findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.GONE);
                q1.setVisibility(View.VISIBLE);
            }
        });
        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.GONE);
                q3.setVisibility(View.VISIBLE);
            }
        });
        back3 = (Button) findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2.setVisibility(View.VISIBLE);
                q3.setVisibility(View.GONE);
            }
        });
        next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q3.setVisibility(View.GONE);
                q4.setVisibility(View.VISIBLE);
            }
        });
        back4 = (Button) findViewById(R.id.back4);
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q3.setVisibility(View.VISIBLE);
                q4.setVisibility(View.GONE);
            }
        });
        next4 = (Button) findViewById(R.id.next4);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q4.setVisibility(View.GONE);
                q5.setVisibility(View.VISIBLE);
            }
        });
        back5 = (Button) findViewById(R.id.back5);
        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q4.setVisibility(View.VISIBLE);
                q5.setVisibility(View.GONE);
            }
        });
        next5 = (Button) findViewById(R.id.next5);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q5.setVisibility(View.GONE);
                q6.setVisibility(View.VISIBLE);
            }
        });
        back6 = (Button) findViewById(R.id.back6);
        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q5.setVisibility(View.VISIBLE);
                q6.setVisibility(View.GONE);
            }
        });
        next6 = (Button) findViewById(R.id.next6);
        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q6.setVisibility(View.GONE);
                q7.setVisibility(View.VISIBLE);
            }
        });
        back7 = (Button) findViewById(R.id.back7);
        back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q6.setVisibility(View.VISIBLE);
                q7.setVisibility(View.GONE);
            }
        });
        next7 = (Button) findViewById(R.id.next7);
        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q7.setVisibility(View.GONE);
                q8.setVisibility(View.VISIBLE);
            }
        });
        back8 = (Button) findViewById(R.id.back8);
        back8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q7.setVisibility(View.VISIBLE);
                q8.setVisibility(View.GONE);
            }
        });
        next8 = (Button) findViewById(R.id.next8);
        next8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q8.setVisibility(View.GONE);
                q9.setVisibility(View.VISIBLE);
            }
        });
        back9 = (Button) findViewById(R.id.back9);
        back9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q8.setVisibility(View.VISIBLE);
                q9.setVisibility(View.GONE);
            }
        });
        next9 = (Button) findViewById(R.id.next9);
        next9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q9.setVisibility(View.GONE);
                q10.setVisibility(View.VISIBLE);
            }
        });
        back10 = (Button) findViewById(R.id.back10);
        back10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q9.setVisibility(View.VISIBLE);
                q10.setVisibility(View.GONE);
            }
        });
        //TextView
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        question5 = findViewById(R.id.question5);
        question6 = findViewById(R.id.question6);
        question7 = findViewById(R.id.question7);
        question8 = findViewById(R.id.question8);
        question9 = findViewById(R.id.question9);
        question10 = findViewById(R.id.question10);

        //EditText
        ans8 = findViewById(R.id.ans8);
        ans9 = findViewById(R.id.ans9);
        ans10 = findViewById(R.id.ans10);

        reverseTimer(120, timer);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("lesson5");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> number = new ArrayList<String>();
                number.add(0, String.valueOf(1));
                number.add(0, String.valueOf(2));
                number.add(0, String.valueOf(3));
                number.add(0, String.valueOf(4));
                number.add(0, String.valueOf(5));
                number.add(0, String.valueOf(6));
                number.add(0, String.valueOf(7));
                number.add(0, String.valueOf(8));
                Collections.shuffle(number);

                ArrayList<String> tf = new ArrayList<String>();
                tf.add(0, String.valueOf(1));
                tf.add(0, String.valueOf(2));
                tf.add(0, String.valueOf(3));
                tf.add(0, String.valueOf(4));
                tf.add(0, String.valueOf(5));
                tf.add(0, String.valueOf(6));
                Collections.shuffle(tf);

                ArrayList<String> ident = new ArrayList<String>();
                ident.add(0, String.valueOf(1));
                ident.add(0, String.valueOf(2));
                ident.add(0, String.valueOf(3));
                ident.add(0, String.valueOf(4));
                ident.add(0, String.valueOf(5));
                ident.add(0, String.valueOf(6));
                Collections.shuffle(ident);


                final Question one = dataSnapshot.child("PrelimMultipleChoice").child(number.get(0)).getValue(Question.class);
                //Question1

                ArrayList<String> q1choice = new ArrayList<String>();

                q1choice.add(0, one.getOption1());
                q1choice.add(1, one.getOption2());
                q1choice.add(2, one.getOption3());
                q1choice.add(3, one.getOption4());
                Collections.shuffle(q1choice);
                question1.setText(one.getQuestion());
                a1.setText(q1choice.get(0));
                b1.setText(q1choice.get(1));
                c1.setText(q1choice.get(2));
                d1.setText(q1choice.get(3));
                a1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = a1.getText().toString();
                        if (a1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = b1.getText().toString();
                        if (b1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = c1.getText().toString();
                        if (c1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer1 = d1.getText().toString();
                        if (d1.getText().toString().equals(one.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                    }
                });

                final Question two = dataSnapshot.child("PrelimMultipleChoice").child(number.get(1)).getValue(Question.class);
                //Question2
                ArrayList<String> q2choice = new ArrayList<String>();
                q2choice.add(0, two.getOption1());
                q2choice.add(0, two.getOption2());
                q2choice.add(0, two.getOption3());
                q2choice.add(0, two.getOption4());
                Collections.shuffle(q2choice);
                question2.setText(two.getQuestion());
                a2.setText(q2choice.get(0));
                b2.setText(q2choice.get(1));
                c2.setText(q2choice.get(2));
                d2.setText(q2choice.get(3));
                a2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = a2.getText().toString();
                        if (a2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = b2.getText().toString();
                        if (b2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = c2.getText().toString();
                        if (c2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer2 = d2.getText().toString();
                        if (d2.getText().toString().equals(two.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //Question3
                final Question three = dataSnapshot.child("PrelimMultipleChoice").child(number.get(2)).getValue(Question.class);
                ArrayList<String> q3choice = new ArrayList<String>();
                q3choice.add(0, three.getOption1());
                q3choice.add(0, three.getOption2());
                q3choice.add(0, three.getOption3());
                q3choice.add(0, three.getOption4());
                Collections.shuffle(q3choice);
                question3.setText(three.getQuestion());
                a3.setText(q3choice.get(0));
                b3.setText(q3choice.get(1));
                c3.setText(q3choice.get(2));
                d3.setText(q3choice.get(3));

                a3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = a3.getText().toString();
                        if (a3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = b3.getText().toString();
                        if (b3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = c3.getText().toString();
                        if (c3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer3 = d3.getText().toString();
                        if (d3.getText().toString().equals(three.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //Question4
                final Question four = dataSnapshot.child("PrelimMultipleChoice").child(number.get(3)).getValue(Question.class);
                ArrayList<String> q4choice = new ArrayList<String>();
                q4choice.add(0, four.getOption1());
                q4choice.add(0, four.getOption2());
                q4choice.add(0, four.getOption3());
                q4choice.add(0, four.getOption4());
                Collections.shuffle(q4choice);
                question4.setText(four.getQuestion());
                a4.setText(q4choice.get(0));
                b4.setText(q4choice.get(1));
                c4.setText(q4choice.get(2));
                d4.setText(q4choice.get(3));

                a4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = a4.getText().toString();
                        if (a4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = b4.getText().toString();
                        if (b4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = c4.getText().toString();
                        if (c4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                d4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer4 = d4.getText().toString();
                        if (d4.getText().toString().equals(four.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //Question5
                final Question five = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(0)).getValue(Question.class);
                question5.setText(five.getQuestion());
                a5.setText(five.getOption1());
                b5.setText(five.getOption2());

                a5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = a5.getText().toString();
                        if (a5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer5 = b5.getText().toString();
                        if (b5.getText().toString().equals(five.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //Question6
                final Question six = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(1)).getValue(Question.class);
                question6.setText(six.getQuestion());
                a6.setText(six.getOption1());
                b6.setText(six.getOption2());

                a6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = a6.getText().toString();
                        if (a6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer6 = b6.getText().toString();
                        if (b6.getText().toString().equals(six.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });


                //Question7
                final Question seven = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(2)).getValue(Question.class);
                question7.setText(seven.getQuestion());
                a7.setText(seven.getOption1());
                b7.setText(seven.getOption2());

                a7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = a7.getText().toString();
                        if (a7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        answer7 = b7.getText().toString();
                        if (b7.getText().toString().equals(seven.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }
                    }
                });

                //Question8
                final Question eight = dataSnapshot.child("PrelimIdentification").child(ident.get(0)).getValue(Question.class);
                question8.setText(eight.getQuestion());

                //Question9
                final Question nine = dataSnapshot.child("PrelimIdentification").child(ident.get(1)).getValue(Question.class);
                question9.setText(nine.getQuestion());

                //Question10
                final Question ten = dataSnapshot.child("PrelimIdentification").child(ident.get(2)).getValue(Question.class);
                question10.setText(ten.getQuestion());


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        answer8 = ans8.getText().toString();
                        if (answer8.equals(eight.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer9 = ans9.getText().toString();
                        if (answer9.equals(nine.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        answer10 = ans10.getText().toString();
                        if (ans10.getText().toString().equals(ten.getAnswer())) {
                            correct++;
                        } else {
                            wrong++;
                        }

                        //save prelim quiz 1 result
                        myEdit.putString("pq5_date", "Q(5) " +  currdate);
                        myEdit.putInt("pq5_score", correct);
                        myEdit.commit();

                        AlertDialog dialog = new AlertDialog.Builder(prelim_quiz5.this)

                                .setTitle("Caution")
                                .setMessage("Are you sure you want to submit??")
                                .setPositiveButton("Yes", null)
                                .setNegativeButton("No", null)
                                .show();
                        dialog.setCanceledOnTouchOutside(false);
                        final Button positiveButton1 = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        positiveButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog dialog1 = new AlertDialog.Builder(prelim_quiz5.this)
                                        .setTitle("Score")
                                        .setMessage("Your score was: \t" + correct)
                                        .setPositiveButton("OK", null)
                                        .show();
                                final Button positiveButton = dialog1.getButton(AlertDialog.BUTTON_POSITIVE);
                                positiveButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(prelim_quiz5.this, Lecture.class);
                                        startActivity(intent);
                                    }
                                });
//                        builder.setCancelable(false);
//                        builder.setTitle("Score");
//                        builder.setMessage("Your Score was: \t"+  correct);
//                        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
                                //                                Intent intent = new Intent(pquiz1.this,PWeek1.class);
                            }
                        });
//                        builder.show();
//                            }
//                        });

//                        AlertDialog.Builder builder = new AlertDialog.Builder(pquiz1.this);
//                        builder.setCancelable(false);
//                        builder.setTitle("Score");
//                        builder.setMessage("Your Score was: /t"+  correct);
//                        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                            }
//                        });
//                        builder.show();
////                        Intent i = new Intent(pquiz1.this,prelimresult1.class);
////                        finish();
//                        i.putExtra("correct",String.valueOf(correct));
//
//                        i.putExtra("q11", one.getQuestion());
//                        i.putExtra("youranswer1", answer1);
//                        i.putExtra("correctanswer1", one.getAnswer());
//
//                        i.putExtra("q22", two.getQuestion());
//                        i.putExtra("youranswer2", answer2);
//                        i.putExtra("correctanswer2", two.getAnswer());
//
//                        i.putExtra("q33", three.getQuestion());
//                        i.putExtra("youranswer3", answer3);
//                        i.putExtra("correctanswer3", three.getAnswer());
//
//                        i.putExtra("q44", four.getQuestion());
//                        i.putExtra("youranswer4", answer4);
//                        i.putExtra("correctanswer4", four.getAnswer());
//
//                        i.putExtra("q55", five.getQuestion());
//                        i.putExtra("youranswer5", answer5);
//                        i.putExtra("correctanswer5",five.getAnswer());
//
//                        i.putExtra("q66", six.getQuestion());
//                        i.putExtra("youranswer6", answer6);
//                        i.putExtra("correctanswer6", six.getAnswer());
//
//                        i.putExtra("q77", seven.getQuestion());
//                        i.putExtra("youranswer7", answer7);
//                        i.putExtra("correctanswer7", seven.getAnswer());
//
//                        i.putExtra("q88", eight.getQuestion());
//                        i.putExtra("youranswer8", answer8);
//                        i.putExtra("correctanswer8", eight.getAnswer());
//
//                        i.putExtra("q99", nine.getQuestion());
//                        i.putExtra("youranswer9", answer9);
//                        i.putExtra("correctanswer9", nine.getAnswer());
//
//                        i.putExtra("q100", ten.getQuestion());
//                        i.putExtra("youranswer10", answer10);
//                        i.putExtra("correctanswer10", ten.getAnswer());

//                        startActivity(i);
//                        finish();
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void reverseTimer(int seconds, final TextView tv) {
        new CountDownTimer(seconds * 1000 + 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Times Up");
                a1.setEnabled(false);
                b1.setEnabled(false);
                c1.setEnabled(false);
                d1.setEnabled(false);
                a2.setEnabled(false);
                b2.setEnabled(false);
                c2.setEnabled(false);
                d2.setEnabled(false);
                a3.setEnabled(false);
                b3.setEnabled(false);
                c3.setEnabled(false);
                d3.setEnabled(false);
                a4.setEnabled(false);
                b4.setEnabled(false);
                c4.setEnabled(false);
                d4.setEnabled(false);

                a5.setEnabled(false);
                b5.setEnabled(false);

                a6.setEnabled(false);
                b6.setEnabled(false);

                a7.setEnabled(false);
                b7.setEnabled(false);

                ans8.setEnabled(false);
                ans9.setEnabled(false);
                ans10.setEnabled(false);

            }
        }.start();


//
//
//        timer = findViewById(R.id.textView10);
//        //Button
//        submit = findViewById(R.id.submit);
//        //Radio Group
//        next1 = (Button) findViewById(R.id.next1);
//        next2 = (Button) findViewById(R.id.next2);
//        q1 = findViewById(R.id.q1);
//        q2 = findViewById(R.id.q2);
//        q3 = findViewById(R.id.q3);
//        q4 = findViewById(R.id.q4);
//        q5 = findViewById(R.id.q5);
//        q6 = findViewById(R.id.q6);
//        q7 = findViewById(R.id.q7);
////        q8 = findViewById(R.id.q8);
////        q9 = findViewById(R.id.q9);
////        q10 = findViewById(R.id.q10);
//        //RadioButton
//        a1 = findViewById(R.id.a1);
//        b1 = findViewById(R.id.b1);
//        c1 = findViewById(R.id.c1);
//        d1 = findViewById(R.id.d1);
//        a2 = findViewById(R.id.a2);
//        b2 = findViewById(R.id.b2);
//        c2 = findViewById(R.id.c2);
//        d2 = findViewById(R.id.d2);
//        a3 = findViewById(R.id.a3);
//        b3 = findViewById(R.id.b3);
//        c3 = findViewById(R.id.c3);
//        d3 = findViewById(R.id.d3);
//        a4 = findViewById(R.id.a4);
//        b4 = findViewById(R.id.b4);
//        c4 = findViewById(R.id.c4);
//        d4 = findViewById(R.id.d4);
//        a5 = findViewById(R.id.a5);
//        b5 = findViewById(R.id.b5);
//        a6 = findViewById(R.id.a6);
//        b6 = findViewById(R.id.b6);
//        a7 = findViewById(R.id.a7);
//        b7 = findViewById(R.id.b7);
//
//        //TextView
//        question1 = findViewById(R.id.question1);
//        question2 = findViewById(R.id.question2);
//        question3 = findViewById(R.id.question3);
//        question4 = findViewById(R.id.question4);
//        question5 = findViewById(R.id.question5);
//        question6 = findViewById(R.id.question6);
//        question7 = findViewById(R.id.question7);
//        question8 = findViewById(R.id.question8);
//        question9 = findViewById(R.id.question9);
//        question10 = findViewById(R.id.question10);
//
//        //EditText
//        ans8 = findViewById(R.id.ans8);
//        ans9 = findViewById(R.id.ans9);
//        ans10 = findViewById(R.id.ans10);
//
//        q2.setVisibility(View.GONE);
//        q3.setVisibility(View.GONE);
//        q4.setVisibility(View.GONE);
//        q5.setVisibility(View.GONE);
//        q6.setVisibility(View.GONE);
//        q7.setVisibility(View.GONE);
//        question8.setVisibility(View.GONE);
//        question9.setVisibility(View.GONE);
//        question10.setVisibility(View.GONE);
//        ans8.setVisibility(View.GONE);
//        ans9.setVisibility(View.GONE);
//        ans10.setVisibility(View.GONE);
//        next1.setVisibility(View.GONE);
//        next2.setVisibility(View.GONE);
//        submit.setVisibility(View.GONE);
//
//        reverseTimer(120, timer);
//
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("PrelimQuestion").child("lesson1");
//        databaseReference.keepSynced(true);
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ArrayList<String> number = new ArrayList<String>();
//                number.add(0, "1");
//                number.add(0, "2");
//                number.add(0, "3");
//                number.add(0, "4");
//                number.add(0, "5");
//                number.add(0, "6");
//                number.add(0, "7");
//                number.add(0, "8");
//                Collections.shuffle(number);
//
//
//                ArrayList<String> tf = new ArrayList<String>();
//                tf.add(0, String.valueOf(1));
//                tf.add(0, String.valueOf(2));
//                tf.add(0, String.valueOf(3));
//                tf.add(0, String.valueOf(4));
//                tf.add(0, String.valueOf(5));
//                tf.add(0, String.valueOf(6));
//                Collections.shuffle(tf);
//
//                ArrayList<String> ident = new ArrayList<String>();
//                ident.add(0, String.valueOf(1));
//                ident.add(0, String.valueOf(2));
//                ident.add(0, String.valueOf(3));
//                ident.add(0, String.valueOf(4));
//                ident.add(0, String.valueOf(5));
//                ident.add(0, String.valueOf(6));
//                Collections.shuffle(ident);
//
//
//                final Question one = dataSnapshot.child("PrelimMultipleChoice").child(number.get(0)).getValue(Question.class);
//                //Question1
//                ArrayList<String> q1choice = new ArrayList<String>();
//                q1choice.add(0, one.getOption1());
//                q1choice.add(1, one.getOption2());
//                q1choice.add(2, one.getOption3());
//                q1choice.add(3, one.getOption4());
//                Collections.shuffle(q1choice);
//                question1.setText(one.getQuestion());
//                a1.setText(q1choice.get(0));
//                b1.setText(q1choice.get(1));
//                c1.setText(q1choice.get(2));
//                d1.setText(q1choice.get(3));
//                a1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = a1.getText().toString();
//                        if (a1.getText().toString().equals(one.getAnswer())){
//                            correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = b1.getText().toString();
//                        if (b1.getText().toString().equals(one.getAnswer())){
//                            correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = c1.getText().toString();
//                        if (c1.getText().toString().equals(one.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                d1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer1 = d1.getText().toString();
//                        if (d1.getText().toString().equals(one.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q2.setVisibility(View.VISIBLE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                final Question two = dataSnapshot.child("PrelimMultipleChoice").child(number.get(1)).getValue(Question.class);
//                //Question2
//                ArrayList<String> q2choice = new ArrayList<String>();
//                q2choice.add(0, two.getOption1());
//                q2choice.add(0, two.getOption2());
//                q2choice.add(0, two.getOption3());
//                q2choice.add(0, two.getOption4());
//                Collections.shuffle(q2choice);
//                question2.setText(two.getQuestion());
//                a2.setText(q2choice.get(0));
//                b2.setText(q2choice.get(1));
//                c2.setText(q2choice.get(2));
//                d2.setText(q2choice.get(3));
//                a2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = a2.getText().toString();
//                        if (a2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = b2.getText().toString();
//                        if (b2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                c2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = c2.getText().toString();
//                        if (c2.getText().toString().equals(two.getAnswer())){
//                            correct++;} else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                d2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer2 = d2.getText().toString();
//                        if (d2.getText().toString().equals(two.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q3.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//
//                //Question3
//                final Question three = dataSnapshot.child("PrelimMultipleChoice").child(number.get(2)).getValue(Question.class);
//                ArrayList<String> q3choice = new ArrayList<String>();
//                q3choice.add(0, three.getOption1());
//                q3choice.add(0, three.getOption2());
//                q3choice.add(0, three.getOption3());
//                q3choice.add(0, three.getOption4());
//                Collections.shuffle(q3choice);
//                question3.setText(three.getQuestion());
//                a3.setText(q3choice.get(0));
//                b3.setText(q3choice.get(1));
//                c3.setText(q3choice.get(2));
//                d3.setText(q3choice.get(3));
//
//                a3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = a3.getText().toString();
//                        if (a3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = b3.getText().toString();
//                        if (b3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = c3.getText().toString();
//                        if (c3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                d3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer3 = d3.getText().toString();
//                        if (d3.getText().toString().equals(three.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q4.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question4
//                final Question four = dataSnapshot.child("PrelimMultipleChoice").child(number.get(3)).getValue(Question.class);
//                ArrayList<String> q4choice = new ArrayList<String>();
//                q4choice.add(0, four.getOption1());
//                q4choice.add(0, four.getOption2());
//                q4choice.add(0, four.getOption3());
//                q4choice.add(0, four.getOption4());
//                Collections.shuffle(q4choice);
//                question4.setText(four.getQuestion());
//                a4.setText(q4choice.get(0));
//                b4.setText(q4choice.get(1));
//                c4.setText(q4choice.get(2));
//                d4.setText(q4choice.get(3));
//
//                a4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = a4.getText().toString();
//                        if (a4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = b4.getText().toString();
//                        if (b4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                c4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = c4.getText().toString();
//                        if (c4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                d4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer4 = d4.getText().toString();
//                        if (d4.getText().toString().equals(four.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q5.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//
//                //Question5
//                final Question five = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(0)).getValue(Question.class);
//                question5.setText(five.getQuestion());
//                a5.setText(five.getOption1());
//                b5.setText(five.getOption2());
//
//                a5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer5 = a5.getText().toString();
//                        if (a5.getText().toString().equals(five.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q6.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer5 = b5.getText().toString();
//                        if (b5.getText().toString().equals(five.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q6.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question6
//                final Question six = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(1)).getValue(Question.class);
//                question6.setText(six.getQuestion());
//                a6.setText(six.getOption1());
//                b6.setText(six.getOption2());
//
//                a6.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer6 = a6.getText().toString();
//                        if (a6.getText().toString().equals(six.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q7.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b6.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer6 = b6.getText().toString();
//                        if (b6.getText().toString().equals(six.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        q7.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//
//                //Question7
//                final Question seven = dataSnapshot.child("PrelimTrueOrFalse").child(tf.get(2)).getValue(Question.class);
//                question7.setText(seven.getQuestion());
//                a7.setText(seven.getOption1());
//                b7.setText(seven.getOption2());
//
//                a7.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer7 = a7.getText().toString();
//                        if (a7.getText().toString().equals(seven.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        question8.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.VISIBLE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//
//                    }
//                });
//
//                b7.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        answer7 = b7.getText().toString();
//                        if (b7.getText().toString().equals(seven.getAnswer())){correct++;}
//                        else {wrong++;}
//                        q1.setVisibility(View.GONE);
//                        question8.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans8.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next1.setVisibility(View.VISIBLE);
//                        next2.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//
//                //Question8
//                final Question eight = dataSnapshot.child("PrelimIdentification").child(ident.get(0)).getValue(Question.class);
//                question8.setText(eight.getQuestion());
//
//
//                //Question9
//                final Question nine = dataSnapshot.child("PrelimIdentification").child(ident.get(1)).getValue(Question.class);
//                question9.setText(nine.getQuestion());
//
//                //Question10
//                final Question ten = dataSnapshot.child("PrelimIdentification").child(ident.get(2)).getValue(Question.class);
//                question10.setText(ten.getQuestion());
//
////
//                next1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        q1.setVisibility(View.GONE);
//                        question9.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question10.setVisibility(View.GONE);
//                        ans9.setVisibility(View.VISIBLE);
//                        ans8.setVisibility(View.GONE);
//                        ans10.setVisibility(View.GONE);
//                        next2.setVisibility(View.VISIBLE);
//                        next1.setVisibility(View.GONE);
//                        submit.setVisibility(View.GONE);
//                    }
//                });
//                next2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        q1.setVisibility(View.GONE);
//                        question10.setVisibility(View.VISIBLE);
//                        q2.setVisibility(View.GONE);
//                        q3.setVisibility(View.GONE);
//                        q4.setVisibility(View.GONE);
//                        q5.setVisibility(View.GONE);
//                        q6.setVisibility(View.GONE);
//                        q7.setVisibility(View.GONE);
//                        question8.setVisibility(View.GONE);
//                        question9.setVisibility(View.GONE);
//                        ans10.setVisibility(View.VISIBLE);
//                        ans9.setVisibility(View.GONE);
//                        ans8.setVisibility(View.GONE);
//                        next2.setVisibility(View.GONE);
//                        next1.setVisibility(View.GONE);
//                        submit.setVisibility(View.VISIBLE);
//                    }
//                });
//
//                submit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        answer8 = ans8.getText().toString();
//                        if (answer8.equals(eight.getAnswer())){
//                            correct++;
//
//
//                        }
//                        else{wrong++;
//
//                        }
//
//                        answer9 = ans9.getText().toString();
//                        if (answer9.equals(nine.getAnswer())){correct++;
//                        }
//                        else{wrong++;
//
//
//                        }
//
//                        answer10 = ans10.getText().toString();
//                        if (ans10.getText().toString().equals(ten.getAnswer())){correct++;
////
//                        }
//                        else{wrong++;
//
//                        }
//
//
//                        new AlertDialog.Builder(pquiz1.this)
//                                .setTitle("Done!")
//                                .setMessage("Congratulations for taking the quiz, your score is " + correct)
//                                .setCancelable(false)
//                                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//
//
//
//                                        Intent intent = new Intent(pquiz1.this, prelimLecture.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                })
//                                .show();
//                    }
//                });
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    public void reverseTimer(int seconds, final TextView tv) {
//        new CountDownTimer(seconds * 1000 + 1000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                int seconds = (int) (millisUntilFinished / 1000);
//                int minutes = seconds / 60;
//                seconds = seconds % 60;
//                tv.setText(String.format("%02d", minutes)
//                        + ":" + String.format("%02d", seconds));
//            }
//
//            public void onFinish() {
//                tv.setText("Times Up");
//                a1.setEnabled(false);
//                b1.setEnabled(false);
//                c1.setEnabled(false);
//                d1.setEnabled(false);
//                a2.setEnabled(false);
//                b2.setEnabled(false);
//                c2.setEnabled(false);
//                d2.setEnabled(false);
//                a3.setEnabled(false);
//                b3.setEnabled(false);
//                c3.setEnabled(false);
//                d3.setEnabled(false);
//                a4.setEnabled(false);
//                b4.setEnabled(false);
//                c4.setEnabled(false);
//                d4.setEnabled(false);
//
//                a5.setEnabled(false);
//                b5.setEnabled(false);
//
//                a6.setEnabled(false);
//                b6.setEnabled(false);
//
//                a7.setEnabled(false);
//                b7.setEnabled(false);
//
//                ans8.setEnabled(false);
//                ans9.setEnabled(false);
//                ans10.setEnabled(false);
//
//            }
//        }.start();
//    }


    }
    public void onBackPressed () {
    }
}

//                        Intent i = new Intent(sample.this,result.class);
//                        finish();
//                        i.putExtra("correct",String.valueOf(correct));
//
//                        i.putExtra("q11", one.getQuestion());
//                        i.putExtra("youranswer1", answer1);
//                        i.putExtra("correctanswer1", one.getAnswer());
//
//                        i.putExtra("q22", two.getQuestion());
//                        i.putExtra("youranswer2", answer2);
//                        i.putExtra("correctanswer2", two.getAnswer());
//
//                        i.putExtra("q33", three.getQuestion());
//                        i.putExtra("youranswer3", answer3);
//                        i.putExtra("correctanswer3", three.getAnswer());
//
//                        i.putExtra("q44", four.getQuestion());
//                        i.putExtra("youranswer4", answer4);
//                        i.putExtra("correctanswer4", four.getAnswer());
//
//                        i.putExtra("q55", five.getQuestion());
//                        i.putExtra("youranswer5", answer5);
//                        i.putExtra("correctanswer5",five.getAnswer());
//
//                        i.putExtra("q66", six.getQuestion());
//                        i.putExtra("youranswer6", answer6);
//                        i.putExtra("correctanswer6", six.getAnswer());
//
//                        i.putExtra("q77", seven.getQuestion());
//                        i.putExtra("youranswer7", answer7);
//                        i.putExtra("correctanswer7", seven.getAnswer());
//
//                        i.putExtra("q88", eight.getQuestion());
//                        i.putExtra("youranswer8", answer8);
//                        i.putExtra("correctanswer8", eight.getAnswer());
//
//                        i.putExtra("q99", nine.getQuestion());
//                        i.putExtra("youranswer9", answer9);
//                        i.putExtra("correctanswer9", nine.getAnswer());
//
//                        i.putExtra("q100", ten.getQuestion());
//                        i.putExtra("youranswer10", answer10);
//                        i.putExtra("correctanswer10", ten.getAnswer());
//
//                        startActivity(i);
//                        finish();

//                                        EditText sample = findViewById(R.id.sample);
////                                        sample.setEnabled(false);
////                                        sasmple = correct;
////                                        sample.getText().toString();
//                                        SharedPreferences sharedPreferences = pquiz1.this.getPreferences(Context.MODE_PRIVATE);
//                                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                                        editor.putLong("timedate", datetime);
//                                        editor.putInt("score",correct);
//                                        editor.commit();
//
//
//                                        int mm = correct;


//quiz