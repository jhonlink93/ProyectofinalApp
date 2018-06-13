package com.example.jhonlp.proyectofinalapp.presentation.presenter;


public interface LoginContract {

    interface View extends BaseView {
        void goToSignUpFragment();

        void goToRecoverPassword();

        void goToMainActivity();

        void showProgress();

        void hidePRogress();

        void showRememberedUser(String email);
    }

    interface UserActionListener {
        void onLogin(final String email, String password, final boolean remember);

        void loadTorneoDetalle();

        void loadCountries();

        void loadLeagues();

        void loadTeams();

        void configure();
    }
}
