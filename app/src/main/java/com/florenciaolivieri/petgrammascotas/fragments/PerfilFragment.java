package com.florenciaolivieri.petgrammascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.florenciaolivieri.petgrammascotas.R;

public class PerfilFragment extends Fragment {

    public PerfilFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //el layout fragment_recyclerview está contenido en el View v
        return inflater.inflate(R.layout.fragment_perfil, container, false);

    }
}
