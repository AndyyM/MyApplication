package com.example.andy.myapplication;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Andy on 17/11/2015.
 */
public class CurrencyConverter {
    private String [] countries =  {"AUD","BGN","BRL","CAD","CHF","CNY","CZK","DKK","GBP","HKD","HRK","HUF","ISK","JPY",
            "KRW","MXN","MYR","NOK","NZD","PHP","PLN","RON","RUB","SEK","SGD","THB","TRY","USD","ZAR"};
    private String dataTest1;
    private String dataTest2;
    public String URL_CUR;


    public String[] getCountries(){
        return countries;
    }
    public String getDataTest1(){
        return dataTest1;
    }
    public void setDataTest1(String d1){
        dataTest1=d1;
    }
    public String getDataTest2(){
        return dataTest2;
    }
    public void setDataTest2(String d2){
        dataTest2 = d2;
    }
    public String getURL(){
        return URL_CUR;
    }
    public void setURL(String uL){
        URL_CUR = uL;
    }

    /**
     * Gets the data retrieved from the API as a JSON which we use to pull
     * the rates which we then use to calculate the conversion from one currency to
     * the other.
     * @param tester (array of bytes)
     * @param test1
     * @param test2
     */
    public void test(byte[] tester, EditText test1, TextView test2) {
        try {
            String str = new String(tester, "UTF-8");
            JSONObject jsonObj = new JSONObject(str);
            JSONObject ratesObject = jsonObj
                    .getJSONObject("rates");


            //Double rRate = ratesObject.getDouble(dataTest2);
            Double rRate = ratesObject.getDouble(getDataTest2());

            //Calculation of values from rates pulled from the API.
            Double values = Double.valueOf(test1
                    .getText().toString());
            Double finalCost = values * rRate;
            //Log.d("data", dataTest2);
            Log.d("data", getDataTest2());
            String test12 = String.format("%.2f", finalCost);
            // textValue.setText(dataTest2 + " "
            //       + test1);
            test2.setText(getDataTest2() + " " + test12);

        //catch
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
