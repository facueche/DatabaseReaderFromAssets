package com.moor.daniel.databasereaderfromassets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 28/04/17.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<Champion> items;

    //elementos del layout
    private TextView name;
    private TextView title;

    public CustomListAdapter (Context context, ArrayList objects){
        super(context, 0, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.list_item, null,true);

        //asociacion con los elementos visuales del fragment
        name = (TextView) rowView.findViewById(R.id.name_text);
        title = (TextView) rowView.findViewById(R.id.title_text);

        if (this.items.size() > 0){
            name.setText(items.get(position).getName());
            title.setText(items.get(position).getTitle());
        }

        return rowView;
    }
}
