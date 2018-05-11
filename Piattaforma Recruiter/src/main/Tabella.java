package main;

public class Tabella {

	private String ID;
	private String Username;
	private String Password;

	
	public Tabella(String iD, String username, String password) {
	
		ID = iD;
		Username = username;
		Password = password;

		
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


}
