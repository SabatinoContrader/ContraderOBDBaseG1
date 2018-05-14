package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.controller.GestoreEccezioni;

public class loginquery extends Login {

	
	 private final String QUERY = "select * from Tabella where username = ? and password = ?";

	    public boolean login (String username, String password) {

	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement statement = connection.prepareStatement(QUERY);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            return statement.executeQuery().next();
	        }
	        
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }
	        
	    }	
	
		   

	} 


