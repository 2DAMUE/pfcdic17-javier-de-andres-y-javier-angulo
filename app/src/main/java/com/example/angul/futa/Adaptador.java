package com.example.angul.futa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by angul on 04/05/2017.
 */

public class Adaptador extends BaseAdapter {
    Context contexto;
    Ligas [] ligas;

    public Adaptador(Context contexto, Ligas[] ligas) {
        this.contexto = contexto;
        this.ligas = ligas;
    }

    @Override
    public int getCount() {
        return ligas.length;
    }

    @Override
    public Object getItem(int i) {
        return ligas[i];
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.item1, null);
            holder = new ViewHolder();
            holder.txtnLiga = (TextView) view.findViewById(R.id.txtNombre);
            holder.txtid = (TextView) view.findViewById(R.id.txtid);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtnLiga.setText(ligas[i].getnLiga());
        holder.txtid.setText(""+ligas[i].getId());
        return view;
    }


    private class ViewHolder {
        TextView txtid, txtnLiga;
    }
}
