package com.example.angul.futa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by angul on 04/12/2017.
 */

public class LigasDataSource {

    private Context contexto;
    private LigaSQLiteHelper ligaSQLiteHelper;
    public LigasDataSource(Context contexto) {
        this.contexto = contexto;
        ligaSQLiteHelper=new LigaSQLiteHelper(contexto);
    }
    public SQLiteDatabase openReadable() {
        return ligaSQLiteHelper.getReadableDatabase();
    }
    public SQLiteDatabase openWriteable() {
        return ligaSQLiteHelper.getWritableDatabase();
    }

    public void close(SQLiteDatabase database) {
        database.close();
    }
    public void insertLiga(Liga liga) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(LigaSQLiteHelper.NOMBRE_LIGA, liga.getNombreLiga());
        args.put(LigaSQLiteHelper.NUMERO_EQUIPOS, liga.getNumeroParticipantes());
        database.insert(LigaSQLiteHelper.TABLE_LIGAS, null, args);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }
    private int getIntFromColumnName(Cursor cursor, String
            columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getInt(columnIndex);
    }
    private String getStringFromColumnName(Cursor cursor, String
            columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getString(columnIndex);
    }
    public ArrayList<Liga> readLigas() {
        SQLiteDatabase database = openReadable();
        Cursor cursor = database.query( LigaSQLiteHelper.TABLE_LIGAS,
                new String[]{LigaSQLiteHelper.ID_LIGA,
                        LigaSQLiteHelper.NOMBRE_LIGA,
                        LigaSQLiteHelper.NUMERO_EQUIPOS},
                null, null, null, null, null );
        ArrayList<Liga> ligas= new ArrayList<Liga>();
        if (cursor.moveToFirst()) {
            do {
                Liga liga = new Liga(
                        getIntFromColumnName(cursor, LigaSQLiteHelper.ID_LIGA),
                        getStringFromColumnName(cursor, LigaSQLiteHelper.NOMBRE_LIGA),
                        getIntFromColumnName(cursor,LigaSQLiteHelper.NUMERO_EQUIPOS));
                ligas.add(liga);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return ligas;
    }
    public Liga readLiga(long rowId) {
        SQLiteDatabase database = openReadable();
        Liga liga = new Liga();
        Cursor cursor = database.rawQuery("SELECT id_liga, nombre_liga, numero_equipos " +
                        "FROM LIGAS " +
                        "WHERE id_liga = " +rowId,
                null);
        if (cursor.moveToFirst()) {
            liga = new Liga (
                    getIntFromColumnName(cursor, LigaSQLiteHelper.ID_LIGA),
                    getStringFromColumnName(cursor, LigaSQLiteHelper.NOMBRE_LIGA),
                    getIntFromColumnName(cursor,LigaSQLiteHelper.NUMERO_EQUIPOS)
            );
        }
        cursor.close();
        database.close();
        return liga;
    }
    public void actualizarLiga(Liga liga) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        ContentValues args = new ContentValues();
        args.put(LigaSQLiteHelper.NOMBRE_LIGA,
                liga.getNombreLiga());
        args.put(LigaSQLiteHelper.NUMERO_EQUIPOS,
                liga.getNumeroParticipantes());
        database.update(LigaSQLiteHelper.TABLE_LIGAS, args,
                String.format("%s=%d", LigaSQLiteHelper.ID_LIGA,liga.getCodLiga()), null);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }
}
