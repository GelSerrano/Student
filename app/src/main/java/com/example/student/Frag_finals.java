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


public class Frag_finals extends Fragment {

    SharedPreferences shq13, shq14, shq15, shq16;
    List<String> fq13xAxisValues, fq14xAxisValues, fq15xAxisValues, fq16xAxisValues;
    String[] fq13xAxisstr,  fq14xAxisstr, fq15xAxisstr, fq16xAxisstr;
    ValueFormatter vf;

    public Frag_finals() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finals, container, false);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };

        makeFQ13_Graph(view);
        makeFQ14_Graph(view);
        makeFQ15_Graph(view);
        makeFQ16_Graph(view);
        return view;
    }

    private void makeFQ13_Graph(View view){
        shq13  = this.getActivity().getSharedPreferences("F_Q13SharedPref", MODE_PRIVATE);
        String fquiz13_date1 = shq13.getString("fq13_h1_date", "");
        String fquiz13_date2 = shq13.getString("fq13_h2_date", "");
        String fquiz13_date3 = shq13.getString("fq13_h3_date", "");
        String fquiz13_date4 = shq13.getString("fq13_h4_date", "");
        String fquiz13_date5 = shq13.getString("fq13_h5_date", "");
        String fquiz13_date6 = shq13.getString("fq13_h6_date", "");
        String fquiz13_date7 = shq13.getString("fq13_h7_date", "");
        String fquiz13_date8 = shq13.getString("fq13_h8_date", "");
        String fquiz13_date9 = shq13.getString("fq13_h9_date", "");
        String fquiz13_date10 = shq13.getString("fq13_h10_date", "");

        fq13xAxisValues = new ArrayList<>(Arrays.asList(
                fquiz13_date1,fquiz13_date2,fquiz13_date3,fquiz13_date4,fquiz13_date5,fquiz13_date6,fquiz13_date7,fquiz13_date8,fquiz13_date9,fquiz13_date10
        )
        );

        fq13xAxisstr = new String[]{fquiz13_date1,fquiz13_date2,fquiz13_date3,fquiz13_date4,fquiz13_date5,fquiz13_date6,fquiz13_date7,fquiz13_date8,fquiz13_date9,fquiz13_date10};
        Log.i("fq13xaxis"," "+fq13xAxisValues);

        ArrayList<ILineDataSet> dataSets13 = new ArrayList<>();

        List<Entry> FQ13scoreEntries = getScoreEntriesFQ13();
        dataSets13 = new ArrayList<>();

        LineDataSet set13;
        set13 = new LineDataSet(FQ13scoreEntries, "Score");
        set13.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set13.setValueTextColor(Color.rgb(55, 70, 73));
        set13.setMode(LineDataSet.Mode.LINEAR);
        dataSets13.add(set13);

        LineChart mLineGraph13 =  view.findViewById (R.id.linechart13);
        mLineGraph13.setTouchEnabled(false);
        mLineGraph13.setDragEnabled(false);
        mLineGraph13.setScaleEnabled(false);
        mLineGraph13.setPinchZoom(false);
        mLineGraph13.setDrawGridBackground(true);
        mLineGraph13.getAxisRight().setEnabled(false);
        set13.setLineWidth(3f);
        set13.setCircleRadius(4f);
        set13.setDrawCircleHole(true);
        set13.setCircleHoleRadius(2f);
        set13.setCircleHoleColor(Color.WHITE);
        set13.setDrawValues(true);
        set13.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph13.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq13xAxisValues));
        XAxis xAxis = mLineGraph13.getXAxis();

        Log.i("xAxistStrlen", fq13xAxisValues.size()+"");
        xAxis.setLabelCount(fq13xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets13);
        mLineGraph13.setData(data);
        mLineGraph13.animateX(2000);
        mLineGraph13.invalidate();
        mLineGraph13.getDescription().setEnabled(false);
        mLineGraph13.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph13.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = FQ13scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph13.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set13.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph13.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq13xAxisValues));
        XAxis xAxis13 = mLineGraph13.getXAxis();

        xAxis13.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", fq13xAxisValues.size()+"");
        xAxis13.setLabelCount(fq13xAxisstr.length,true);
        xAxis13.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data13 = new LineData(dataSets13);
        mLineGraph13.setData(data);
        mLineGraph13.animateX(2000);
        mLineGraph13.invalidate();
        mLineGraph13.getDescription().setEnabled(false);
        mLineGraph13.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph13.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+FQ13scoreEntries.size());// figure out the max value in your dataset
        mLineGraph13.getAxisLeft().setLabelCount(FQ13scoreEntries.size());
        data13.setValueFormatter(vf);
        set13.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeFQ14_Graph(View view){
        shq14  = this.getActivity().getSharedPreferences("F_Q14SharedPref", MODE_PRIVATE);
        String fquiz14_date1 = shq14.getString("fq14_h1_date", "");
        String fquiz14_date2 = shq14.getString("fq14_h2_date", "");
        String fquiz14_date3 = shq14.getString("fq14_h3_date", "");
        String fquiz14_date4 = shq14.getString("fq14_h4_date", "");
        String fquiz14_date5 = shq14.getString("fq14_h5_date", "");
        String fquiz14_date6 = shq14.getString("fq14_h6_date", "");
        String fquiz14_date7 = shq14.getString("fq14_h7_date", "");
        String fquiz14_date8 = shq14.getString("fq14_h8_date", "");
        String fquiz14_date9 = shq14.getString("fq14_h9_date", "");
        String fquiz14_date10 = shq14.getString("fq14_h10_date", "");

        fq14xAxisValues = new ArrayList<>(Arrays.asList(
                fquiz14_date1,fquiz14_date2,fquiz14_date3,fquiz14_date4,fquiz14_date5,fquiz14_date6,fquiz14_date7,fquiz14_date8,fquiz14_date9,fquiz14_date10
        )
        );

        fq14xAxisstr = new String[]{fquiz14_date1,fquiz14_date2,fquiz14_date3,fquiz14_date4,fquiz14_date5,fquiz14_date6,fquiz14_date7,fquiz14_date8,fquiz14_date9,fquiz14_date10};
        Log.i("fq14xaxis"," "+fq14xAxisValues);

        ArrayList<ILineDataSet> dataSets14 = new ArrayList<>();

        List<Entry> FQ14scoreEntries = getScoreEntriesFQ14();
        dataSets14 = new ArrayList<>();

        LineDataSet set14;
        set14 = new LineDataSet(FQ14scoreEntries, "Score");
        set14.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set14.setValueTextColor(Color.rgb(55, 70, 73));
        set14.setMode(LineDataSet.Mode.LINEAR);
        dataSets14.add(set14);

        LineChart mLineGraph14 =  view.findViewById (R.id.linechart14);
        mLineGraph14.setTouchEnabled(false);
        mLineGraph14.setDragEnabled(false);
        mLineGraph14.setScaleEnabled(false);
        mLineGraph14.setPinchZoom(false);
        mLineGraph14.setDrawGridBackground(true);
        mLineGraph14.getAxisRight().setEnabled(false);
        set14.setLineWidth(3f);
        set14.setCircleRadius(4f);
        set14.setDrawCircleHole(true);
        set14.setCircleHoleRadius(2f);
        set14.setCircleHoleColor(Color.WHITE);
        set14.setDrawValues(true);
        set14.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph14.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq14xAxisValues));
        XAxis xAxis = mLineGraph14.getXAxis();

        Log.i("xAxistStrlen", fq14xAxisValues.size()+"");
        xAxis.setLabelCount(fq14xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets14);
        mLineGraph14.setData(data);
        mLineGraph14.animateX(2000);
        mLineGraph14.invalidate();
        mLineGraph14.getDescription().setEnabled(false);
        mLineGraph14.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph14.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = FQ14scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph14.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set14.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph14.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq14xAxisValues));
        XAxis xAxis14 = mLineGraph14.getXAxis();

        xAxis14.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", fq14xAxisValues.size()+"");
        xAxis14.setLabelCount(fq14xAxisstr.length,true);
        xAxis14.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data14 = new LineData(dataSets14);
        mLineGraph14.setData(data);
        mLineGraph14.animateX(2000);
        mLineGraph14.invalidate();
        mLineGraph14.getDescription().setEnabled(false);
        mLineGraph14.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph14.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+FQ14scoreEntries.size());// figure out the max value in your dataset
        mLineGraph14.getAxisLeft().setLabelCount(FQ14scoreEntries.size());
        data14.setValueFormatter(vf);
        set14.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeFQ15_Graph(View view){
        shq15  = this.getActivity().getSharedPreferences("F_Q15SharedPref", MODE_PRIVATE);
        String fquiz15_date1 = shq15.getString("fq15_h1_date", "");
        String fquiz15_date2 = shq15.getString("fq15_h2_date", "");
        String fquiz15_date3 = shq15.getString("fq15_h3_date", "");
        String fquiz15_date4 = shq15.getString("fq15_h4_date", "");
        String fquiz15_date5 = shq15.getString("fq15_h5_date", "");
        String fquiz15_date6 = shq15.getString("fq15_h6_date", "");
        String fquiz15_date7 = shq15.getString("fq15_h7_date", "");
        String fquiz15_date8 = shq15.getString("fq15_h8_date", "");
        String fquiz15_date9 = shq15.getString("fq15_h9_date", "");
        String fquiz15_date10 = shq15.getString("fq15_h10_date", "");

        fq15xAxisValues = new ArrayList<>(Arrays.asList(
                fquiz15_date1,fquiz15_date2,fquiz15_date3,fquiz15_date4,fquiz15_date5,fquiz15_date6,fquiz15_date7,fquiz15_date8,fquiz15_date9,fquiz15_date10
        )
        );

        fq15xAxisstr = new String[]{fquiz15_date1,fquiz15_date2,fquiz15_date3,fquiz15_date4,fquiz15_date5,fquiz15_date6,fquiz15_date7,fquiz15_date8,fquiz15_date9,fquiz15_date10};
        Log.i("fq15xaxis"," "+fq15xAxisValues);

        ArrayList<ILineDataSet> dataSets15 = new ArrayList<>();

        List<Entry> FQ15scoreEntries = getScoreEntriesFQ15();
        dataSets15 = new ArrayList<>();

        LineDataSet set15;
        set15 = new LineDataSet(FQ15scoreEntries, "Score");
        set15.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set15.setValueTextColor(Color.rgb(55, 70, 73));
        set15.setMode(LineDataSet.Mode.LINEAR);
        dataSets15.add(set15);

        LineChart mLineGraph15 =  view.findViewById (R.id.linechart15);
        mLineGraph15.setTouchEnabled(false);
        mLineGraph15.setDragEnabled(false);
        mLineGraph15.setScaleEnabled(false);
        mLineGraph15.setPinchZoom(false);
        mLineGraph15.setDrawGridBackground(true);
        mLineGraph15.getAxisRight().setEnabled(false);
        set15.setLineWidth(3f);
        set15.setCircleRadius(4f);
        set15.setDrawCircleHole(true);
        set15.setCircleHoleRadius(2f);
        set15.setCircleHoleColor(Color.WHITE);
        set15.setDrawValues(true);
        set15.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph15.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq15xAxisValues));
        XAxis xAxis = mLineGraph15.getXAxis();

        Log.i("xAxistStrlen", fq15xAxisValues.size()+"");
        xAxis.setLabelCount(fq15xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets15);
        mLineGraph15.setData(data);
        mLineGraph15.animateX(2000);
        mLineGraph15.invalidate();
        mLineGraph15.getDescription().setEnabled(false);
        mLineGraph15.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph15.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = FQ15scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph15.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set15.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph15.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq15xAxisValues));
        XAxis xAxis15 = mLineGraph15.getXAxis();

        xAxis15.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", fq15xAxisValues.size()+"");
        xAxis15.setLabelCount(fq15xAxisstr.length,true);
        xAxis15.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data15 = new LineData(dataSets15);
        mLineGraph15.setData(data);
        mLineGraph15.animateX(2000);
        mLineGraph15.invalidate();
        mLineGraph15.getDescription().setEnabled(false);
        mLineGraph15.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph15.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+FQ15scoreEntries.size());// figure out the max value in your dataset
        mLineGraph15.getAxisLeft().setLabelCount(FQ15scoreEntries.size());
        data15.setValueFormatter(vf);
        set15.setValueTextSize(11f);
        //end for whole number formatting

    }

    private void makeFQ16_Graph(View view){
        shq16  = this.getActivity().getSharedPreferences("F_Q16SharedPref", MODE_PRIVATE);
        String fquiz16_date1 = shq16.getString("fq16_h1_date", "");
        String fquiz16_date2 = shq16.getString("fq16_h2_date", "");
        String fquiz16_date3 = shq16.getString("fq16_h3_date", "");
        String fquiz16_date4 = shq16.getString("fq16_h4_date", "");
        String fquiz16_date5 = shq16.getString("fq16_h5_date", "");
        String fquiz16_date6 = shq16.getString("fq16_h6_date", "");
        String fquiz16_date7 = shq16.getString("fq16_h7_date", "");
        String fquiz16_date8 = shq16.getString("fq16_h8_date", "");
        String fquiz16_date9 = shq16.getString("fq16_h9_date", "");
        String fquiz16_date10 = shq16.getString("fq16_h10_date", "");

        fq16xAxisValues = new ArrayList<>(Arrays.asList(
                fquiz16_date1,fquiz16_date2,fquiz16_date3,fquiz16_date4,fquiz16_date5,fquiz16_date6,fquiz16_date7,fquiz16_date8,fquiz16_date9,fquiz16_date10
        )
        );

        fq16xAxisstr = new String[]{fquiz16_date1,fquiz16_date2,fquiz16_date3,fquiz16_date4,fquiz16_date5,fquiz16_date6,fquiz16_date7,fquiz16_date8,fquiz16_date9,fquiz16_date10};
        Log.i("fq16xaxis"," "+fq16xAxisValues);

        ArrayList<ILineDataSet> dataSets16 = new ArrayList<>();

        List<Entry> FQ16scoreEntries = getScoreEntriesFQ16();
        dataSets16 = new ArrayList<>();

        LineDataSet set16;
        set16 = new LineDataSet(FQ16scoreEntries, "Score");
        set16.setColor(getResources().getColor(R.color.pie_color_4));  //line color
        set16.setValueTextColor(Color.rgb(55, 70, 73));
        set16.setMode(LineDataSet.Mode.LINEAR);
        dataSets16.add(set16);

        LineChart mLineGraph16 =  view.findViewById (R.id.linechart16);
        mLineGraph16.setTouchEnabled(false);
        mLineGraph16.setDragEnabled(false);
        mLineGraph16.setScaleEnabled(false);
        mLineGraph16.setPinchZoom(false);
        mLineGraph16.setDrawGridBackground(true);
        mLineGraph16.getAxisRight().setEnabled(false);
        set16.setLineWidth(3f);
        set16.setCircleRadius(4f);
        set16.setDrawCircleHole(true);
        set16.setCircleHoleRadius(2f);
        set16.setCircleHoleColor(Color.WHITE);
        set16.setDrawValues(true);
        set16.setCircleColor(getResources().getColor(R.color.pie_color_4));

        mLineGraph16.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq16xAxisValues));
        XAxis xAxis = mLineGraph16.getXAxis();

        Log.i("xAxistStrlen", fq16xAxisValues.size()+"");
        xAxis.setLabelCount(fq16xAxisstr.length,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data = new LineData(dataSets16);
        mLineGraph16.setData(data);
        mLineGraph16.animateX(2000);
        mLineGraph16.invalidate();
        mLineGraph16.getDescription().setEnabled(false);
        mLineGraph16.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph16.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });
        int max = FQ16scoreEntries.size();
        Log.d("scoreEntries:", "max: "+max);// figure out the max value in your dataset
        mLineGraph16.getAxisLeft().setLabelCount(max);

        vf = new ValueFormatter() { //value format here, here is the overridden method
            @Override
            public String getFormattedValue(float value) {
                return ""+(int)value;
            }
        };
        data.setValueFormatter(vf);
        set16.setValueTextSize(11f);
        //end for whole number formatting

        mLineGraph16.getXAxis().setValueFormatter(new IndexAxisValueFormatter(fq16xAxisValues));
        XAxis xAxis16 = mLineGraph16.getXAxis();

        xAxis16.setLabelRotationAngle(90f);
        Log.i("xAxistStrlen", fq16xAxisValues.size()+"");
        xAxis16.setLabelCount(fq16xAxisstr.length,true);
        xAxis16.setPosition(XAxis.XAxisPosition.BOTTOM);

        LineData data16 = new LineData(dataSets16);
        mLineGraph16.setData(data);
        mLineGraph16.animateX(2000);
        mLineGraph16.invalidate();
        mLineGraph16.getDescription().setEnabled(false);
        mLineGraph16.getLegend().setEnabled(false);

        //start for whole number formatting
        mLineGraph16.getAxisLeft().setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int) Math.floor(value));
            }
        });

        Log.d("scoreEntries:", "max: "+FQ16scoreEntries.size());// figure out the max value in your dataset
        mLineGraph16.getAxisLeft().setLabelCount(FQ16scoreEntries.size());
        data16.setValueFormatter(vf);
        set16.setValueTextSize(11f);
        //end for whole number formatting

    }

    private List<Entry> getScoreEntriesFQ13() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int fq13h1_score = shq13.getInt("fq13_h1_score", 0);
        int fq13h2_score = shq13.getInt("fq13_h2_score", 0);
        int fq13h3_score = shq13.getInt("fq13_h3_score", 0);
        int fq13h4_score = shq13.getInt("fq13_h4_score", 0);
        int fq13h5_score = shq13.getInt("fq13_h5_score", 0);
        int fq13h6_score = shq13.getInt("fq13_h6_score", 0);
        int fq13h7_score = shq13.getInt("fq13_h7_score", 0);
        int fq13h8_score = shq13.getInt("fq13_h8_score", 0);
        int fq13h9_score = shq13.getInt("fq13_h9_score", 0);
        int fq13h10_score = shq13.getInt("fq13_h10_score", 0);

        scoreEntries.add(new Entry(0, fq13h1_score));
        scoreEntries.add(new Entry(1, fq13h2_score));
        scoreEntries.add(new Entry(2, fq13h3_score));
        scoreEntries.add(new Entry(3, fq13h4_score));
        scoreEntries.add(new Entry(4, fq13h5_score));
        scoreEntries.add(new Entry(5, fq13h6_score));
        scoreEntries.add(new Entry(6, fq13h7_score));
        scoreEntries.add(new Entry(7, fq13h8_score));
        scoreEntries.add(new Entry(8, fq13h9_score));
        scoreEntries.add(new Entry(9, fq13h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesFQ14() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int fq14h1_score = shq14.getInt("fq14_h1_score", 0);
        int fq14h2_score = shq14.getInt("fq14_h2_score", 0);
        int fq14h3_score = shq14.getInt("fq14_h3_score", 0);
        int fq14h4_score = shq14.getInt("fq14_h4_score", 0);
        int fq14h5_score = shq14.getInt("fq14_h5_score", 0);
        int fq14h6_score = shq14.getInt("fq14_h6_score", 0);
        int fq14h7_score = shq14.getInt("fq14_h7_score", 0);
        int fq14h8_score = shq14.getInt("fq14_h8_score", 0);
        int fq14h9_score = shq14.getInt("fq14_h9_score", 0);
        int fq14h10_score = shq14.getInt("fq14_h10_score", 0);

        scoreEntries.add(new Entry(0, fq14h1_score));
        scoreEntries.add(new Entry(1, fq14h2_score));
        scoreEntries.add(new Entry(2, fq14h3_score));
        scoreEntries.add(new Entry(3, fq14h4_score));
        scoreEntries.add(new Entry(4, fq14h5_score));
        scoreEntries.add(new Entry(5, fq14h6_score));
        scoreEntries.add(new Entry(6, fq14h7_score));
        scoreEntries.add(new Entry(7, fq14h8_score));
        scoreEntries.add(new Entry(8, fq14h9_score));
        scoreEntries.add(new Entry(9, fq14h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesFQ15() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int fq15h1_score = shq15.getInt("fq15_h1_score", 0);
        int fq15h2_score = shq15.getInt("fq15_h2_score", 0);
        int fq15h3_score = shq15.getInt("fq15_h3_score", 0);
        int fq15h4_score = shq15.getInt("fq15_h4_score", 0);
        int fq15h5_score = shq15.getInt("fq15_h5_score", 0);
        int fq15h6_score = shq15.getInt("fq15_h6_score", 0);
        int fq15h7_score = shq15.getInt("fq15_h7_score", 0);
        int fq15h8_score = shq15.getInt("fq15_h8_score", 0);
        int fq15h9_score = shq15.getInt("fq15_h9_score", 0);
        int fq15h10_score = shq15.getInt("fq15_h10_score", 0);

        scoreEntries.add(new Entry(0, fq15h1_score));
        scoreEntries.add(new Entry(1, fq15h2_score));
        scoreEntries.add(new Entry(2, fq15h3_score));
        scoreEntries.add(new Entry(3, fq15h4_score));
        scoreEntries.add(new Entry(4, fq15h5_score));
        scoreEntries.add(new Entry(5, fq15h6_score));
        scoreEntries.add(new Entry(6, fq15h7_score));
        scoreEntries.add(new Entry(7, fq15h8_score));
        scoreEntries.add(new Entry(8, fq15h9_score));
        scoreEntries.add(new Entry(9, fq15h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

    private List<Entry> getScoreEntriesFQ16() {
        ArrayList<Entry> scoreEntries = new ArrayList<>();

        int fq16h1_score = shq16.getInt("fq16_h1_score", 0);
        int fq16h2_score = shq16.getInt("fq16_h2_score", 0);
        int fq16h3_score = shq16.getInt("fq16_h3_score", 0);
        int fq16h4_score = shq16.getInt("fq16_h4_score", 0);
        int fq16h5_score = shq16.getInt("fq16_h5_score", 0);
        int fq16h6_score = shq16.getInt("fq16_h6_score", 0);
        int fq16h7_score = shq16.getInt("fq16_h7_score", 0);
        int fq16h8_score = shq16.getInt("fq16_h8_score", 0);
        int fq16h9_score = shq16.getInt("fq16_h9_score", 0);
        int fq16h10_score = shq16.getInt("fq16_h10_score", 0);

        scoreEntries.add(new Entry(0, fq16h1_score));
        scoreEntries.add(new Entry(1, fq16h2_score));
        scoreEntries.add(new Entry(2, fq16h3_score));
        scoreEntries.add(new Entry(3, fq16h4_score));
        scoreEntries.add(new Entry(4, fq16h5_score));
        scoreEntries.add(new Entry(5, fq16h6_score));
        scoreEntries.add(new Entry(6, fq16h7_score));
        scoreEntries.add(new Entry(7, fq16h8_score));
        scoreEntries.add(new Entry(8, fq16h9_score));
        scoreEntries.add(new Entry(9, fq16h10_score));

        Log.i("ScoreEntries","size "+ scoreEntries.size());
        Log.i("ScoreEntriesval", scoreEntries+"");

        return scoreEntries.subList(0, scoreEntries.size()); //5 is the number of entries.
    }

}