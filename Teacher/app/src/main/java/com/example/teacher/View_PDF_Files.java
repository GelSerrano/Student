package com.example.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_PDF_Files extends AppCompatActivity {
    ListView myPDfListView;


    DatabaseReference databaseReference;
    List<uploadPDF> uploadPDFS;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__p_d_f__files);      myPDfListView = (ListView) findViewById(R.id.myListView);
        uploadPDFS = new ArrayList<>();

        progressDialog = new ProgressDialog(View_PDF_Files.this);

        viewAllFiles();


        myPDfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final uploadPDF uploadPDF = uploadPDFS.get(position);

                new AlertDialog.Builder(View_PDF_Files.this)
                        .setTitle(uploadPDF.getName())
                        .setMessage("What do you want to do with this file?")

                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setData(Uri.parse(uploadPDF.getUrl()));
                                startActivity(intent);
                            }
                        })

                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                progressDialog.setMessage("Deleting...");
                                progressDialog.show();

                                databaseReference = FirebaseDatabase.getInstance().getReference("uploads").child(uploadPDF.getPdfId());
                                databaseReference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressDialog.dismiss();

                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);

                                        Toast.makeText(View_PDF_Files.this, "File deleted.", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();






            }
        });

    }

    private void viewAllFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){


                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.teacher.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);

                }

                String[] uploads = new String[uploadPDFS.size()];

                for (int i=0;i<uploads.length;i++){
                    uploads[i] = uploadPDFS.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploads){


                    @Override
                    public View getView(int position, View convertView,  ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);

                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);





                        return view;
                    }
                };
                myPDfListView.setAdapter(adapter);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
