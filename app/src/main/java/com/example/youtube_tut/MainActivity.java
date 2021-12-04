package com.example.youtube_tut;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private Button btn;

private TextView txt;
private final int MainActivityRequestCode=100;
private UtilizatorDao utilizatorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.editTextTextEmailAddress2);
        btn=findViewById(R.id.bt1);//cauta butonul in
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"apasat pe buton",Toast.LENGTH_LONG).show();
//                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
//
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,MainActivityRequestCode);
            }else{
                Toast.makeText(MainActivity.this,"Pagina Principala",Toast.LENGTH_LONG).show();
               Intent intent=new Intent(getApplicationContext(),PaginaPrincipala.class);
               startActivity(intent);
            }}

        });
//        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
//        //Optional parameters
//        MainActivity.this.startActivity(myIntent);
//
        Log.v("lifestyle","onCreate()");

utilizatorDAO=dataAcces.getInstance(this).getDatabase().utilizatorDao();
Utilizator u1=new Utilizator("Maria","Pop","12.09.2021","pop@gmail.com","oopo");
Utilizator u2=new Utilizator("Ana","Lorena","12.02.2021","anaLorena@gmail.com","lll");

new Thread(new Runnable() {
    @Override
    public void run() {
        utilizatorDAO.insert(u1);
        utilizatorDAO.insert(u2);
        utilizatorDAO.delete(u1);

        List<Utilizator> lista2=utilizatorDAO.select();
        List<Utilizator>lista3=utilizatorDAO.getAll("Maria");
        Log.v("operatii",lista2.toString());
        Log.v("operatii",lista3.toString());
    }
}).start();

   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MainActivityRequestCode){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle bundle=data.getBundleExtra("bundle");
                    Utilizator u= bundle.getParcelable("OK");
                    txt.setText(u.getEmail().toString());

                }
            }
        }
    }


}