package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.model.Auto;
import com.project.model.Utente;

import utility.Utility;


public class AlertsDAO {

	Connection conn = ConnessioneDB.getInstance();
	
	private final Logger getLog = Logger.getLogger(AlertsDAO.class);
	
	private final int DEADLINE_SCADENZA_REVISIONE = 15;
	private final int DEADLINE_SCADENZA_TAGLIANDO = 15;
	private final int DEADLINE_SCADENZA_ASSICURAZIONE = 15;
	private final int DEADLINE_SCADENZA_BOLLO = 15;

	
	public void getUserAlertsGuasti(Utente u){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;



		//lista auto driver
		if(u.getRuolo() == 0){

			QUERY = "Select g.Codice, g.Data, a.Marca, a.Modello, a.Targa, a.NumeroTelaio"
					+" from guasto g, auto a, dispositivo d,auto_utente au, utente u"
					+" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.ID = au.IdUtente"
					+" and au.IdAuto = a.ID and u.ID =?";
			try {
				ps = conn.prepareStatement(QUERY);
				ps.setInt(1, u.getID());
				rs = ps.executeQuery();

				if(rs.isBeforeFirst()){
					System.out.println("ATTENZIONE HAI DELLE AUTO CON GUASTI:");

					while (rs.next()) {


						System.out.println("//////////////////////");
						System.out.println("Data: "+rs.getDate("Data"));
						System.out.println("Codice Guasto: "+rs.getString("Codice"));
						System.out.println("Marca auto: "+rs.getString("Marca"));
						System.out.println("Modello auto: "+rs.getString("Modello"));
						System.out.println("Numero targa: "+rs.getString("Targa"));
						System.out.println("Numero Telaio: "+rs.getString("NumeroTelaio"));
						System.out.println("//////////////////////");
						System.out.println();
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			/*finally{
				Utility.closeConnection(rs,ps,conn,true);
			}*/
		} 
		if(u.getRuolo()==1){
			// ALERTS DELLE AUTO CON GUASTI RELATIVI ALL AZIENDA.

			QUERY = "Select g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione"+
					" from guasto g, auto a, dispositivo d,auto_azienda au, utente u,tipologia_guasto tg"+
					" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.IdAzienda = au.IdAzienda "+
					" and tg.Codice= g.Codice and au.IdAuto = a.ID and u.ID = ?";

			try {
				ps = conn.prepareStatement(QUERY);
				ps.setInt(1, u.getID());
				rs = ps.executeQuery();

				if(rs.isBeforeFirst()){
					System.out.println("ELENCO AUTO CON GUASTI:");

					while (rs.next()) {

						System.out.println("//////////////////////");
						System.out.println("Data: "+rs.getDate("Data"));
						System.out.println("Id guasto: " +rs.getInt("ID"));
						System.out.println("Codice Guasto: "+rs.getString("Codice"));
						System.out.println("Descrizione guasto: "+rs.getString("Descrizione"));
						System.out.println("Id Telemtria: "+rs.getInt("IdTelemetria"));
						System.out.println("Id dispositivo: "+rs.getInt("IdDispositivo"));
						System.out.println("Marca auto: "+rs.getString("Marca"));
						System.out.println("Modello auto: "+rs.getString("Modello"));
						System.out.println("Numero targa: "+rs.getString("Targa"));
						System.out.println("Numero Telaio: "+rs.getString("NumeroTelaio"));
						System.out.println("//////////////////////");
						System.out.println();
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			/*finally{
					Utility.closeConnection(rs,ps,conn,true);
				}*/
		}
	}

	public void alertsKm(Utente u){

		String QUERY = null;
		PreparedStatement ps = null;
		ResultSet rs = null;


		QUERY=  "SELECT a.marca,a.modello,a.targa,a.KmAttuali,a.KmInizioNoleggio, au.MaxKmNoleggio,u.Nome,u.Cognome " +
				" FROM auto a, auto_utente au, utente u "+
				" WHERE a.id = au.IdAuto and au.IdUtente = u.ID and au.MaxKmNoleggio IS NOT NULL and au.MaxKmNoleggio>0 and u.id=? ";

		try{
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getID());
			rs = ps.executeQuery();

			while(rs.next()){

				int kmAttuali = rs.getInt("KmAttuali");
				int kmInizioNoleggio = rs.getInt("KmInizioNoleggio");
				int maxKmNoleggio = rs.getInt("MaxKmNoleggio");
				int kmConsumati = kmAttuali - kmInizioNoleggio;
				float sogliaKm = maxKmNoleggio/10;
				int cont=0;
				if(kmConsumati!=0 && ((maxKmNoleggio-kmConsumati)<sogliaKm)){
					cont++;
					if(cont==1)System.out.println("--------------------------------------\nNOTIFICHE AUTO NOLEGGIO UTENTE\n--------------------------------------");
					System.out.println();
					System.out.println("|------------------------------------------------------------------------|");
					System.out.println("ATTENZIONE L'AUTO CON TARGA: "+rs.getString("targa")+" e modello: "+rs.getString("modellO")+ " e marca: "+rs.getString("marca") );
					System.out.println("ASSOCIATA A: "+rs.getString("Nome") + " "+rs.getString("Cognome"));
					System.out.println("STA PER SUPERARE LA SOGLIA MASSIMA DI KM DISPONIBILI PER QUESTO NOLEGGIO");
					System.out.println("|------------------------------------------------------------------------|");
					System.out.println();
				}
			}
		}	
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void allAlertsKm(Utente  u){
		String QUERY = null;
		PreparedStatement ps = null;
		ResultSet rs = null;


		QUERY=  "SELECT a.marca,a.modello,a.targa,a.KmAttuali,a.KmInizioNoleggio, au.MaxKmNoleggio,u.Nome,u.Cognome " +
				" FROM auto a, auto_utente au, utente u "+
				" WHERE a.id = au.IdAuto and au.IdUtente = u.ID and au.MaxKmNoleggio IS NOT NULL  and  au.MaxKmNoleggio >0 and  u.IdAzienda=? and  u.ID!=? ";

		try{
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getIdAzienda());
			ps.setInt(2, u.getID());
			rs = ps.executeQuery();
int cont=0;
			while(rs.next()){
				cont++;
				if(cont==1)System.out.println("--------------------------------------\nNOTIFICHE AUTO NOLEGGIO CLIENTI\n--------------------------------------");
				int kmAttuali = rs.getInt("KmAttuali");
				int kmInizioNoleggio = rs.getInt("KmInizioNoleggio");
				int maxKmNoleggio = rs.getInt("MaxKmNoleggio");
				int kmConsumati = kmAttuali - kmInizioNoleggio;
				float sogliaKm = maxKmNoleggio/10;

				if(kmConsumati!=0 && ((maxKmNoleggio-kmConsumati)<sogliaKm)){
					System.out.println();
					System.out.println("|------------------------------------------------------------------------|");
					System.out.println("ATTENZIONE L'AUTO CON TARGA: "+rs.getString("targa")+" e modello: "+rs.getString("modellO")+ " e marca: "+rs.getString("marca") );
					System.out.println("ASSOCIATA A: "+rs.getString("Nome") + " "+rs.getString("Cognome"));
					System.out.println("STA PER SUPERARE LA SOGLIA MASSIMA DI KM DISPONIBILI PER QUESTO NOLEGGIO");
					System.out.println("|------------------------------------------------------------------------|");
					System.out.println();
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//ALERTS SCADENZA REVISIONE driver
	public void alertsScadenzaRevisione(Utente u){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		QUERY = " SELECT a.Marca, a.Modello,a.ScadenzaRevisione,a.Targa"+
				" FROM auto a,utente u,auto_utente au"+ 
				" WHERE a.ID=au.IdAuto and au.IdUtente = u.ID and u.id=? and a.ScadenzaRevisione<=DATE_ADD(NOW(),INTERVAL 10 DAY)";
		try{
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getID());
			rs = ps.executeQuery();
			if(rs.isBeforeFirst()){
				while(rs.next()){
					String macchina = rs.getString("Marca")+" "+rs.getString("Modello")+" - "+rs.getString("Targa").toUpperCase();
					Date scadenzaRevisione = rs.getDate("ScadenzaRevisione");
					Date oggi = new Date(System.currentTimeMillis());
					System.out.println();
					System.out.println("|----------------------------------------------------|");
					System.out.println("La macchina: "+macchina);
					System.out.println("DATA SCADENZA REVISIONE: "+scadenzaRevisione);
					if(oggi.after(scadenzaRevisione)){
						System.out.println("LA REVISIONE E' SCADUTA");
					}
					System.out.println("|----------------------------------------------------|");
					System.out.println();
				}
			}else{
				System.out.println("Non ci sono revisioni in scadenza!");
				System.out.println();
			}
		}		
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//METODO CHE RESTITUISCE TUTTE LE REVISIONI IN SCADENZA(VISTA GARAGE-ADMIN)
	public void alertsRevisioneGarageAdmin(Utente u){

		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		QUERY = " SELECT autoz.idAzienda, a.Marca, a.Modello,a.ScadenzaRevisione,a.Targa "
				+ " FROM auto a,auto_azienda autoz,azienda az"
				+ " WHERE a.ID=autoz.IdAuto and az.ID = autoz.IdAzienda and az.ID=? and a.ScadenzaRevisione<=DATE_ADD(NOW(),INTERVAL 10 DAY)";

		try{
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getIdAzienda());
			rs = ps.executeQuery();
			if(rs.isBeforeFirst()){
				while(rs.next()){
					Date scadenzaRevisione = rs.getDate("ScadenzaRevisione");
					Date oggi = new Date(System.currentTimeMillis());
					String macchina = rs.getString("Marca")+" "+rs.getString("Modello")+" - "+rs.getString("Targa").toUpperCase();
					System.out.println();
					System.out.println("|----------------------------------------------------|");
					System.out.println("La macchina: "+macchina);
					System.out.println("DATA SCADENZA REVISIONE: "+scadenzaRevisione);
					if(oggi.after(scadenzaRevisione)){
						System.out.println("----LA REVISIONE E' SCADUTA!!!----");
					}
					System.out.println("|----------------------------------------------------|");
					System.out.println();
				}
			}else{
				System.out.println("Non ci sono revisioni in scadenza!");
				System.out.println();
			}
		}		
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Auto> autoConRevisioneInScadenza(List<Auto> listaIn){
		ArrayList<Auto> listaAutoInScadenzaRevisione = new ArrayList<Auto>();
		for(Auto a : listaAutoInScadenzaRevisione){
			if(Utility.getGiorniScadenzaGenerica(a.getScadenzaRevisione())< DEADLINE_SCADENZA_REVISIONE){
				listaAutoInScadenzaRevisione.add(a);
			}
		}return listaAutoInScadenzaRevisione;
	}
	
	public ArrayList<Auto> autoConTagliandoInScadenza(List<Auto> listaIn){	
		ArrayList<Auto> listaAutoInScadenzaRevisione = new ArrayList<Auto>();
		for(Auto a : listaAutoInScadenzaRevisione){
			if(Utility.getGiorniScadenzaGenerica(a.getScadenzaRevisione())< DEADLINE_SCADENZA_TAGLIANDO){
				listaAutoInScadenzaRevisione.add(a);
			}
		}return listaAutoInScadenzaRevisione;
	}
	
	public ArrayList<Auto> autoConAssicurazioneInScadenza(List<Auto> listaIn){
		ArrayList<Auto> listaAutoInScadenzaRevisione = new ArrayList<Auto>();
		for(Auto a : listaAutoInScadenzaRevisione){
			if(Utility.getGiorniScadenzaGenerica(a.getScadenzaRevisione())< DEADLINE_SCADENZA_ASSICURAZIONE){
				listaAutoInScadenzaRevisione.add(a);
			}
		}return listaAutoInScadenzaRevisione;
	}
	
	public ArrayList<Auto> autoConBolloInScadenza(List<Auto> listaIn){
		ArrayList<Auto> listaAutoInScadenzaRevisione = new ArrayList<Auto>();
		for(Auto a : listaAutoInScadenzaRevisione){
			if(Utility.getGiorniScadenzaGenerica(a.getScadenzaRevisione())< DEADLINE_SCADENZA_BOLLO){
				listaAutoInScadenzaRevisione.add(a);
			}
		}return listaAutoInScadenzaRevisione;
	}
	
}
