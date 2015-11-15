package com.example.andy.myapplication.Data;

/**
 * Created by Andy on 15/11/2015.
 */
public class CurrencyObject {
    private String base;
    private String date;
    private String rates;

    public CurrencyObject(String base, String date, String rates){
        this.base= base;
        this.date = date;
        this.rates =rates;
    }
    public String getBase(){
        return base;
    }
    public void setBase(String base){
        this.base = base;
    }
    public String getDate(String date) {
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getRates(){
        return rates;
    }
    public void setRates(String rates){
        this.rates = rates;
    }



}
