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
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Frag_prelim extends Fragment {

    SharedPreferences shq1, shq2, shq3, shq4, shq5;
    List<String> pq1xAxisValues, pq2xAxisValues, pq3xAxisValues, pq4xAxisValues, pq5xAxisValues;
    String[] pq1xAxisstr,  pq2xAxisstr, pq3xAxisstr, pq4xAxisstr, pq5xAxisstr;
    ValueFormatter vf;

    public Frag_prelim() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Retrieving the values using shared pref from the quizzes class
        shq1  = this.getActivity().getSharedPreferences("P_Q1SharedPref", MODE_PRIVATE);

        String pquiz1_date1 = shq1.getString("pq1_h1_date", "");
        String pquiz1_date2 = shq1.getString("pq1_h2_date", "");
        String pquiz1_date3 = shq1.getString("pq1_h3_date", "");
        String pquiz1_date4 = shq1.getString("pq1_h4_date", "");
        String pquiz1_date5 = shq1.getString("pq1_h5_date", "");
        String pquiz1_date6 = shq1.getString("pq1_h6_date", "");
        String pquiz1_date7 = shq1.getString("pq1_h7_date", "");
        String pquiz1_date8 = shq1.getString("pq1_h8_date", "");
        String pquiz1_date9 = shq1.getString("pq1_h9_date", "");
        String pquiz1_date10 = shq1.getString("pq1_h10_date", "");

        ArrayList<ILineDataSet> dataSets1 = new ArrayList<>();

        pq1xAxisValues = new ArrayList<>(Arrays.asList(
                        pquiz1_date1,pquiz1_date2,pquiz1_date3,pquiz1_date4,pquiz1_date5,pquiz1_date6,pquiz1_date7,pquiz1_date8,pquiz1_date9,pquiz1_date10
                )
        );

        pq1xAxisstr = new String[]{pquiz1_date1,pquiz1_date2,pquiz1_date3,pquiz1_date4,pquiz1_date5,pquiz1_date6,pquiz1_date7,pquiz1_date8,pquiz1_date9,pquiz1_date10};

        //    xAxisstr = new String[]{pquiz1_date,pquiz2_date,pquiz3_date,pquiz4_date,pquiz5_date};

        Log.i("pq1xaxis"," "+ pq1xAxisValues);

        List<Entry> PQ1scoreEntries = getScoreEntriesPQ1();

        dataSets1 = new ArrayList<>();
        LineDataSet set1;

        set1 = new LineDataSet(PQ1scoreEntries, "Score");
        set1.setColor(getResources().getColor(R.color.pie_color_4)); //line color
        set1.setValueTextColor(Color.rgb(55, 70, 73));
        set1.setMode(LineDataSet.Mode.LINEAR);
        dataSets1.add(set1);

        View view = inflater.inflate(R.layout.fragment_prelim, container, false);

        //customization
        LineChart mLineGraph1 =  view.findViewById (R.id.linechart);
        mLineGraph1.setTouchEnabled(false);
        mLineGraph1.setDragEnabled(false);
        mLineGraph1.setScaleEnabled(false);
        mLineGraph1.setPinchZoom(false);
        mLineGraph1.setDrawGridBackground(true);
        mLineGraph1.getAxisRight().setEnabled(false);

        set1.setLineWidth(3f);
        set1.setCircleRadius(4f);
        set1.setDrawCircleHole(true);
        set1.setCircleHoleRadius(2f);
        set1.setCircleHoleColor(Color.WHITE);
        set1.setDrawValues(true);
        set1.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph1.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq1xAxisValues));
        XAxis xAxis = mLineGraph1.getXAxis();

        xAxis.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", pq1xAxisValues.size()+"");
        xAxis.setLabelCount(pq1xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets1);
        mLineGraph1.setData(data);
        mLineGraph1.animateX(2000);
        mLineGraph1.invalidate();
        mLineGraph1.getDescription().setEnabled(false);
        mLineGraph1.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph1.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ1scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph1.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set1.setValueTextSize(11f);
        //end for whole number formatting

        makePQ2_Graph(view);
        makePQ3_Graph(view);
        makePQ4_Graph(view);
        makePQ5_Graph(view);
        return view;
    }

    private void makePQ2_Graph(View view){
        shq2  = this.getActivity().getSharedPreferences("P_Q2SharedPref", MODE_PRIVATE);
        String pquiz2_date1 = shq2.getString("pq2_h1_date", "");
        String pquiz2_date2 = shq2.getString("pq2_h2_date", "");
        String pquiz2_date3 = shq2.getString("pq2_h3_date", "");
        String pquiz2_date4 = shq2.getString("pq2_h4_date", "");
        String pquiz2_date5 = shq2.getString("pq2_h5_date", "");
        String pquiz2_date6 = shq2.getString("pq2_h6_date", "");
        String pquiz2_date7 = shq2.getString("pq2_h7_date", "");
        String pquiz2_date8 = shq2.getString("pq2_h8_date", "");
        String pquiz2_date9 = shq2.getString("pq2_h9_date", "");
        String pquiz2_date10 = shq2.getString("pq2_h10_date", "");

        pq2xAxisValues = new ArrayList<>(Arrays.asList(
                pquiz2_date1,pquiz2_date2,pquiz2_date3,pquiz2_date4,pquiz2_date5,pquiz2_date6,pquiz2_date7,pquiz2_date8,pquiz2_date9,pquiz2_date10
        )
        );

        pq2xAxisstr = new String[]{pquiz2_date1,pquiz2_date2,pquiz2_date3,pquiz2_date4,pquiz2_date5,pquiz2_date6,pquiz2_date7,pquiz2_date8,pquiz2_date9,pquiz2_date10};
        Log.i("pq2xaxis"," "+pq2xAxisValues);

        ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();

        List<Entry> PQ2scoreEntries = getScoreEntriesPQ2();
        dataSets2 = new ArrayList<>();

        LineDataSet set2;
        set2 = new LineDataSet(PQ2scoreEntries, "Score");
        set2.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set2.setValueTextColor(Color.rgb(55, 70, 73));
        set2.setMode(LineDataSet.Mode.LINEAR);
        dataSets2.add(set2);

        LineChart mLineGraph2 =  view.findViewById (R.id.linechart2);
        mLineGraph2.setTouchEnabled(false);
        mLineGraph2.setDragEnabled(false);
        mLineGraph2.setScaleEnabled(false);
        mLineGraph2.setPinchZoom(false);
        mLineGraph2.setDrawGridBackground(true);
        mLineGraph2.getAxisRight().setEnabled(false);
        set2.setLineWidth(3f);
        set2.setCircleRadius(4f);
        set2.setDrawCircleHole(true);
        set2.setCircleHoleRadius(2f);
        set2.setCircleHoleColor(Color.WHITE);
        set2.setDrawValues(true);
        set2.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph2.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq2xAxisValues));
        XAxis xAxis = mLineGraph2.getXAxis();

        Log.i("xAxistStrlen", pq2xAxisValues.size()+"");
        xAxis.setLabelCount(pq2xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets2);
        mLineGraph2.setData(data);
        mLineGraph2.animateX(2000);
        mLineGraph2.invalidate();
        mLineGraph2.getDescription().setEnabled(false);
        mLineGraph2.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph2.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ2scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph2.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set2.setValueTextSize(11f);
        //end for whole number formatting

         mLineGraph2.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq2xAxisValues));
        XAxis xAxis2 = mLineGraph2.getXAxis();

        xAxis2.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", pq2xAxisValues.size()+"");
        xAxis2.setLabelCount(pq2xAxisstr.length,true);
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data2 = new LineData(dataSets2);
        mLineGraph2.setData(data);
        mLineGraph2.animateX(2000);
        mLineGraph2.invalidate();
        mLineGraph2.getDescription().setEnabled(false);
        mLineGraph2.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph2.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ2scoreEntries.size());// figure out the max value in your dataset
        mLineGraph2.getAxisLeft().setLabelCount(PQ2scoreEntries.size());
        data2.setValueFormatter(vf);
        set2.setValueTextSize(11f);
        //end for whole number formatting

    }


    private void makePQ3_Graph(View view){
        shq3  = this.getActivity().getSharedPreferences("P_Q3SharedPref", MODE_PRIVATE);
        String pquiz3_date1 = shq3.getString("pq3_h1_date", "");
        String pquiz3_date2 = shq3.getString("pq3_h2_date", "");
        String pquiz3_date3 = shq3.getString("pq3_h3_date", "");
        String pquiz3_date4 = shq3.getString("pq3_h4_date", "");
        String pquiz3_date5 = shq3.getString("pq3_h5_date", "");
        String pquiz3_date6 = shq3.getString("pq3_h6_date", "");
        String pquiz3_date7 = shq3.getString("pq3_h7_date", "");
        String pquiz3_date8 = shq3.getString("pq3_h8_date", "");
        String pquiz3_date9 = shq3.getString("pq3_h9_date", "");
        String pquiz3_date10 = shq3.getString("pq3_h10_date", "");

        pq3xAxisValues = new ArrayList<>(Arrays.asList(
                pquiz3_date1,pquiz3_date2,pquiz3_date3,pquiz3_date4,pquiz3_date5,pquiz3_date6,pquiz3_date7,pquiz3_date8,pquiz3_date9,pquiz3_date10
        )
        );

        pq3xAxisstr = new String[]{pquiz3_date1,pquiz3_date2,pquiz3_date3,pquiz3_date4,pquiz3_date5,pquiz3_date6,pquiz3_date7,pquiz3_date8,pquiz3_date9,pquiz3_date10};
        Log.i("pq3xaxis"," "+pq3xAxisValues);

        ArrayList<ILineDataSet> dataSets3 = new ArrayList<>();

        List<Entry> PQ3scoreEntries = getScoreEntriesPQ3();
        dataSets3 = new ArrayList<>();

        LineDataSet set3;
        set3 = new LineDataSet(PQ3scoreEntries, "Score");
        set3.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set3.setValueTextColor(Color.rgb(55, 70, 73));
        set3.setMode(LineDataSet.Mode.LINEAR);
        dataSets3.add(set3);

        LineChart mLineGraph3 =  view.findViewById (R.id.linechart3);
        mLineGraph3.setTouchEnabled(false);
        mLineGraph3.setDragEnabled(false);
        mLineGraph3.setScaleEnabled(false);
        mLineGraph3.setPinchZoom(false);
        mLineGraph3.setDrawGridBackground(true);
        mLineGraph3.getAxisRight().setEnabled(false);
        set3.setLineWidth(3f);
        set3.setCircleRadius(4f);
        set3.setDrawCircleHole(true);
        set3.setCircleHoleRadius(2f);
        set3.setCircleHoleColor(Color.WHITE);
        set3.setDrawValues(true);
        set3.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph3.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq3xAxisValues));
        XAxis xAxis = mLineGraph3.getXAxis();

        Log.i("xAxistStrlen", pq3xAxisValues.size()+"");
        xAxis.setLabelCount(pq3xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets3);
        mLineGraph3.setData(data);
        mLineGraph3.animateX(2000);
        mLineGraph3.invalidate();
        mLineGraph3.getDescription().setEnabled(false);
        mLineGraph3.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph3.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ3scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph3.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set3.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph3.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq3xAxisValues));
        XAxis xAxis3 = mLineGraph3.getXAxis();

        xAxis3.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", pq3xAxisValues.size()+"");
        xAxis3.setLabelCount(pq3xAxisstr.length,true);
        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data3 = new LineData(dataSets3);
        mLineGraph3.setData(data);
        mLineGraph3.animateX(2000);
        mLineGraph3.invalidate();
        mLineGraph3.getDescription().setEnabled(false);
        mLineGraph3.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph3.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ3scoreEntries.size());// figure out the max value in your dataset
        mLineGraph3.getAxisLeft().setLabelCount(PQ3scoreEntries.size());
        data3.setValueFormatter(vf);
        set3.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makePQ4_Graph(View view){
        shq4  = this.getActivity().getSharedPreferences("P_Q4SharedPref", MODE_PRIVATE);
        String pquiz4_date1 = shq4.getString("pq4_h1_date", "");
        String pquiz4_date2 = shq4.getString("pq4_h2_date", "");
        String pquiz4_date3 = shq4.getString("pq4_h3_date", "");
        String pquiz4_date4 = shq4.getString("pq4_h4_date", "");
        String pquiz4_date5 = shq4.getString("pq4_h5_date", "");
        String pquiz4_date6 = shq4.getString("pq4_h6_date", "");
        String pquiz4_date7 = shq4.getString("pq4_h7_date", "");
        String pquiz4_date8 = shq4.getString("pq4_h8_date", "");
        String pquiz4_date9 = shq4.getString("pq4_h9_date", "");
        String pquiz4_date10 = shq4.getString("pq4_h10_date", "");

        pq4xAxisValues = new ArrayList<>(Arrays.asList(
                pquiz4_date1,pquiz4_date2,pquiz4_date3,pquiz4_date4,pquiz4_date5,pquiz4_date6,pquiz4_date7,pquiz4_date8,pquiz4_date9,pquiz4_date10
        )
        );

        pq4xAxisstr = new String[]{pquiz4_date1,pquiz4_date2,pquiz4_date3,pquiz4_date4,pquiz4_date5,pquiz4_date6,pquiz4_date7,pquiz4_date8,pquiz4_date9,pquiz4_date10};
        Log.i("pq4xaxis"," "+pq4xAxisValues);

        ArrayList<ILineDataSet> dataSets4 = new ArrayList<>();

        List<Entry> PQ4scoreEntries = getScoreEntriesPQ4();
        dataSets4 = new ArrayList<>();

        LineDataSet set4;
        set4 = new LineDataSet(PQ4scoreEntries, "Score");
        set4.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set4.setValueTextColor(Color.rgb(55, 70, 73));
        set4.setMode(LineDataSet.Mode.LINEAR);
        dataSets4.add(set4);

        LineChart mLineGraph4 =  view.findViewById (R.id.linechart4);
        mLineGraph4.setTouchEnabled(false);
        mLineGraph4.setDragEnabled(false);
        mLineGraph4.setScaleEnabled(false);
        mLineGraph4.setPinchZoom(false);
        mLineGraph4.setDrawGridBackground(true);
        mLineGraph4.getAxisRight().setEnabled(false);
        set4.setLineWidth(3f);
        set4.setCircleRadius(4f);
        set4.setDrawCircleHole(true);
        set4.setCircleHoleRadius(2f);
        set4.setCircleHoleColor(Color.WHITE);
        set4.setDrawValues(true);
        set4.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph4.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq4xAxisValues));
        XAxis xAxis = mLineGraph4.getXAxis();

        Log.i("xAxistStrlen", pq4xAxisValues.size()+"");
        xAxis.setLabelCount(pq4xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets4);
        mLineGraph4.setData(data);
        mLineGraph4.animateX(2000);
        mLineGraph4.invalidate();
        mLineGraph4.getDescription().setEnabled(false);
        mLineGraph4.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph4.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ4scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph4.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set4.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph4.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq4xAxisValues));
        XAxis xAxis4 = mLineGraph4.getXAxis();

        xAxis4.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", pq4xAxisValues.size()+"");
        xAxis4.setLabelCount(pq4xAxisstr.length,true);
        xAxis4.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data4 = new LineData(dataSets4);
        mLineGraph4.setData(data);
        mLineGraph4.animateX(2000);
        mLineGraph4.invalidate();
        mLineGraph4.getDescription().setEnabled(false);
        mLineGraph4.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph4.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ4scoreEntries.size());// figure out the max value in your dataset
        mLineGraph4.getAxisLeft().setLabelCount(PQ4scoreEntries.size());
        data4.setValueFormatter(vf);
        set4.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makePQ5_Graph(View view){
        shq5  = this.getActivity().getSharedPreferences("P_Q5SharedPref", MODE_PRIVATE);
        String pquiz5_date1 = shq5.getString("pq5_h1_date", "");
        String pquiz5_date2 = shq5.getString("pq5_h2_date", "");
        String pquiz5_date3 = shq5.getString("pq5_h3_date", "");
        String pquiz5_date4 = shq5.getString("pq5_h4_date", "");
        String pquiz5_date5 = shq5.getString("pq5_h5_date", "");
        String pquiz5_date6 = shq5.getString("pq5_h6_date", "");
        String pquiz5_date7 = shq5.getString("pq5_h7_date", "");
        String pquiz5_date8 = shq5.getString("pq5_h8_date", "");
        String pquiz5_date9 = shq5.getString("pq5_h9_date", "");
        String pquiz5_date10 = shq5.getString("pq5_h10_date", "");

        pq5xAxisValues = new ArrayList<>(Arrays.asList(
                pquiz5_date1,pquiz5_date2,pquiz5_date3,pquiz5_date4,pquiz5_date5,pquiz5_date6,pquiz5_date7,pquiz5_date8,pquiz5_date9,pquiz5_date10
        )
        );

        pq5xAxisstr = new String[]{pquiz5_date1,pquiz5_date2,pquiz5_date3,pquiz5_date4,pquiz5_date5,pquiz5_date6,pquiz5_date7,pquiz5_date8,pquiz5_date9,pquiz5_date10};
        Log.i("pq5xaxis"," "+pq5xAxisValues);

        ArrayList<ILineDataSet> dataSets5 = new ArrayList<>();

        List<Entry> PQ5scoreEntries = getScoreEntriesPQ5();
        dataSets5 = new ArrayList<>();

        LineDataSet set5;
        set5 = new LineDataSet(PQ5scoreEntries, "Score");
        set5.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set5.setValueTextColor(Color.rgb(55, 70, 73));
        set5.setMode(LineDataSet.Mode.LINEAR);
        dataSets5.add(set5);

        LineChart mLineGraph5 =  view.findViewById (R.id.linechart5);
        mLineGraph5.setTouchEnabled(false);
        mLineGraph5.setDragEnabled(false);
        mLineGraph5.setScaleEnabled(false);
        mLineGraph5.setPinchZoom(false);
        mLineGraph5.setDrawGridBackground(true);
        mLineGraph5.getAxisRight().setEnabled(false);
        set5.setLineWidth(3f);
        set5.setCircleRadius(4f);
        set5.setDrawCircleHole(true);
        set5.setCircleHoleRadius(2f);
        set5.setCircleHoleColor(Color.WHITE);
        set5.setDrawValues(true);
        set5.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph5.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq5xAxisValues));
        XAxis xAxis = mLineGraph5.getXAxis();

        Log.i("xAxistStrlen", pq5xAxisValues.size()+"");
        xAxis.setLabelCount(pq5xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets5);
        mLineGraph5.setData(data);
        mLineGraph5.animateX(2000);
        mLineGraph5.invalidate();
        mLineGraph5.getDescription().setEnabled(false);
        mLineGraph5.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph5.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ5scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph5.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set5.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph5.getXAxis().setValueFormatter(new IndexAxisValueFormatter(pq5xAxisValues));
        XAxis xAxis5 = mLineGraph5.getXAxis();

        xAxis5.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", pq5xAxisValues.size()+"");
        xAxis5.setLabelCount(pq5xAxisstr.length,true);
        xAxis5.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data5 = new LineData(dataSets5);
        mLineGraph5.setData(data);
        mLineGraph5.animateX(2000);
        mLineGraph5.invalidate();
        mLineGraph5.getDescription().setEnabled(false);
        mLineGraph5.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph5.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ5scoreEntries.size());// figure out the max value in your dataset
        mLineGraph5.getAxisLeft().setLabelCount(PQ5scoreEntries.size());
        data5.setValueFormatter(vf);
        set5.setValueTextSize(11f);
        //end for whole number formatting

    }

    private List<Entry> getScoreEntriesPQ1() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pq1h1_score = shq1.getInt("pq1_h1_score", 0);
        int pq1h2_score = shq1.getInt("pq1_h2_score", 0);
        int pq1h3_score = shq1.getInt("pq1_h3_score", 0);
        int pq1h4_score = shq1.getInt("pq1_h4_score", 0);
        int pq1h5_score = shq1.getInt("pq1_h5_score", 0);
        int pq1h6_score = shq1.getInt("pq1_h6_score", 0);
        int pq1h7_score = shq1.getInt("pq1_h7_score", 0);
        int pq1h8_score = shq1.getInt("pq1_h8_score", 0);
        int pq1h9_score = shq1.getInt("pq1_h9_score", 0);
        int pq1h10_score = shq1.getInt("pq1_h10_score", 0);

