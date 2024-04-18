package com.example.foodpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BhojOrder extends AppCompatActivity {

    ImageView addorder1,addorder2,addorder3,addorder4,addorder5,addorder6,removeorder1,removeorder2,removeorder3,
            removeorder4,removeorder5,removeorder6;
    TextView  timing,item1,item2,item3,item4,item5,item6,menu1,menu2,menu3,menu4,menu11,menu12,menu13,menu14,
            price1,price2,price3,price4,price5,price6,price7,totalprice;
    Button btn1;
    SwitchCompat lunch,dinner;
    String restroName,cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhoj_order);

        getSupportActionBar().hide();
       Window window=getWindow();
       window.setStatusBarColor(ContextCompat.getColor(this,R.color.mycolor1));

       lunch=findViewById(R.id.lunch);
       dinner=findViewById(R.id.dinner);
       timing=findViewById(R.id.timingtext);
       menu1=findViewById(R.id.menu1);
       menu2=findViewById(R.id.menu2);
       menu3=findViewById(R.id.menu3);
       menu4=findViewById(R.id.menu4);
       menu11=findViewById(R.id.menu11);
       menu12=findViewById(R.id.menu12);
       menu13=findViewById(R.id.menu13);
       menu14=findViewById(R.id.menu14);
       addorder1= findViewById(R.id.additem1);
       addorder2= findViewById(R.id.additem2);
       addorder3= findViewById(R.id.additem3);
       addorder4= findViewById(R.id.additem4);
       addorder5= findViewById(R.id.additem5);
       addorder6=findViewById(R.id.additem6);
       removeorder1=findViewById(R.id.removeitem1);
       removeorder2=findViewById(R.id.removeitem2);
       removeorder3=findViewById(R.id.removeitem3);
       removeorder4=findViewById(R.id.removeitem4);
       removeorder5=findViewById(R.id.removeitem5);
       removeorder6=findViewById(R.id.removeitem6);
       item1= findViewById(R.id.item1);
       item2= findViewById(R.id.item2);
       item3= findViewById(R.id.item3);
       item4= findViewById(R.id.item4);
       item5=findViewById(R.id.item5);
       item6=findViewById(R.id.item6);
       price1=findViewById(R.id.price1);
       price2=findViewById(R.id.price2);
       price3=findViewById(R.id.price3);
       price4=findViewById(R.id.price4);
       price5=findViewById(R.id.price5);
       price6=findViewById(R.id.price6);
       price7=findViewById(R.id.price7);
       totalprice=findViewById(R.id.totalprice);
       btn1=findViewById(R.id.placeorder);

        restroName=getIntent().getStringExtra("name");
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               OrderFragment fragment=new OrderFragment();
               cost=totalprice.getText().toString();
               fragment.putString(restroName,cost);
               fragment.show(getSupportFragmentManager(),fragment.getTag());

           }
       });

       lunch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (lunch.isChecked()) {
                   dinner.setChecked(false);
                   timing.setText("Delivery between 12:00 pm to 1:00 pm");
               }
               else {
                   dinner.setChecked(false);
                   lunch.setChecked(true);
                   timing.setText("Delivery between 12:00 pm to 1:00 pm");
               }
           }
       });

       dinner.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(dinner.isChecked())
               {
                   lunch.setChecked(false);
                   timing.setText("Delivery between 8:00 pm to 9:00 pm");
               }
               else{
                   lunch.setChecked(false);
                   dinner.setChecked(true);
                   timing.setText("Delivery between 8:00 pm to 9:00 pm");
               }
           }
       });

            for(int i=0;i<2;i++) {
                String name=getIntent().getStringExtra("sun1"+i);
                if(i==0) {menu1.setText(name);menu11.setText(name);}
                else {menu2.setText(name);menu12.setText(name);}
            }
            for(int i=0;i<2;i++) {
                String name=getIntent().getStringExtra("sun2"+i);
                if(i==0) {menu3.setText(name);menu13.setText(name);}
                else {menu4.setText(name);menu14.setText(name);}
            }

        addorder1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Integer.parseInt(item1.getText().toString())>=3){
                   int item=Integer.parseInt(item1.getText().toString());
                   item=item+1;
                   item1.setText(Integer.toString(item));
                   int price=Integer.parseInt(price2.getText().toString());
                   price=price+5;
                   price2.setText(Integer.toString(price));
                   totalPriceOrder();
                   removeorder1.setVisibility(View.VISIBLE);
               }
           }
       });
        removeorder1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Integer.parseInt(item1.getText().toString())>=4){
                   int item=Integer.parseInt(item1.getText().toString());
                   item=item-1;
                   item1.setText(Integer.toString(item));
                   int price=Integer.parseInt(price2.getText().toString());
                   price=price-5;
                   price2.setText(Integer.toString(price));
                   totalPriceOrder();
                   if(Integer.parseInt(item1.getText().toString())==3)
                       removeorder1.setVisibility(View.GONE);
               }
           }
       });

        addorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(item2.getText().toString())>=1){
                    int item=Integer.parseInt(item2.getText().toString());
                    item=item+1;
                    item2.setText(Integer.toString(item));
                    int price=Integer.parseInt(price3.getText().toString());
                    price=price+15;
                    price3.setText(Integer.toString(price));
                    totalPriceOrder();
                    removeorder2.setVisibility(View.VISIBLE);
                }
            }
        });
        removeorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item2.getText().toString())>=2){
                    int item=Integer.parseInt(item2.getText().toString());
                    item=item-1;
                    item2.setText(Integer.toString(item));
                    int price=Integer.parseInt(price3.getText().toString());
                    price=price-15;
                    price3.setText(Integer.toString(price));
                    totalPriceOrder();
                    if(Integer.parseInt(item2.getText().toString())==1)
                        removeorder2.setVisibility(View.GONE);
                }
            }
        });

        addorder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item3.getText().toString())>=1){
                    int item=Integer.parseInt(item3.getText().toString());
                    item=item+1;
                    item3.setText(Integer.toString(item));
                    int price=Integer.parseInt(price4.getText().toString());
                    price=price+15;
                    price4.setText(Integer.toString(price));
                    totalPriceOrder();
                    removeorder3.setVisibility(View.VISIBLE);
                }
            }
        });
        removeorder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item3.getText().toString())>=2){
                    int item=Integer.parseInt(item3.getText().toString());
                    item=item-1;
                    item3.setText(Integer.toString(item));
                    int price=Integer.parseInt(price4.getText().toString());
                    price=price-15;
                    price4.setText(Integer.toString(price));
                    totalPriceOrder();
                    if(Integer.parseInt(item3.getText().toString())==1)
                        removeorder3.setVisibility(View.GONE);
                }
            }
        });

        addorder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item4.getText().toString())>=0){
                    int item=Integer.parseInt(item4.getText().toString());
                    item=item+1;
                    item4.setText(Integer.toString(item));
                    int price=Integer.parseInt(price5.getText().toString());
                    price=price+15;
                    price5.setText(Integer.toString(price));
                    totalPriceOrder();
                    removeorder4.setVisibility(View.VISIBLE);
                }
            }
        });
        removeorder4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item4.getText().toString())>=1){
                    int item=Integer.parseInt(item4.getText().toString());
                    item=item-1;
                    item4.setText(Integer.toString(item));
                    int price=Integer.parseInt(price5.getText().toString());
                    price=price-15;
                    price5.setText(Integer.toString(price));
                    totalPriceOrder();
                    if(Integer.parseInt(item4.getText().toString())==0)
                        removeorder4.setVisibility(View.GONE);
                }
            }
        });

        addorder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item5.getText().toString())>=0){
                    int item=Integer.parseInt(item5.getText().toString());
                    item=item+1;
                    item5.setText(Integer.toString(item));
                    int price=Integer.parseInt(price6.getText().toString());
                    price=price+15;
                    price6.setText(Integer.toString(price));
                    totalPriceOrder();
                    removeorder5.setVisibility(View.VISIBLE);
                }
            }
        });
        removeorder5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item5.getText().toString())>=1){
                    int item=Integer.parseInt(item5.getText().toString());
                    item=item-1;
                    item5.setText(Integer.toString(item));
                    int price=Integer.parseInt(price6.getText().toString());
                    price=price-15;
                    price6.setText(Integer.toString(price));
                    totalPriceOrder();
                    if(Integer.parseInt(item5.getText().toString())==0)
                        removeorder5.setVisibility(View.GONE);
                }
            }
        });

        addorder6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item6.getText().toString())>=1){
                    int item=Integer.parseInt(item6.getText().toString());
                    item=item+1;
                    item6.setText(Integer.toString(item));
                    int price=Integer.parseInt(price7.getText().toString());
                    price=price+10;
                    price7.setText(Integer.toString(price));
                    totalPriceOrder();
                    removeorder6.setVisibility(View.VISIBLE);
                }
            }
        });
        removeorder6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(item6.getText().toString())>=2){
                    int item=Integer.parseInt(item6.getText().toString());
                    item=item-1;
                    item6.setText(Integer.toString(item));
                    int price=Integer.parseInt(price7.getText().toString());
                    price=price-10;
                    price7.setText(Integer.toString(price));
                    totalPriceOrder();
                    if(Integer.parseInt(item6.getText().toString())==1)
                        removeorder6.setVisibility(View.GONE);
                }
            }
        });

    }

    private void totalPriceOrder()
    {
        int total = Integer.parseInt(price1.getText().toString()) + Integer.parseInt(price2.getText().toString())
                + Integer.parseInt(price3.getText().toString()) + Integer.parseInt(price4.getText().toString())
                + Integer.parseInt(price5.getText().toString()) + Integer.parseInt(price6.getText().toString())
                + Integer.parseInt(price7.getText().toString());
        totalprice.setText(Integer.toString(total));
    }
}