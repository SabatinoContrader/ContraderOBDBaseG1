package com.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;


import com.project.model.Auto;
import com.project.model.Utente;

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
				//Se non verr� inserito nessuna data di default la data sar� "0000-00-00" e verr� restituito un errore
				utente = new Utente(resultSet.getInt("ID"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"), resultSet.getDate("DataRegistrazione"), resultSet.getInt("Ruolo"), resultSet.getString("Telefono"), null);
				utente.idAziendaPrivata = resultSet.getInt("IdAziendaPrivata");
				
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


public static boolean signUp(String nome, String cognome, String email, String password, int ruolo, String telefono, int idAzienda, int idAziendaPrivata) {
	
	Date dataRegistrazione;
	
	dataRegistrazione = new Date(System.currentTimeMillis());
	
	String Query;
	PreparedStatement statement;
	
	
	if(idAzienda==0 && idAziendaPrivata == 0) Query = "INSERT INTO `utente` (`Nome`, `Cognome`, `Email`, `Password`, `DataRegistrazione`, `Ruolo`, `Telefono`) VALUES ('"+ nome +"', '"+ cognome +"', '"+ email +"', '"+ password +"', ?, "+ ruolo +", '"+telefono +"')";
	else if((idAziendaPrivata==0) && (idAzienda > 0)) Query = "INSERT INTO `utente` (`Nome`, `Cognome`, `Email`, `Password`, `IdAzienda`, `DataRegistrazione`, `Ruolo`, `Telefono`) VALUES ('"+ nome +"', '"+ cognome +"', '"+ email +"', '"+ password +"', "+ idAzienda +", ?, "+ ruolo +", '"+telefono +"')";
	else if ((idAziendaPrivata>0) && (idAzienda == 0)) Query = "INSERT INTO `utente` (`Nome`, `Cognome`, `Email`, `Password`, `DataRegistrazione`, `Ruolo`, `Telefono`, `IdAziendaPrivata`) VALUES ('"+ nome +"', '"+ cognome +"', '"+ email +"', '"+ password +"', ?, "+ ruolo +", '"+telefono +"', "+idAziendaPrivata+")";
	else if (idAzienda!=0 && idAziendaPrivata != 0) Query = "INSERT INTO `utente` (`Nome`, `Cognome`, `Email`, `Password`, `IdAzienda`, `DataRegistrazione`, `Ruolo`, `Telefono`, `IdAziendaPrivata`) VALUES ('"+ nome +"', '"+ cognome +"', '"+ email +"', '"+ password +"', "+ idAzienda +", ?, "+ ruolo +", '"+telefono +"', "+idAziendaPrivata+")";
	else return false;
	
	
	//System.out.println(Query);
	
	
	
	ResultSet resultSet = null;
	
	int registrato = 0;
	
	try {
		
		statement = ConnessioneDB.getInstance().prepareStatement(Query);
		statement.setDate(1, dataRegistrazione);
		registrato = statement.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println("Errore di Registrazione su DB!");
		e.printStackTrace();
	}
	
	if(registrato > 0) return true;
	else return false;
	
	
}


public static List<Utente> getListUtenti(int idAzienda){
	Connection conn = ConnessioneDB.getInstance();
	PreparedStatement statement;
	ResultSet resultSet = null;
	List<Utente> lista = new ArrayList<>();
	String QUERY ="select * from utente WHERE IdAzienda=? and Stato=0";


	try {
		statement = conn.prepareStatement(QUERY);
		statement.setInt(1, idAzienda);
		resultSet = statement.executeQuery();

		/*if (resultSet.isBeforeFirst()) {
			System.out.println("\nAuto dell'azienda");
		}
*/

		while(resultSet.next()) {

			//System.out.println("Trovate Auto Associate!");

			Utente u = new Utente(resultSet.getInt("ID"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"),
			resultSet.getDate("DataRegistrazione"),
			resultSet.getInt("Ruolo"), resultSet.getString("Telefono"),null);

			lista.add(u);

		}



	}
	catch (SQLException e) {
		System.out.println("Errore di Recupero Lista Auto Azienda!");
	}


	return lista;


}
	public static int updateUtente(Utente u) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk=0;
		String QUERY = "UPDATE utente SET Nome=?,Cognome=?,Email=?,Password=?,Stato=?,IdAzienda=?,DataRegistrazione=?,Ruolo=?,Telefono=? WHERE ID=?";

		try{



			statement = conn.prepareStatement(QUERY);



			statement.setString(1, u.getNome());
			statement.setString(2, u.getCognome());
			statement.setString(3, u.getEmail());
			statement.setString(4, u.getPassword());
			statement.setInt(5, u.getStato());
			statement.setInt(6, u.getIdAzienda());
			statement.setDate(7, u.getDataRegistrazione());
			statement.setInt(8, u.getRuolo());
			statement.setString(9, u.getTelefono());
			statement.setInt(10, u.getID());
			insertOk= statement.executeUpdate();


		}catch(SQLException e){
			System.out.println(e);
		}


return insertOk;
	}

	public static void removeUtente(int idUtente) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk;
		String QUERY = "DELETE FROM auto_utente WHERE IdUtente=?";

		try{

			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, idUtente);
			statement.executeUpdate();

			try {
				String QUERYCROSS = "DELETE FROM utente WHERE ID=?";

				statement = conn.prepareStatement(QUERYCROSS);
				statement.setInt(1, idUtente);


				statement.executeUpdate();
				System.out.println("Utente rimosso correttamente");
			}catch(SQLException e){
				System.out.println(e);
			}



		}catch(SQLException e){
			System.out.println(e);
		}


	}

	public static boolean updateUtenteOfficina(String nome,String cognome,String email, String telefono,int idmod) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk=0;
		String QUERY = "UPDATE utente SET Nome=?,Cognome=?,Email=?,Telefono=? WHERE ID=?";

		try{



			statement = conn.prepareStatement(QUERY);



			statement.setString(1, nome);
			statement.setString(2, cognome);
			statement.setString(3, email);
			statement.setString(4,telefono);
			statement.setInt(5, idmod);

			insertOk= statement.executeUpdate();


		}catch(SQLException e){
			System.out.println(e);
		}


	if(insertOk>0)return true;
		else return false;
	}

	public static boolean updateUtenteBusinessOfficina(String denominazione,String nome,String cognome,String email, String telefono,String citta,int idmod) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk=0;
		String QUERY = "UPDATE azienda_privata SET Denominazione=?, NomeReferente=?,CognomeReferente=?,Email=?,Telefono=?,Citta=? WHERE ID=?";

		try{



			statement = conn.prepareStatement(QUERY);


			statement.setString(1, denominazione);
			statement.setString(2, nome);
			statement.setString(3, cognome);
			statement.setString(4, email);
			statement.setString(5,telefono);
			statement.setString(6,citta);
			statement.setInt(7, idmod);

			insertOk= statement.executeUpdate();


		}catch(SQLException e){
			System.out.println(e);
		}


		if(insertOk>0){

			return true;
		}
		else return false;
	}

	public static boolean disableUtente(int idmod) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk=0;
		String QUERY = "UPDATE utente SET Stato=1 WHERE ID=?";

		try{



			statement = conn.prepareStatement(QUERY);



			statement.setInt(1, idmod);

			insertOk= statement.executeUpdate();


		}catch(SQLException e){
			System.out.println(e);
		}


		if(insertOk>0)return true;
		else return false;
	}
}
