package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Azienda;

public class AziendaDAO{

	public static void setAzienda(Azienda a) {
		
		String Query = "INSERT INTO `azienda` (`Denominazione`, `NomeReferente`, `CognomeReferente`, `Email`, `Telefono`, `Latitudine`, `Longitudine`, `Tipologia`, `DataInserimento`, `Citta`) VALUES ('"+a.getDenominazione()+"', '"+a.getNomeReferente()+"', '"+a.getCognomeReferente()+"', '"+a.getEmail()+"', '"+a.getTelefono()+"', ?, ?, "+a.getTipologia()+", ?, '"+a.getCitta()+"')";
		
		System.out.println(Query);
		
		PreparedStatement statement;
		
		int inserito = 0;
		
		try {
			
			statement = ConnessioneDB.getInstance().prepareStatement(Query);
			statement.setFloat(1, Float.parseFloat(a.getLatitudine()));
			statement.setFloat(2, Float.parseFloat(a.getLongitudine()));
			statement.setDate(3, (Date) a.getDataInserimento());
			inserito = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Errore di Registrazione su DB!");
			//e.printStackTrace();
		}
		
		if(inserito > 0) System.out.println("Registrazione Avvenuta con SUCCESSO!");
		else System.out.println("Registrazione FALLITA!");
		
	}
	
}
