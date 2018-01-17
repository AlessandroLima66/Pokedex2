package com.alessandrolima.pokedex2.api;

import com.alessandrolima.pokedex2.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ALUNO on 16/01/2018.
 */

public interface PokemonAPI  {

    @GET("/api/v2/pokemon/{numeroPokemon}")
    Call<Pokemon> buscarPokemon(@Path(value = "numeroPokemon") int numeroPokemon);
}
