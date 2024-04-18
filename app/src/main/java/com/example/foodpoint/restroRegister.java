package com.example.foodpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class restroRegister extends AppCompatActivity {

    EditText edit1,edit2;
    Button btn1,btn2;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_register);

        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        btn1= findViewById(R.id.login);
        btn2=findViewById(R.id.register);
        edit1=findViewById(R.id.loginemail);
        edit2=findViewById(R.id.loginpassword);
        mAuth=FirebaseAuth.getInstance();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(restroRegister.this,restroLogin.class);
                startActivity(in);
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }
    private  void loginUser()
    {
        String email=edit1.getText().toString();
        String password=edit2.getText().toString();
        final String[] name = new String[1];
        if(TextUtils.isEmpty(email)){
            edit1.setError("Email cannot be empty");
            edit1.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            edit2.setError("Password cannot be empty");
            edit2.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(restroRegister.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Query qry = databaseReference.child("recycler2");
                        qry.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                        if (snapshot1.child("email").exists() && email.equals(snapshot1.child("email").getValue().toString())) {
                                            name[0] =snapshot1.child("name").getValue().toString();
                                            Intent in=new Intent(restroRegister.this,restroOwner.class);
                                            in.putExtra("name",name[0]);
                                            startActivity(in);
                                            break;
                                        }
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }else{
                        Toast.makeText(restroRegister.this,"Error"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}