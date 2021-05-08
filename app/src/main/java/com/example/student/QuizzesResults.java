package com.example.student;

import android.app.Application;

import java.util.List;

public class QuizzesResults extends Application {

    private List prelim_q1_result;
    private List prelim_q2_result;
    private List prelim_q3_result;
    private List prelim_q4_result;
    private List prelim_q5_result;

    public List getPrelim_q1_result() {
        return prelim_q1_result;
    }

    public void setPrelim_q1_result(List prelim_q1_result) {
        this.prelim_q1_result = prelim_q1_result;
    }

    public List getPrelim_q2_result() {
        return prelim_q2_result;
    }

    public void setPrelim_q2_result(List prelim_q2_result) {
        this.prelim_q2_result = prelim_q2_result;
    }

    public List getPrelim_q3_result() {
        return prelim_q3_result;
    }

    public void setPrelim_q3_result(List prelim_q3_result) {
        this.prelim_q3_result = prelim_q3_result;
    }

    public List getPrelim_q4_result() {
        return prelim_q4_result;
    }

    public void setPrelim_q4_result(List prelim_q4_result) {
        this.prelim_q4_result = prelim_q4_result;
    }

    public List getPrelim_q5_result() {
        return prelim_q5_result;
    }

    public void setPrelim_q5_result(List prelim_q5_result) {
        this.prelim_q5_result = prelim_q5_result;
    }

}
