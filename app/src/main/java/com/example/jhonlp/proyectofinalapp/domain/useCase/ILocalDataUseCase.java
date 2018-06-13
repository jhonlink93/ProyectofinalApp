package com.example.jhonlp.proyectofinalapp.domain.useCase;


public interface ILocalDataUseCase {

    <T> boolean setData(String key, T value) throws Exception;

    <T> T getData(String key, Class<T> type) throws Exception;

    void clearAllData();
}
