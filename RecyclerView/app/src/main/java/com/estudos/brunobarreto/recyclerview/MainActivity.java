package com.estudos.brunobarreto.recyclerview;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.estudos.brunobarreto.recyclerview.domain.Car;
import com.estudos.brunobarreto.recyclerview.fragments.CarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarFragment frag = (CarFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if (frag == null) {
            frag = new CarFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag");
            ft.commit();
        }
    }

    public List<Car> getSetCarList(int qtd){

        String[] models = new String[]{"Gallardo", "Vyron", "Corvette", "Paganni Zonda", "Porsche 911", "BMW 720", "DB77", "Mustang", "Camaro", "CT6"};
        String[] marcas = new String[]{"Lamborghini", "Bugatti", "Chevrolet", "Pagani", "Porsche", "BMW", "Aston Martin", "Ford", "Chevrolet", "Cadillac"};
        int[] photos = new int[]{R.drawable.gallardo, R.drawable.vyron, R.drawable.corvette, R.drawable.paganni_zonda, R.drawable.porsche_911, R.drawable.bmw_720, R.drawable.db77, R.drawable.mustang, R.drawable.camaro, R.drawable.ct6 };

        List<Car> listAux = new ArrayList<Car>();

        for (int i = 0; i < qtd; i++) {
            Car c = new Car( models[i % models.length], marcas[i % marcas.length], photos[i % photos.length]);

            listAux.add(c);
        }

        return(listAux);
    }
}
