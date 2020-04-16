package com.example.athrved;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);






                databaseArtists = FirebaseDatabase.getInstance().getReference("artist");
                editTextName1 = findViewById(R.id.editText1);
                editTextName2 = findViewById(R.id.editText2);
                editTextName3 = findViewById(R.id.editText3);
                editTextName4 = findViewById(R.id.editText4);
                editTextName5 = findViewById(R.id.editText5);
                editTextName6 = findViewById(R.id.editText6);
                button = findViewById(R.id.button);
        listViewDetails = findViewById(R.id.listViewDetails);


                artistList = new ArrayList<>();
            }

            @Override
            protected void onStart() {
                super.onStart();
                databaseArtists.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        artistList.clear();
                        for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                            Artist artist = artistSnapshot.getValue(Artist.class);
                            artistList.add(artist);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }


            public void done(View view) {
                addprofile();

            }


            private void addprofile() {
                String name1 = editTextName1.getText().toString().trim();
                String name2 = editTextName2.getText().toString().trim();
                String name3 = editTextName3.getText().toString().trim();
                String name4 = editTextName4.getText().toString().trim();
                String name5 = editTextName5.getText().toString().trim();
                String name6 = editTextName6.getText().toString().trim();


                if (!TextUtils.isEmpty(name1)) {
                    if (!TextUtils.isEmpty(name2)) {
                        if (!TextUtils.isEmpty(name3)) {
                            if (!TextUtils.isEmpty(name4)) {
                                if (!TextUtils.isEmpty(name5)){
                                    if (!TextUtils.isEmpty(name6)){
                                                                 String id = databaseArtists.push().getKey();
                                Artist artist = new Artist(id, name1, name2, name3, name4,name5,name6);
                                databaseArtists.child(id).setValue(artist);
                                Toast.makeText(this, "profile added", Toast.LENGTH_SHORT).show();
                            }
                                    else {
                                        Toast.makeText(this, "name6 field is empty", Toast.LENGTH_SHORT).show();
                                    }}
                                    else {
                                        Toast.makeText(this, "name5 field is empty", Toast.LENGTH_SHORT).show();
                                    }}
                                    else {
                                Toast.makeText(this, "name4 field is empty", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(this, "Name3 field is empty", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "name2 field is empty", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "name1 field is empty", Toast.LENGTH_SHORT).show();
                }

                editTextName1.setText(" ");
                editTextName2.setText(" ");
                editTextName3.setText(" ");
                editTextName4.setText(" ");
                editTextName5.setText(" ");
                editTextName6.setText(" ");

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
                    StringBuilder s;
                    s = new StringBuilder(textView1.getText().toString());

                    for(int i = 4; i < s.length(); i += 5){
                        s.insert(i, " ");
                    }
                    textView1.setText(s.toString());
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
