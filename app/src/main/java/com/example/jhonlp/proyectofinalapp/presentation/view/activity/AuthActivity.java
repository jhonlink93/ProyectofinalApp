package com.example.jhonlp.proyectofinalapp.presentation.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.AuthPresenter;
import com.example.jhonlp.proyectofinalapp.presentation.view.fragment.DatosPersonalesFragment;
import com.example.jhonlp.proyectofinalapp.presentation.view.fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity implements AuthContract.View {
    private AuthContract.UserActionListener mActionListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mActionListner = new AuthPresenter(this);
        mActionListner.goToFirstFragment();

    }


    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_auth, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void showMessageError(Exception error) {

    }

    @Override
    public void goToLoginFragment() {
        replaceFragment(LoginFragment.getInstance(), false);

    }

    @Override
    public void goToMainActivity() {

        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
        finish();

    }
}
