package com.example.foodpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class restroOwner extends AppCompatActivity {

    EditText mon1,mon2,mon3,mon4,tues1,tues2,tues3,tues4,wednes1,wednes2,wednes3,wednes4,thrus1,thrus2,thrus3,thrus4,
            fri1,fri2,fri3,fri4,satur1,satur2,satur3,satur4,sun1,sun2,sun3,sun4;
    Button btn1;
    TextView txt;
     private FirebaseDatabase db=FirebaseDatabase.getInstance();
     private DatabaseReference root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_owner);
        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        String name=getIntent().getStringExtra("name");
        root=db.getReference().child(name);

        txt=findViewById(R.id.name);
        btn1=findViewById(R.id.btnsub);
        mon1=findViewById(R.id.mon1);
        mon2=findViewById(R.id.mon2);
        mon3=findViewById(R.id.mon3);
        mon4=findViewById(R.id.mon4);
        tues1=findViewById(R.id.tues1);
        tues2=findViewById(R.id.tues2);
        tues3=findViewById(R.id.tues3);
        tues4=findViewById(R.id.tues4);
        wednes1=findViewById(R.id.wednes1);
        wednes2=findViewById(R.id.wednes2);
        wednes3=findViewById(R.id.wednes3);
        wednes4=findViewById(R.id.wednes4);
        thrus1=findViewById(R.id.thrus1);
        thrus2=findViewById(R.id.thrus2);
        thrus3=findViewById(R.id.thrus3);
        thrus4=findViewById(R.id.thrus4);
        fri1=findViewById(R.id.fri1);
        fri2=findViewById(R.id.fri2);
        fri3=findViewById(R.id.fri3);
        fri4=findViewById(R.id.fri4);
        satur1=findViewById(R.id.satur1);
        satur2=findViewById(R.id.satur2);
        satur3=findViewById(R.id.satur3);
        satur4=findViewById(R.id.satur4);
        sun1=findViewById(R.id.sun1);
        sun2=findViewById(R.id.sun2);
        sun3=findViewById(R.id.sun3);
        sun4=findViewById(R.id.sun4);

        String name1=getIntent().getStringExtra("name");
        txt.setText(name1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monday1=mon1.getText().toString();
                String monday2=mon2.getText().toString();
                String monday3=mon3.getText().toString();
                String monday4=mon4.getText().toString();
                String tuesday1=tues1.getText().toString();
                String tuesday2=tues2.getText().toString();
                String tuesday3=tues3.getText().toString();
                String tuesday4=tues4.getText().toString();
                String wednesday1=wednes1.getText().toString();
                String wednesday2=wednes2.getText().toString();
                String wednesday3=wednes3.getText().toString();
                String wednesday4=wednes4.getText().toString();
                String thrusday1=thrus1.getText().toString();
                String thrusday2=thrus2.getText().toString();
                String thrusday3=thrus3.getText().toString();
                String thrusday4=thrus4.getText().toString();
                String friday1=fri1.getText().toString();
                String friday2=fri2.getText().toString();
                String friday3=fri3.getText().toString();
                String friday4=fri4.getText().toString();
                String saturday1=satur1.getText().toString();
                String saturday2=satur2.getText().toString();
                String saturday3=satur3.getText().toString();
                String saturday4=satur4.getText().toString();
                String sunday1=sun1.getText().toString();
                String sunday2=sun2.getText().toString();
                String sunday3=sun3.getText().toString();
                String sunday4=sun4.getText().toString();

                HashMap<String,String> map=new HashMap<>();

                if(!monday1.isEmpty())
                map.put("monday1",monday1);
                if(!monday2.isEmpty())
                map.put("monday2",monday2);
                if(!monday3.isEmpty())
                map.put("monday3",monday3);
                if(!monday4.isEmpty())
                map.put("monday4",monday4);
                if(!tuesday1.isEmpty())
                map.put("tuesday1",tuesday1);
                if(!tuesday2.isEmpty())
                map.put("tuesday2",tuesday2);
                if(!tuesday3.isEmpty())
                map.put("tuesday3",tuesday3);
                if(!tuesday4.isEmpty())
                map.put("tuesday4",tuesday4);
                if(!wednesday1.isEmpty())
                map.put("wednesday1",wednesday1);
                if(!wednesday2.isEmpty())
                map.put("wednesday2",wednesday2);
                if(!wednesday3.isEmpty())
                map.put("wednesday3",wednesday3);
                if(!wednesday4.isEmpty())
                map.put("wednesday4",wednesday4);
                if(!thrusday1.isEmpty())
                map.put("thrusday1",thrusday1);
                if(!thrusday2.isEmpty())
                map.put("thrusday2",thrusday2);
                if(!thrusday3.isEmpty())
                map.put("thrusday3",thrusday3);
                if(!thrusday4.isEmpty())
                map.put("thrusday4",thrusday4);
                if(!friday1.isEmpty())
                map.put("friday1",friday1);
                if(!friday2.isEmpty())
                map.put("friday2",friday2);
                if(!friday3.isEmpty())
                map.put("friday3",friday3);
                if(!friday4.isEmpty())
                map.put("friday4",friday4);
                if(!saturday1.isEmpty())
                map.put("saturday1",saturday1);
                if(!saturday2.isEmpty())
                map.put("saturday2",saturday2);
                if(!saturday3.isEmpty())
                map.put("saturday3",saturday3);
                if(!saturday4.isEmpty())
                map.put("saturday4",saturday4);
                if(!sunday1.isEmpty())
                map.put("sunday1",sunday1);
                if(!sunday2.isEmpty())
                map.put("sunday2",sunday2);
                if(!sunday3.isEmpty())
                map.put("sunday3",sunday3);
                if(!sunday4.isEmpty())
                map.put("sunday4",sunday4);
                root.setValue(map);
            }
        });
    }
}