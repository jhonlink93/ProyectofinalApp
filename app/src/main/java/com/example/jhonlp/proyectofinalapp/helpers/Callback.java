package com.example.jhonlp.proyectofinalapp.helpers;

/**
 * Created by jhonlp on 09/06/2018.
 */

public interface Callback<T> {
    void success(T result);

    void error(Exception error);
}

