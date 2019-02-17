package com.example.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagens Filmes
        this.criarFilmes();

        //Configurar o adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //esse instruçao coloca uma linha entre as lista
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                  getApplicationContext(),
                                  "Item pressionad: " + filme.getTituloFilme(),
                                  Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {

        Filme filme = new Filme("Avangers", "Açao/Comedia", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Robbin Hood", "Açao", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Açao", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Snowden", "Drama", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("3 Idiotas", "Comedia", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Sozinho em casa", "Comedia", "2009");
        this.listaFilmes.add(filme);

        filme = new Filme("Dead Pool", "Açao/Comedia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A frera", "Terror", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("A mosca", "Terror", "1997");
        this.listaFilmes.add(filme);

        filme = new Filme("O segredo dos animais", "Animaçao/Comedia", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("A bela e a fera", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Aqua Man", "Açao/Comedia", "2018");
        this.listaFilmes.add(filme);



    }

}
