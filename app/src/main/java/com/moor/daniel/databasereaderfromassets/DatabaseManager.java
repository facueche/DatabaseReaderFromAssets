package com.moor.daniel.databasereaderfromassets;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by root on 28/04/17.
 */

public class DatabaseManager extends SQLiteAssetHelper {

    //Aqui estoy trabajando con una base de datos que obtuve del juego League of Legends

    private static final String DATABASE_NAME = "gameStats.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    //En este caso obtengo los datos de los campeones
    private Cursor getChampions () {
        return getReadableDatabase().rawQuery("SELECT name, title FROM champions", null);
    }

    public ArrayList<Champion> SelectData() {
        ArrayList<Champion> infoList = new ArrayList<>();
        Cursor cursor = getChampions();
        //Si se obtuvieron resultados
        if (cursor.moveToFirst()) {
            do {
                Champion champ = new Champion();
                champ.setName(cursor.getString(0));
                champ.setTitle(cursor.getString(1));
                infoList.add(champ);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return infoList;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

}
