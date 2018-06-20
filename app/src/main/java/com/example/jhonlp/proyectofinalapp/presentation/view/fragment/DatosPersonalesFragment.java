package com.example.jhonlp.proyectofinalapp.presentation.view.fragment;

import android.annotation.TargetApi;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jhonlp.proyectofinalapp.R;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.DatosPersonalesContract;
import com.example.jhonlp.proyectofinalapp.presentation.presenter.DatosPersonalesPresenter;
import com.example.jhonlp.proyectofinalapp.presentation.view.activity.AuthActivity;
import com.example.jhonlp.proyectofinalapp.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paola on 16/06/2018.
 */

public class DatosPersonalesFragment extends Fragment implements DatosPersonalesContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private DatosPersonalesContract.UserActionListener mActionListener;
    private Spinner spnGenero;
    private TextInputLayout textEdad;
    private TextInputLayout textEstatura;
    private TextInputLayout textPesoActual;
    private Spinner spnActividad;
    private Spinner spnObjetivo;
    private TextInputLayout textPesoDeseado;
    private Button btnSiguiente;


    public DatosPersonalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datospersonales, container, false);

        mActionListener = new DatosPersonalesPresenter(this);

        spnGenero = view.findViewById(R.id.spnGenero);
        textEdad = view.findViewById(R.id.textEdad);
        textEstatura = view.findViewById(R.id.textEstatura);
        textPesoActual = view.findViewById(R.id.textPesoActual);
        spnActividad = view.findViewById(R.id.spnActividad);
        spnObjetivo = view.findViewById(R.id.spnObjetivo);
        textPesoDeseado = view.findViewById(R.id.textPesoDeseado);
        btnSiguiente = view.findViewById(R.id.btnSiguiente);
        spnGenero.setOnItemSelectedListener(this);
        llenarSpinerGenero();
        llenarSpinerActividad();
        llenarSpinerObjetivos();
        btnSiguiente.setOnClickListener(this);


        return view;
    }

    @Override
    public void goToObjetivosCaloriasFragment() {


        int edad = Integer.parseInt( textEdad.getEditText().getText().toString());



        AuthActivity authActivity = (AuthActivity) getActivity();
        //authActivity.replaceFragment(ObjetivosCaloriasFragment.getInstance(), true);


        authActivity.replaceFragment(ObjetivosCaloriasFragment.getInstance(edad), true);



    }

    @TargetApi(Build.VERSION_CODES.M)
    public void  llenarSpinerGenero(){
        List<String> tipos = new ArrayList<>(0);
        tipos.add("Femenino");
        tipos.add("Masculino");


        ArrayAdapter<String> generos= new ArrayAdapter<String>(
                getContext(), R.layout.support_simple_spinner_dropdown_item, tipos);
        generos.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnGenero.setAdapter(generos);
    }

    public static Fragment getInstance() {
        return new DatosPersonalesFragment();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void  llenarSpinerActividad(){
        List<String> tipos = new ArrayList<>(0);
        tipos.add("Sedentaria");
        tipos.add("Leve");
        tipos.add("Moderada");
        tipos.add("Fuerte");

        ArrayAdapter<String> actividades= new ArrayAdapter<String>(
                getContext(), R.layout.support_simple_spinner_dropdown_item, tipos);
        actividades.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnActividad.setAdapter(actividades);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void  llenarSpinerObjetivos(){
        List<String> tipos = new ArrayList<>(0);
        tipos.add("Aumentar masa muscular");
        tipos.add("Perder masa muscular");
        tipos.add("Mantener masa muscular");

        ArrayAdapter<String> Objetivos= new ArrayAdapter<String>(
                getContext(), R.layout.support_simple_spinner_dropdown_item, tipos);
        Objetivos.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnObjetivo.setAdapter(Objetivos);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSiguiente:
                onNext();
        }

    }

    @Override
    public void showMessageError(Exception error) {

    }

    public void onNext() {
        Boolean result = true;
        String edad = textEdad.getEditText().getText().toString();
        String estatura = textEstatura.getEditText().getText().toString();
        String pesoActual = textPesoActual.getEditText().getText().toString();;
        String PesoDeseado = textPesoDeseado.getEditText().getText().toString();;




        if (Utilities.isEmpty(edad)) {
            textEdad.setError("La edad es requerida");
            textEdad.setErrorEnabled(true);
            result = false;
        } else {
            textEdad.setError(null);
            textEdad.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(estatura)) {
            textEstatura.setError("La estatura es requerida");
            textEstatura.setErrorEnabled(true);
            result = false;
        } else {
            textEstatura.setError(null);
            textEstatura.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(pesoActual)) {
            textPesoActual.setError("el  peso actual es requerido");
            textPesoActual.setErrorEnabled(true);
            result = false;
        } else {
            textPesoActual.setError(null);
            textPesoActual.setErrorEnabled(false);
        }

        if (Utilities.isEmpty(PesoDeseado)) {
            textPesoDeseado.setError("el  peso deseado es requerido");
            textPesoDeseado.setErrorEnabled(true);
            result = false;
        } else {
            textPesoDeseado.setError(null);
            textPesoDeseado.setErrorEnabled(false);
        }

        if (result) {
            mActionListener.onNext();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
