package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Dispositivo;


public class DispositivoDAO {

	public static List<Dispositivo> showAllDevices(int IdAzienda) {
		
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
		
		return listaDispositivi;
		
	}

	public static void setDispositivoAuto(int iddisp,int idauto){
		Connection conn = ConnessioneDB.getInstance();

		String QUERY = "UPDATE dispositivo SET IdAuto=? WHERE ID=?";

		PreparedStatement statement;
		ResultSet resultSet = null;

		try {

			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, idauto);
			statement.setInt(2,iddisp);
			 statement.executeUpdate();
	}catch(SQLException e){
		System.out.println(e);
		}
	}

	public String getDispositivo(int idauto){
		String codice="";
		Connection conn = ConnessioneDB.getInstance();

		String QUERY = "SELECT Codice FROM dispositivo WHERE IdAuto=?";

		PreparedStatement statement;
		ResultSet resultSet = null;

		try {

			statement = conn.prepareStatement(QUERY);
			statement.setInt(1, idauto);
			resultSet=statement.executeQuery();

			if (resultSet.isBeforeFirst()){
				while(resultSet.next()) {
					codice=resultSet.getString("Codice");
			}
				return codice;
				}

				else return "no";
		}catch(SQLException e){
			System.out.println(e);
			return "no";
		}

	}
}
	
	

