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

public class restroLogin extends AppCompatActivity {

    EditText edit1,edit2;
    Button btn1;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_login);

        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        edit1=findViewById(R.id.emailRestro);
        edit2=findViewById(R.id.passwordRestro);
        btn1=findViewById(R.id.btnRegister);

        mAuth=FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser()
    {
        String email=edit1.getText().toString();
        String password=edit2.getText().toString();

        if(TextUtils.isEmpty(email)){
            edit1.setError("Email cannot be empty");
            edit1.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            edit2.setError("Password cannot be empty");
            edit2.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(restroLogin.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                        Intent in =new Intent(restroLogin.this,restroDetails.class);
                        in.putExtra("email",email);
                        startActivity(in);

                        finish();
                    }else{
                        Toast.makeText(restroLogin.this,"Error"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}