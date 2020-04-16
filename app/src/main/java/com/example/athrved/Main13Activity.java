package com.example.athrved;

import android.app.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main13Activity extends AppCompatActivity {
    EditText editTextName1;
    EditText editTextName2;
    EditText editTextName3;
    EditText editTextName4;
    EditText editTextName5;
    EditText editTextName6;
    Button button;
    ListView listViewDetails;


    DatabaseReference databaseArtists;

    List<Artist> artistList;





    @Override
    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artistList.clear();
                for(DataSnapshot artistSnapshot:dataSnapshot.getChildren()){
                    Artist artist=artistSnapshot.getValue(Artist.class);
                    artistList.add(artist);
                }
                ArtistList adapter=new ArtistList(Main13Activity.this,artistList);
                listViewDetails.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }






            @Override
            protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main13);
                Toolbar toolbar=findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Profile");
                databaseArtists = FirebaseDatabase.getInstance().getReference("artist");
                editTextName1 = findViewById(R.id.editText1);
                editTextName2 = findViewById(R.id.editText2);
                editTextName3 = findViewById(R.id.editText3);
                editTextName4 = findViewById(R.id.editText4);
                editTextName5 = findViewById(R.id.editText5);
                editTextName6 = findViewById(R.id.editText6);
                Button button2=findViewById(R.id.button2);
                button=findViewById(R.id.button);
                listViewDetails=findViewById(R.id.listViewDetails);



                artistList=new ArrayList<>();
            }



            static class ArtistList extends ArrayAdapter<Artist> {
                private Activity context;
                private List<Artist> artistList;

                public ArtistList(Activity context,List<Artist>artistList) {
                    super(context, R.layout.list_layout,artistList);
                    this.context=context;
                    this.artistList=artistList;
                }
                @Override public View getView(int position, View convertView, ViewGroup parent) {
                    LayoutInflater inflater=context.getLayoutInflater();
                    View listViewItem=inflater.inflate(R.layout.list_layout,null,true);

                    TextView textView1=listViewItem.findViewById(R.id.textView1);
                    TextView textView2=listViewItem.findViewById(R.id.textView2);
                    TextView textView3=listViewItem.findViewById(R.id.textView3);
                    TextView textView4=listViewItem.findViewById(R.id.textView4);
                    TextView textView5=listViewItem.findViewById(R.id.textView5);
                    TextView textView6=listViewItem.findViewById(R.id.textView6);
                    Artist artist=artistList.get(position);
                    textView1.setText(artist.getName1());
                    textView2.setText(artist.getName2());
                    textView3.setText(artist.getName3());
                    textView4.setText(artist.getName4());
                    textView5.setText(artist.getName5());
                    textView6.setText(artist.getName6());
                    return listViewItem;

                }





            }
}
