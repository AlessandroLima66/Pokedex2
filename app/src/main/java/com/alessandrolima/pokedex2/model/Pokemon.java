package com.alessandrolima.pokedex2.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ALUNO on 16/01/2018.
 */

public class Pokemon {

    @SerializedName(value = "name")
    private String nome;
    private Sprites sprites;

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
