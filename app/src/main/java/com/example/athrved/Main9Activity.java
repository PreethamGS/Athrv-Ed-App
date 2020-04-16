package com.example.athrved;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

public class Main9Activity extends AppCompatActivity {

//creating array data and storing to listview
    String[] listviewName=new String[]{
        "Sudhanva", "Preetham G S", "Sudhanva", "Preetham G S", "Listview Name 5", "Listview Name 6", "Listview Name 7", "Listview Name 8"
};
    String[] listviewEmail=new String[]{
           " sudhanva@gmail.com"," preethamgs34@gmail.com"," sudhanva@gmail.com"," preethamgs34@gmail.com"," ListView Email 5"," ListView Email 6"," ListView Email 7"," ListView Email 8"


    };
    int[] listviewImages=new int[]{
        R.drawable.sud,R.drawable.preetham,R.drawable.sud,R.drawable.preetham,R.drawable.sud,R.drawable.sud,R.drawable.sud,R.drawable.sud
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);


        List<HashMap<String,String>> aList=new ArrayList<HashMap<String,String>>();
        for(int x=0;x<8;x++){
            HashMap<String,String> hm=new HashMap<String,String>();
            hm.put("ListName",listviewName[x]);
            hm.put("ListEmail",listviewEmail[x]);
            hm.put("ListImages",Integer.toString(listviewImages[x]));
            aList.add(hm);
        }
        String[] from={
                "ListImages","ListName","ListEmail"

        };
        int[] to={
                R.id.listview_images,R.id.Title,R.id.Description

        };
        SimpleAdapter simpleAdapter=new SimpleAdapter(getBaseContext(),aList,R.layout.listviewitems,from,to);
        ListView simplelistview=findViewById(R.id.listView);
        simplelistview.setAdapter(simpleAdapter);

    }
}
