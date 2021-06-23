package com.example.teacher;

public class uploadPDF {

    public String name;
    public String url;
    String pdfId;

    public uploadPDF() {
    }


    public uploadPDF(String name, String url, String pdfId) {
        this.name = name;
        this.url = url;
        this.pdfId = pdfId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPdfId() {
        return pdfId;
    }

}
