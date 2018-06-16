package com.example.jhonlp.proyectofinalapp.domain.model;

import android.support.annotation.NonNull;

public class User implements Comparable<User> {
    private String fullName;
    private String email;
    private String password;
    private String genero, peso, estatura, nivelActividad, objetivo, pesoDeseado;

    public User() {
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getNivelActividad() {
        return nivelActividad;
    }

    public void setNivelActividad(String nivelActividad) {
        this.nivelActividad = nivelActividad;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPesoDeseado() {
        return pesoDeseado;
    }

    public void setPesoDeseado(String pesoDeseado) {
        this.pesoDeseado = pesoDeseado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public User(String fullName, String email, String password, String peso, String genero, String estatura, String nivelActividad, String objetivo, String pesoDeseado) {
        this.fullName = fullName;
        this.email = email;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        this.nivelActividad = nivelActividad;
        this.objetivo = objetivo;
        this.pesoDeseado = pesoDeseado;
        this.password = password;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(@NonNull User anotherUser) {
        return anotherUser.getEmail().compareTo(this.getEmail());
    }
}