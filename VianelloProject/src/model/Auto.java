package model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Auto {
	  
	  public Auto(int iD, String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
			int kmInizioNoleggio, Date scadenzaRevisione, Date sadenzaTagliando, Date scadenzaAssicurazione,
			Date scadenzaBollo, String tipologiaAuto, int daNoleggio) {
		ID = iD;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.numeroTelaio = numeroTelaio;
		this.kmAttuali = kmAttuali;
		this.kmInizioNoleggio = kmInizioNoleggio;
		this.scadenzaRevisione = scadenzaRevisione;
		this.sadenzaTagliando = sadenzaTagliando;
		this.scadenzaAssicurazione = scadenzaAssicurazione;
		this.scadenzaBollo = scadenzaBollo;
		this.tipologiaAuto = tipologiaAuto;
		this.daNoleggio = daNoleggio;
	}
	  
	  
	  private int ID;
	  private String marca;
	  private String modello;
	  private String targa;
	  private String numeroTelaio;
	  private int kmAttuali;
	  private int kmInizioNoleggio;
	  private Date scadenzaRevisione;
	  private Date sadenzaTagliando;
	  private Date scadenzaAssicurazione;
	  private Date scadenzaBollo;
	  private String tipologiaAuto;
	  private int daNoleggio;
	  
	  
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
	public String getNumeroTelaio() {
		return numeroTelaio;
	}
	public void setNumeroTelaio(String numeroTelaio) {
		this.numeroTelaio = numeroTelaio;
	}
	public int getKmAttuali() {
		return kmAttuali;
	}
	public void setKmAttuali(int kmAttuali) {
		this.kmAttuali = kmAttuali;
	}
	public int getKmInizioNoleggio() {
		return kmInizioNoleggio;
	}
	public void setKmInizioNoleggio(int kmInizioNoleggio) {
		this.kmInizioNoleggio = kmInizioNoleggio;
	}
	public Date getScadenzaRevisione() {
		return scadenzaRevisione;
	}
	public void setScadenzaRevisione(Date scadenzaRevisione) {
		this.scadenzaRevisione = scadenzaRevisione;
	}
	public Date getSadenzaTagliando() {
		return sadenzaTagliando;
	}
	public void setSadenzaTagliando(Date sadenzaTagliando) {
		this.sadenzaTagliando = sadenzaTagliando;
	}
	public Date getScadenzaAssicurazione() {
		return scadenzaAssicurazione;
	}
	public void setScadenzaAssicurazione(Date scadenzaAssicurazione) {
		this.scadenzaAssicurazione = scadenzaAssicurazione;
	}
	public Date getScadenzaBollo() {
		return scadenzaBollo;
	}
	public void setScadenzaBollo(Date scadenzaBollo) {
		this.scadenzaBollo = scadenzaBollo;
	}
	public String getTipologiaAuto() {
		return tipologiaAuto;
	}
	public void setTipologiaAuto(String tipologiaAuto) {
		this.tipologiaAuto = tipologiaAuto;
	}
	public int getDaNoleggio() {
		return daNoleggio;
	}
	public void setDaNoleggio(int daNoleggio) {
		this.daNoleggio = daNoleggio;
	}
	  

	
}
