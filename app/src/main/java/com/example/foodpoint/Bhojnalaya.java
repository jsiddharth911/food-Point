package com.example.foodpoint;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Bhojnalaya extends AppCompatActivity {

    ImageView img1,cartbhoj;
    TextView addItem;
    ConstraintLayout monday,tuesday,wednesday,thrusday,friday,saturday,sunday;
    Button up1,up2,up3,up4,up5,up6,up7,add1,add2,add3,add4,add5,add6,add7;
    CheckBox wednesday1,wednesday2,wednesday3,wednesday4,friday1,friday2,friday3,friday4,saturday1,saturday2,saturday3,saturday4,
            sunday1,sunday2,sunday3,sunday4,monday1,monday2,monday3,monday4,tuesday1,tuesday2,tuesday3,tuesday4,thrusday1,
              thrusday2,thrusday3,thrusday4;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String name;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhojnalaya);

        getSupportActionBar().hide();
        Window window=getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

        name=getIntent().getStringExtra("name");
        Log.d("<><><><>",name);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        initialize2();

        monday=findViewById(R.id.monday);
        up1=findViewById(R.id.arrow_up);
        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(monday.getVisibility()==View.GONE)
                {
                    monday.setVisibility(View.VISIBLE);
                    up1.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    monday.setVisibility(View.GONE);
                    up1.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        tuesday=findViewById(R.id.tuesday);
        up2=findViewById(R.id.arrow_up2);
        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tuesday.getVisibility()==View.GONE)
                {
                    tuesday.setVisibility(View.VISIBLE);
                    up2.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    tuesday.setVisibility(View.GONE);
                    up2.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        wednesday=findViewById(R.id.wednesday);
        up3=findViewById(R.id.arrow_up3);
        up3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wednesday.getVisibility()==View.GONE)
                {
                    wednesday.setVisibility(View.VISIBLE);
                    up3.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    wednesday.setVisibility(View.GONE);
                    up3.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        thrusday=findViewById(R.id.thrusday);
        up4=findViewById(R.id.arrow_up4);
        up4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thrusday.getVisibility()==View.GONE)
                {
                    thrusday.setVisibility(View.VISIBLE);
                    up4.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    thrusday.setVisibility(View.GONE);
                    up4.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        friday=findViewById(R.id.friday);
        up5=findViewById(R.id.arrow_up5);
        up5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friday.getVisibility()==View.GONE)
                {
                    friday.setVisibility(View.VISIBLE);
                    up5.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    friday.setVisibility(View.GONE);
                    up5.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        saturday=findViewById(R.id.saturday);
        up6=findViewById(R.id.arrow_up6);
        up6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saturday.getVisibility()==View.GONE)
                {
                    saturday.setVisibility(View.VISIBLE);
                    up6.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    saturday.setVisibility(View.GONE);
                    up6.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        sunday=findViewById(R.id.sunday);
        up7=findViewById(R.id.arrow_up7);
        up7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sunday.getVisibility()==View.GONE)
                {
                    sunday.setVisibility(View.VISIBLE);
                    up7.setBackgroundResource(R.drawable.ic_drop_up);
                }else{
                    sunday.setVisibility(View.GONE);
                    up7.setBackgroundResource(R.drawable.ic_drop_down);
                }
            }
        });

        final ArrayList<String> sun1=new ArrayList<>();
        final ArrayList<String> sun2=new ArrayList<>();
        addItem=findViewById(R.id.add_item);
        add1=findViewById(R.id.addbtn1);
        add2=findViewById(R.id.addbtn2);
        add3=findViewById(R.id.addbtn3);
        add4=findViewById(R.id.addbtn4);
        add5=findViewById(R.id.addbtn5);
        add6=findViewById(R.id.addbtn6);
        add7=findViewById(R.id.addbtn7);
        monday1=findViewById(R.id.monday1);
        monday2=findViewById(R.id.monday2);
        monday3=findViewById(R.id.monday3);
        monday4=findViewById(R.id.monday4);
        tuesday1=findViewById(R.id.tuesday1);
        tuesday2=findViewById(R.id.tuesday2);
        tuesday3=findViewById(R.id.tuesday3);
        tuesday4=findViewById(R.id.tuesday4);
        wednesday1=findViewById(R.id.wednesday1);
        wednesday2=findViewById(R.id.wednesday2);
        wednesday3=findViewById(R.id.wednesday3);
        wednesday4=findViewById(R.id.wednesday4);
        thrusday1=findViewById(R.id.thrusday1);
        thrusday2=findViewById(R.id.thrusday2);
        thrusday3=findViewById(R.id.thrusday3);
        thrusday4=findViewById(R.id.thrusday4);
        friday1=findViewById(R.id.friday1);
        friday2=findViewById(R.id.friday2);
        friday3=findViewById(R.id.friday3);
        friday4=findViewById(R.id.friday4);
        saturday1=findViewById(R.id.saturday1);
        saturday2=findViewById(R.id.saturday2);
        saturday3=findViewById(R.id.saturday3);
        saturday4=findViewById(R.id.saturday4);
        sunday1=findViewById(R.id.sunday1);
        sunday2=findViewById(R.id.sunday2);
        sunday3=findViewById(R.id.sunday3);
        sunday4=findViewById(R.id.sunday4);
        Calendar calendar=Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
