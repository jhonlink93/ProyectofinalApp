package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by jhonlp on 16/06/2018.
 */

public class DatosPersonalesPresenter implements DatosPersonalesContract.UserActionListener {
    private DatosPersonalesContract.View view;

    public DatosPersonalesPresenter(DatosPersonalesContract.View view) {
        this.view = view;

    }

    @Override
    public void onNext() {

        view.goToObjetivosCaloriasFragment();

    }
}
