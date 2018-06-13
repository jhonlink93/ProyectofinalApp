package com.example.jhonlp.proyectofinalapp.repository;

import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;


public interface IAuthRepository {

    void login(String email, String password, final Callback<User> callback);

    void signUp(final User user, final Callback<User> callback);

    void recoverPassword(String email, final Callback<Boolean> callback);
}
