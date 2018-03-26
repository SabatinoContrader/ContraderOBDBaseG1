package com.project.model;


public class RichiestaPreventivo {
	private int id;
	private String descrizione;
	private int idUtente;
	private int idAuto;
	private int idAzienda;


	public RichiestaPreventivo(int id, String descrizione, int idUtente, int idAuto, int idAzienda) {
		this.id = id;
		this.descrizione = descrizione;
		this.idUtente = idUtente;
		this.idAuto = idAuto;
		this.idAzienda = idAzienda;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int newId){
		this.id = newId;
	}

	public String getDescrizione(){
		return this.descrizione;
	}

	public void setDescrizione(String newDescrizione){
		this.descrizione=newDescrizione;
	}

	public int getIdUtente(){
		return this.idUtente;
	}
	public void setIdUtente(int newIdUtente){
		this.idUtente = newIdUtente;
	}


	public int getIdAuto(){
		return this.idAuto;
	}
	public void setIdAuto(int newIdAuto){
		this.idAuto = newIdAuto;
	}


	public int getIdAzienda(){
		return this.idAzienda;
	}
	public void setIdAzienda(int newIdAzienda){
		this.idAzienda = newIdAzienda;
	}


}
