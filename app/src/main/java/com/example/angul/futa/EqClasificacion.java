package com.example.angul.futa;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by angul on 18/05/2017.
 */

public class EqClasificacion implements Parcelable {

    private String position;
    private String teamName;
    private String crestURI;
    private String playedGames;
    private String points;

    private String goals;
    private String goalsAgainst;
    private String goalDifference;

    private String wins;
    private String draws;
    private String losses;

    public EqClasificacion() {
    }

    protected EqClasificacion(Parcel in) {
        position = in.readString();
        teamName = in.readString();
        crestURI = in.readString();
        playedGames = in.readString();
        points = in.readString();
        goals = in.readString();
        goalsAgainst = in.readString();
        goalDifference = in.readString();
        wins = in.readString();
        draws = in.readString();
        losses = in.readString();
    }

    public static final Creator<EqClasificacion> CREATOR = new Creator<EqClasificacion>() {
        @Override
        public EqClasificacion createFromParcel(Parcel in) {
            return new EqClasificacion(in);
        }

        @Override
        public EqClasificacion[] newArray(int size) {
            return new EqClasificacion[size];
        }
    };

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(String playedGames) {
        this.playedGames = playedGames;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public String getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(String goalDifference) {
        this.goalDifference = goalDifference;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(position);
        parcel.writeString(teamName);
        parcel.writeString(crestURI);
        parcel.writeString(playedGames);
        parcel.writeString(points);
        parcel.writeString(goals);
        parcel.writeString(goalsAgainst);
        parcel.writeString(goalDifference);
        parcel.writeString(wins);
        parcel.writeString(draws);
        parcel.writeString(losses);
    }
}
