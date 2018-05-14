package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UtenteDAO {

	

	public static List<Utente> ritornaTuttiUtenti() {
		
		
		String Query = "select * from utente";
		
		List<Utente> utenti = new ArrayList<>();
	     Connection connection = null;
		try {
			connection = ConnessioneDB.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     try {
	    	
	    	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);
	    	//ps.setInt(1, 3);
	    	ResultSet resultSet = ps.executeQuery();
	    	
	    	
	    	
//	        Statement statement = connection.createStatement();
//	        resultSet resultSet = statement.executeQuery(Query);
//	        
//	        while (resultSet.next()) {
//	        	
//	            int id = resultSet.getInt("id");
//	            String username = resultSet.getString("username");
//	            String password = resultSet.getString("password");
//	            
//	            utenti.add(new Utente(id, username, password));
//	        }
//	     }
//	     catch (SQLException e) {
//	         e.printStackTrace();
//	     }
//	     return utenti;
//	    }

	
	 while (resultSet.next()) {
    	
		 int ID = resultSet.getInt("ID");
			String Username = resultSet.getString("Username");
			String Password = resultSet.getString("Password");
			String Nome = resultSet.getString("Nome");
			String Cognome = resultSet.getString("Cognome");
			String Posizione = resultSet.getString("Posizione");
			
        utenti.add(new Utente(ID,Username,Password,Nome,Cognome,Posizione));
      
    }
 }
 catch (SQLException e) {
     e.printStackTrace();
 }
 return utenti;
}
		
		
		
	}

