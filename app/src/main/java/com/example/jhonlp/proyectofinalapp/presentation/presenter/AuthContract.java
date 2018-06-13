package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by jhonlp on 09/06/2018.
 */
public interface AuthContract {

    interface View extends BaseView {
        void goToLoginFragment();

        void goToMainActivity();
    }

    interface UserActionListener {
        void goToFirstFragment();
    }
}
