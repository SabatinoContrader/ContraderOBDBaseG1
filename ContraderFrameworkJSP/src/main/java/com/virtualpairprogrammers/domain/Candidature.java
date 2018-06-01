package com.virtualpairprogrammers.domain;

public class Candidature {

    private int ID_Annunci;
    private int ID_Candidati;

    public Candidature(int ID_Annunci, int ID_Candidati) {
        this.ID_Annunci = ID_Annunci;
        this.ID_Candidati = ID_Candidati;
    }

    public int getID_Annunci() {
        return ID_Annunci;
    }

    public void setID_Annunci(int ID_Annunci) {
        this.ID_Annunci = ID_Annunci;
    }

    public int getID_Candidati() {
        return ID_Candidati;
    }

    public void setID_Candidati(int ID_Candidati) {
        this.ID_Candidati = ID_Candidati;
    }
}
