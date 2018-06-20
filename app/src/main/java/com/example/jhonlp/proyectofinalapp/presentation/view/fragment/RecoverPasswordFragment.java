package com.example.jhonlp.proyectofinalapp.presentation.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.RecoverPasswordContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.RecoverPasswordPresenter;
import com.example.jhonlp.proyectofinalapp.presentation.view.activity.AuthActivity;
import com.example.jhonlp.proyectofinalapp.utilities.Utilities;

/**
 * Created by Paola on 19/06/2018.
 */

public class RecoverPasswordFragment  extends Fragment implements RecoverPasswordContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private RecoverPasswordContract.UserActionListener mActionListener;
    private TextInputLayout tilEmail;
    private Button btnrecuperar, btncancelar;

    public static RecoverPasswordFragment getInstance() {
        return new RecoverPasswordFragment();
    }

    public RecoverPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recoverpassword, container, false);

        mActionListener = new RecoverPasswordPresenter(this);

        tilEmail = view.findViewById(R.id.tilEmail);
        btnrecuperar = view.findViewById(R.id.btnrecuperar);
        btncancelar = view.findViewById(R.id.btncancelar);

        btnrecuperar.setOnClickListener(this);
        btncancelar.setOnClickListener(this);

        return view;
    }

    @Override
    public void goToLogin() {

        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(LoginFragment.getInstance(), true);
    }

    public void onRecover(){
        Boolean result = true;
        String email = tilEmail.getEditText().getText().toString();

        if (Utilities.isEmpty(email)) {
            tilEmail.setError("El email es requerido");
            tilEmail.setErrorEnabled(true);
            result = false;
        } else {
            tilEmail.setError(null);
            tilEmail.setErrorEnabled(false);
        }

        if (result) {
            mActionListener.onRecover(email);
        }
    }


    @Override
    public void showMessageError(Exception error) {

        Toast.makeText(getContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnrecuperar:
                onRecover();
                break;
            case R.id.btncancelar:
                goToLogin();
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
