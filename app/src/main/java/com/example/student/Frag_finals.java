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


public class Frag_finals extends Fragment {

    SharedPreferences sh1, sh2, sh3, sh4, sh5;
    List<String> xAxisValues;
    String[] xAxisstr;

    public Frag_finals() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Retrieving the values using shared pref from the quizzes class
        sh1  = this.getActivity().getSharedPreferences("F_Q13SharedPref", MODE_PRIVATE);
        String pquiz1_date = sh1.getString("fq13_date", "");

        sh2 = this.getActivity().getSharedPreferences("F_Q14SharedPref", MODE_PRIVATE);
        String pquiz2_date = sh2.getString("fq14_date", "");

        sh3 = this.getActivity().getSharedPreferences("F_Q15SharedPref", MODE_PRIVATE);
        String pquiz3_date = sh3.getString("fq15_date", "");

        sh4 = this.getActivity().getSharedPreferences("F_Q16SharedPref", MODE_PRIVATE);
        String pquiz4_date = sh4.getString("fq16_date", "");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        //putting string values in chart
        xAxisValues = new ArrayList<>(Arrays.
                asList(
                        pquiz1_date,
                        pquiz2_date,
                        pquiz3_date,
                        pquiz4_date
                )
        );

        xAxisstr = new String[]{pquiz1_date,pquiz2_date,pquiz3_date,pquiz4_date};

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

        View view = inflater.inflate(R.layout.fragment_finals, container, false);

//customization
        LineChart mLineGraph =  view.findViewById (R.id.f_linechart);
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

        int pquiz1_score = sh1.getInt("fq13_score", 0);
        int pquiz2_score = sh2.getInt("fq14_score", 0);
        int pquiz3_score = sh3.getInt("fq15_score", 0);
        int pquiz4_score = sh4.getInt("fq16_score", 0);

        Log.i("scores", pquiz1_score + " " + pquiz2_score + " " + pquiz3_score + " " + pquiz4_score );

        scoreEntries.add(new Entry(0, pquiz1_score));
        scoreEntries.add(new Entry(1, pquiz2_score));
        scoreEntries.add(new Entry(2, pquiz3_score));
        scoreEntries.add(new Entry(3, pquiz4_score));

        return scoreEntries.subList(0, 4);
    }
}