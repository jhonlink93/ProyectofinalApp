package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 16/06/2018.
 */

public interface SingUpContract {

    interface View extends BaseView {

        void goToMainActivity();
    }

    interface UserActionListener {
        void onSingUp(final String username, String email, String password, String peso, String genero, String estatura, String nivelActividad, String objetivo, String pesoDeseado);

    }
}
