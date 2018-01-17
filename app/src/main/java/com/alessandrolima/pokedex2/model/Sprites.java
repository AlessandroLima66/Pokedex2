package com.alessandrolima.pokedex2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ALUNO on 16/01/2018.
 */

public class Sprites {

    @SerializedName(value = "front_default")
    private String frente;

    @SerializedName(value = "back_default")
    private String verso;

    public String getFrente() {
        return frente;
    }

    public void setFrente(String frente) {
        this.frente = frente;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }
}
