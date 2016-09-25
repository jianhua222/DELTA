package com.example.allen.delta;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.List;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String dateSt = "", flightSt = "";
    String departureCodeSt = "";
    //public static ArrayList<Integer> sum = new ArrayList<>();
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tryButtonClick();


    }

    public void setDepartureCode(String inputSt) {
        departureCodeSt = inputSt;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(departureCodeSt);
    }

    public int getTimeFromWaitTime(String inputSt) {
        int res = 0;
        String st = "";
        int index = inputSt.indexOf('+');
        if (index == -1)
            index = inputSt.indexOf(' ');
        //Log.v("allam", ""+index);
        for (int i = index - 1; i >= 0; i--) {
            if (inputSt.charAt(i) >= '0' && inputSt.charAt(i) <= '9') {
                st = inputSt.charAt(i) + st;
                //Log.v("allam", st);
            } else break;
        }
        //Log.v("allam", st);
        res = Integer.parseInt(st);
        return res;
    }

    public void getTSATime() {
        TSA service = TSA.retrofit.create(TSA.class);

        Call<TSA_Class> call = service.getFlight(departureCodeSt, getString(R.string.delta_api_key));

        Log.v("allam", "Call url: " + call.request().url());
        call.enqueue(new Callback<TSA_Class>() {
            @Override
            public void onResponse(Call<TSA_Class> call, Response<TSA_Class> response) {

                TSA_Class baseObject = response.body();
                List<TSA_Class.waitTime> list = baseObject.getWaitTime();

                for (int i = 0; i < list.size(); i++) {


                    //Log.v("allam", list.get(i).getWaittime());
                    Integer t = getTimeFromWaitTime((list.get(i).getWaittime()));
                    sum += t;
                    //sum.add(t);
                    //Log.v("allam", "" + t);
                }
                sum = sum / list.size();
                Log.v("allam", ""+sum);

                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                resultIntent.putExtra("airportCode", departureCodeSt);
                resultIntent.putExtra(ResultActivity.WAIT_AVERAGE, sum);
                Log.v("allam", ""+sum);
                startActivity(resultIntent);
            }

            @Override
            public void onFailure(Call<TSA_Class> call, Throwable t) {
                Log.v("allam", t.getMessage());
            }
        });
    }

    public void getDepartureCode() {
        Flight_States service = Flight_States.retrofit.create(Flight_States.class);

        Call<Flight_States_Class> call = service.getFlight(flightSt, dateSt, getString(R.string.delta_api_key));

        Log.v("ADAM_MCNEILLY", "Call url: " + call.request().url().toString());

        call.enqueue(new Callback<Flight_States_Class>() {
            @Override
            public void onResponse(Call<Flight_States_Class> call, Response<Flight_States_Class> response) {

                Flight_States_Class baseObject = response.body();

                String departureAirportCode = baseObject.getDepartureAirportCode();

                setDepartureCode(departureAirportCode);
                getTSATime();
                Log.v("ADAM_MCNEILLY", departureAirportCode);
            }

            @Override
            public void onFailure(Call<Flight_States_Class> call, Throwable t) {
                Log.v("ADAM_MCNEILLY", t.getMessage());
            }
        });

        //return departureAirportCode;
    }

    public void clickEvent(View v) {
        EditText fightNumberInput = (EditText) findViewById(R.id.flightNumberInput);
        EditText dateInput = (EditText) findViewById(R.id.dateInput);
        dateSt = dateInput.getText().toString();
        flightSt = fightNumberInput.getText().toString();
        Log.v("Allam", dateSt);
        Log.v("Allam", flightSt);
        getDepartureCode();
    }

    public void tryButtonClick() {
        Button click = (Button) findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
