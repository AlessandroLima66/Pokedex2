package com.alessandrolima.pokedex2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alessandrolima.pokedex2.api.PokemonAPI;
import com.alessandrolima.pokedex2.model.Pokemon;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private EditText numeroPokemon;
    private Button btPesquisar;
    private ImageView ivPokemon;
    private TextView tvPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroPokemon = (EditText) findViewById(R.id.numeroPokemon);
        btPesquisar = (Button) findViewById(R.id.btPesquisar);
        ivPokemon = (ImageView) findViewById(R.id.ivPokemon);
        tvPokemon = (TextView) findViewById(R.id.tvPokemon);

        btPesquisar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               pesquisar();
            }
        });
    }

    private void pesquisar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonAPI api = retrofit.create(PokemonAPI.class);

        int numero = Integer.parseInt(numeroPokemon.getText().toString());
        api.buscarPokemon(numero).enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                tvPokemon.setText(response.body().getNome());
                Picasso.with(MainActivity.this)
                        .load(response.body().getSprites().getFrente())
                        .into(ivPokemon);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}
