package com.example.youtube_tut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
private FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.floatingActionButton);//cauta butonul in
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"apasat pe buton",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);

            }

        });
//        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
//        //Optional parameters
//        MainActivity.this.startActivity(myIntent);
//
        Log.v("lifestyle","onCreate()");



    }
}