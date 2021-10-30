package com.example.youtube_tut;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONRead {
    public void read(String param_url, IResponse response){
        try {
            URL url = new URL(param_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            StringBuilder result= new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                result.append(line);

            }

            List<Domeniu> list=Parsare(result.toString());

            response.onSuccess(list);


            Log.v("Rezultat net", list.toString());
            bufferedReader.close();
            streamReader.close();
            inputStream.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Domeniu> Parsare(String jsonString){
        List<Domeniu> listaJSON=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(jsonString);
            JSONArray array=object.getJSONArray("domenii");
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject =array.getJSONObject(i);
                String nume=jsonObject.getString("denumire");
                Integer populatie=jsonObject.getInt("nr_postari");
                //String descriere=jsonObject.getString("descriere");


                Domeniu domeniu=new Domeniu(nume,populatie);
                listaJSON.add(domeniu);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaJSON;
    }
}
