package com.example.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filme;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    //Esse metodo apenas Cria os itens e retorna esses itens
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //converter o adaptr_lista.xml em uma View
        View itemLista =  LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup, false);


        return new MyViewHolder(itemLista);
    }

    @Override
    //Este è o metodo que vai exibir os itens
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get(i);

        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }

}
