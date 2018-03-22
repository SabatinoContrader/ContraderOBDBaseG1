package com.project.model;

import java.sql.Date;
import java.util.List;


public class Utente {
	

	  
	  public Utente(int iD, String nome, String cognome, String email, String password, int stato, int idAzienda,
			Date dataRegistrazione, int ruolo, String telefono, List<Auto> auto) {
		ID = iD;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.stato = stato;
		this.idAzienda = idAzienda;
		this.dataRegistrazione = dataRegistrazione;
		this.ruolo = ruolo;
		this.telefono = telefono;
		this.auto = auto;
	}
	  
	  
	  
	  private int ID;
	  private String nome;
	  private String cognome;
	  private String email;
	  private String password;
	  private int stato;
	  private int idAzienda;
	  private Date dataRegistrazione;
	  private int ruolo;
	  private String telefono;
	  private List<Auto> auto;
	  
	  public int idAziendaPrivata;
	  
	  
	  
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStato() {
		return stato;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public int getRuolo() {
		return ruolo;
	}
	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Auto> getAuto() {
		return auto;
	}
	public void setAuto(List<Auto> auto) {
		this.auto = auto;
	}
	  
	  
	
}
