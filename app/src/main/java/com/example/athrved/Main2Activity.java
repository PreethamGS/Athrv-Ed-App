package com.example.athrved;

import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.athrved.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main2Activity extends AppCompatActivity {
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        getSupportActionBar().setTitle("Home");



    }
    public void aboutus(View v){

        startActivity(new Intent(Main2Activity.this,Main3Activity.class));
    }
    public void domains(View v){

        startActivity(new Intent(Main2Activity.this,Main4Activity.class));
    }
    public void activities(View view){

        startActivity(new Intent(Main2Activity.this,Main5Activity.class));
    }
    public void athrvlih(View view){

        startActivity(new Intent(Main2Activity.this,Main6Activity.class));
    }
    public void mentors(View v){

        startActivity(new Intent(Main2Activity.this,Main8Activity.class));
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu1,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:


                finish();
                return  true;

        }
        return  false;
    }
   public  void Logout(){
        FirebaseAuth.getInstance().signOut();


    }*/

  }




