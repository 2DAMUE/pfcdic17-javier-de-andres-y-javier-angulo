package com.example.angul.futa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by angul on 04/12/2017.
 */

public class LigaSQLiteHelper extends SQLiteOpenHelper{
    public static final String ID_LIGA="id_liga";
    public static final String NOMBRE_LIGA="nombre_liga";
    public static final String NUMERO_EQUIPOS="numero_equipos";
    public static final String TABLE_LIGAS="LIGAS";
    static final String DATABASE_NAME="LigasDB";
    static final int DATABASE_VERSION=1;

    static final String CREATE_TABLE_LIGAS=
            "CREATE TABLE " +TABLE_LIGAS+ "( " +ID_LIGA+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NOMBRE_LIGA+" TEXT NOT NULL, " +NUMERO_EQUIPOS+ " INTEGER NOT NULL );";

    public LigaSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LIGAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