//        int pquiz2_score = sh2.getInt("pq2_score", 0);
//        int pquiz3_score = sh3.getInt("pq3_score", 0);
//        int pquiz4_score = sh4.getInt("pq4_score", 0);
//        int pquiz5_score = sh5.getInt("pq5_score", 0);

       // Log.i("scores", pquiz1_score +" "+ pquiz2_score +" "+ pquiz3_score +" "+ pquiz4_score+" "+pquiz5_score);

        scoreEntries.add(new Entry(0, pq1h1_score));
        scoreEntries.add(new Entry(1, pq1h2_score));
        scoreEntries.add(new Entry(2, pq1h3_score));
        scoreEntries.add(new Entry(3, pq1h4_score));
        scoreEntries.add(new Entry(4, pq1h5_score));
        scoreEntries.add(new Entry(5, pq1h6_score));
        scoreEntries.add(new Entry(6, pq1h7_score));
        scoreEntries.add(new Entry(7, pq1h8_score));
        scoreEntries.add(new Entry(8, pq1h9_score));
        scoreEntries.add(new Entry(9, pq1h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());

        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ2() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pq2h1_score = shq2.getInt("pq2_h1_score", 0);
        int pq2h2_score = shq2.getInt("pq2_h2_score", 0);
        int pq2h3_score = shq2.getInt("pq2_h3_score", 0);
        int pq2h4_score = shq2.getInt("pq2_h4_score", 0);
        int pq2h5_score = shq2.getInt("pq2_h5_score", 0);
        int pq2h6_score = shq2.getInt("pq2_h6_score", 0);
        int pq2h7_score = shq2.getInt("pq2_h7_score", 0);
        int pq2h8_score = shq2.getInt("pq2_h8_score", 0);
        int pq2h9_score = shq2.getInt("pq2_h9_score", 0);
        int pq2h10_score = shq2.getInt("pq2_h10_score", 0);

        scoreEntries.add(new Entry(0, pq2h1_score));
        scoreEntries.add(new Entry(1, pq2h2_score));
        scoreEntries.add(new Entry(2, pq2h3_score));
        scoreEntries.add(new Entry(3, pq2h4_score));
        scoreEntries.add(new Entry(4, pq2h5_score));
        scoreEntries.add(new Entry(5, pq2h6_score));
        scoreEntries.add(new Entry(6, pq2h7_score));
        scoreEntries.add(new Entry(7, pq2h8_score));
        scoreEntries.add(new Entry(8, pq2h9_score));
        scoreEntries.add(new Entry(9, pq2h10_score));

        Log.i("ScoreEntries2","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval2", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ3() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pq3h1_score = shq3.getInt("pq3_h1_score", 0);
        int pq3h2_score = shq3.getInt("pq3_h2_score", 0);
        int pq3h3_score = shq3.getInt("pq3_h3_score", 0);
        int pq3h4_score = shq3.getInt("pq3_h4_score", 0);
        int pq3h5_score = shq3.getInt("pq3_h5_score", 0);
        int pq3h6_score = shq3.getInt("pq3_h6_score", 0);
        int pq3h7_score = shq3.getInt("pq3_h7_score", 0);
        int pq3h8_score = shq3.getInt("pq3_h8_score", 0);
        int pq3h9_score = shq3.getInt("pq3_h9_score", 0);
        int pq3h10_score = shq3.getInt("pq3_h10_score", 0);

        scoreEntries.add(new Entry(0, pq3h1_score));
        scoreEntries.add(new Entry(1, pq3h2_score));
        scoreEntries.add(new Entry(2, pq3h3_score));
        scoreEntries.add(new Entry(3, pq3h4_score));
        scoreEntries.add(new Entry(4, pq3h5_score));
        scoreEntries.add(new Entry(5, pq3h6_score));
        scoreEntries.add(new Entry(6, pq3h7_score));
        scoreEntries.add(new Entry(7, pq3h8_score));
        scoreEntries.add(new Entry(8, pq3h9_score));
        scoreEntries.add(new Entry(9, pq3h10_score));

        Log.i("ScoreEntries3","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval3", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ4() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pq4h1_score = shq4.getInt("pq4_h1_score", 0);
        int pq4h2_score = shq4.getInt("pq4_h2_score", 0);
        int pq4h3_score = shq4.getInt("pq4_h3_score", 0);
        int pq4h4_score = shq4.getInt("pq4_h4_score", 0);
        int pq4h5_score = shq4.getInt("pq4_h5_score", 0);
        int pq4h6_score = shq4.getInt("pq4_h6_score", 0);
        int pq4h7_score = shq4.getInt("pq4_h7_score", 0);
        int pq4h8_score = shq4.getInt("pq4_h8_score", 0);
        int pq4h9_score = shq4.getInt("pq4_h9_score", 0);
        int pq4h10_score = shq4.getInt("pq4_h10_score", 0);

        scoreEntries.add(new Entry(0, pq4h1_score));
        scoreEntries.add(new Entry(1, pq4h2_score));
        scoreEntries.add(new Entry(2, pq4h3_score));
        scoreEntries.add(new Entry(3, pq4h4_score));
        scoreEntries.add(new Entry(4, pq4h5_score));
        scoreEntries.add(new Entry(5, pq4h6_score));
        scoreEntries.add(new Entry(6, pq4h7_score));
        scoreEntries.add(new Entry(7, pq4h8_score));
        scoreEntries.add(new Entry(8, pq4h9_score));
        scoreEntries.add(new Entry(9, pq4h10_score));

        Log.i("ScoreEntries4","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval4", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ5() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int pq5h1_score = shq5.getInt("pq5_h1_score", 0);
        int pq5h2_score = shq5.getInt("pq5_h2_score", 0);
        int pq5h3_score = shq5.getInt("pq5_h3_score", 0);
        int pq5h4_score = shq5.getInt("pq5_h4_score", 0);
        int pq5h5_score = shq5.getInt("pq5_h5_score", 0);
        int pq5h6_score = shq5.getInt("pq5_h6_score", 0);
        int pq5h7_score = shq5.getInt("pq5_h7_score", 0);
        int pq5h8_score = shq5.getInt("pq5_h8_score", 0);
        int pq5h9_score = shq5.getInt("pq5_h9_score", 0);
        int pq5h10_score = shq5.getInt("pq5_h10_score", 0);

        scoreEntries.add(new Entry(0, pq5h1_score));
        scoreEntries.add(new Entry(1, pq5h2_score));
        scoreEntries.add(new Entry(2, pq5h3_score));
        scoreEntries.add(new Entry(3, pq5h4_score));
        scoreEntries.add(new Entry(4, pq5h5_score));
        scoreEntries.add(new Entry(5, pq5h6_score));
        scoreEntries.add(new Entry(6, pq5h7_score));
        scoreEntries.add(new Entry(7, pq5h8_score));
        scoreEntries.add(new Entry(8, pq5h9_score));
        scoreEntries.add(new Entry(9, pq5h10_score));

        Log.i("ScoreEntries5","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval5", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }
}