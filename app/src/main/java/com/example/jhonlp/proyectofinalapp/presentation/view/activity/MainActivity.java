package com.example.jhonlp.proyectofinalapp.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthPresenter;

public class MainActivity extends AppCompatActivity implements AuthContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuthPresenter mActionListener = new AuthPresenter(this);

    }

    @Override
    public void showMessageError(Exception error) {

    }

    @Override
    public void goToLoginFragment() {

    }

    @Override
    public void goToMainActivity() {

    }
}
