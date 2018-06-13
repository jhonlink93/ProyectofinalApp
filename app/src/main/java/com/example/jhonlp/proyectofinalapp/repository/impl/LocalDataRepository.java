package com.example.jhonlp.proyectofinalapp.repository.impl;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.jhonlp.proyectofinalapp.repository.ILocalDataRepository;
import com.example.jhonlp.proyectofinalapp.utilities.SharedPreferencesUtil;

import java.util.Map;

/**
 * Created by jhonlp on 09/06/2018.
 */

public class LocalDataRepository implements ILocalDataRepository {

    @Override
    public <T> boolean setData(String key, T value) throws Exception {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (value == null) {
            editor.remove(key);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        }

        return editor.commit();
    }

    @Override
    public <T> T getData(String key, Class<T> type) throws Exception {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        Map<String, Object> preferences = (Map<String, Object>) sharedPreferences.getAll();
        Object value = preferences.get(key);

        try {
            if (value != null) {
                return type.cast(value);
            }
        } catch (RuntimeException rex) {
            Log.e(LocalDataRepository.class.toString(), rex.getMessage());
            throw new Exception(rex);
        }

        return null;
    }

    @Override
    public void clearAllData() {
        SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences();
        sharedPreferences.edit().clear().commit();
    }
}
