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


public class Frag_midterm extends Fragment {

    SharedPreferences shq7, shq8, shq9, shq10, shq11;
    List<String> mq7xAxisValues, mq8xAxisValues, mq9xAxisValues, mq10xAxisValues, mq11xAxisValues;
    String[] mq7xAxisstr,  mq8xAxisstr, mq9xAxisstr, mq10xAxisstr, mq11xAxisstr;
    ValueFormatter vf;

    public Frag_midterm() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_midterm, container, false);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };

        makeMQ7_Graph(view);
        makeMQ8_Graph(view);
        makeMQ9_Graph(view);
        makeMQ10_Graph(view);
        makeMQ11_Graph(view);
        return view;
    }

    private void makeMQ7_Graph(View view){
        shq7  = this.getActivity().getSharedPreferences("M_Q7SharedPref", MODE_PRIVATE);
        String mquiz7_date1 = shq7.getString("mq7_h1_date", "");
        String mquiz7_date2 = shq7.getString("mq7_h2_date", "");
        String mquiz7_date3 = shq7.getString("mq7_h3_date", "");
        String mquiz7_date4 = shq7.getString("mq7_h4_date", "");
        String mquiz7_date5 = shq7.getString("mq7_h5_date", "");
        String mquiz7_date6 = shq7.getString("mq7_h6_date", "");
        String mquiz7_date7 = shq7.getString("mq7_h7_date", "");
        String mquiz7_date8 = shq7.getString("mq7_h8_date", "");
        String mquiz7_date9 = shq7.getString("mq7_h9_date", "");
        String mquiz7_date10 = shq7.getString("mq7_h10_date", "");

        mq7xAxisValues = new ArrayList<>(Arrays.asList(
                mquiz7_date1,mquiz7_date2,mquiz7_date3,mquiz7_date4,mquiz7_date5,mquiz7_date6,mquiz7_date7,mquiz7_date8,mquiz7_date9,mquiz7_date10
        )
        );

        mq7xAxisstr = new String[]{mquiz7_date1,mquiz7_date2,mquiz7_date3,mquiz7_date4,mquiz7_date5,mquiz7_date6,mquiz7_date7,mquiz7_date8,mquiz7_date9,mquiz7_date10};
        Log.i("mq7xaxis"," "+mq7xAxisValues);

        ArrayList<ILineDataSet> dataSets7 = new ArrayList<>();

        List<Entry> PQ7scoreEntries = getScoreEntriesPQ7();
        dataSets7 = new ArrayList<>();

        LineDataSet set7;
        set7 = new LineDataSet(PQ7scoreEntries, "Score");
        set7.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set7.setValueTextColor(Color.rgb(55, 70, 73));
        set7.setMode(LineDataSet.Mode.LINEAR);
        dataSets7.add(set7);

        LineChart mLineGraph7 =  view.findViewById (R.id.linechart7);
        mLineGraph7.setTouchEnabled(false);
        mLineGraph7.setDragEnabled(false);
        mLineGraph7.setScaleEnabled(false);
        mLineGraph7.setPinchZoom(false);
        mLineGraph7.setDrawGridBackground(true);
        mLineGraph7.getAxisRight().setEnabled(false);
        set7.setLineWidth(3f);
        set7.setCircleRadius(4f);
        set7.setDrawCircleHole(true);
        set7.setCircleHoleRadius(2f);
        set7.setCircleHoleColor(Color.WHITE);
        set7.setDrawValues(true);
        set7.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph7.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq7xAxisValues));
        XAxis xAxis = mLineGraph7.getXAxis();

        Log.i("xAxistStrlen", mq7xAxisValues.size()+"");
        xAxis.setLabelCount(mq7xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets7);
        mLineGraph7.setData(data);
        mLineGraph7.animateX(2000);
        mLineGraph7.invalidate();
        mLineGraph7.getDescription().setEnabled(false);
        mLineGraph7.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph7.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ7scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph7.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set7.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph7.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq7xAxisValues));
        XAxis xAxis7 = mLineGraph7.getXAxis();

        xAxis7.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", mq7xAxisValues.size()+"");
        xAxis7.setLabelCount(mq7xAxisstr.length,true);
        xAxis7.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data7 = new LineData(dataSets7);
        mLineGraph7.setData(data);
        mLineGraph7.animateX(2000);
        mLineGraph7.invalidate();
        mLineGraph7.getDescription().setEnabled(false);
        mLineGraph7.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph7.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ7scoreEntries.size());// figure out the max value in your dataset
        mLineGraph7.getAxisLeft().setLabelCount(PQ7scoreEntries.size());
        data7.setValueFormatter(vf);
        set7.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeMQ8_Graph(View view){
        shq8  = this.getActivity().getSharedPreferences("M_Q8SharedPref", MODE_PRIVATE);
        String mquiz8_date1 = shq8.getString("mq8_h1_date", "");
        String mquiz8_date2 = shq8.getString("mq8_h2_date", "");
        String mquiz8_date3 = shq8.getString("mq8_h3_date", "");
        String mquiz8_date4 = shq8.getString("mq8_h4_date", "");
        String mquiz8_date5 = shq8.getString("mq8_h5_date", "");
        String mquiz8_date6 = shq8.getString("mq8_h6_date", "");
        String mquiz8_date7 = shq8.getString("mq8_h7_date", "");
        String mquiz8_date8 = shq8.getString("mq8_h8_date", "");
        String mquiz8_date9 = shq8.getString("mq8_h9_date", "");
        String mquiz8_date10 = shq8.getString("mq8_h10_date", "");

        mq8xAxisValues = new ArrayList<>(Arrays.asList(
                mquiz8_date1,mquiz8_date2,mquiz8_date3,mquiz8_date4,mquiz8_date5,mquiz8_date6,mquiz8_date7,mquiz8_date8,mquiz8_date9,mquiz8_date10
        )
        );

        mq8xAxisstr = new String[]{mquiz8_date1,mquiz8_date2,mquiz8_date3,mquiz8_date4,mquiz8_date5,mquiz8_date6,mquiz8_date7,mquiz8_date8,mquiz8_date9,mquiz8_date10};
        Log.i("mq8xaxis"," "+mq8xAxisValues);

        ArrayList<ILineDataSet> dataSets8 = new ArrayList<>();

        List<Entry> PQ8scoreEntries = getScoreEntriesPQ8();
        dataSets8 = new ArrayList<>();

        LineDataSet set8;
        set8 = new LineDataSet(PQ8scoreEntries, "Score");
        set8.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set8.setValueTextColor(Color.rgb(55, 70, 73));
        set8.setMode(LineDataSet.Mode.LINEAR);
        dataSets8.add(set8);

        LineChart mLineGraph8 =  view.findViewById (R.id.linechart8);
        mLineGraph8.setTouchEnabled(false);
        mLineGraph8.setDragEnabled(false);
        mLineGraph8.setScaleEnabled(false);
        mLineGraph8.setPinchZoom(false);
        mLineGraph8.setDrawGridBackground(true);
        mLineGraph8.getAxisRight().setEnabled(false);
        set8.setLineWidth(3f);
        set8.setCircleRadius(4f);
        set8.setDrawCircleHole(true);
        set8.setCircleHoleRadius(2f);
        set8.setCircleHoleColor(Color.WHITE);
        set8.setDrawValues(true);
        set8.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph8.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq8xAxisValues));
        XAxis xAxis = mLineGraph8.getXAxis();

        Log.i("xAxistStrlen", mq8xAxisValues.size()+"");
        xAxis.setLabelCount(mq8xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets8);
        mLineGraph8.setData(data);
        mLineGraph8.animateX(2000);
        mLineGraph8.invalidate();
        mLineGraph8.getDescription().setEnabled(false);
        mLineGraph8.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph8.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ8scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph8.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set8.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph8.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq8xAxisValues));
        XAxis xAxis8 = mLineGraph8.getXAxis();

        xAxis8.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", mq8xAxisValues.size()+"");
        xAxis8.setLabelCount(mq8xAxisstr.length,true);
        xAxis8.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data8 = new LineData(dataSets8);
        mLineGraph8.setData(data);
        mLineGraph8.animateX(2000);
        mLineGraph8.invalidate();
        mLineGraph8.getDescription().setEnabled(false);
        mLineGraph8.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph8.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ8scoreEntries.size());// figure out the max value in your dataset
        mLineGraph8.getAxisLeft().setLabelCount(PQ8scoreEntries.size());
        data8.setValueFormatter(vf);
        set8.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeMQ9_Graph(View view){
        shq9  = this.getActivity().getSharedPreferences("M_Q9SharedPref", MODE_PRIVATE);
        String mquiz9_date1 = shq9.getString("mq9_h1_date", "");
        String mquiz9_date2 = shq9.getString("mq9_h2_date", "");
        String mquiz9_date3 = shq9.getString("mq9_h3_date", "");
        String mquiz9_date4 = shq9.getString("mq9_h4_date", "");
        String mquiz9_date5 = shq9.getString("mq9_h5_date", "");
        String mquiz9_date6 = shq9.getString("mq9_h6_date", "");
        String mquiz9_date7 = shq9.getString("mq9_h7_date", "");
        String mquiz9_date8 = shq9.getString("mq9_h8_date", "");
        String mquiz9_date9 = shq9.getString("mq9_h9_date", "");
        String mquiz9_date10 = shq9.getString("mq9_h10_date", "");

        mq9xAxisValues = new ArrayList<>(Arrays.asList(
                mquiz9_date1,mquiz9_date2,mquiz9_date3,mquiz9_date4,mquiz9_date5,mquiz9_date6,mquiz9_date7,mquiz9_date8,mquiz9_date9,mquiz9_date10
        )
        );

        mq9xAxisstr = new String[]{mquiz9_date1,mquiz9_date2,mquiz9_date3,mquiz9_date4,mquiz9_date5,mquiz9_date6,mquiz9_date7,mquiz9_date8,mquiz9_date9,mquiz9_date10};
        Log.i("mq9xaxis"," "+mq9xAxisValues);

        ArrayList<ILineDataSet> dataSets9 = new ArrayList<>();

        List<Entry> PQ9scoreEntries = getScoreEntriesPQ9();
        dataSets9 = new ArrayList<>();

        LineDataSet set9;
        set9 = new LineDataSet(PQ9scoreEntries, "Score");
        set9.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set9.setValueTextColor(Color.rgb(55, 70, 73));
        set9.setMode(LineDataSet.Mode.LINEAR);
        dataSets9.add(set9);

        LineChart mLineGraph9 =  view.findViewById (R.id.linechart9);
        mLineGraph9.setTouchEnabled(false);
        mLineGraph9.setDragEnabled(false);
        mLineGraph9.setScaleEnabled(false);
        mLineGraph9.setPinchZoom(false);
        mLineGraph9.setDrawGridBackground(true);
        mLineGraph9.getAxisRight().setEnabled(false);
        set9.setLineWidth(3f);
        set9.setCircleRadius(4f);
        set9.setDrawCircleHole(true);
        set9.setCircleHoleRadius(2f);
        set9.setCircleHoleColor(Color.WHITE);
        set9.setDrawValues(true);
        set9.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph9.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq9xAxisValues));
        XAxis xAxis = mLineGraph9.getXAxis();

        Log.i("xAxistStrlen", mq9xAxisValues.size()+"");
        xAxis.setLabelCount(mq9xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets9);
        mLineGraph9.setData(data);
        mLineGraph9.animateX(2000);
        mLineGraph9.invalidate();
        mLineGraph9.getDescription().setEnabled(false);
        mLineGraph9.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph9.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ9scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph9.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set9.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph9.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq9xAxisValues));
        XAxis xAxis9 = mLineGraph9.getXAxis();

        xAxis9.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", mq9xAxisValues.size()+"");
        xAxis9.setLabelCount(mq9xAxisstr.length,true);
        xAxis9.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data9 = new LineData(dataSets9);
        mLineGraph9.setData(data);
        mLineGraph9.animateX(2000);
        mLineGraph9.invalidate();
        mLineGraph9.getDescription().setEnabled(false);
        mLineGraph9.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph9.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ9scoreEntries.size());// figure out the max value in your dataset
        mLineGraph9.getAxisLeft().setLabelCount(PQ9scoreEntries.size());
        data9.setValueFormatter(vf);
        set9.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeMQ10_Graph(View view){
        shq10  = this.getActivity().getSharedPreferences("M_Q10SharedPref", MODE_PRIVATE);
        String mquiz10_date1 = shq10.getString("mq10_h1_date", "");
        String mquiz10_date2 = shq10.getString("mq10_h2_date", "");
        String mquiz10_date3 = shq10.getString("mq10_h3_date", "");
        String mquiz10_date4 = shq10.getString("mq10_h4_date", "");
        String mquiz10_date5 = shq10.getString("mq10_h5_date", "");
        String mquiz10_date6 = shq10.getString("mq10_h6_date", "");
        String mquiz10_date7 = shq10.getString("mq10_h7_date", "");
        String mquiz10_date8 = shq10.getString("mq10_h8_date", "");
        String mquiz10_date9 = shq10.getString("mq10_h9_date", "");
        String mquiz10_date10 = shq10.getString("mq10_h10_date", "");

        mq10xAxisValues = new ArrayList<>(Arrays.asList(
                mquiz10_date1,mquiz10_date2,mquiz10_date3,mquiz10_date4,mquiz10_date5,mquiz10_date6,mquiz10_date7,mquiz10_date8,mquiz10_date9,mquiz10_date10
        )
        );

        mq10xAxisstr = new String[]{mquiz10_date1,mquiz10_date2,mquiz10_date3,mquiz10_date4,mquiz10_date5,mquiz10_date6,mquiz10_date7,mquiz10_date8,mquiz10_date9,mquiz10_date10};
        Log.i("mq10xaxis"," "+mq10xAxisValues);

        ArrayList<ILineDataSet> dataSets10= new ArrayList<>();

        List<Entry> PQ10scoreEntries = getScoreEntriesPQ10();
        dataSets10= new ArrayList<>();

        LineDataSet set10;
        set10 = new LineDataSet(PQ10scoreEntries, "Score");
        set10.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set10.setValueTextColor(Color.rgb(55, 70, 73));
        set10.setMode(LineDataSet.Mode.LINEAR);
        dataSets10.add(set10);

        LineChart mLineGraph10 =  view.findViewById (R.id.linechart10);
        mLineGraph10.setTouchEnabled(false);
        mLineGraph10.setDragEnabled(false);
        mLineGraph10.setScaleEnabled(false);
        mLineGraph10.setPinchZoom(false);
        mLineGraph10.setDrawGridBackground(true);
        mLineGraph10.getAxisRight().setEnabled(false);
        set10.setLineWidth(3f);
        set10.setCircleRadius(4f);
        set10.setDrawCircleHole(true);
        set10.setCircleHoleRadius(2f);
        set10.setCircleHoleColor(Color.WHITE);
        set10.setDrawValues(true);
        set10.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph10.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq10xAxisValues));
        XAxis xAxis = mLineGraph10.getXAxis();

        Log.i("xAxistStrlen", mq10xAxisValues.size()+"");
        xAxis.setLabelCount(mq10xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets10);
        mLineGraph10.setData(data);
        mLineGraph10.animateX(2000);
        mLineGraph10.invalidate();
        mLineGraph10.getDescription().setEnabled(false);
        mLineGraph10.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph10.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ10scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph10.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set10.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph10.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq10xAxisValues));
        XAxis xAxis10 = mLineGraph10.getXAxis();

        xAxis10.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", mq10xAxisValues.size()+"");
        xAxis10.setLabelCount(mq10xAxisstr.length,true);
        xAxis10.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data10 = new LineData(dataSets10);
        mLineGraph10.setData(data);
        mLineGraph10.animateX(2000);
        mLineGraph10.invalidate();
        mLineGraph10.getDescription().setEnabled(false);
        mLineGraph10.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph10.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ10scoreEntries.size());// figure out the max value in your dataset
        mLineGraph10.getAxisLeft().setLabelCount(PQ10scoreEntries.size());
        data10.setValueFormatter(vf);
        set10.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeMQ11_Graph(View view){
        shq11  = this.getActivity().getSharedPreferences("M_Q11SharedPref", MODE_PRIVATE);
        String mquiz11_date1 = shq11.getString("mq11_h1_date", "");
        String mquiz11_date2 = shq11.getString("mq11_h2_date", "");
        String mquiz11_date3 = shq11.getString("mq11_h3_date", "");
        String mquiz11_date4 = shq11.getString("mq11_h4_date", "");
        String mquiz11_date5 = shq11.getString("mq11_h5_date", "");
        String mquiz11_date6 = shq11.getString("mq11_h6_date", "");
        String mquiz11_date7 = shq11.getString("mq11_h7_date", "");
        String mquiz11_date8 = shq11.getString("mq11_h8_date", "");
        String mquiz11_date9 = shq11.getString("mq11_h9_date", "");
        String mquiz11_date10 = shq11.getString("mq11_h10_date", "");

        mq11xAxisValues = new ArrayList<>(Arrays.asList(
                mquiz11_date1,mquiz11_date2,mquiz11_date3,mquiz11_date4,mquiz11_date5,mquiz11_date6,mquiz11_date7,mquiz11_date8,mquiz11_date9,mquiz11_date10
        )
        );

        mq11xAxisstr = new String[]{mquiz11_date1,mquiz11_date2,mquiz11_date3,mquiz11_date4,mquiz11_date5,mquiz11_date6,mquiz11_date7,mquiz11_date8,mquiz11_date9,mquiz11_date10};
        Log.i("mq11xaxis"," "+mq11xAxisValues);

        ArrayList<ILineDataSet> dataSets11= new ArrayList<>();

        List<Entry> PQ11scoreEntries = getScoreEntriesPQ11();
        dataSets11= new ArrayList<>();

        LineDataSet set11;
        set11 = new LineDataSet(PQ11scoreEntries, "Score");
        set11.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set11.setValueTextColor(Color.rgb(55, 70, 73));
        set11.setMode(LineDataSet.Mode.LINEAR);
        dataSets11.add(set11);

        LineChart mLineGraph11 =  view.findViewById (R.id.linechart11);
        mLineGraph11.setTouchEnabled(false);
        mLineGraph11.setDragEnabled(false);
        mLineGraph11.setScaleEnabled(false);
        mLineGraph11.setPinchZoom(false);
        mLineGraph11.setDrawGridBackground(true);
        mLineGraph11.getAxisRight().setEnabled(false);
        set11.setLineWidth(3f);
        set11.setCircleRadius(4f);
        set11.setDrawCircleHole(true);
        set11.setCircleHoleRadius(2f);
        set11.setCircleHoleColor(Color.WHITE);
        set11.setDrawValues(true);
        set11.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph11.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq11xAxisValues));
        XAxis xAxis = mLineGraph11.getXAxis();

        Log.i("xAxistStrlen", mq11xAxisValues.size()+"");
        xAxis.setLabelCount(mq11xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets11);
        mLineGraph11.setData(data);
        mLineGraph11.animateX(2000);
        mLineGraph11.invalidate();
        mLineGraph11.getDescription().setEnabled(false);
        mLineGraph11.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph11.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = PQ11scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph11.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set11.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph11.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mq11xAxisValues));
        XAxis xAxis11 = mLineGraph11.getXAxis();

        xAxis11.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", mq11xAxisValues.size()+"");
        xAxis11.setLabelCount(mq11xAxisstr.length,true);
        xAxis11.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data11 = new LineData(dataSets11);
        mLineGraph11.setData(data);
        mLineGraph11.animateX(2000);
        mLineGraph11.invalidate();
        mLineGraph11.getDescription().setEnabled(false);
        mLineGraph11.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph11.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+PQ11scoreEntries.size());// figure out the max value in your dataset
        mLineGraph11.getAxisLeft().setLabelCount(PQ11scoreEntries.size());
        data11.setValueFormatter(vf);
        set11.setValueTextSize(11f);
        //end for whole number formatting

    }

    private List<Entry> getScoreEntriesPQ7() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int mq7h1_score = shq7.getInt("mq7_h1_score", 0);
        int mq7h2_score = shq7.getInt("mq7_h2_score", 0);
        int mq7h3_score = shq7.getInt("mq7_h3_score", 0);
        int mq7h4_score = shq7.getInt("mq7_h4_score", 0);
        int mq7h5_score = shq7.getInt("mq7_h5_score", 0);
        int mq7h6_score = shq7.getInt("mq7_h6_score", 0);
        int mq7h7_score = shq7.getInt("mq7_h7_score", 0);
        int mq7h8_score = shq7.getInt("mq7_h8_score", 0);
        int mq7h9_score = shq7.getInt("mq7_h9_score", 0);
        int mq7h10_score = shq7.getInt("mq7_h10_score", 0);

        scoreEntries.add(new Entry(0, mq7h1_score));
        scoreEntries.add(new Entry(1, mq7h2_score));
        scoreEntries.add(new Entry(2, mq7h3_score));
        scoreEntries.add(new Entry(3, mq7h4_score));
        scoreEntries.add(new Entry(4, mq7h5_score));
        scoreEntries.add(new Entry(5, mq7h6_score));
        scoreEntries.add(new Entry(6, mq7h7_score));
        scoreEntries.add(new Entry(7, mq7h8_score));
        scoreEntries.add(new Entry(8, mq7h9_score));
        scoreEntries.add(new Entry(9, mq7h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ8() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int mq8h1_score = shq8.getInt("mq8_h1_score", 0);
        int mq8h2_score = shq8.getInt("mq8_h2_score", 0);
        int mq8h3_score = shq8.getInt("mq8_h3_score", 0);
        int mq8h4_score = shq8.getInt("mq8_h4_score", 0);
        int mq8h5_score = shq8.getInt("mq8_h5_score", 0);
        int mq8h6_score = shq8.getInt("mq8_h6_score", 0);
        int mq8h7_score = shq8.getInt("mq8_h7_score", 0);
        int mq8h8_score = shq8.getInt("mq8_h8_score", 0);
        int mq8h9_score = shq8.getInt("mq8_h9_score", 0);
        int mq8h10_score = shq8.getInt("mq8_h10_score", 0);

        scoreEntries.add(new Entry(0, mq8h1_score));
        scoreEntries.add(new Entry(1, mq8h2_score));
        scoreEntries.add(new Entry(2, mq8h3_score));
        scoreEntries.add(new Entry(3, mq8h4_score));
        scoreEntries.add(new Entry(4, mq8h5_score));
        scoreEntries.add(new Entry(5, mq8h6_score));
        scoreEntries.add(new Entry(6, mq8h7_score));
        scoreEntries.add(new Entry(7, mq8h8_score));
        scoreEntries.add(new Entry(8, mq8h9_score));
        scoreEntries.add(new Entry(9, mq8h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ9() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int mq9h1_score = shq9.getInt("mq9_h1_score", 0);
        int mq9h2_score = shq9.getInt("mq9_h2_score", 0);
        int mq9h3_score = shq9.getInt("mq9_h3_score", 0);
        int mq9h4_score = shq9.getInt("mq9_h4_score", 0);
        int mq9h5_score = shq9.getInt("mq9_h5_score", 0);
        int mq9h6_score = shq9.getInt("mq9_h6_score", 0);
        int mq9h7_score = shq9.getInt("mq9_h7_score", 0);
        int mq9h8_score = shq9.getInt("mq9_h8_score", 0);
        int mq9h9_score = shq9.getInt("mq9_h9_score", 0);
        int mq9h10_score = shq9.getInt("mq9_h10_score", 0);

        scoreEntries.add(new Entry(0, mq9h1_score));
        scoreEntries.add(new Entry(1, mq9h2_score));
        scoreEntries.add(new Entry(2, mq9h3_score));
        scoreEntries.add(new Entry(3, mq9h4_score));
        scoreEntries.add(new Entry(4, mq9h5_score));
        scoreEntries.add(new Entry(5, mq9h6_score));
        scoreEntries.add(new Entry(6, mq9h7_score));
        scoreEntries.add(new Entry(7, mq9h8_score));
        scoreEntries.add(new Entry(8, mq9h9_score));
        scoreEntries.add(new Entry(9, mq9h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ10() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int mq10h1_score = shq10.getInt("mq10_h1_score", 0);
        int mq10h2_score = shq10.getInt("mq10_h2_score", 0);
        int mq10h3_score = shq10.getInt("mq10_h3_score", 0);
        int mq10h4_score = shq10.getInt("mq10_h4_score", 0);
        int mq10h5_score = shq10.getInt("mq10_h5_score", 0);
        int mq10h6_score = shq10.getInt("mq10_h6_score", 0);
        int mq10h7_score = shq10.getInt("mq10_h7_score", 0);
        int mq10h8_score = shq10.getInt("mq10_h8_score", 0);
        int mq10h9_score = shq10.getInt("mq10_h9_score", 0);
        int mq10h10_score = shq10.getInt("mq10_h10_score", 0);

        scoreEntries.add(new Entry(0, mq10h1_score));
        scoreEntries.add(new Entry(1, mq10h2_score));
        scoreEntries.add(new Entry(2, mq10h3_score));
        scoreEntries.add(new Entry(3, mq10h4_score));
        scoreEntries.add(new Entry(4, mq10h5_score));
        scoreEntries.add(new Entry(5, mq10h6_score));
        scoreEntries.add(new Entry(6, mq10h7_score));
        scoreEntries.add(new Entry(7, mq10h8_score));
        scoreEntries.add(new Entry(8, mq10h9_score));
        scoreEntries.add(new Entry(9, mq10h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesPQ11() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int mq11h1_score = shq11.getInt("mq11_h1_score", 0);
        int mq11h2_score = shq11.getInt("mq11_h2_score", 0);
        int mq11h3_score = shq11.getInt("mq11_h3_score", 0);
        int mq11h4_score = shq11.getInt("mq11_h4_score", 0);
        int mq11h5_score = shq11.getInt("mq11_h5_score", 0);
        int mq11h6_score = shq11.getInt("mq11_h6_score", 0);
        int mq11h7_score = shq11.getInt("mq11_h7_score", 0);
        int mq11h8_score = shq11.getInt("mq11_h8_score", 0);
        int mq11h9_score = shq11.getInt("mq11_h9_score", 0);
        int mq11h10_score = shq11.getInt("mq11_h10_score", 0);

        scoreEntries.add(new Entry(0, mq11h1_score));
        scoreEntries.add(new Entry(1, mq11h2_score));
        scoreEntries.add(new Entry(2, mq11h3_score));
        scoreEntries.add(new Entry(3, mq11h4_score));
        scoreEntries.add(new Entry(4, mq11h5_score));
        scoreEntries.add(new Entry(5, mq11h6_score));
        scoreEntries.add(new Entry(6, mq11h7_score));
        scoreEntries.add(new Entry(7, mq11h8_score));
        scoreEntries.add(new Entry(8, mq11h9_score));
        scoreEntries.add(new Entry(9, mq11h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }


}