//<><><><><><><><><><><><><><><><><><><><><><><><>monday<><><><><><><><><><><><><><><><><><>monday<><><><><><><><><><><><><><><><><><>
        final int[] count1 = {0};
        CheckBox[] chkBoxs1;
        int i1=0;
        Integer[] chkBoxId1={R.id.monday1,R.id.monday2,R.id.monday3,R.id.monday4};
        chkBoxs1=new CheckBox[chkBoxId1.length];
        while (i1 < 4) {
            chkBoxs1[i1] = (CheckBox) findViewById(chkBoxId1[i1]);
            chkBoxs1[i1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count1[0]++;
                    if (!b)
                        count1[0]--;
                }
            });  i1++;
        }add1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.MONDAY)
                    {
                        Toast.makeText(getApplicationContext(), "Today is not Monday", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(count1[0]==2) {
                            for(int i=0;i<4;i++) {
                                if(chkBoxs1[i].isChecked())
                                    sun1.add(chkBoxs1[i].getText().toString());
                            }
                            for(int i=0;i<4;i++){
                                if(!chkBoxs1[i].isChecked())
                                    sun2.add(chkBoxs1[i].getText().toString());
                            }
                            addItem.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><><><><><><><><><><>tuesday<><><><><><><><><><><><><><><><><><>tuesday<><><><><><><><><><><><><><><><><><><><><><><><>
        final int[] count2 = {0};
        CheckBox[] chkBoxs2;
        int i2=0;
        Integer[] chkBoxId2={R.id.tuesday1,R.id.tuesday2,R.id.tuesday3,R.id.tuesday4};
        chkBoxs2=new CheckBox[chkBoxId2.length];
        while (i2 < 4) {
            chkBoxs2[i2] = (CheckBox) findViewById(chkBoxId2[i2]);
            chkBoxs2[i2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count2[0]++;
                    if (!b)
                        count2[0]--;
                }
            });  i2++;
        }add2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.TUESDAY)
                        Toast.makeText(getApplicationContext(), "Today is not Tuesday", Toast.LENGTH_SHORT).show();
                    else {
                        if(count2[0]==2) {
                            for(int i=0;i<4;i++) {
                                if(chkBoxs2[i].isChecked())
                                    sun1.add(chkBoxs2[i].getText().toString());
                            }
                            for(int i=0;i<4;i++){
                                if(!chkBoxs2[i].isChecked())
                                    sun2.add(chkBoxs2[i].getText().toString());
                            }
                            addItem.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><><><><><><><><><><>wednesday<><><><><><><><><><><><><><><><><><wednesday<><><><><><><><><><><><><><><><><><><>
        final int[] count3 = {0};
        CheckBox[] chkBoxs3;
        int i3=0;
        Integer[] chkBoxId3={R.id.wednesday1,R.id.wednesday2,R.id.wednesday3,R.id.wednesday4};
        chkBoxs3=new CheckBox[chkBoxId3.length];
        while (i3 < 4) {
            chkBoxs3[i3] = (CheckBox) findViewById(chkBoxId3[i3]);
            chkBoxs3[i3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count3[0]++;
                    if (!b)
                        count3[0]--;
                }
            });  i3++;
        }add3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.WEDNESDAY)
                        Toast.makeText(getApplicationContext(), "Today is not Wednesday", Toast.LENGTH_SHORT).show();
                    else {
                             if(count3[0]==2) {
                                 for(int i=0;i<4;i++) {
                                     if(chkBoxs3[i].isChecked())
                                         sun1.add(chkBoxs3[i].getText().toString());
                                 }
                                 for(int i=0;i<4;i++){
                                     if(!chkBoxs3[i].isChecked())
                                         sun2.add(chkBoxs3[i].getText().toString());
                                 }
                                 addItem.setVisibility(View.VISIBLE);
                                 Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                             }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><><><><><><><><><><>thrusday<><><><><><><><><><><><><><><><><><>thrusday<><><><><><><><><><><><><><><><><><><>
        final int[] count4 = {0};
        CheckBox[] chkBoxs4;
        int i4=0;
        Integer[] chkBoxId4={R.id.thrusday1,R.id.thrusday2,R.id.thrusday3,R.id.thrusday4};
        chkBoxs4=new CheckBox[chkBoxId4.length];
        while (i4 < 4) {
            chkBoxs4[i4] = (CheckBox) findViewById(chkBoxId4[i4]);
            chkBoxs4[i4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count4[0]++;
                    if (!b)
                        count4[0]--;
                }
            });  i4++;
        } add4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.THURSDAY)
                        Toast.makeText(getApplicationContext(), "Today is not Thrusday", Toast.LENGTH_SHORT).show();
                    else {
                        if(count4[0]==2) {
                            for(int i=0;i<4;i++) {
                                if(chkBoxs4[i].isChecked())
                                    sun1.add(chkBoxs4[i].getText().toString());
                            }
                            for(int i=0;i<4;i++){
                                if(!chkBoxs4[i].isChecked())
                                    sun2.add(chkBoxs4[i].getText().toString());
                            }
                            addItem.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><><><><><><><><><>friday<><><><><><><><><><><><><><><><><>friday<><><><><><<><><><><><><><><><><><><><><><>
        final int[] count5 = {0};
        CheckBox[] chkBoxs5;
        int i5=0;
        Integer[] chkBoxId5={R.id.friday1,R.id.friday2,R.id.friday3,R.id.friday4};
        chkBoxs5=new CheckBox[chkBoxId5.length];
        while (i5 < 4) {
            chkBoxs5[i5] = (CheckBox) findViewById(chkBoxId5[i5]);
            chkBoxs5[i5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count5[0]++;
                    if (!b)
                        count5[0]--;
                }
            });  i5++;
        } add5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.FRIDAY)
                        Toast.makeText(getApplicationContext(), "Today is not Friday", Toast.LENGTH_SHORT).show();
                    else {
                        if(count5[0]==2) {
                            for(int i=0;i<4;i++) {
                                if(chkBoxs5[i].isChecked())
                                    sun1.add(chkBoxs5[i].getText().toString());
                            }
                            for(int i=0;i<4;i++){
                                if(!chkBoxs5[i].isChecked())
                                    sun2.add(chkBoxs5[i].getText().toString());
                            }
                            addItem.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><><><><><><><><>saturday<><><><><><><><><><><><><><>saturday<><><><><><><><><><><><><><><><><><><><><><><><><>
        final int[] count6 = {0};
           CheckBox[] chkBoxs6;
           int i6=0;
           Integer[] chkBoxId6={R.id.saturday1,R.id.saturday2,R.id.saturday3,R.id.saturday4};
            chkBoxs6=new CheckBox[chkBoxId6.length];
                while (i6 < 4) {
                    chkBoxs6[i6] = (CheckBox) findViewById(chkBoxId6[i6]);
                    chkBoxs6[i6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b)
                                count6[0]++;
                            if (!b)
                                count6[0]--;
                        }
                    });  i6++;
                }  add6.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          if (day != Calendar.SATURDAY)
                              Toast.makeText(getApplicationContext(), "Today is not Saturday", Toast.LENGTH_SHORT).show();
                          else {
                              if(count6[0]==2) {
                                  for(int i=0;i<4;i++) {
                                      if(chkBoxs6[i].isChecked())
                                          sun1.add(chkBoxs6[i].getText().toString());
                                  }
                                  for(int i=0;i<4;i++){
                                      if(!chkBoxs6[i].isChecked())
                                          sun2.add(chkBoxs6[i].getText().toString());
                                  }
                                  addItem.setVisibility(View.VISIBLE);
                                  Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                              }
                              else
                                  Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                          }
                      }
                  });
