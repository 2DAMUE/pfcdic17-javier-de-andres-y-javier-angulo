package com.example.angul.futa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by angul on 18/05/2017.
 */

public class AdaptadorClasificacion extends BaseAdapter {
    Context contexto;
    EqClasificacion[] eqClasificacions;

    public AdaptadorClasificacion(Context contexto, EqClasificacion[] eqClasificacions) {
        this.contexto = contexto;
        this.eqClasificacions = eqClasificacions;
    }

    @Override
    public int getCount() {
        return eqClasificacions.length;
    }

    @Override
    public Object getItem(int i) {
        return eqClasificacions[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.item3, null);
            holder = new AdaptadorClasificacion.ViewHolder();
            holder.txtpos = (TextView) view.findViewById(R.id.txtpos);
            holder.txtnombre = (TextView) view.findViewById(R.id.txtnombre);
            holder.txtplayedgames = (TextView) view.findViewById(R.id.txtplayedgames);
            holder.txtpoints = (TextView) view.findViewById(R.id.txtpoints);
            holder.txtgoals = (TextView) view.findViewById(R.id.txtgoals);
            holder.txtgoalsAgainst = (TextView) view.findViewById(R.id.txtgoalsAgainst);
            holder.txtgoalDifference = (TextView) view.findViewById(R.id.txtgoalDifference);
            holder.txtwins = (TextView) view.findViewById(R.id.txtwins);
            holder.txtloses = (TextView) view.findViewById(R.id.txtloses);
            holder.txtdraws = (TextView) view.findViewById(R.id.txtdraws);

            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.txtpos.setText(eqClasificacions[i].getPosition());
        holder.txtnombre.setText(eqClasificacions[i].getTeamName());
        holder.txtplayedgames.setText(eqClasificacions[i].getPlayedGames());
        holder.txtpoints.setText(eqClasificacions[i].getPoints());
        holder.txtgoals.setText(eqClasificacions[i].getGoals());
        holder.txtgoalsAgainst.setText(eqClasificacions[i].getGoalsAgainst());
        holder.txtgoalDifference.setText(eqClasificacions[i].getGoalDifference());
        holder.txtwins.setText(eqClasificacions[i].getWins());
        holder.txtloses.setText(eqClasificacions[i].getLosses());
        holder.txtdraws.setText(eqClasificacions[i].getDraws());

        return view;
    }

    private class ViewHolder {
        TextView txtpos, txtnombre, txturl, txtplayedgames, txtpoints, txtgoals,
                txtgoalsAgainst, txtgoalDifference, txtwins, txtloses, txtdraws;
    }


}

