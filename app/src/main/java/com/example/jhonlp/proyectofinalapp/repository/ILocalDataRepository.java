package com.example.jhonlp.proyectofinalapp.repository;

/**
 * Created by jhonlp on 09/06/2018.
 */

public interface ILocalDataRepository {

    <T> boolean setData(String key, T value) throws Exception;

    <T> T getData(String key, Class<T> type) throws Exception;

    void clearAllData();

}