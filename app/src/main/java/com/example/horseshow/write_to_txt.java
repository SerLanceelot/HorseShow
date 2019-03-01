package com.example.horseshow;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class write_to_txt extends AppCompatActivity {

    public EditText editText, textmsg;
    public Button button1;
    public String input;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_to_txt);

        editText = (EditText) findViewById(R.id.editText);
        String message2 = editText.getText().toString();
        //editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        button1 = (Button) findViewById(R.id.enter_button2);
        //button1.setOnClickListener(btnListener);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //capture layout TextVeiw and set the string as its text
        TextView compititon_name = findViewById(R.id.compeitionName2);
        compititon_name.setText(message);
        textmsg=(EditText)findViewById(R.id.editText);
    }

    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout = openFileOutput("people_competiting.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendCompName(View view) { // do something withe the response to the button press
        Intent intent = new Intent(this, competitor_activity.class);
        EditText editText2 = (EditText) findViewById(R.id.EnterHorseComp);
        startActivity(intent); // start instance of competitor_activity
    }

    //private View.OnClickListener btnListener = new View.OnClickListener(){

    //public void onClick1(View v) {

        //input = editText.getText().toString();
        //writeToFile(input,this);
/*
        try {

            writeToFile(input, this);
            FileOutputStream fOut = openFileOutput("people_competiting.txt", MODE_WORLD_READABLE | MODE_APPEND);
            //FileOutputStream fOut = openFileOutput("people_competiting.txt",  MODE_APPEND);
            //PrintStream output = new PrintStream("people_competiting.txt");
            //File file = new File(Environment.getExternalStorageDirectory(), ".txt");

            //OutputStreamWriter writer = new OutputStreamWriter(fOut);
/*
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fOut), true));

            writer.write(input);
            writer.newLine();
            writer.flush();
            writer.close();  * /
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("people_competiting.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}

//}

