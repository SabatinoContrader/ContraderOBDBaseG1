package main.model;

public class Candidati {

	private String nome;
    private String cognome;
    private String codice_fiscale;
    private String indirizzo;
    private String email;
    private String telefono;
    
    
    
    public Candidati(String nome,String cognome,String codice_fiscale,String indirizzo,String email,String telefono) {
    	
    	this.nome = nome;
    	this.cognome = cognome;
    	this.codice_fiscale = codice_fiscale;
    	this.indirizzo = indirizzo;
    	this.email = email;
    	this.telefono = telefono;
    	
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



	public String getCodice_fiscale() {
		return codice_fiscale;
	}



	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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



	
	
	
}
