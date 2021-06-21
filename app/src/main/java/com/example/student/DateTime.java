package com.example.student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTime {

    public String getDate(){
        String currentDate = new SimpleDateFormat("MMM-dd-YY", Locale.getDefault()).format(new Date());
        return currentDate;
    }
}
