package com.example.teacher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainUpload extends AppCompatActivity {

    Button btn_upload;
    EditText pdfName;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_upload);
        btn_upload = (Button) findViewById(R.id.btn_upload);



        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(MainUpload.this);
                dialog.setContentView(R.layout.upload_pdf_dialog);
                dialog.setCancelable(true);

                final Button button_uploadpdf = (Button) dialog.findViewById(R.id.button_uploadpdf);
                final Button button_done = (Button) dialog.findViewById(R.id.button_done);
                pdfName = (EditText) dialog.findViewById(R.id.pdfName);


                button_uploadpdf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(TextUtils.isEmpty(pdfName.getText().toString())){
                            pdfName.setError("PDF Name is required.");
                        }else{
                            selectPDFFile();
                        }
                    }
                });

                button_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void selectPDFFile() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF File "),1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == 1 && resultCode == RESULT_OK
                && data !=null && data.getData()!=null){


            uploadPDFFile(data.getData());

        }
    }
    private void uploadPDFFile(Uri data) {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading ...");
        progressDialog.show();
        StorageReference reference = storageReference.child("uploads/"+System.currentTimeMillis()+ ".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete());
                        Uri url = uri.getResult();

                        String key = databaseReference.push().getKey();

                        uploadPDF uploadPDF = new uploadPDF(pdfName.getText().toString(),url.toString(), key);
                        databaseReference.child(key).setValue(uploadPDF);
                        Toast.makeText(MainUpload.this,"File Uploaded ",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        dialog.dismiss();


                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {


                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getBytesTransferred();
                progressDialog.setMessage("Uploaded"+ (int)progress+"%");

            }
        });
    }
    public void btn_action(View view) {

        startActivity(new Intent(getApplicationContext(), View_PDF_Files.class));

    }
}