//<><><><><><><><><><><><><><>sunday<><><><><><><><><>sunday<><><><><><><><><><><>sunday<><><><><><><><><><><><><><><><><><><><><>
        final int[] count7 = {0};
        CheckBox[] chkBoxs7;
        int i7=0;
        Integer[] chkBoxId7={R.id.sunday1,R.id.sunday2,R.id.sunday3,R.id.sunday4};
        chkBoxs7=new CheckBox[chkBoxId7.length];
        while (i7 < 4) {
            chkBoxs7[i7] = (CheckBox) findViewById(chkBoxId7[i7]);
            chkBoxs7[i7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        count7[0]++;
                    if (!b)
                        count7[0]--;
                }
            });  i7++;
        }add7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(day!=Calendar.SUNDAY)
                        Toast.makeText(getApplicationContext(), "Today is not Sunday", Toast.LENGTH_SHORT).show();
                    else {
                        if(count7[0]==2) {
                            for(int i=0;i<4;i++) {
                                if(chkBoxs7[i].isChecked())
                                    sun1.add(chkBoxs7[i].getText().toString());
                            }
                            for(int i=0;i<4;i++){
                                if(!chkBoxs7[i].isChecked())
                                    sun2.add(chkBoxs7[i].getText().toString());
                            }
                            addItem.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Your order add in your cart", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "You have to choose two items", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//<><><><><><><><><>end<><><><><><><><><>end<><><><><><>end<><><><><><>end<><><><><><>end<><><><><><>ebd<><><><><><>end<><><><><><>
        img1=(ImageView)findViewById(R.id.back);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Bhojnalaya.this,Home.class);
                startActivity(in);
                finish();
            }
        });

        cartbhoj=(ImageView) findViewById(R.id.cartbhoj);
        cartbhoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addItem.getVisibility()==View.VISIBLE)
                {
                    Intent in=new Intent(Bhojnalaya.this,BhojOrder.class);
                    for(int i=0;i<sun1.size();i++)
                        in.putExtra("sun1"+i,sun1.get(i));
                    for(int i=0;i<sun2.size();i++)
                        in.putExtra("sun2"+i,sun2.get(i));

                    in.putExtra("name",name);
                    startActivity(in);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(), "Sorry! you don't add any order in your cart", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initialize2() {
       // String name=getIntent().getStringExtra("name");
        Query qry = databaseReference.child(name);
        qry.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        if(snapshot1.getKey().equals("monday1"))
                            monday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("monday2"))
                            monday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("monday3"))
                            monday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("monday4"))
                            monday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("tuesday1"))
                            tuesday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("tuesday2"))
                            tuesday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("tuesday3"))
                            tuesday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("tuesday4"))
                            tuesday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("wednesday1"))
                            wednesday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("wednesday2"))
                            wednesday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("wednesday3"))
                            wednesday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("wednesday4"))
                            wednesday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("thrusday1"))
                            thrusday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("thrusday2"))
                            thrusday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("thrusday3"))
                            thrusday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("thrusday4"))
                            thrusday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("friday1"))
                            friday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("friday2"))
                            friday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("friday3"))
                            friday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("friday4"))
                            friday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("saturday1"))
                            saturday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("saturday2"))
                            saturday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("saturday3"))
                            saturday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("saturday4"))
                            saturday4.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("sunday1"))
                            sunday1.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("sunday2"))
                            sunday2.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("sunday3"))
                            sunday3.setText(snapshot1.getValue().toString());
                        if(snapshot1.getKey().equals("sunday4"))
                            sunday4.setText(snapshot1.getValue().toString());

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
