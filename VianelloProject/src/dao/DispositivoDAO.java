package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dispositivo;

import com.mysql.jdbc.Connection;

public class DispositivoDAO {

	public static void showAllDevices(int IdAzienda) {
		
		List<Dispositivo> listaDispositivi = new ArrayList<>();

		Connection conn = ConnessioneDB.getInstance();
		
		String QUERY = "select * from dispositivo where IdAzienda = ?";
		
		PreparedStatement statement;
		ResultSet resultSet = null;
		
		try {
			
			statement = conn.prepareStatement(QUERY);
            statement.setInt(1, IdAzienda);
            resultSet = statement.executeQuery();
			
			while(resultSet.next()) listaDispositivi.add(new Dispositivo(resultSet.getInt("ID"), resultSet.getString("Codice"), resultSet.getInt("IdAuto"), resultSet.getDate("DataInstallazione"), resultSet.getInt("IdAzienda")));
		
		} catch (SQLException e) {
			
			System.out.println("Errore nel recupero dei Dispositivi associati all'Azienda!");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		if(listaDispositivi.size() != 0) System.out.println("Elenco di Dispositivi dell'Azienda:\n");
		
		for(int i = 0; i < listaDispositivi.size(); i ++) {
			
			System.out.println("ID: "+listaDispositivi.get(i).getId()+"	Codice: "+listaDispositivi.get(i).getCodice()+"	Id Auto: "+listaDispositivi.get(i).getIdAuto()+"	Id Azienda: "+listaDispositivi.get(i).getIdAzienda()+"	Data di Installazione: "+listaDispositivi.get(i).getDataInstallazione());
			
		}
	}

}
	
	

