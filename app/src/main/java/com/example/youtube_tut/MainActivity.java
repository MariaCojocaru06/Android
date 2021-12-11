package com.example.youtube_tut;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private Button btn;

private TextView txt;
private final int MainActivityRequestCode=100;
private UtilizatorDao utilizatorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // writeToDatabase();
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
        writeToDatabase();
        readFromDatabase();

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

public void writeToDatabase(){
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    myRef.setValue("Hello, World!");
    Utilizator u1=new Utilizator("Maria","Pop","12.09.2021","pop@gmail.com","oopo");
myRef.child("Utilizator_1").setValue(u1);
    Utilizator u2=new Utilizator("Ana","Lorena","12.02.2021","anaLorena@gmail.com","lll");
    myRef.child("Utilizator_2").setValue(u2);
    Utilizator u3=new Utilizator("Mihai","Ionut","28.07.20210","mihai.ionut@gmail.com","saposa");
    myRef.child("Utilizator_3").setValue(u3);
}

public void readFromDatabase(){
    // Read from the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            //String value = dataSnapshot.getValue(String.class);
           // Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                String data = ds.child("data").getValue(String.class);
                String email = ds.child("email").getValue(String.class);

                String nume=ds.child("nume").getValue(String.class);
                String prenume=ds.child("prenume").getValue(String.class);
                String parola =ds.child("parola").getValue(String.class);
                Log.d("citire",  data+ " , " + email+ " , "+parola + " , "+nume + " , "+prenume);
            }
            //Log.d("citire", "Value is: " + value);


        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            // Failed to read value
            Log.w("Citire", "Failed to read value.", error.toException());


        }


    });

}

}