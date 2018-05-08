package main.model;

public class Utenti {

	private String nome;
    private String cognome;
	private int id;
	private String posizione;
	
	
	public Utenti(String nome, String cognome, int id, String poszione) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.id = id;
		this.posizione = posizione;
		
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPosizione() {
		return posizione;
	}


	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	
	
	
	
	
	
	
	
	
	
}
