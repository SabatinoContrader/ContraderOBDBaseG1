package main.model;

import java.util.Date;
import java.util.Objects;

public class Auto {

    private int cod_Dispositivo;
    private String targa;
    private int telaio;
    private String casa_Costruttrice;
    private String modello;
    private String alimentazione;
    private String tipologia;
    private String cambio;
    private int driver;
    private int proprietario;
    private Date revisione;
    private Date tagliando_Data;
    private int tagliando_Km;


    public Auto(int cod_Dispositivo, String targa, int telaio, String casa_Costruttrice, String modello, String alimentazione, String tipologia, String cambio, int driver, int proprietario, Date revisione, Date tagliando_Data, int tagliando_Km) {
        this.cod_Dispositivo = cod_Dispositivo;
        this.targa = targa;
        this.telaio = telaio;
        this.casa_Costruttrice = casa_Costruttrice;
        this.modello = modello;
        this.alimentazione = alimentazione;
        this.tipologia = tipologia;
        this.cambio = cambio;
        this.proprietario = proprietario;
        this.revisione = revisione;
        this.tagliando_Data = tagliando_Data;
        this.tagliando_Km = tagliando_Km;
    }

    public int getCod_Dispositivo() {
        return cod_Dispositivo;
    }

    public void setCod_Dispositivo(int cod_Dispositivo) {
        this.cod_Dispositivo = cod_Dispositivo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getTelaio() {
        return telaio;
    }

    public void setTelaio(int telaio) {
        this.telaio = telaio;
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

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public Date getRevisione() {
        return revisione;
    }

    public void setRevisione(Date revisione) {
        this.revisione = revisione;
    }

    public Date getTagliando_Data() {
        return tagliando_Data;
    }

    public void setTagliando_Data(Date tagliando_Data) {
        this.tagliando_Data = tagliando_Data;
    }

    public int getTagliando_Km() {
        return tagliando_Km;
    }

    public void setTagliando_Km(int tagliando_Km) {
        this.tagliando_Km = tagliando_Km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return cod_Dispositivo == auto.cod_Dispositivo &&
                telaio == auto.telaio &&
                cambio == auto.cambio &&
                driver == auto.driver &&
                proprietario == auto.proprietario &&
                tagliando_Km == auto.tagliando_Km &&
                Objects.equals(targa, auto.targa) &&
                Objects.equals(casa_Costruttrice, auto.casa_Costruttrice) &&
                Objects.equals(modello, auto.modello) &&
                Objects.equals(alimentazione, auto.alimentazione) &&
                Objects.equals(tipologia, auto.tipologia) &&
                Objects.equals(revisione, auto.revisione) &&
                Objects.equals(tagliando_Data, auto.tagliando_Data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, driver, proprietario, revisione, tagliando_Data, tagliando_Km);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "cod_Dispositivo=" + cod_Dispositivo +
                ", targa='" + targa + '\'' +
                ", telaio=" + telaio +
                ", casa_Costruttrice='" + casa_Costruttrice + '\'' +
                ", modello='" + modello + '\'' +
                ", alimentazione='" + alimentazione + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", cambio=" + cambio +
                ", driver=" + driver +
                ", proprietario=" + proprietario +
                ", revisione=" + revisione +
                ", tagliando_Data=" + tagliando_Data +
                ", tagliando_Km=" + tagliando_Km +
                '}';
    }
}
