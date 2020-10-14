package com.florenciaolivieri.petgrammascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //manipulo el RecyclerView de Mascotas
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //defino cómo mostrar el RecyclerView  en una lista (LinearLayout)
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //pongo orientación vertical para mostrar las tarjetas
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Indico que el RecyclerView se comporte como un LinearLayout
        listaMascotas.setLayoutManager(llm);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador() {
        //instancio MascotaAdaptador que recibe la lista de mascotas inicializasa
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.foto_perro_cocker,"Kitty", "5"));
        mascotas.add(new Mascota(R.drawable.fotoperro_milu,"Milu", "4"));
        mascotas.add(new Mascota(R.drawable.fotoperro_jruss,"Laika", "4"));
        mascotas.add(new Mascota(R.drawable.foto_perro_salchicha,"Lupe", "6"));
        mascotas.add(new Mascota(R.drawable.foto_perro_plato_comida,"Odie", "1"));
        mascotas.add(new Mascota(R.drawable.foto_perro_rosa,"Sirius", "8"));

    }


    public void irFavoritos(View v) {
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    }


}