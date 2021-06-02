package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assessment extends AppCompatActivity {
    SharedPreferences sh1, sh2, sh3, sh4, sh5;
    List<String> xAxisValues;
    String[] xAxisstr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        // Retrieving the values using shared pref from the quizzes class
        sh1  = getSharedPreferences("P_Q1SharedPref", MODE_PRIVATE);
        String pquiz1_date = sh1.getString("pq1_date", "");

        sh2 = getSharedPreferences("P_Q2SharedPref", MODE_PRIVATE);
        String pquiz2_date = sh2.getString("pq2_date", "");

        sh3 = getSharedPreferences("P_Q3SharedPref", MODE_PRIVATE);
        String pquiz3_date = sh3.getString("pq3_date", "");

        sh4 = getSharedPreferences("P_Q4SharedPref", MODE_PRIVATE);
        String pquiz4_date = sh4.getString("pq4_date", "");

        sh5 = getSharedPreferences("P_Q5SharedPref", MODE_PRIVATE);
        String pquiz5_date = sh5.getString("pq5_date", "");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        //putting string values in chart
        xAxisValues = new ArrayList<>(Arrays.
                asList(
                       pquiz1_date,
                       pquiz2_date,
                       pquiz3_date,
                       pquiz4_date,
                       pquiz5_date
                )
        );

        xAxisstr = new String[]{pquiz1_date,pquiz2_date,pquiz3_date,pquiz4_date,pquiz5_date};

        Log.i("DateList"," "+ xAxisValues );
        List<Entry> scoreEntries = getScoreEntries();

        dataSets = new ArrayList<>();
        LineDataSet set1;

        set1 = new LineDataSet(scoreEntries, "Score");
        set1.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set1.setValueTextColor(Color.rgb(55, 70, 73));
        set1.setValueTextSize(8f);
        set1.setMode(LineDataSet.Mode.LINEAR);
        dataSets.add(set1);

        //customization
        LineChart mLineGraph = findViewById (R.id.linechart);
        mLineGraph.setTouchEnabled(false);
        mLineGraph.setDragEnabled(false);
        mLineGraph.setScaleEnabled(false);
        mLineGraph.setPinchZoom(false);
        mLineGraph.setDrawGridBackground(true);
        mLineGraph.getAxisRight().setEnabled(false);

        set1.setLineWidth(3f);
        set1.setCircleRadius(4f);
        set1.setDrawCircleHole(true);
        set1.setCircleHoleRadius(2f);
        set1.setCircleHoleColor(Color.WHITE);
        set1.setDrawValues(true);
        set1.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisValues));
        XAxis xAxis = mLineGraph.getXAxis();

        xAxis.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", xAxisValues.size()+"");
        xAxis.setLabelCount(xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets);
        mLineGraph.setData(data);
        mLineGraph.animateX(2000);
        mLineGraph.invalidate();
        mLineGraph.getDescription().setEnabled(false);

        mLineGraph.getLegend().setEnabled(false);

    }

    private List<Entry> getScoreEntries() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pquiz1_score = sh1.getInt("pq1_score", 0);
        int pquiz2_score = sh2.getInt("pq2_score", 0);
        int pquiz3_score = sh3.getInt("pq3_score", 0);
        int pquiz4_score = sh4.getInt("pq4_score", 0);
        int pquiz5_score = sh5.getInt("pq5_score", 0);

        Log.i("scores", pquiz1_score +" "+ pquiz2_score +" "+ pquiz3_score +" "+ pquiz4_score+" "+pquiz5_score);

        scoreEntries.add(new Entry(0, pquiz1_score));
        scoreEntries.add(new Entry(1, pquiz2_score));
        scoreEntries.add(new Entry(2, pquiz3_score));
        scoreEntries.add(new Entry(3, pquiz4_score));
        scoreEntries.add(new Entry(4, pquiz5_score));


        return scoreEntries.subList(0, 5);
    }
}

