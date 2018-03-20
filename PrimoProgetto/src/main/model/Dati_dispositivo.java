package main.model;

import java.util.Objects;

public class Dati_dispositivo {

    private int cod_Dispositivo;
    private String data;
    private int km;
    private float livello_olio;
    private String codice_Errore;
    private int stato;

    public Dati_dispositivo(){

    }

    public Dati_dispositivo(int cod_Dispositivo, String data,  int km, float livello_olio, String codice_Errore, int stato) {
        this.cod_Dispositivo = cod_Dispositivo;
        this.data = data;
        this.km = km;
        this.livello_olio = livello_olio;
        this.codice_Errore = codice_Errore;
        this.stato = stato;
    }

    public int getCod_Dispositivo() {
        return cod_Dispositivo;
    }

    public void setCod_Dispositivo(int cod_Dispositivo) {
        this.cod_Dispositivo = cod_Dispositivo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCodice_Errore() {
        return codice_Errore;
    }

    public void setCodice_Errore(String codice_Errore) {
        this.codice_Errore = codice_Errore;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public float getLivello_olio() {
        return livello_olio;
    }

    public void setLivello_olio(float livello_olio) {
        this.livello_olio = livello_olio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dati_dispositivo that = (Dati_dispositivo) o;
        return cod_Dispositivo == that.cod_Dispositivo &&
                km == that.km &&
                stato == that.stato &&
                Float.compare(that.livello_olio, livello_olio) == 0 &&
                Objects.equals(codice_Errore, that.codice_Errore) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cod_Dispositivo, km, codice_Errore, stato, livello_olio, data);
    }

    @Override
    public String toString() {
        return "Dati_dispositivo{" +
                "cod_Dispositivo=" + cod_Dispositivo +
                ", km=" + km +
                ", codice_Errore='" + codice_Errore + '\'' +
                ", stato=" + stato +
                ", livello_olio=" + livello_olio +
                ", data='" + data + '\'' +
                '}';
    }
}
