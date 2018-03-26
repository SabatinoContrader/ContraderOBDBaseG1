package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;

import com.project.model.Auto;
import com.project.model.Utente;
import utility.Utility;



public class CarDAO {

	private final Logger getLog = Logger.getLogger(CarDAO.class);


	public static List<Auto> getListAutoAzienda(int IdAzienda) {
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Auto> lista = new ArrayList<>();

		String QUERY = "select a.* from auto a,auto_azienda az  where az.IdAzienda = ? and az.IdAuto=a.ID ORDER BY a.ID ASC";


		try {
			resultSet = null;
			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, IdAzienda);
			resultSet = statement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				System.out.println("\nAuto dell'azienda");
			}


			while (resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
						resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
						resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
						resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
						resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

				lista.add(a);

			}


		} catch (SQLException e) {
			System.out.println("Errore di Recupero Lista Auto Azienda!");
		}

		return lista;
	}
	
	
	// GET LISTA AUTO CLIENTI AZIENDA - CREDO CHE E' SBAGLIATA
	public static List<Auto> getListAutoAziendaClienti(int IdAzienda) {
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Auto> lista = new ArrayList<>();

		String QUERY1 ="select DISTINCT a.* from auto a,auto_utente au,utente u  where au.IdAuto = a.ID and u.IdAzienda=? ORDER BY a.ID ASC";


		try {
			statement = conn.prepareStatement(QUERY1);
			statement.setInt(1, IdAzienda);
			resultSet = statement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				System.out.println("\nAuto dei clienti");
			}


			while(resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
						resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
						resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
						resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
						resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

				lista.add(a);

			}
		}catch (SQLException e){
			System.out.println(e);
		}
		return  lista;
	}


	//Ottengo lista delle Auto di un Utente che non sono io
	public static List<Auto> getListAutoUtente(int IdUtente){
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Auto> lista = new ArrayList<>();
		String QUERY ="select a.* from auto a,auto_utente au  where au.IdUtente = ? and au.IdAuto=a.ID ";

		try {
			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, IdUtente);
			resultSet = statement.executeQuery();

			/*     if (resultSet.isBeforeFirst()) {
                System.out.println("Auto dell'azienda con Id "+IdAzienda);
            }*/


			while(resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
						resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
						resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
						resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
						resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

				lista.add(a);

			}



		}
		catch (SQLException e) {
			System.out.println("Errore di Recupero Lista Auto Utente!");
		}

		return lista;
	}


	// INSERT AUTO PER INSERIRE AUTO IN TABELLA AUTO ED ASSEGNARLA AD UN UTENTE
	public static void insertAutoUtente(int idUtente,int MaxKmNoleggio,String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
			int kmInizioNoleggio, Date scadenzaRevisione,Date scadenzaTagliando, Date scadenzaBollo, Date scadenzaAssicurazione, String tipologiaAuto, int daNoleggio) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk;
		String QUERY = "INSERT INTO auto (ID,Marca,Modello,Targa,NumeroTelaio,KmAttuali,KmInizioNoleggio,ScadenzaRevisione,ScadenzaTagliando,ScadenzaBollo,ScadenzaAssicurazione,TipologiaAuto,DaNoleggio)VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{

			statement = conn.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, marca);
			statement.setString(2, modello);
			statement.setString(3, targa);
			statement.setString(4, numeroTelaio);
			statement.setInt(5, kmAttuali);
			statement.setInt(6, kmInizioNoleggio);
			statement.setDate(7, scadenzaRevisione);
			statement.setDate(8, scadenzaTagliando);
			statement.setDate(9, scadenzaBollo);
			statement.setDate(10, scadenzaAssicurazione);
			statement.setString(11, tipologiaAuto);
			statement.setInt(12, daNoleggio);
			insertOk= statement.executeUpdate();
			if(insertOk>0){

				int autoIncKeyFromApi = -1;

				resultSet = statement.getGeneratedKeys();

				if (resultSet.next()) {
					autoIncKeyFromApi = resultSet.getInt(1);

					String QUERYCROSS="INSERT INTO auto_utente (IdUtente,IdAuto,MaxKmNoleggio) VALUES(?,?,?)";
					try {

						statement = conn.prepareStatement(QUERYCROSS);
						statement.setInt(1,idUtente );
						statement.setInt(2,autoIncKeyFromApi );
						statement.setInt(3,MaxKmNoleggio );
						insertOk= statement.executeUpdate();
						if(insertOk>0){
							System.out.println("Auto inserita correttamente");
						}else{
							System.out.println("Errore nell'inserimento auto");
						}
					}catch(SQLException e){
						System.out.println(e);
					}

				} else {

					// throw an exception from here
				}

				//                System.out.println("Key returned from getGeneratedKeys():"                        + autoIncKeyFromApi);


			}
			else System.out.println("Errore nell'inserimento auto");

		}catch(SQLException e){
			System.out.println(e);
		}


	}

	//INSERT AUTO AZIENDA
	public static void insertAutoAzienda(int idAzienda,String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
			int kmInizioNoleggio, Date scadenzaRevisione,Date scadenzaTagliando, Date scadenzaBollo, Date scadenzaAssicurazione, String tipologiaAuto, int daNoleggio) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk;
		String QUERY = "INSERT INTO auto (ID,Marca,Modello,Targa,NumeroTelaio,KmAttuali,KmInizioNoleggio,ScadenzaRevisione,ScadenzaTagliando,ScadenzaBollo,ScadenzaAssicurazione,TipologiaAuto,DaNoleggio)VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{

			statement = conn.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, marca);
			statement.setString(2, modello);
			statement.setString(3, targa);
			statement.setString(4, numeroTelaio);
			statement.setInt(5, kmAttuali);
			statement.setInt(6, kmInizioNoleggio);
			statement.setDate(7, scadenzaRevisione);
			statement.setDate(8, scadenzaTagliando);
			statement.setDate(9, scadenzaBollo);
			statement.setDate(10, scadenzaAssicurazione);
			statement.setString(11, tipologiaAuto);
			statement.setInt(12, daNoleggio);
			insertOk= statement.executeUpdate();
			if(insertOk>0){

				int autoIncKeyFromApi = -1;

				resultSet = statement.getGeneratedKeys();

				if (resultSet.next()) {
					autoIncKeyFromApi = resultSet.getInt(1);

					String QUERYCROSS="INSERT INTO auto_azienda (IdAzienda,IdAuto) VALUES(?,?)";
					try {

						statement = conn.prepareStatement(QUERYCROSS);
						statement.setInt(1,idAzienda );
						statement.setInt(2,autoIncKeyFromApi );

						insertOk= statement.executeUpdate();
						if(insertOk>0){
							System.out.println("Auto inserita correttamente");
						}else{
							System.out.println("Errore nell'inserimento auto");
						}
					}catch(SQLException e){
						System.out.println(e);
					}

				} else {

					// throw an exception from here
				}

				//                System.out.println("Key returned from getGeneratedKeys():"                        + autoIncKeyFromApi);
			}
			else System.out.println("Errore nell'inserimento auto");
		}catch(SQLException e){
			System.out.println(e);
		}
	}

	// AGGIORNAMENTO AUTO
	public static void updateAuto(Auto a) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk;
		String QUERY = "UPDATE auto SET Marca=?,Modello=?,Targa=?,NumeroTelaio=?,KmAttuali=?,KmInizioNoleggio=?,ScadenzaRevisione=?,ScadenzaTagliando=?,ScadenzaAssicurazione=?,ScadenzaBollo=?,TipologiaAuto=?,DaNoleggio=? WHERE ID=?";
		try{

			statement = conn.prepareStatement(QUERY);

			statement.setString(1, a.getMarca());
			statement.setString(2, a.getModello());
			statement.setString(3, a.getTarga());
			statement.setString(4, a.getNumeroTelaio());
			statement.setInt(5, a.getKmAttuali());
			statement.setInt(6, a.getKmInizioNoleggio());
			statement.setDate(7, a.getScadenzaRevisione());
			statement.setDate(8, a.getScadenzaTagliando());
			statement.setDate(9, a.getScadenzaBollo());
			statement.setDate(10, a.getScadenzaAssicurazione());
			statement.setString(11, a.getTipologiaAuto());
			statement.setInt(12, a.getDaNoleggio());
			statement.setInt(13, a.getID());
			insertOk= statement.executeUpdate();

		}catch(SQLException e){
			System.out.println(e);
		}
	}

	//RIMUOVI AUTO CON RIMOZIONE CROSS REFERENCE E UPDATE DISPOSITIVO
	public static void removeAuto(int idAuto) {

		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		int insertOk;
		String QUERY = "DELETE FROM auto_azienda WHERE IdAuto=?";

		try{

			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, idAuto);
			statement.executeUpdate();

			try {
				String QUERYCROSS = "DELETE FROM auto_utente WHERE IdAuto=?";

				statement = conn.prepareStatement(QUERYCROSS);
				statement.setInt(1, idAuto);


				statement.executeUpdate();
			}catch(SQLException e){
				System.out.println("1: "+e);
			}
			try{
				String QUERYCROSS3="UPDATE dispositivo SET IdAuto=NULL WHERE IdAuto=?";


				statement = conn.prepareStatement(QUERYCROSS3);
				statement.setInt(1, idAuto);
				statement.executeUpdate();
			}catch(SQLException e){
				System.out.println("2: "+e);
			}
			try {
				String QUERYCROSS2 = "DELETE FROM auto WHERE ID=?";


				statement = conn.prepareStatement(QUERYCROSS2);
				statement.setInt(1, idAuto);
				int res= statement.executeUpdate();
				if(res==0){System.out.println("Auto non presente");}else{
					System.out.println("Auto eliminata correttamente");
				}
			}catch(SQLException e){
				System.out.println("3: "+e);
			}
		}catch(SQLException e){
			System.out.println(e);
		}



	}

	public static ResultSet getAutoDetail(int idAuto){
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;

		String QUERY1 ="select DISTINCT u.*,a.* from sql2226824.auto a,sql2226824.auto_utente au,sql2226824.utente u  where au.IdAuto = a.ID and a.ID= ? and au.IdUtente=u.ID";

		try {
			statement = conn.prepareStatement(QUERY1);
			statement.setInt(1, idAuto);
			resultSet = statement.executeQuery();
			return resultSet;
		}catch(SQLException e){
			System.out.println(e);
		}
		return null;
	}
	
	public Auto selectAutoFromId(){
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		Auto a = null;
		String QUERY = "Select * from auto a where a.ID=1 ";
		try{
			statement = conn.prepareStatement(QUERY);
			resultSet = statement.executeQuery();
			a = new Auto();
			if(resultSet.next()){
				a.setScadenzaRevisione(resultSet.getDate("ScadenzaRevisione"));
			}
		}catch(Exception e){
			
		}
		return a;
	}
	public static List<Auto> getListAllAuto() {
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Auto> lista = new ArrayList<>();

		String QUERY = "select * from auto ORDER BY ID ASC";


		try {
			resultSet = null;
			statement = conn.prepareStatement(QUERY);
			resultSet = statement.executeQuery();

			if (resultSet.isBeforeFirst()) {
				System.out.println("\nAuto dell'azienda");
			}


			while (resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
						resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
						resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
						resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
						resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

				lista.add(a);

			}


		} catch (SQLException e) {
			System.out.println("Errore di Recupero Lista Auto Azienda!");
		}

		return lista;
	}

	public static Utente getUtenteFromAuto(int idAuto){
		Connection conn = ConnessioneDB.getInstance();
		PreparedStatement statement;
		ResultSet resultSet = null;
		Utente  u = null;
		String QUERY ="select distinct u.ID as uid,u.* from auto a,auto_utente au,utente u  where au.IdUtente = u.ID and au.IdAuto=? ";

		try {
			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, idAuto);
			resultSet = statement.executeQuery();

			/*     if (resultSet.isBeforeFirst()) {
                System.out.println("Auto dell'azienda con Id "+IdAzienda);
            }*/


			while(resultSet.next()) {

				//System.out.println("Trovate Auto Associate!");

				 u = new Utente(resultSet.getInt("uid"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"),
						resultSet.getDate("DataRegistrazione"),
						resultSet.getInt("Ruolo"), resultSet.getString("Telefono"),null);


			}



		}
		catch (SQLException e) {
			System.out.println("Errore di Recupero Lista Auto Utente!");
		}

		return u;
	}

}
