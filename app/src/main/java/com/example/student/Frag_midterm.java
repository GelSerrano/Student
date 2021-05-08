package com.example.student;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Frag_midterm extends Fragment {

    SharedPreferences sh1, sh2, sh3, sh4, sh5;
    List<String> xAxisValues;
    String[] xAxisstr;

    public Frag_midterm() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the values using shared pref from the quizzes class
        sh1  = this.getActivity().getSharedPreferences("M_Q7SharedPref", MODE_PRIVATE);
        String pquiz1_date = sh1.getString("mq7_date", "");

        sh2 = this.getActivity().getSharedPreferences("M_Q8SharedPref", MODE_PRIVATE);
        String pquiz2_date = sh2.getString("mq8_date", "");

        sh3 = this.getActivity().getSharedPreferences("M_Q9SharedPref", MODE_PRIVATE);
        String pquiz3_date = sh3.getString("mq9_date", "");

        sh4 = this.getActivity().getSharedPreferences("M_Q10SharedPref", MODE_PRIVATE);
        String pquiz4_date = sh4.getString("mq10_date", "");

        sh5 = this.getActivity().getSharedPreferences("M_Q11SharedPref", MODE_PRIVATE);
        String pquiz5_date = sh5.getString("mq11_date", "");

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
        set1.setColor(Color.rgb(80, 80, 171),100); //line color
        set1.setValueTextColor(Color.rgb(55, 70, 73));
        set1.setValueTextSize(8f);
        set1.setMode(LineDataSet.Mode.LINEAR);
        dataSets.add(set1);

        View view = inflater.inflate(R.layout.fragment_midterm, container, false);

//customization
        LineChart mLineGraph =  view.findViewById (R.id.m_linechart);
        mLineGraph.setTouchEnabled(false);
        mLineGraph.setDragEnabled(false);
        mLineGraph.setScaleEnabled(false);
        mLineGraph.setPinchZoom(false);
        mLineGraph.setDrawGridBackground(true);
        mLineGraph.getAxisRight().setEnabled(false);

        set1.setLineWidth(3f);
        set1.setCircleRadius(6f);
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

        return view;
    }

    private List<Entry> getScoreEntries() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pquiz1_score = sh1.getInt("mq7_score", 0);
        int pquiz2_score = sh2.getInt("mq8_score", 0);
        int pquiz3_score = sh3.getInt("mq9_score", 0);
        int pquiz4_score = sh4.getInt("mq10_score", 0);
        int pquiz5_score = sh5.getInt("mq11_score", 0);

        Log.i("scores", pquiz1_score +" "+ pquiz2_score +" "+ pquiz3_score +" "+ pquiz4_score+" "+pquiz5_score);

        scoreEntries.add(new Entry(0, pquiz1_score));
        scoreEntries.add(new Entry(1, pquiz2_score));
        scoreEntries.add(new Entry(2, pquiz3_score));
        scoreEntries.add(new Entry(3, pquiz4_score));
        scoreEntries.add(new Entry(4, pquiz5_score));

        return scoreEntries.subList(0, 5);
    }
}