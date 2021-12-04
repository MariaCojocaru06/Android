package com.example.youtube_tut;

import android.content.Context;

import androidx.room.Room;

public class dataAcces {
    private dataBase dataBase;
    private dataAcces(Context context){
        dataBase= Room.databaseBuilder(context,dataBase.class,"dbutilizator").build();

    }
    //proprietate
    private static dataAcces instance;

    //metoda statica acceseaza prin clasa
    //nu are acces la atributele private
    public static dataAcces getInstance(Context c){
        if(instance==null){
            instance=new dataAcces( c);
        }
        return  instance;
    }


    public  dataBase getDatabase(){
        return  dataBase;

    }

}
