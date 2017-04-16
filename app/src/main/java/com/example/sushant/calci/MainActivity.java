package com.example.sushant.calci;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String filename = "config.txt";
        String string = "2,12";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public void add_from_file(View view){
        Context context = getApplicationContext();
        String to_parse = readFromFile(context);

        String delims = "[,]";
        String[] tokens = to_parse.split(delims);

        String num1_raw = tokens[0];
        String num2_raw = tokens[1];

        int num1, num2;

        num1 = Integer.parseInt(num1_raw);
        num2 = Integer.parseInt(num2_raw);

        int answer = num1 + num2;

        TextView answer_view;
        answer_view = (TextView)findViewById(R.id.answer);

        answer_view.setText(String.valueOf(answer));

    }

    public void addition_ui(View view){
        TextView answer_view;
        EditText number1;
        EditText number2;

        number1 = (EditText)findViewById(R.id.number1);
        number2 = (EditText)findViewById(R.id.number2) ;
        answer_view = (TextView)findViewById(R.id.answer);

        int local_num1;
        int local_num2;
        int answer;

        String num1_raw;
        String num2_raw;

        num1_raw = number1.getText().toString();
        num2_raw = number2.getText().toString();

        local_num1 = Integer.parseInt(num1_raw);
        local_num2 = Integer.parseInt(num2_raw);

        Calculator calculator = new Calculator();

        answer = calculator.add(local_num1,local_num2);

        String ans = String.valueOf((int) answer);

        answer_view.setText(ans);
    }

    public void subtract_ui(View view){
        EditText number1;
        EditText number2;
        TextView answer_2;

        number1 = (EditText)findViewById(R.id.number1);
        number2 = (EditText)findViewById(R.id.number2);
        answer_2 = (TextView)findViewById(R.id.answer);

        int local1;
        int local2;

        String num1;
        String num2;

        num1 = number1.getText().toString();
        num2 = number2.getText().toString();

        local1 = Integer.parseInt(num1);
        local2 = Integer.parseInt(num2);

        int answer;

        Calculator calc = new Calculator();
        answer = calc.sub(local1,local2);

        String ans;
        ans = String.valueOf(answer);

        answer_2.setText(ans);
    }

        public void mutiplication_ui(View view)
        {
            TextView answer;
            EditText n1;
            EditText n2;

            n1 = (EditText)findViewById(R.id.number1);
            n2 = (EditText)findViewById(R.id.number2);
            answer = (TextView)findViewById(R.id.answer);

            int l1;
            int l2;

            String no1;
            String no2;

            no1 = n1.getText().toString();
            no2 = n2.getText().toString();

            l1 = Integer.parseInt(no1);
            l2 = Integer.parseInt(no2);

            Calculator calculator = new Calculator();

            int a = calculator.mul(l1,l2);

            String ab;
            ab = String.valueOf(a);

            answer.setText(ab);

        }
        public void divide_ui(View view){

            TextView  answer;
            EditText number1;
            EditText number2;

            number1 = (EditText)findViewById(R.id.number1);
            number2 = (EditText)findViewById(R.id.number2);
            answer = (TextView)findViewById(R.id.answer);

            int loc1;
            int loc2;

            String num1;
            String num2;

            num1 = number1.getText().toString();
            num2 = number2.getText().toString();

            loc1 = Integer.parseInt(num1);
            loc2  = Integer.parseInt(num2);

            Calculator calculator = new Calculator();
            int ans =calculator.div(loc1, loc2);

            String an = String.valueOf(ans);

            answer.setText(an);


    }
}
