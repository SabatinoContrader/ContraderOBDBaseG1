package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.controller.GestoreEccezioni;

public class ricercaquery {

	static private final String QUERY = "select * from Candidati where nome = ?";

	   static public Candidati ricerca (String nome) {
		  
		   try {
	        	Connection connection = ConnessioneDB.getInstance();
	        	
	            PreparedStatement statement = connection.prepareStatement(QUERY);
	            statement.setString(1, nome);
	      
	            ResultSet resulset = statement.executeQuery();
		   
	            while (resulset.next()) {
        			
        			
        			String Nome = resulset.getString("Nome");
        			String Cognome = resulset.getString("Cognome");
        			String Indirizzo = resulset.getString("Indirizzo");
        			String Telefono = resulset.getString("Telefono");
        			String Email = resulset.getString("Email");
        			return new Candidati (Nome,Cognome,Indirizzo,Telefono,Email);
        		}
            
            
        }
        catch (SQLException e) {
            System.out.println("Query fallita");
            return null;
        }
		return null;
        
    }	

		   
	   }
	

