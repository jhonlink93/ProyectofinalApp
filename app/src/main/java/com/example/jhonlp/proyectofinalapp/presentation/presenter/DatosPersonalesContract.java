package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 16/06/2018.
 */

public interface DatosPersonalesContract {
    interface View extends BaseView {


        void goToObjetivosCaloriasFragment();
    }

    interface UserActionListener {
        void onNext();
    }
}
