package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_b_m_i);

        TextView show_name = (TextView) findViewById(R.id.tv_name);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        TextView show_bmi = (TextView) findViewById(R.id.tv_bmi);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");

        double bmi = Double.parseDouble(w) / (Double.parseDouble(h) / 100 * Double.parseDouble(h) / 100.0);
        DecimalFormat df = new DecimalFormat("#.#");


        String msg="";
        if(bmi<18.5) {
            msg = "體重過輕";
            view1.setImageResource(R.drawable.b1);
        }
        else if(bmi>24){
            msg = "體重過重";
            view1.setImageResource(R.drawable.b2);
        }

        else{
            msg = "體重正常";
            view1.setImageResource(R.drawable.b3);
        }
        show_name.setText(name);
        show_bmi.setText("你的BMI是" + df.format(bmi) +" , " + msg);
    }
}
