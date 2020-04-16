package com.example.athrved;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

    }
    public void core_projects_workshops(View v){

        startActivity(new Intent(Main6Activity.this,Main7Activity.class));
    }
}
