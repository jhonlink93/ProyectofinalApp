package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 16/06/2018.
 */

public interface SingUpContract {

    interface View extends BaseView {

    }

    interface UserActionListener {
        void onSingUp( final String username, String email, String password);

    }
}
