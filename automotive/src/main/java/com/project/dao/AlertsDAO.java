package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.automotive.dto.GuastoDTO;
import com.project.model.Auto;
import com.project.model.Utente;

import utility.Utility;


public class AlertsDAO {

	Connection conn = ConnessioneDB.getInstance();

	private final static Logger getLog = Logger.getLogger(AlertsDAO.class);

	private final int DEADLINE_SCADENZA_REVISIONE = 15;
	private final int DEADLINE_SCADENZA_TAGLIANDO = 15;
	private final int DEADLINE_SCADENZA_ASSICURAZIONE = 15;
	private final int DEADLINE_SCADENZA_BOLLO = 15;


	/* QUESTA è LA LISTA DI TUTTE LE AUTO CON GUASTI DEL SISTEMA */
	public ArrayList<GuastoDTO> getAlertsGuastiSystemAdministrator(){

		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;



		QUERY = "SELECT  g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione "+
				"FROM auto a, guasto g, dispositivo d, tipologia_guasto tg "+
				"WHERE g.IdDispositivo = d.ID and d.IdAuto=a.ID and tg.Codice = g.Codice ORDER BY g.ID ASC";


		try {
			ps = conn.prepareStatement(QUERY);

			rs = ps.executeQuery();


			listGuastoDto = new ArrayList<GuastoDTO>();


			while (rs.next()) {
				guastoDto = new GuastoDTO();
				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setId(rs.getInt("ID"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setDescrizione(rs.getString("Descrizione"));
				guastoDto.setIdTelemetria(rs.getInt("IdTelemetria"));
				guastoDto.setIdDispositivo(rs.getInt("IdDispositivo"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getAlertsGuastiSystemAdministrator ",e);
			throw new RuntimeException(e);
		} 

		return listGuastoDto;
	}


	/* QUESTA è LA LISTA DI TUTTE LE AUTO CON GUASTI ASSOCIATE AL DRIVER */
	public ArrayList<GuastoDTO> getUserAlertsGuastiDriver(Utente u){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;


		QUERY = "Select g.Codice, g.Data, a.Marca, a.Modello, a.Targa, a.NumeroTelaio"
				+" from guasto g, auto a, dispositivo d,auto_utente au, utente u"
				+" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.ID = au.IdUtente"
				+" and au.IdAuto = a.ID and u.ID =?";
		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getID());
			rs = ps.executeQuery();

			listGuastoDto = new ArrayList<GuastoDTO>();

			while (rs.next()) {
				guastoDto = new GuastoDTO();

				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getUserAlertsGuastiDriver ",e);
			throw new RuntimeException(e);
		} 
		return listGuastoDto;
	}


	/* QUESTA è LA LISTA DI TUTTE LE AUTO CON GUASTI ASSOCIATE ALL'OFFICINA SPECIFICA */
	public ArrayList<GuastoDTO> getAlertsGuastiGarageAdmin(Utente u){

		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;

		QUERY = "Select g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione"+
				" from guasto g, auto a, dispositivo d,auto_azienda au, utente u,tipologia_guasto tg"+
				" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.IdAzienda = au.IdAzienda "+
				" and tg.Codice= g.Codice and au.IdAuto = a.ID and u.ID = ?";

		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getID());
			rs = ps.executeQuery();


			listGuastoDto = new ArrayList<GuastoDTO>();

			while (rs.next()) {
				guastoDto = new GuastoDTO();
				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setId(rs.getInt("ID"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setDescrizione(rs.getString("Descrizione"));
				guastoDto.setIdTelemetria(rs.getInt("IdTelemetria"));
				guastoDto.setIdDispositivo(rs.getInt("IdDispositivo"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getUserAlertsGuastiGarageAdmin ",e);
			throw new RuntimeException(e);
		}
		return listGuastoDto;
	}



	/* QUESTA è LA LISTA DI TUTTE LE AUTO CON GUASTI ASSOCIATE ALL'AZIENDA PRIVATA */
	public ArrayList<GuastoDTO> getAlertsGuastiAziendaPrivata(int azPrivataId){
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;

		QUERY="SELECT g.*, a.Marca, a.Modello, a.NumeroTelaio,tg.Descrizione "+
				"FROM guasto g, auto a, auto_aziendali a_z, dispositivo d,tipologia_guasto tg, azienda_privata azp "+
				"WHERE g.IdDispositivo = d.ID and d.IdAuto = a.ID and tg.Codice = g.Codice and a_z.IdAuto = a.ID and a_z.IdAziendaPrivata = azp.ID and azp.ID= ?";
		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, azPrivataId);
			rs = ps.executeQuery();


			listGuastoDto = new ArrayList<GuastoDTO>();

			while (rs.next()) {
				guastoDto = new GuastoDTO();
				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setId(rs.getInt("ID"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setDescrizione(rs.getString("Descrizione"));
				guastoDto.setIdTelemetria(rs.getInt("IdTelemetria"));
				guastoDto.setIdDispositivo(rs.getInt("IdDispositivo"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getAlertsGuastiAziendaPrivata ",e);
			throw new RuntimeException(e);
		}
		return listGuastoDto;
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

	public ArrayList<GuastoDTO> getListaGuastiDispositivo(int idDispositivo,int idAzienda){

		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;

		QUERY = "Select distinct g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione"+
				" from guasto g, auto a, dispositivo d,auto_azienda au, utente u,tipologia_guasto tg"+
				" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.IdAzienda = au.IdAzienda "+
				" and tg.Codice= g.Codice and au.IdAuto = a.ID and d.ID = ? and u.IdAzienda=?";

		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, idDispositivo);
			ps.setInt(2, idAzienda);
			rs = ps.executeQuery();


			listGuastoDto = new ArrayList<GuastoDTO>();

			while (rs.next()) {
				guastoDto = new GuastoDTO();
				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setId(rs.getInt("ID"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setDescrizione(rs.getString("Descrizione"));
				guastoDto.setIdTelemetria(rs.getInt("IdTelemetria"));
				guastoDto.setIdDispositivo(rs.getInt("IdDispositivo"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getListaGuastiDispositivo ",e);
			throw new RuntimeException(e);
		}
		return listGuastoDto;
	}

	/*GET LISTA GUASTI DISPOSITIVO DA ADMIN*/
	public ArrayList<GuastoDTO> getListaGuastiDispositivoSystem(int idDispositivo){

		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;

		GuastoDTO guastoDto = null;
		ArrayList<GuastoDTO> listGuastoDto = null;

		QUERY = "Select distinct g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione"+
				" from guasto g, auto a, dispositivo d,auto_azienda au, utente u,tipologia_guasto tg"+
				" where g.IdDispositivo = d.ID and d.IdAuto=a.ID and u.IdAzienda = au.IdAzienda "+
				" and tg.Codice= g.Codice and au.IdAuto = a.ID and d.ID = ? ";

		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, idDispositivo);

			rs = ps.executeQuery();


			listGuastoDto = new ArrayList<GuastoDTO>();

			while (rs.next()) {
				guastoDto = new GuastoDTO();
				guastoDto.setData(rs.getDate("Data"));
				guastoDto.setId(rs.getInt("ID"));
				guastoDto.setCodice(rs.getString("Codice"));
				guastoDto.setDescrizione(rs.getString("Descrizione"));
				guastoDto.setIdTelemetria(rs.getInt("IdTelemetria"));
				guastoDto.setIdDispositivo(rs.getInt("IdDispositivo"));
				guastoDto.setMarcaAuto(rs.getString("Marca"));
				guastoDto.setModelloAuto(rs.getString("Modello"));
				guastoDto.setNumeroTarga(rs.getString("Targa"));
				guastoDto.setNumeroTelaio(rs.getString("NumeroTelaio"));
				listGuastoDto.add(guastoDto);
			}

		} catch (Exception e) {
			getLog.error("Exception in getListaGuastiDispositivo ",e);
			throw new RuntimeException(e);
		}
		return listGuastoDto;
	}
}
