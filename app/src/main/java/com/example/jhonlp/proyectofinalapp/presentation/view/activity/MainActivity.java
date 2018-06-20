package com.example.jhonlp.proyectofinalapp.presentation.view.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthPresenter;

public class MainActivity extends AppCompatActivity implements AuthContract.View {

    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.menu_fab);
        fab.setImageResource(R.drawable.icon_add);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                click = !click;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                            android.R.interpolator.fast_out_slow_in);

                    view.animate()
                            .rotation(click ? 45f : 0)
                            .setInterpolator(interpolador)
                            .start();
                }
            }
        });*/

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
