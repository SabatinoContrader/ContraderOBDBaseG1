package com.project.model;

import java.util.Date;

public class Guasto {
	
	  private int id;
	  private String codice;
	  private String idTelemetria;
	  private Date dateTime;
	  private int idDispositivo;
	  
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
	public String getIdTelemetria() {
		return idTelemetria;
	}
	public void setIdTelemetria(String idTelemetria) {
		this.idTelemetria = idTelemetria;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public Guasto() {
	}
	
	public Guasto(int id, String codice, String idTelemetria, Date dateTime, int idDispositivo) {
		this.id = id;
		this.codice = codice;
		this.idTelemetria = idTelemetria;
		this.dateTime = dateTime;
		this.idDispositivo = idDispositivo;
	}
}
