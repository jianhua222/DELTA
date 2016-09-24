package com.example.allen.delta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String dateSt="", flightSt="";
    String departureCodeSt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void setDepartureCode(String inputSt){
        departureCodeSt = inputSt;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(departureCodeSt);
    }

    public void getDepartureCode(){
        Flight_States service = Flight_States.retrofit.create(Flight_States.class);

        Call<Flight_States_Class> call = service.getFlight(flightSt, dateSt, getString(R.string.delta_api_key));

        Log.v("ADAM_MCNEILLY", "Call url: " + call.request().url().toString());

        call.enqueue(new Callback<Flight_States_Class>() {
            @Override
            public void onResponse(Call<Flight_States_Class> call, Response<Flight_States_Class> response) {

                Flight_States_Class baseObject = response.body();

                String departureAirportCode = baseObject.getDepartureAirportCode();

                setDepartureCode(departureAirportCode);

                Log.v("ADAM_MCNEILLY", departureAirportCode);
            }

            @Override
            public void onFailure(Call<Flight_States_Class> call, Throwable t) {
                Log.v("ADAM_MCNEILLY", t.getMessage());
            }
        });

        //return departureAirportCode;
    }

    public void clickEvent(View v){
        EditText fightNumberInput = (EditText) findViewById(R.id.flightNumberInput);
        EditText dateInput = (EditText) findViewById(R.id.dateInput);
        dateSt = dateInput.getText().toString();
        flightSt = fightNumberInput.getText().toString();
        Log.v("Allam", dateSt);
        Log.v("Allam", flightSt);
        getDepartureCode();
    }

}
