package com.project.automotive.dto;

import java.sql.Date;

public class GuastoDTO {


	private Date data;
	private int id;
	private String codice;
	private String descrizione;
	private int idTelemetria;
	private int idDispositivo;
	private String marcaAuto;
	private String modelloAuto;
	private String numeroTarga;
	private String numeroTelaio;
	
	
	public GuastoDTO(Date data, int id, String codice, String descrizione, int idTelemetria, int idDispositivo,
			String marcaAuto, String modelloAuto, String numeroTarga, String numeroTelaio) {
		this.data = data;
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.idTelemetria = idTelemetria;
		this.idDispositivo = idDispositivo;
		this.marcaAuto = marcaAuto;
		this.modelloAuto = modelloAuto;
		this.numeroTarga = numeroTarga;
		this.numeroTelaio = numeroTelaio;
	}


	public GuastoDTO() {
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


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


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getIdTelemetria() {
		return idTelemetria;
	}


	public void setIdTelemetria(int idTelemetria) {
		this.idTelemetria = idTelemetria;
	}


	public int getIdDispositivo() {
		return idDispositivo;
	}


	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}


	public String getMarcaAuto() {
		return marcaAuto;
	}


	public void setMarcaAuto(String marcaAuto) {
		this.marcaAuto = marcaAuto;
	}


	public String getModelloAuto() {
		return modelloAuto;
	}


	public void setModelloAuto(String modelloAuto) {
		this.modelloAuto = modelloAuto;
	}


	public String getNumeroTarga() {
		return numeroTarga;
	}


	public void setNumeroTarga(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}


	public String getNumeroTelaio() {
		return numeroTelaio;
	}


	public void setNumeroTelaio(String numeroTelaio) {
		this.numeroTelaio = numeroTelaio;
	}
	
	
	
	

}
