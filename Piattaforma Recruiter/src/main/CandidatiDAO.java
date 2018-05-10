package main;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.util.List;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class CandidatiDAO {



// private final String QUERY_ALL = "select * from candidati";
  //private final String QUERY_INSERT = "insert into candidati (nome, cognome, codice_fiscale, indirizzo, email, telefono) values (?,?,?)";

	
  // public CandidatiDAO() {
	
	public static List<Candidati> ritornaTuttiCandidati() {
		
		String Query = "select * from candidati";
		
		List<Candidati> candidati= new ArrayList<>();
		
		Connection connection = null;
		try {
			connection = ConnessioneDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);	
			//ps.setInt(1, 3);
			
			ResultSet resulset = ps.executeQuery();
			
			
		while (resulset.next()) {
			
			String nome = resulset.getString("nome");
			String cognome = resulset.getString("cognome");
			String indirizzo = resulset.getString("indirizzo");
			String email = resulset.getString("email");
			String telefono = resulset.getString("telefono");
			
			candidati.add(new Candidati(nome, cognome,indirizzo,email,telefono));
		}
	}	
	catch (SQLException k)	{
		k.printStackTrace();
	}
		
return candidati;



}

	
   
	
}
