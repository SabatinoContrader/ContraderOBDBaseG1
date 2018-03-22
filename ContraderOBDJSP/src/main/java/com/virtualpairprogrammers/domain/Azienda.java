package com.virtualpairprogrammers.domain;

public class Azienda {

    String nomeAzienda;
    String Citta;

    public Azienda(){}

    public Azienda(String nomeAzienda, String Citta){
        this.nomeAzienda = nomeAzienda;
        this.Citta = Citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Azienda azienda = (Azienda) o;

        if (!azienda.Citta.equals(Citta)) return false;
        if (!azienda.nomeAzienda.equals(nomeAzienda)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = nomeAzienda != null ? nomeAzienda.hashCode() : 0;
        result = 31 * result + (Citta != null ? Citta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nome Azienda: " + nomeAzienda + "\nNome città: " +Citta +"\n";
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public void setCitta(String Citta) {
        this.Citta = Citta;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getCitta() {
        return Citta;
    }
}


