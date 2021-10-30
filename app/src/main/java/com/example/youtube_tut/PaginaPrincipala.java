package com.example.youtube_tut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaginaPrincipala extends AppCompatActivity {
    private ListView lv1;
    private ListView lv2;
    private DomeniuAdapter adapter;
    private  DomeniuAdapter adapter2;
    private Adaptor2 ad;
    private Adaptor2 ad1;
    private JSONRead jsonRead;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.exemplu,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//      switch (item.getItemId()){
//          case R.id.item1:
//              Toast.makeText(this,"Vizualizare lista",Toast.LENGTH_LONG).show();
//              return true;
//          case R.id.item2:
//              Toast.makeText(this,"Vizualizare JSON",Toast.LENGTH_LONG).show();
//              return true;

        //    }
        if(item.getItemId()==R.id.item1){
            Toast.makeText(this,"Vizualizare lista",Toast.LENGTH_LONG).show();
//
            lv1=findViewById(R.id.listView1);
            lv2=findViewById(R.id.listView2);

            adapter=new DomeniuAdapter(getList());
            lv1.setAdapter(adapter);
            adapter.updateList(getList());

            adapter2=new DomeniuAdapter(getList2());
            lv2.setAdapter(adapter2);
            adapter2.updateList(getList2());

        }
        if(item.getItemId()==R.id.item2) {
            Toast.makeText(this,"Vizualizare JSON",Toast.LENGTH_LONG).show();
            lv1=findViewById(R.id.listView1);
            ad=new Adaptor2(lista());
            lv1.setAdapter(ad);
            //Golire list2
            lv2=findViewById(R.id.listView2);
            ad1=new Adaptor2(new ArrayList<>());
            lv2.setAdapter(ad1);


//            adapter = new DomeniuAdapter(lista());
//
//            lv1.setAdapter(adapter);


            jsonRead= new JSONRead();

            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    jsonRead.read(" https://jsonkeeper.com/b/JDMQ", new IResponse() {
                        @Override
                        public void onSuccess(List<Domeniu> list) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ad.updateList(list);

                                }
                            });

                        }

                        @Override
                        public void onError(String errorMessage) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PaginaPrincipala.this,errorMessage,Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    });

                }
            });
            thread.start();


        }
        return super.onOptionsItemSelected(item);
    }
    private List<Domeniu> lista(){
        ArrayList lista= new ArrayList<Domeniu>();
//        Domeniu d1=new Domeniu("Hairstyle",3900);
//        lista.add(d1);


        return lista;
    }
}