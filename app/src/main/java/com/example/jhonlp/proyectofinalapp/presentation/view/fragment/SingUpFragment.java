package com.example.jhonlp.proyectofinalapp.presentation.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.SingUpContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.SingUpPresenter;
import com.example.jhonlp.proyectofinalapp.presentation.view.activity.MainActivity;
import com.example.jhonlp.proyectofinalapp.utilities.Utilities;

/**
 * Created by Paola on 16/06/2018.
 */

public class SingUpFragment extends Fragment implements SingUpContract.View, View.OnClickListener  {

    private SingUpContract.UserActionListener mActionListener;
    private TextInputLayout UsernameSingUp;
    private TextInputLayout EmailSingUp;
    private TextInputLayout PasswordSingUp;
    private Button btnSignUp;

    public SingUpFragment() {

    }

    public static Fragment getInstance() {
        return new SingUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singup, container, false);

        mActionListener = new SingUpPresenter(this);

        UsernameSingUp = view.findViewById(R.id.UsernameSingUp);
        EmailSingUp = view.findViewById(R.id.EmailSingUp);
        PasswordSingUp = view.findViewById(R.id.PasswordSingUp);
        btnSignUp= view.findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(this);

        return view;
    }

    public void onSingUp() {
        Boolean result = true;
        String username = UsernameSingUp.getEditText().getText().toString();
        String email = EmailSingUp.getEditText().getText().toString();
        String password = PasswordSingUp.getEditText().getText().toString();

        if (Utilities.isEmpty(email)) {
            UsernameSingUp.setError("El nombre de usuario es requerido");
            UsernameSingUp.setErrorEnabled(true);
            result = false;
        } else {
            UsernameSingUp.setError(null);
            UsernameSingUp.setErrorEnabled(false);
        }


        if (Utilities.isEmpty(email)) {
            EmailSingUp.setError("El email es requerido");
            EmailSingUp.setErrorEnabled(true);
            result = false;
        } else {
            EmailSingUp.setError(null);
            EmailSingUp.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(password)) {
            PasswordSingUp.setError("La contraseña es requerida");
            PasswordSingUp.setErrorEnabled(true);
            result = false;
        } else {
            PasswordSingUp.setError(null);
            PasswordSingUp.setErrorEnabled(false);
        }

        if (result) {
            mActionListener.onSingUp(username, email, password, "1.63", "mas", "hola", "maso", "ser el mejor", "el tuyo");
        }
    }

    @Override
    public void goToMainActivity() {
/*
      cargar lo necesario antes de llamar al intnet*/

        Intent intentMainActivity = new Intent(getContext(), MainActivity.class);
        startActivity(intentMainActivity);
        getActivity().finish();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignUp:
                onSingUp();

        }



    }

    @Override
    public void showMessageError(Exception error) {
        Toast.makeText(getContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();

    }
}
