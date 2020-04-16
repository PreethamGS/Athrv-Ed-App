package com.example.athrved;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.google.firebase.auth.FirebaseAuth;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Athrv L & I");






    }
    public void coremembers(View v){

        startActivity(new Intent(Main7Activity.this,Main9Activity.class));
    }
    public void projects(View v){

        startActivity(new Intent(Main7Activity.this,Main10Activity.class));
    }
    public void workshops(View v){

        startActivity(new Intent(Main7Activity.this,Main11Activity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {


        getMenuInflater().inflate(R.menu.menu2,menu2);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addprofile:

                startActivity(new Intent(Main7Activity.this, Main12Activity.class));
                finish();
                return true;
            case R.id.viewprofile:

                startActivity(new Intent(Main7Activity.this, Main13Activity.class));
                finish();
                return true;
        }
        return  false;
    }
}
