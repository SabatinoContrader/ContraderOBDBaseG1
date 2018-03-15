package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import model.Utente;
import utility.Utility;


public class AlertsDAO {

	Connection conn = ConnessioneDB.getInstance();


	public void getUserAlertsGuasti(Utente u){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String QUERY = null;



		//lista auto driver
		if(u.getRuolo() == 0){

			QUERY = "Select g.Codice, g.Data, a.Marca, a.Modello, a.Targa, a.NumeroTelaio"
					+" from db.guasto g, db.auto a, db.dispositivo d,db.auto_utente au, db.utente u"
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
			}finally{
				Utility.closeConnection(rs,ps,conn,true);
			}
		} 
		if(u.getRuolo()==1){
			// ALERTS DELLE AUTO CON GUASTI RELATIVI ALL AZIENDA.

			QUERY = "Select g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio, tg.Descrizione"+
					" from db.guasto g, db.auto a, db.dispositivo d,db.auto_azienda au, db.utente u,db.tipologia_guasto tg"+
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
				}finally{
					Utility.closeConnection(rs,ps,conn,true);
				}
			}
		}
	}
