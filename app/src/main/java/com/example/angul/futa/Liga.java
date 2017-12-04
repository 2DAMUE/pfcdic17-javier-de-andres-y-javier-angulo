package com.example.angul.futa;

/**
 * Created by angul on 04/12/2017.
 */

public class Liga {
    private int codLiga;
    private String nombreLiga;
    private int numeroParticipantes;

    public Liga() {
    }

    public Liga(int codLiga, String nombreLiga, int numeroParticipantes) {
        this.codLiga = codLiga;
        this.nombreLiga = nombreLiga;
        this.numeroParticipantes = numeroParticipantes;
    }

    public int getCodLiga() {
        return codLiga;
    }

    public void setCodLiga(int codLiga) {
        this.codLiga = codLiga;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

}
