package com.example.jhonlp.proyectofinalapp;

import android.app.Application;
import android.util.Log;

import com.example.jhonlp.proyectofinalapp.utilities.SharedPreferencesUtil;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        SharedPreferencesUtil.init(getApplicationContext());


    }
}

