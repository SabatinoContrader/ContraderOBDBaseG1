package main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UtenteDAO {

	

	public static List<Utente> ritornaTuttiUtenti(){
		
		
		String Query = "select * from utente";
		
		List<Utente> utenti = new ArrayList<>();
	     Connection connection = ConnessioneDB.getInstance();
	     try {
	    	
	    	PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);
	    	//ps.setInt(1, 3);
	    	ResultSet resultSet = ps.executeQuery();
	    	
	    	
	    	
//	        Statement statement = connection.createStatement();
//	        ResultSet resultSet = statement.executeQuery(Query);
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
    	
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        
        utenti.add(new Utente(id, username, password));
    }
 }
 catch (SQLException e) {
     e.printStackTrace();
 }
 return utenti;
}
		
		
		
	}

