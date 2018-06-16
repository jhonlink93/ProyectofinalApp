package com.example.jhonlp.proyectofinalapp.domain.useCase;


import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;

public interface IUserUseCase {

    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, String peso, String genero, String estatura, String nivelActividad, String objetivo, String pesoDeseado, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);

    boolean isValidLoginAndPassword(String email, String password);

}
