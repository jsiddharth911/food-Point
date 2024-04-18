package com.example.foodpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class restroDetails extends AppCompatActivity {


    EditText name1,price1,unique1;
    Button btn;
    ImageView image;
    ProgressBar progressBar;
    private Uri imageUri;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("recycler2");
    private StorageReference reference= FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_details);

        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        progressBar=findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        image=findViewById(R.id.imageupload);
        name1=findViewById(R.id.resname);
        price1=findViewById(R.id.mincost);
        unique1=findViewById(R.id.unique);
        btn=findViewById(R.id.subdetails);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent=new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,2);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageUri!=null){
                    uploadToFirebase(imageUri);

                }else{
                    Toast.makeText(restroDetails.this, "Please Select Image", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2 && resultCode==RESULT_OK && data !=null)
        {
            imageUri=data.getData();
            image.setImageURI(imageUri);
        }
    }

    private void  uploadToFirebase(Uri uri)
    {
        StorageReference fileref=reference.child(System.currentTimeMillis()+"."+getFileExtension(uri));
        fileref.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String email=getIntent().getStringExtra("email");
                        String name=name1.getText().toString();
                        String price=price1.getText().toString();
                        String unique=unique1.getText().toString();
                        if(!price.isEmpty())
                        price="Rs- "+price+" for one";

                        modalUploadImage model=new modalUploadImage(uri.toString(),email,name,price,unique);

                        if(!name.isEmpty() && !unique.isEmpty() && !price.isEmpty()) {
                            root.child(name).setValue(model);
                            Intent in=new Intent(restroDetails.this,restroOwner.class);
                            in.putExtra("name",name);
                            startActivity(in);
                            finish();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                        else {
                            Toast.makeText(restroDetails.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(restroDetails.this, "Uploading failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri mUri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mine=MimeTypeMap.getSingleton();
        return mine.getMimeTypeFromExtension(cr.getType(mUri));
    }
}