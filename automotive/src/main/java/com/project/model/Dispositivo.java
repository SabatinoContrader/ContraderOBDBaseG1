package com.project.model;

import java.util.Date;

public class Dispositivo {

	public Dispositivo(int id, String codice, int idAuto, Date dataInstallazione, int idAzienda) {
		this.id = id;
		this.codice = codice;
		this.idAuto = idAuto;
		this.dataInstallazione = dataInstallazione;
		this.idAzienda = idAzienda;
	}
	
	private int id;
	private String codice;
	private int idAuto;
	private Date dataInstallazione;
	private  int idAzienda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}
	public Date getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(Date dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
}
