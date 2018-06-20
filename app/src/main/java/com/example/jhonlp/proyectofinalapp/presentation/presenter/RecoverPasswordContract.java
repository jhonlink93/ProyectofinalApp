package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 19/06/2018.
 */

public interface RecoverPasswordContract {

    interface View extends BaseView {
        void goToLogin();

    }

    interface UserActionListener {
        void onRecover(final String email);

    }
}
