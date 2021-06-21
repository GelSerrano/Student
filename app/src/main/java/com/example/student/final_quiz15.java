package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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

public class final_quiz15 extends AppCompatActivity {

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
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz15);

        correct = 0;
        // Storing data into SharedPreferences
        sharedPreferences = getSharedPreferences("F_Q15SharedPref",MODE_PRIVATE);
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

        databaseReference = FirebaseDatabase.getInstance().getReference().child("lesson15");
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


                final Question one = dataSnapshot.child("FinalsMultipleChoice").child(number.get(0)).getValue(Question.class);
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

                final Question two = dataSnapshot.child("FinalsMultipleChoice").child(number.get(1)).getValue(Question.class);
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
                final Question three = dataSnapshot.child("FinalsMultipleChoice").child(number.get(2)).getValue(Question.class);
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
                final Question four = dataSnapshot.child("FinalsMultipleChoice").child(number.get(3)).getValue(Question.class);
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
                final Question five = dataSnapshot.child("FinalsTrueOrFalse").child(tf.get(0)).getValue(Question.class);
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
                final Question six = dataSnapshot.child("FinalsTrueOrFalse").child(tf.get(1)).getValue(Question.class);
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
                final Question seven = dataSnapshot.child("FinalsTrueOrFalse").child(tf.get(2)).getValue(Question.class);
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
                final Question eight = dataSnapshot.child("FinalsIdentification").child(ident.get(0)).getValue(Question.class);
                question8.setText(eight.getQuestion());

                //Question9
                final Question nine = dataSnapshot.child("FinalsIdentification").child(ident.get(1)).getValue(Question.class);
                question9.setText(nine.getQuestion());

                //Question10
                final Question ten = dataSnapshot.child("FinalsIdentification").child(ident.get(2)).getValue(Question.class);
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

                        //storing history stuff
                        String fq15_h1_pref = sharedPreferences.getString("fq15_h1_date", null);
                        if(fq15_h1_pref == null) {
                            myEdit.putString("fq15_h1_date",currdate);
                            myEdit.putInt("fq15_h1_score", correct);
                            myEdit.commit();

                            myEdit.putString("test","test");
                            Log.i("SP_", "fq15_h1 processed");

                        } else {
                            String fq15_h2_pref = sharedPreferences.getString("fq15_h2_date", null);
                            if (fq15_h2_pref == null) {
                                myEdit.putString("fq15_h2_date", currdate);
                                myEdit.putInt("fq15_h2_score", correct);
                                myEdit.commit();
                                Log.i("SP_", "fq15_h2 processed");
                            } else {
                                String fq15_h3_pref = sharedPreferences.getString("fq15_h3_date", null);
                                if (fq15_h3_pref == null) {
                                    myEdit.putString("fq15_h3_date", currdate);
                                    myEdit.putInt("fq15_h3_score", correct);
                                    myEdit.commit();
                                    Log.i("SP_", "fq15_h3 processed");
                                } else {

                                    String fq15_h4_pref = sharedPreferences.getString("fq15_h4_date", null);
                                    if (fq15_h4_pref == null) {
                                        myEdit.putString("fq15_h4_date", currdate);
                                        myEdit.putInt("fq15_h4_score", correct);
                                        myEdit.commit();
                                        Log.i("SP_", "fq15_h4 processed");
                                    } else {
                                        String fq15_h5_pref = sharedPreferences.getString("fq15_h5_date", null);
                                        if (fq15_h5_pref == null) {
                                            myEdit.putString("fq15_h5_date", currdate);
                                            myEdit.putInt("fq15_h5_score", correct);
                                            myEdit.commit();
                                            Log.i("SP_", "fq15_h5 processed");
                                        } else{
                                            String fq15_h6_pref = sharedPreferences.getString("fq15_h6_date", null);
                                            if (fq15_h6_pref == null) {
                                                myEdit.putString("fq15_h6_date", currdate);
                                                myEdit.putInt("fq15_h6_score", correct);
                                                myEdit.commit();
                                                Log.i("SP_", "fq15_h6 processed");
                                            }else{
                                                String fq15_h7_pref = sharedPreferences.getString("fq15_h7_date", null);
                                                if (fq15_h7_pref == null) {
                                                    myEdit.putString("fq15_h7_date", currdate);
                                                    myEdit.putInt("fq15_h7_score", correct);
                                                    myEdit.commit();
                                                    Log.i("SP_", "fq15_h7 processed");
                                                }else{
                                                    String fq15_h8_pref = sharedPreferences.getString("fq15_h8_date", null);
                                                    if (fq15_h8_pref == null) {
                                                        myEdit.putString("fq15_h8_date", currdate);
                                                        myEdit.putInt("fq15_h8_score", correct);
                                                        myEdit.commit();
                                                        Log.i("SP_", "fq15_h8 processed");
                                                    }else{
                                                        String fq15_h9_pref = sharedPreferences.getString("fq15_h9_date", null);
                                                        if (fq15_h9_pref == null) {
                                                            myEdit.putString("fq15_h9_date", currdate);
                                                            myEdit.putInt("fq15_h9_score", correct);
                                                            myEdit.commit();
                                                            Log.i("SP_", "fq15_h9 processed");
                                                        }else{
                                                            String fq15_h10_pref = sharedPreferences.getString("fq15_h10_date", null);
                                                            if (fq15_h10_pref == null) {
                                                                myEdit.putString("fq15_h10_date", currdate);
                                                                myEdit.putInt("fq15_h10_score", correct);
                                                                myEdit.commit();
                                                                Log.i("SP_", "fq15_h10 processed");
                                                            }else{
                                                                Log.i("SP_","history is full");

                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("fq15_h1_date",  sharedPreferences.getString("fq15_h2_date", ""));
                                                                myEdit.putInt("fq15_h1_score", sharedPreferences.getInt("fq15_h2_score", 0));

                                                                myEdit.putString("fq15_h2_date",  sharedPreferences.getString("fq15_h3_date", ""));
                                                                myEdit.putInt("fq15_h2_score", sharedPreferences.getInt("fq15_h3_score", 0));

                                                                myEdit.putString("fq15_h3_date",  sharedPreferences.getString("fq15_h4_date", ""));
                                                                myEdit.putInt("fq15_h3_score", sharedPreferences.getInt("fq15_h4_score", 0));

                                                                myEdit.putString("fq15_h4_date",  sharedPreferences.getString("fq15_h5_date", ""));
                                                                myEdit.putInt("fq15_h4_score", sharedPreferences.getInt("fq15_h5_score", 0));

                                                                myEdit.putString("fq15_h5_date",  sharedPreferences.getString("fq15_h6_date", ""));
                                                                myEdit.putInt("fq15_h5_score", sharedPreferences.getInt("fq15_h6_score", 0));

                                                                myEdit.putString("fq15_h6_date",  sharedPreferences.getString("fq15_h7_date", ""));
                                                                myEdit.putInt("fq15_h6_score", sharedPreferences.getInt("fq15_h7_score", 0));

                                                                myEdit.putString("fq15_h7_date",  sharedPreferences.getString("fq15_h8_date", ""));
                                                                myEdit.putInt("fq15_h7_score", sharedPreferences.getInt("fq15_h8_score", 0));

                                                                myEdit.putString("fq15_h8_date",  sharedPreferences.getString("fq15_h9_date", ""));
                                                                myEdit.putInt("fq15_h8_score", sharedPreferences.getInt("fq15_h9_score", 0));

                                                                myEdit.putString("fq15_h9_date",  sharedPreferences.getString("fq15_h10_date", ""));
                                                                myEdit.putInt("fq15_h9_score", sharedPreferences.getInt("fq15_h10_score", 0));
                                                                //adjusts entries 2 to 1, 3 to 2 and so on
                                                                myEdit.putString("fq15_h10_date", currdate);
                                                                myEdit.putInt("fq15_h10_score", correct);
                                                                myEdit.commit();

                                                            }
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //end of storing history stuff

                        sharedPreferences  = getSharedPreferences("F_Q15SharedPref", MODE_PRIVATE);
                        int q15_h1_s = sharedPreferences.getInt("fq15_h1_score", 0);
                        String q15_h1_d = sharedPreferences.getString("fq15_h1_date", "");
                        int q15_h2_s = sharedPreferences.getInt("fq15_h2_score", 0);
                        String q15_h2_d = sharedPreferences.getString("fq15_h2_date", "");
                        int q15_h3_s = sharedPreferences.getInt("fq15_h3_score", 0);
                        String q15_h3_d = sharedPreferences.getString("fq15_h3_date", "");
                        int q15_h4_s = sharedPreferences.getInt("fq15_h4_score", 0);
                        String q15_h4_d = sharedPreferences.getString("fq15_h4_date", "");
                        int q15_h5_s = sharedPreferences.getInt("fq15_h5_score", 0);
                        String q15_h5_d = sharedPreferences.getString("fq15_h5_date", "");
                        int q15_h6_s = sharedPreferences.getInt("fq15_h6_score", 0);
                        String q15_h6_d = sharedPreferences.getString("fq15_h6_date", "");
                        int q15_h7_s = sharedPreferences.getInt("fq15_h7_score", 0);
                        String q15_h7_d = sharedPreferences.getString("fq15_h7_date", "");
                        int q15_h8_s = sharedPreferences.getInt("fq15_h8_score", 0);
                        String q15_h8_d = sharedPreferences.getString("fq15_h8_date", "");
                        int q15_h9_s = sharedPreferences.getInt("fq15_h9_score", 0);
                        String q15_h9_d = sharedPreferences.getString("fq15_h9_date", "");
                        int q15_h10_s = sharedPreferences.getInt("fq15_h10_score", 0);
                        String q15_h10_d = sharedPreferences.getString("fq15_h10_date", "");
                        Log.i("SP_content", "" );
                        Log.i("SP_content", "h1: "+ q15_h1_d +" "+ q15_h1_s );
                        Log.i("SP_content", "h2: "+ q15_h2_d +" "+ q15_h2_s );
                        Log.i("SP_content", "h3: "+ q15_h3_d +" "+ q15_h3_s );
                        Log.i("SP_content", "h4: "+ q15_h4_d +" "+ q15_h4_s );
                        Log.i("SP_content", "h5: "+ q15_h5_d +" "+ q15_h5_s );
                        Log.i("SP_content", "h6: "+ q15_h6_d +" "+ q15_h6_s );
                        Log.i("SP_content", "h7: "+ q15_h7_d +" "+ q15_h7_s );
                        Log.i("SP_content", "h8: "+ q15_h8_d +" "+ q15_h8_s );
                        Log.i("SP_content", "h9: "+ q15_h9_d +" "+ q15_h9_s );
                        Log.i("SP_content", "h10: "+ q15_h10_d +" "+ q15_h10_s );
                        AlertDialog dialog = new AlertDialog.Builder(final_quiz15.this)

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

                                AlertDialog dialog1 = new AlertDialog.Builder(final_quiz15.this)
                                        .setTitle("Score")
                                        .setMessage("Your score was: \t" + correct)
                                        .setPositiveButton("OK", null)
                                        .show();
                                final Button positiveButton = dialog1.getButton(AlertDialog.BUTTON_POSITIVE);
                                positiveButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(final_quiz15.this, lecture_finals.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
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



    }
    public void onBackPressed () {
    }
}
