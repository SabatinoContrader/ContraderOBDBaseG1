package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import model.Auto;
import model.Utente;

public class GestioneUtenteDAO {

public static Utente logIn(String email, String password) {
		
		Connection conn = ConnessioneDB.getInstance();
		
		String QUERY = "select * from utente where Email = ? and Password = ?";
		
		boolean found = false;
		
		PreparedStatement statement;
		PreparedStatement statement1;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		
		Utente utente = null;
		
		 try {
	            statement = conn.prepareStatement(QUERY);
	            statement.setString(1, email);
	            statement.setString(2, password);
	            resultSet = statement.executeQuery();
	            
	            found = resultSet.next();
	        }
	        catch (SQLException e) {
	            System.out.println("Errore di Log In!");
	        }
		 
		 if(found) {
			 
			 try {
				utente = new Utente(resultSet.getInt("ID"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"), resultSet.getDate("DataRegistrazione"), resultSet.getInt("Ruolo"), resultSet.getString("Telefono"), null);
				
				String QueryAuto = "select a.* from auto as a inner join auto_utente as au on a.ID = au.IdAuto inner join utente as u on u.ID = au.IdUtente where au.IdUtente = ?";
				
				statement1 = conn.prepareStatement(QueryAuto);
				statement1.setInt(1, utente.getID());
	            resultSet1 = statement1.executeQuery();
	            
	            List<Auto> lista = new ArrayList<>();
	            
	            while(resultSet1.next()) {
	            	
	            	//System.out.println("Trovate Auto Associate!");
	            	
	            	Auto a = new Auto(resultSet1.getInt("ID"), resultSet1.getString("Marca"), resultSet1.getString("Modello"), resultSet1.getString("Targa"), resultSet1.getString("NumeroTelaio"), resultSet1.getInt("KmAttuali"), resultSet1.getInt("KmInizioNoleggio"), resultSet1.getDate("ScadenzaRevisione"), resultSet1.getDate("ScadenzaTagliando"), resultSet1.getDate("ScadenzaAssicurazione"), resultSet1.getDate("ScadenzaBollo"), resultSet1.getString("TipologiaAuto"), resultSet1.getInt("DaNoleggio"));
	            	
	            	lista.add(a);
	            	
	            }
	            
	            utente.setAuto(lista);
				
				
			} catch (SQLException e) {
				
				System.out.println("Errore Inizzializzazione Utente Corrente!");
				ConnessioneDB.closeConnection();
				//e.printStackTrace();
			} 
			 
			
		
		 } else {
			 System.out.println("[Attenzione]: Email o Password ERRATI!");
		 }
		
		 
		 
		 
		return utente;
		
	}
}
