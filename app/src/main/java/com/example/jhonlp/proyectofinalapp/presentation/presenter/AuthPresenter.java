package com.example.jhonlp.proyectofinalapp.presentation.presenter;

import android.util.Log;

import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.LocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.utilities.Constant;

/**
 * Created by jhonlp on 09/06/2018.
 */

public class AuthPresenter implements AuthContract.UserActionListener {

    private AuthContract.View view;
    private ILocalDataUseCase localDataUseCase;


    public AuthPresenter(AuthContract.View view) {
        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();

    }


    @Override
    public void goToFirstFragment() {
        try {
            Log.d("entra", "goToFirstFragment: el if ");

            Boolean isAuth = localDataUseCase.getData(Constant.SHARED_PREF_IS_AUTH, Boolean.class);

            if (isAuth == null || !isAuth) {
                view.goToLoginFragment();

            } else {
                view.goToMainActivity();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}