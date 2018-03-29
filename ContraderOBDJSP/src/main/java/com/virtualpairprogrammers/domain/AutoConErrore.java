package com.virtualpairprogrammers.domain;

import java.util.Objects;

public class AutoConErrore {

    private String casa_Costruttrice;
    private String modello;
    private String targa;
    private String data;
    private String cod_errore;
    private String nome_driver;
    private String cognome_driver;

    public AutoConErrore(String casa_Costruttrice, String modello, String targa, String data, String cod_errore, String nome_driver, String cognome_driver) {
        this.casa_Costruttrice = casa_Costruttrice;
        this.modello = modello;
        this.targa = targa;
        this.data = data;
        this.cod_errore = cod_errore;
        this.nome_driver = nome_driver;
        this.cognome_driver = cognome_driver;
    }

    public String getCasa_Costruttrice() {
        return casa_Costruttrice;
    }

    public void setCasa_Costruttrice(String casa_Costruttrice) {
        this.casa_Costruttrice = casa_Costruttrice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCod_errore() {
        return cod_errore;
    }

    public void setCod_errore(String cod_errore) {
        this.cod_errore = cod_errore;
    }

    public String getNome_driver() {
        return nome_driver;
    }

    public void setNome_driver(String nome_driver) {
        this.nome_driver = nome_driver;
    }

    public String getCognome_driver() {
        return cognome_driver;
    }

    public void setCognome_driver(String cognome_driver) {
        this.cognome_driver = cognome_driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoConErrore that = (AutoConErrore) o;
        return Objects.equals(casa_Costruttrice, that.casa_Costruttrice) &&
                Objects.equals(modello, that.modello) &&
                Objects.equals(targa, that.targa) &&
                Objects.equals(data, that.data) &&
                Objects.equals(cod_errore, that.cod_errore) &&
                Objects.equals(nome_driver, that.nome_driver) &&
                Objects.equals(cognome_driver, that.cognome_driver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(casa_Costruttrice, modello, targa, data, cod_errore, nome_driver, cognome_driver);
    }

    @Override
    public String toString() {
        return "AutoConErrore{" +
                "casa_Costruttrice='" + casa_Costruttrice + '\'' +
                ", modello='" + modello + '\'' +
                ", targa='" + targa + '\'' +
                ", data='" + data + '\'' +
                ", cod_errore='" + cod_errore + '\'' +
                ", nome_driver='" + nome_driver + '\'' +
                ", cognome_driver='" + cognome_driver + '\'' +
                '}';
    }
}
