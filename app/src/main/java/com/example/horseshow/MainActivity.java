package com.example.horseshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.horseshow.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendCompName(View view) { // do something withe the response to the button press
        Intent intent = new Intent(this, write_to_txt.class);
        EditText editText = (EditText) findViewById(R.id.EnterHorseComp);
        String competition_name = editText.getText().toString(); //string message of the compitition name
        intent.putExtra(EXTRA_MESSAGE, competition_name);
        startActivity(intent); // start instance of competitor_activity
    }
}
