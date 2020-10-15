package com.florenciaolivieri.petgrammascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.florenciaolivieri.petgrammascotas.adapter.MascotaAdaptador;
import com.florenciaolivieri.petgrammascotas.adapter.PageAdapter;
import com.florenciaolivieri.petgrammascotas.fragments.PerfilFragment;
import com.florenciaolivieri.petgrammascotas.fragments.RecyclerViewFragment;
import com.florenciaolivieri.petgrammascotas.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }


    private ArrayList<Fragment> agregarfragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), 2, agregarfragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
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




    public void irFavoritos(View v) {
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    }


}