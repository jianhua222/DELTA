package com.example.allen.delta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flight_States service = Flight_States.retrofit.create(Flight_States.class);

        Call<TestClass> call = service.getFlight("1195", "2016-10-10", getString(R.string.delta_api_key));

        Log.v("ADAM_MCNEILLY", "Call url: " + call.request().url().toString());

        call.enqueue(new Callback<TestClass>() {
            @Override
            public void onResponse(Call<TestClass> call, Response<TestClass> response) {
                TestClass baseObject = response.body();

                String departureAirportCode = baseObject.getDepartureAirportCode();

                Log.v("ADAM_MCNEILLY", departureAirportCode);
            }

            @Override
            public void onFailure(Call<TestClass> call, Throwable t) {
                Log.v("ADAM_MCNEILLY", t.getMessage());
            }
        });
    }

//    public JSONObject testAPI(){
//        HttpPost request = new HttpPost("your url");
//        JSONObject param = new JSONObject();
//        param.put("name", "rarnu");
//        param.put("password", "123456");
//
//        StringEntity se = new StringEntity(param.toString());
//        request.setEntity(se);
//
//        HttpResponse httpResponse = new DefaultHttpClient().execute(request);
//
//        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//
//            String response= EntityUtils.toString(httpResponse.getEntity());
//            JSONObject result = new JSONObject(response);
//            return result;
//        }
//    }
    public void clickEvent(View v){
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText fightNumberInput = (EditText) findViewById(R.id.dateInput);
        EditText dateInput = (EditText) findViewById(R.id.fightNumberInput)
        textView.setText(inputText.getText());
    }
}
