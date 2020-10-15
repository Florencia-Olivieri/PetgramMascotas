package com.florenciaolivieri.petgrammascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.florenciaolivieri.petgrammascotas.R;
import com.florenciaolivieri.petgrammascotas.adapter.MascotaAdaptador;
import com.florenciaolivieri.petgrammascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //el layout fragment_recyclerview está contenido en el View v
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        //manipulo el RecyclerView de Mascotas
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //defino cómo mostrar el RecyclerView  en una lista (LinearLayout)
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //pongo orientación vertical para mostrar las tarjetas
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Indico que el RecyclerView se comporte como un LinearLayout
        listaMascotas.setLayoutManager(llm);

        // Inicializo lista de Mascotas
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

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
}
