package com.example.athrved;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    private List<Artist> artistList;
    public ArtistList(Activity context, List<Artist> artistList) {
        super(context,R.layout.list_layout,artistList);

        this.context = context;
        this.artistList = artistList;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem =inflater.inflate(R.layout.list_layout,null,true);
        TextView name1=listViewItem.findViewById(R.id.editText1);
        TextView name2=listViewItem.findViewById(R.id.editText2);
        TextView name3=listViewItem.findViewById(R.id.editText3);
        TextView name4=listViewItem.findViewById(R.id.editText4);
        TextView name5=listViewItem.findViewById(R.id.editText5);
        TextView name6=listViewItem.findViewById(R.id.editText6);
        Artist artist=artistList.get(position);
        name1.setText(artist.getName1());
        name2.setText(artist.getName2());
        name3.setText(artist.getName3());
        name4.setText(artist.getName4());
        name5.setText(artist.getName5());
        name6.setText(artist.getName6());
        return listViewItem;

    }
}

