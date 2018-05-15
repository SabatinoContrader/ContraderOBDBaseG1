package main;

public class Candidati 


{

	
	public Candidati() {
		super();
	}
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String email;
	
	public Candidati(String nome,String cognome, String indirizzo,String telefono,String email) {
		super();
		this.nome= nome;
		this.cognome = cognome;
		this.indirizzo= indirizzo;     
		this.telefono=telefono;
		this.email=email;
		
		
	}
	
	
	public String getNome() {
		return nome ;
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
	public String getIndirizzo() {
		// TODO Auto-generated method stub
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
