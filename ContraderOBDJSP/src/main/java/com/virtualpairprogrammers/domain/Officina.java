package com.virtualpairprogrammers.domain;

import java.util.Objects;

public class Officina
{
    private String nome;
    private String indirizzo;
    private String citta;

    public Officina(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Officina officina = (Officina) o;
        return Objects.equals(nome, officina.nome) &&
                Objects.equals(indirizzo, officina.indirizzo) &&
                Objects.equals(citta, officina.citta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome, indirizzo, citta);
    }

    @Override
    public String toString() {
        return "Officina{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
