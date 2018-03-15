package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Azienda;

public class AziendaDAO{

	void setAzienda(Azienda a) {
		
		String Query = "INSERT INTO `azienda` (`Denominazione`, `NomeReferente`, `CognomeReferente`, `Email`, `Telefono`, `Latitudine`, `Longitudine`, `Tipologia`, `DataInserimento`, `CittÃ `) VALUES (`"+a.getDenominazione()+"`, `"+a.getNomeReferente()+"`, `"+a.getCognomeReferente()+"`, `"+a.getEmail()+"`, `"+a.getTelefono()+"`, `"+a.getLatitudine()+"`, `"+a.getLongitudine()+"`, `"+a.getTipologia()+"`, `"+a.getDataInserimento()+"`, `"+a.getCitta()+" `)";
		
		System.out.println(Query);
		
		PreparedStatement statement;
		ResultSet resultSet = null;
		
		int inserito = 0;
		
		try {
			
			statement = ConnessioneDB.getInstance().prepareStatement(Query);
			inserito = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Errore di Registrazione su DB!");
			//e.printStackTrace();
		}
		
		if(inserito > 0) System.out.println("Registrazione Avvenuta con SUCCESSO!");
		else System.out.println("Registrazione FALLITA!");
		
	}
	
}
