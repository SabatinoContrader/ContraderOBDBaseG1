package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.controller.GestoreEccezioni;

public class loginquery  {								

	
	 static private final String QUERY = "select * from Utente where username = ? and password = ?";

	   static public Utente login(String username, String password) {

	        
	        try {
	        	Connection connection = ConnessioneDB.getInstance();
	        	
	            PreparedStatement statement = connection.prepareStatement(QUERY);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            
	            
	            
	            ResultSet resulset = statement.executeQuery();
				
	    		
	        	while (resulset.next()) {
	        			
	        			int ID = resulset.getInt("ID");
	        			String Username = resulset.getString("Username");
	        			String Password = resulset.getString("Password");
	        			String Nome = resulset.getString("Nome");
	        			String Cognome = resulset.getString("Cognome");
	        			String Posizione = resulset.getString("Posizione");
	        			
	        			return new Utente(ID,Username,Password,Nome,Cognome,Posizione);
	        		}
	            
	            
	        }
	        catch (SQLException e) {
	            System.out.println("Query fallita");
	            return null;
	        }
			return null;
	        
	    }	
	
		   

	} 


