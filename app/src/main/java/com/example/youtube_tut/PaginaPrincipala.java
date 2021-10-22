package com.example.youtube_tut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaginaPrincipala extends AppCompatActivity {
    private ListView lv1;
    private ListView lv2;
    private DomeniuAdapter adapter;
    private  DomeniuAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principala);



        lv1=findViewById(R.id.listView1);
        lv2=findViewById(R.id.listView2);

        adapter=new DomeniuAdapter(getList());
        lv1.setAdapter(adapter);
        adapter.updateList(getList());

        adapter2=new DomeniuAdapter(getList2());
        lv2.setAdapter(adapter2);
        adapter2.updateList(getList2());


    }
    private List<Domeniu> getList()
    {
        ArrayList<Domeniu> lista=new ArrayList<Domeniu>();
        Domeniu d1=new Domeniu("Hairstyle",3900,R.drawable.hairstyle);
        Domeniu d2 =new Domeniu("Nail",2000,R.drawable.nails);
        Domeniu d3=new Domeniu("Cook",5000,R.drawable.cooking);
        Domeniu d4=new Domeniu("Car",40000,R.drawable.car);
        Domeniu d5=new Domeniu("Flower",9000,R.drawable.flower);
        Domeniu d6=new Domeniu("Kids",9200, R.drawable.kids);
        Domeniu d7=new Domeniu("Science",80700, R.drawable.sci);

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        lista.add(d6);
        lista.add(d7);
        return  lista;
    }

    private List<Domeniu> getList2()
    {
        ArrayList<Domeniu> lista=new ArrayList<Domeniu>();
        Domeniu d1=new Domeniu("Painting",3900,R.drawable.paint);
        Domeniu d2 =new Domeniu("Nature",2000,R.drawable.nature);
        Domeniu d3=new Domeniu("Fashion",4000,R.drawable.fashion);
        Domeniu d4=new Domeniu("Coffee",30000, R.drawable.coffee);
        Domeniu d5=new Domeniu("Animals",4000,R.drawable.animals);
        Domeniu d6=new Domeniu("Christmas",7800,R.drawable.christ);
        Domeniu d7=new Domeniu("Architecture",9200, R.drawable.art);

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        lista.add(d6);
        lista.add(d7);
        return  lista;
    }
}