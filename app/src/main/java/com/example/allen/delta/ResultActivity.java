package com.example.allen.delta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    public static final String WAIT_AVERAGE = "waitAverage";
    //ArrayList<Integer> input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //input =  MainActivity.sum;
        //input = getIntent().getAc //((MainActivity)savedInstanceState).sum;
        //getAverage(input);

        int sum = getIntent().getIntExtra(WAIT_AVERAGE, 0);
        String departureCode = getIntent().getStringExtra("airportCode");

        Log.v("allam", "here?: "+sum);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("The predicted security check in time for "+ departureCode +" airport is "+sum+" mins."+"\n"+"\nThe predicted baggage check in time is 25 mins. "+"\n"+"\nRecommend arive departure airport " +(25+sum+30)+" mins before the filght departure.");
    }
//
//    public void getAverage(ArrayList<Integer> input){
//
//        Log.v("allam", "" + input.size());
//        int counter = 0;
//        int sum = 0;
//            sum =+ input.get(i);
//            counter++;
//        }
//        for(int i = 0 ; i< input.size(); i++){
//        TextView textView = (TextView) findViewById(R.id.textView2);
//        textView.setText((sum/counter));
//
//    }
}
