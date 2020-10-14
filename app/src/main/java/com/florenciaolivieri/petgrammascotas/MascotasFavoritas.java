package com.florenciaolivieri.petgrammascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;



public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //manipulo el RecyclerView de Mascotas
        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);

        //defino cómo mostrar el RecyclerView  en una lista (LinearLayout)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //pongo orientación vertical para mostrar las tarjetas
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Indico que el RecyclerView se comporte como un LinearLayout
        listaMascotasFav.setLayoutManager(llm);

        // Inicializo lista de Mascotas
        inicializarListaMascotas();
        inicializarAdaptador();

        /*
        //casteo el ListView
        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);
        //para llevar el ArrayList al ListView necesito un Adaptador
        lstMascotas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresMascota));
        lstMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                //enviar intent con parametros
                intent.putExtra(getResources().getString(R.string.pnombre), mascotas.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pNLikes), mascotas.get(position).getNumeroLikes());
                startActivity(intent)
                finish();

            }
        });
        */
    }

    public void inicializarAdaptador() {
        //instancio MascotaAdaptador que recibe la lista de mascotas iniciliada
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotasFav.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.foto_perro_rosa,"Sirius", "8"));
        mascotas.add(new Mascota(R.drawable.fotoperro_jruss,"Laika", "4"));
        mascotas.add(new Mascota(R.drawable.fotoperro_milu,"Milu", "4"));
        mascotas.add(new Mascota(R.drawable.foto_perro_cocker,"Kitty", "5"));
        mascotas.add(new Mascota(R.drawable.foto_perro_salchicha,"Lupe", "6"));

    }

    public void irAtras(View v) {
        Intent i = new Intent(MascotasFavoritas.this, MainActivity.class);
        startActivity(i);
    }
}