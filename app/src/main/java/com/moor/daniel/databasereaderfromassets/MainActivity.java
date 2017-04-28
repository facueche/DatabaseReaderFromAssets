package com.moor.daniel.databasereaderfromassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //listview
    private ListView listView;
    //Lista de elementos
    private ArrayList<Champion> list;
    //Manejador de base de datos
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        databaseManager = new DatabaseManager(getApplicationContext());

        Init();
    }

    private void Init(){
        this.list = databaseManager.SelectData();

        if (list.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No hay elementos", Toast.LENGTH_LONG).show();
            return;
        }

        CustomListAdapter adapter = new CustomListAdapter(getApplicationContext(), this.list);
        listView.setAdapter(adapter);
    }
}
