package com.example.youtube_tut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {
Utilizator utilizator;
Button Login;
EditText nume, prenume, data, email,parola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //preluare date de la utilizator
        utilizator=new Utilizator();
        //initializare campuri
        Login=findViewById(R.id.button);
        nume=findViewById(R.id.nume);
        prenume=findViewById(R.id.Prenume);
        data=findViewById(R.id.editTextDate);
        email=findViewById(R.id.editTextTextEmailAddress);
        parola=findViewById(R.id.editTextTextPassword);

        //adaugare eveniment pe buton
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                utilizator.setNume(nume.getText().toString());
                utilizator.setPrenume(prenume.getText().toString());
                utilizator.setData(data.getText().toString());
                utilizator.setEmail(email.getText().toString());
                utilizator.setParola(parola.getText().toString());
                Toast.makeText(MainActivity2.this,"Utilizator creat",Toast.LENGTH_LONG).show();}
                //trimitere date incapsulate
                Bundle bundle= new Bundle();

                bundle.putParcelable("OK",utilizator);//ob parsabil
                Intent intent=new Intent();
                intent.putExtra("bundle",bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });





    }
    private boolean isValid(){
        if(nume.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this,"Nume invalid",Toast.LENGTH_LONG).show();
            return false;
        }
        if(prenume.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this,"Prenume invalid",Toast.LENGTH_LONG).show();
            return false;
        }
        if(data.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this,"Data invalida",Toast.LENGTH_LONG).show();
            return false;
        }
        if(email.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this,"Email invalid",Toast.LENGTH_LONG).show();
            return false;
        }
        if(parola.getText().toString().isEmpty()){
            Toast.makeText(MainActivity2.this,"Parola invalida",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}