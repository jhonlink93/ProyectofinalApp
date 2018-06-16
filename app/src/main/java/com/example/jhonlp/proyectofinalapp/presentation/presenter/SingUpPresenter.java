package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 16/06/2018.
 */

import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.LocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.impl.UserUseCase;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;
import com.example.jhonlp.proyectofinalapp.presentation.view.fragment.SingUpFragment;
import com.example.jhonlp.proyectofinalapp.utilities.Constant;

public class SingUpPresenter implements  SingUpContract.UserActionListener {

    private SingUpContract.View view;
    private ILocalDataUseCase localDataUseCase;
    private UserUseCase userUseCase;

    public SingUpPresenter(SingUpContract.View view) {

        this.view = view;
        this.localDataUseCase = new LocalDataUseCase();
        this.userUseCase = new UserUseCase();
    }





    @Override
    public void onSingUp(String username, String email, String password) {
        userUseCase.signUp(username,email, password, new Callback<User>() {
            @Override
            public void success(User result) {
                //view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {

                view.showMessageError(error);
            }
        });
    }
}



