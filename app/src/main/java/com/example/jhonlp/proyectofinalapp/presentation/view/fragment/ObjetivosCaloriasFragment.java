package com.example.jhonlp.proyectofinalapp.presentation.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.ObjetivosCaloriasContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.ObjetivosCaloriasPresenter;
import com.example.jhonlp.proyectofinalapp.presentation.view.activity.AuthActivity;

/**
 * Created by Paola on 18/06/2018.
 */

public class ObjetivosCaloriasFragment  extends Fragment implements ObjetivosCaloriasContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener  {

    private ObjetivosCaloriasContract.UserActionListener mActionListener;
    private TextView tvCaloriasDiaria, tvCaloriasSemanal,tvCaloriasMensual;
    private Button btnSiguiente;

    private int edad;
    String genero;



    public ObjetivosCaloriasFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    //public ObjetivosCaloriasFragment(Integer edad, Integer estatura, Integer pesoActual, String actividad, String objetivo) {

    public ObjetivosCaloriasFragment(int edad){
        this.edad=edad;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_objetivoscalorias, container, false);
        mActionListener =  new ObjetivosCaloriasPresenter(this);
        if (!getArguments().isEmpty()) {

            // aqui ya estan los datos... solo hay q guardarlos en variables como al primero
            genero = getArguments().getString("genero");
            edad = getArguments().getInt("edad");
            getArguments().getFloat("estatura");
            getArguments().getFloat("pesoActual");
            getArguments().getFloat("pesoDeseado");
            getArguments().getString("objetivoDeseado");
            getArguments().getString("actividad");
        }
        tvCaloriasDiaria = view.findViewById(R.id.tvCaloriasDiaria);
        //tvCaloriasDiaria.setText(edad);

        tvCaloriasSemanal = view.findViewById(R.id.tvCaloriasSemanal);
        tvCaloriasMensual = view.findViewById(R.id.tvCaloriasMensual);
        btnSiguiente = view.findViewById(R.id.btnSiguiente);


        btnSiguiente.setOnClickListener(this);


        return view;
    }

    public static ObjetivosCaloriasFragment getInstance( int edad) {
        return new ObjetivosCaloriasFragment(edad);
    }

    public static ObjetivosCaloriasFragment getInstance( ) {
        return new ObjetivosCaloriasFragment();
    }

    @Override
    public void goToSingUpFragment() {
        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(SingUpFragment.getInstance(), true);

    }

    @Override
    public void goToSingDatosPersonalesFragment() {
        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(DatosPersonalesFragment.getInstance(), true);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSiguiente:
                goToSingUpFragment();
                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void showMessageError(Exception error) {

    }

}
