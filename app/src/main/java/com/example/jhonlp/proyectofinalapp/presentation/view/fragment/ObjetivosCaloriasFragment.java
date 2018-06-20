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
    private String genero,objetivoDeseado,actividad;
    private double estatura,pesoActual,pesoDeseado;



    public ObjetivosCaloriasFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_objetivoscalorias, container, false);
        mActionListener =  new ObjetivosCaloriasPresenter(this);
        if (!getArguments().isEmpty()) {

            genero = getArguments().getString("genero");
            edad = getArguments().getInt("edad");
            estatura=getArguments().getFloat("estatura");
            pesoActual=getArguments().getFloat("pesoActual");
            pesoDeseado=getArguments().getFloat("pesoDeseado");
            objetivoDeseado=getArguments().getString("objetivoDeseado");
            actividad=getArguments().getString("actividad");
        }
        tvCaloriasDiaria = view.findViewById(R.id.tvCaloriasDiaria);
        tvCaloriasSemanal = view.findViewById(R.id.tvCaloriasSemanal);
        tvCaloriasMensual = view.findViewById(R.id.tvCaloriasMensual);
        btnSiguiente = view.findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(this);
        calcularObjetivos();


        return view;
    }


    public static ObjetivosCaloriasFragment getInstance( ) {
        return new ObjetivosCaloriasFragment();
    }

    @Override
    public void calcularObjetivos(){
        double resultadoParcial,tmb , resultadoFinal ;
        if (genero=="Femenino"){
            tmb= 655 + (9.6* pesoActual) + (1.8 * estatura) - (4.7 * edad);
            }
        else {
            tmb= 66.5  + (13.8 * pesoActual) + (5  * estatura) - (6.8  * edad);
        }

        if (actividad=="Sedentaria"){
            resultadoParcial= tmb*1.2;
        }
        else if (actividad=="Leve"){
            resultadoParcial= tmb*1.375;
        }
        else if (actividad=="Moderada"){
            resultadoParcial= tmb*1.55;
        }
        else {
            resultadoParcial= tmb*1.725;
        }

        if (objetivoDeseado=="Aumentar peso"){

            resultadoFinal=resultadoParcial + resultadoParcial*0.2;
        }
        else if (objetivoDeseado=="Disminuir peso"){

            resultadoFinal=resultadoParcial*0.8;
        }
        else{
            resultadoFinal=resultadoParcial;
        }
        
        

        tvCaloriasDiaria.setText(resultadoFinal+" Kcal");
        tvCaloriasSemanal.setText(resultadoFinal*7 +" Kcal");
        tvCaloriasMensual.setText(resultadoFinal*4 +" Kcal");





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
