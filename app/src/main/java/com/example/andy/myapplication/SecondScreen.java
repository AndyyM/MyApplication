package com.example.andy.myapplication;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Andy on 14/11/2015.
 */
public class SecondScreen extends Activity {

    String [] countries =  {"AUD","BGN","BRL","CAD","CHF","CNY","CZK","DKK","GBP","HKD","HRK","HUF","ISK","JPY",
            "KRW","MXN","MYR","NOK","NZD","PHP","PLN","RON","RUB","SEK","SGD","THB","TRY","USD","ZAR"};
    private String dataTest1;
    private String dataTest2;
    public String URL_CUR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Button convert = (Button) findViewById(R.id.button2);
        final EditText writeValue = (EditText) findViewById(R.id.editText2);
        final TextView textValue = (TextView) findViewById(R.id.textView);

        final Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                int currency_value = spinner.getSelectedItemPosition();
                dataTest1 = countries[currency_value];
                URL_CUR = "http://api.fixer.io/latest?base=" + dataTest1;
                Log.d("tester:" , URL_CUR);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                int currency_value = spinner2.getSelectedItemPosition();
                dataTest2 = countries[currency_value];
                Log.d("test", countries[currency_value]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        convert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!writeValue.getText().toString().equals("")) {
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.get(URL_CUR, new AsyncHttpResponseHandler() {

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                           Log.d("test", "why");
                            }

                            @Override
                            public void onStart() {
                                // TODO Auto-generated method stub
                                super.onStart();
                            }


                            @Override
                            public void onFinish() {
                                // TODO Auto-generated method stub
                                super.onFinish();
                            }


                            @Override
                            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                Log.i("Testing", "HTTP Success");

                                try {
                                    String str = new String(responseBody, "UTF-8");
                                    JSONObject jsonObj = new JSONObject(str);
                                    JSONObject ratesObject = jsonObj
                                            .getJSONObject("rates");


                                    Double rRate = ratesObject.getDouble(dataTest2);


                                    Double values = Double.valueOf(writeValue
                                            .getText().toString());
                                     Double finalCost = values *rRate;
                                    Log.d("data", dataTest2);
                                    String test1 = String.format("%.2f",finalCost);
                                    textValue.setText(dataTest2 + " "
                                            + test1);


                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Please enter a value",
                                Toast.LENGTH_LONG).show();

                    }

                }
            });


            }
        }












