package com.example.jhonlp.proyectofinalapp.presentation.presenter;

import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.LocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.UserUseCase;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;

/**
 * Created by Paola on 19/06/2018.
 */

public class RecoverPasswordPresenter implements RecoverPasswordContract.UserActionListener {


    private RecoverPasswordContract.View view;
    private ILocalDataUseCase localDataUseCase;
    private UserUseCase userUseCase;


    public RecoverPasswordPresenter(RecoverPasswordContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
        this.userUseCase = new UserUseCase();
    }

    @Override
    public void onRecover(String email) {

        userUseCase.recoveryPassword(email, new Callback<Boolean>(){
            @Override
            public void success(Boolean result) {
                view.goToLogin();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });

    }
}
