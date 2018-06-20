package com.example.jhonlp.proyectofinalapp.presentation.presenter;

/**
 * Created by Paola on 18/06/2018.
 */

public class ObjetivosCaloriasPresenter implements ObjetivosCaloriasContract.UserActionListener {

    private ObjetivosCaloriasContract.View view;

    public ObjetivosCaloriasPresenter(ObjetivosCaloriasContract.View view) {
        this.view = view;

    }

    @Override
    public void onNext() {
        view.goToSingUpFragment();

    }

    @Override
    public void onBack() {
        view.goToSingDatosPersonalesFragment();

    }
}
