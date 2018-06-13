package com.example.jhonlp.proyectofinalapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesUtil {

    private static Context context;
    private static SharedPreferences sp;

    public static void init(Context context) {
        SharedPreferencesUtil.context = context;
    }

    public static SharedPreferences getSharedPreferences() {
        if (sp == null) {
            sp = context.getSharedPreferences(Constant.MY_SHARED_PREF, Context.MODE_PRIVATE);
        }
        return sp;
    }
}


