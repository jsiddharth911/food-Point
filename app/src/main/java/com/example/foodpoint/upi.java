package com.example.foodpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class upi extends AppCompatActivity implements PaymentResultListener {

    String cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);

        Checkout.preload(getApplicationContext());

        cost=getIntent().getStringExtra("cost");
        payment(cost);
    }

    private void payment(String amount) {
        final Activity activity=this;

        Checkout checkout=new Checkout();
        checkout.setKeyID("rzp_test_7SVXHED5fxYYQC");

        double finalAmount=Float.parseFloat(amount)*100;

        try{
            JSONObject options=new JSONObject();
            options.put("name", "Food Point");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
           // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", finalAmount);//pass amount in currency subunits
            options.put("prefill.email", "jainharshit775.com");
            options.put("prefill.contact","7249955562");


            checkout.open(activity, options);
        }catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "successfull", Toast.LENGTH_LONG).show();
        Intent in =new Intent(upi.this,Home.class);
        startActivity(in);
        finish();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
        Intent in =new Intent(upi.this,BhojOrder.class);
        startActivity(in);
        finish();
    }
}