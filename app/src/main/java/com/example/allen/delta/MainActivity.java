package com.example.allen.delta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickEvent(View v){
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText inputText = (EditText) findViewById(R.id.inputText);
        textView.setText(inputText.getText());
    }
}
