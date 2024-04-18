package com.example.foodpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView1,recyclerView2;
    adapter1 adap1;
    adapter2 adap2;
    List<modal1> list;
    CardView card;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView textView1;
    ArrayList<modal2>mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        textView1=findViewById(R.id.list2_txt4);

        firebaseDatabase = FirebaseDatabase.getInstance();
       databaseReference = firebaseDatabase.getReference();
        mList=new ArrayList<modal2>();

        card=findViewById(R.id.card_home1);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Home.this,Bhojnalaya.class);
                String bhoj="bhoj";
                in.putExtra("name",bhoj);
                startActivity(in);
                finish();
            }
        });

        recyclerView1=findViewById(R.id.recycler1);
        recyclerView1.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);

        adapter1 adap1=new adapter1(list);
        initializeData();
        initializeAdapter();

        recyclerView2=findViewById(R.id.recycler2);
        recyclerView2.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        initialize2();

    }

    private  void initializeData()
    {
        list=new ArrayList<>();
        list.add(new modal1("pizza",R.drawable.pizza));
        list.add(new modal1("momos",R.drawable.momos));
        list.add(new modal1("burger",R.drawable.burger));
        list.add(new modal1("noodles",R.drawable.noodles));
        list.add(new modal1("biryani",R.drawable.biryani));
        list.add(new modal1("cakes",R.drawable.cake));
        list.add(new modal1("salad",R.drawable.salad));
        list.add(new modal1("combos",R.drawable.thali));
    }
    private void initializeAdapter(){
        adapter1 adap1=new adapter1(list);
        recyclerView1.setAdapter(adap1);
    }

    private void initialize2() {
        Query qry = databaseReference.child("recycler2");
        qry.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        modal2 obj = new modal2();
                        if(snapshot1.child("image").exists())
                        obj.setImage(snapshot1.child("image").getValue().toString());

                        if(snapshot1.child("name").exists())
                        obj.setName(snapshot1.child("name").getValue().toString());

                        if(snapshot1.child("rating").exists())
                        obj.setRating(snapshot1.child("rating").getValue().toString());

                        if(snapshot1.child("price").exists())
                        obj.setPrice(snapshot1.child("price").getValue().toString());

                        if(snapshot1.child("unique").exists()) {
                            obj.setUnique(snapshot1.child("unique").getValue().toString());
                        }
                        mList.add(obj);
                    }
                } else {
                    Toast.makeText(Home.this, "not", Toast.LENGTH_SHORT).show();
                }
                adapter2 ob = new adapter2(Home.this, mList);
                recyclerView2.setAdapter(ob);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}