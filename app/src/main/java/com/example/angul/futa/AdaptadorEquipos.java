package com.example.angul.futa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by angul on 11/05/2017.
 */

public class AdaptadorEquipos extends BaseAdapter{
    Context contexto;
    Equipos [] equiposes;

    public AdaptadorEquipos(Context contexto, Equipos[] equiposes) {
        this.contexto = contexto;
        this.equiposes = equiposes;
    }

    @Override
    public int getCount() {
        return equiposes.length;
    }

    @Override
    public Object getItem(int i) {
        return equiposes[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.item2, null);
            holder = new ViewHolder();
            holder.txtname = (TextView) view.findViewById(R.id.txtna1);
            holder.txtncode = (TextView) view.findViewById(R.id.txtco2);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtname.setText("Nombre: " + equiposes[i].getNameEquipo());
        holder.txtncode.setText("Codigo: " + equiposes[i].getCode());
        return view;
    }


    private class ViewHolder {
        TextView txtname, txtncode;
    }
}
