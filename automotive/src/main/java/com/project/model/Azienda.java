package com.project.model;

import java.util.ArrayList;
import java.util.Date;

public class Azienda {
	
	  public Azienda(String denominazione, String nomeReferente, String cognomeReferente, String email, String telefono,
			String latitudine, String longitudine, String tipologia, Date dataInserimento, String citta,
			ArrayList<Auto> listAuto) {
		this.denominazione = denominazione;
		this.nomeReferente = nomeReferente;
		this.cognomeReferente = cognomeReferente;
		this.email = email;
		this.telefono = telefono;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.tipologia = tipologia;
		this.dataInserimento = dataInserimento;
		this.citta = citta;
		this.listAuto = listAuto;
	}
	  
	  
	private String denominazione;
	  private String nomeReferente;
	  private String cognomeReferente;
	  private String email;
	  private String telefono;
	  private String latitudine;
	  private String longitudine;
	  private String tipologia;
	  private Date dataInserimento;
	  private String citta;
	  private ArrayList<Auto> listAuto;
	  public int id;
	  
	  
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getNomeReferente() {
		return nomeReferente;
	}
	public void setNomeReferente(String nomeReferente) {
		this.nomeReferente = nomeReferente;
	}
	public String getCognomeReferente() {
		return cognomeReferente;
	}
	public void setCognomeReferente(String cognomeReferente) {
		this.cognomeReferente = cognomeReferente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public ArrayList<Auto> getListAuto() {
		return listAuto;
	}
	public void setListAuto(ArrayList<Auto> listAuto) {
		this.listAuto = listAuto;
	}
}
