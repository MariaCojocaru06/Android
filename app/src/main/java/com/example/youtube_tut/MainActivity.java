package com.example.youtube_tut;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
private Button btn;
private TextView txt;
private final int MainActivityRequestCode=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.editTextTextEmailAddress2);
        btn=findViewById(R.id.bt1);//cauta butonul in
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"apasat pe buton",Toast.LENGTH_LONG).show();
//                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
//
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,MainActivityRequestCode);
            }




        });
//        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
//        //Optional parameters
//        MainActivity.this.startActivity(myIntent);
//
        Log.v("lifestyle","onCreate()");

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