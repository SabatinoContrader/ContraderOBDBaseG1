package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class TabellaDao {
	

   public static List<Tabella> ritornaTuttiTabella() {
		
	   
		String Query = "select * from Tabella";
		
		List<Tabella> Tabella= new ArrayList<>();
		
		Connection connection = null;
		try {
			connection = ConnessioneDB.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("COnnessione non avvenuta ");
		}
		
		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);	
		//ps.setInt(1, 3);
			
			ResultSet resulset = ps.executeQuery();
			
		
	while (resulset.next()) {
			
	String ID = resulset.getString("ID");
			String Username = resulset.getString("Username");
			String Password = resulset.getString("Password");
	
			
			Tabella.add(new Tabella(ID,Username,Password));
		}
	}	
	catch (SQLException k)	{
		k.printStackTrace();
}
		
return Tabella;



}
	
	
	
	
	
	

}
