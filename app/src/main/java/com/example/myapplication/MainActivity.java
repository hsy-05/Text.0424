package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText height;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews() {
        name = (EditText) findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
    }


    public void show(View view) {

        TextView b =(TextView) findViewById(R.id.tv_showbmi);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        String h = height.getText().toString();
        String w = weight.getText().toString();

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

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        b.setText(name.getText().toString() + "，你的BMI是" + df.format(bmi));
    }



    public void nextPage(View view) {
        Bundle bundle = new Bundle();

        bundle.putString("height",height.getText().toString());
        bundle.putString("weight",weight.getText().toString());
        bundle.putString("name",name.getText().toString());

        Intent intent = new Intent(this, ShowBMIActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
