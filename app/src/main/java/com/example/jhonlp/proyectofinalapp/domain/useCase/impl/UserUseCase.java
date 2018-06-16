package com.example.jhonlp.proyectofinalapp.domain.useCase.impl;


import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.domain.useCase.ILocalDataUseCase;
import com.example.jhonlp.proyectofinalapp.domain.useCase.IUserUseCase;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;
import com.example.jhonlp.proyectofinalapp.repository.IAuthRepository;
import com.example.jhonlp.proyectofinalapp.repository.impl.AuthFirebaseRepository;
import com.example.jhonlp.proyectofinalapp.utilities.Constant;


public class UserUseCase implements IUserUseCase {

    private IAuthRepository authRepository;
    private ILocalDataUseCase localDataUseCase;

    public UserUseCase() {
        this.authRepository = new AuthFirebaseRepository();
        this.localDataUseCase = new LocalDataUseCase();
    }

    @Override
    public void login(final String email, String password, final boolean remember, final Callback<User> callback) {
        authRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {

                try {

                    if (user != null && remember) {
                        localDataUseCase.setData(Constant.SHARED_PREF_EMAIL, email);
                    }

                    localDataUseCase.setData(Constant.SHARED_PREF_IS_AUTH, true);
                    localDataUseCase.setData(Constant.SETUP_DATA, true);
                    callback.success(user);

                } catch (Exception e) {
                    callback.error(e);
                }
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void signUp(String fullName, String email, String password, String peso, String genero, String estatura, String nivelActividad, String objetivo, String pesoDeseado, final Callback<User> callback) {

        User user = new User(fullName, email, password, peso, genero, estatura, nivelActividad, objetivo, pesoDeseado);
        authRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User user) {
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void recoveryPassword(String email, final Callback<Boolean> callback) {

        authRepository.recoverPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                callback.success(true);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });

    }

    @Override
    public boolean isValidLoginAndPassword(String email, String password) {
        return false;
    }
}
