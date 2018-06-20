package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 18/06/2018.
 */

public interface ObjetivosCaloriasContract {

    interface View extends BaseView {


        void goToSingUpFragment();
        void goToSingDatosPersonalesFragment();
    }

    interface UserActionListener {
        void onNext();
        void onBack();
    }
}
