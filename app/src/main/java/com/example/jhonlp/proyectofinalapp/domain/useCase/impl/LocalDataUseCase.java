package com.example.jhonlp.proyectofinalapp.domain.useCase.impl;

import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.repository.ILocalDataRepository;
import com.example.jhonlp.proyectofinalapp.repository.impl.LocalDataRepository;


public class LocalDataUseCase implements ILocalDataUseCase {

    private ILocalDataRepository localDataRepository;

    public LocalDataUseCase() {
        this.localDataRepository = new LocalDataRepository();
    }

    @Override
    public <T> boolean setData(String key, T value) throws Exception {
        return localDataRepository.setData(key, value);
    }

    @Override
    public <T> T getData(String key, Class<T> type) throws Exception {
        return localDataRepository.getData(key, type);
    }

    @Override
    public void clearAllData() {
        localDataRepository.clearAllData();
    }
}
