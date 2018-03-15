package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import model.Auto;
import model.Utente;
import utilities.Utility;

public class AlertsDAO {

	Connection conn = ConnessioneDB.getInstance();


	public void getUserAlertsGuasti(Utente u){

		
		//lista auto driver
		if(u.getRuolo() == 0){
			ArrayList<Auto> listAutoUser = (ArrayList<Auto>) u.getAuto();
			
			//Amministratore - Utente che vuole i gusati della lista delle auto dell'azienda di cui fa parte
			
			//voglio la lista auto
			
			//ottengo la lista dal metodo di loris
			
			//Funzione: ingrasso = listaAuto --> output a video = i guasti (solo quello che può visualizzare)
		
		
		} else {
			
			//Cliste normale che vuole visualizzare i guuasti delle auto collegate
			
			//ho la lista auto in Utente
			
			//voglio i guasti
			
			//Funzione: ingrasso = listaAuto --> output a video = i guasti (solo quello che può visualizzare)
		}
		
		
		
		
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		String QUERY = "Select g.*, a.Marca, a.Modello, a.Targa, a.NumeroTelaio "
				+ "from guasto g, auto a, dispositivo d,auto_utente au  "+
				" where g.IdDispositivo = d.ID and d.IdAuto=a.ID"+ 
				" and au.IdUtente = ? and au.IdAuto = a.ID";
		
		try {
			ps = conn.prepareStatement(QUERY);
			ps.setInt(1, u.getID());
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(" " +rs.getInt("ID"));

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			Utility.closeConnection(rs,ps,conn,true);
		}
	}
}
