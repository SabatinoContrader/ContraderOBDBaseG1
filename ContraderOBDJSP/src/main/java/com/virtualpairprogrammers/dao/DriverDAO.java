package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.*;
import com.virtualpairprogrammers.domain.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    private final String QUERY_INSERT = "insert into driver (Id_driver, Nome, Cognome, cf,  Residenza) values (?,?,?,?,?)";
    private  final String LISTA_DRIVER = "select * from Driver";

    public DriverDAO(){}

    public boolean insertDriver(Driver driver) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
//            preparedStatement.setInt(1, driver.getId());
//            preparedStatement.setString(2, driver.getNome());
//            preparedStatement.setString(3, driver.getCognome());
//            preparedStatement.setString(4, driver.getCf());
//            preparedStatement.setString(5, driver.getResidenza());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public int updateAutoDriver(int Id_Driver, int Id_Auto){
        Connection connection = ConnectionSingleton.getInstance();
        try{
            String QUERY_UPDATE = "update automobile set Driver = ? where Code_Dispositivo=?";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
           
            return  preparedStatement.executeUpdate();

        }
        catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return 1000;   }

    }


    public ResultSet getAllDriverConErrori(){

        Connection connection = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(LISTA_DRIVER);
            return  preparedStatement.executeQuery();
        }
          catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return null;
          }
      }
    
    public List<Driver> getAllDriver(){
    	Connection connection = ConnectionSingleton.getInstance();
    	List<Driver> listaDriver = new ArrayList<Driver>();
    	try{
            PreparedStatement preparedStatement = connection.prepareStatement(LISTA_DRIVER);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	String nome = rs.getString("nome");
            	String cognome = rs.getString("cognome");
            	String cf = rs.getString("cf");
            	String residenza = rs.getString("residenza");
            	int id_driver = rs.getInt("id_driver");
            	listaDriver.add(new Driver(nome, cognome, cf, residenza, id_driver));
            }
            return listaDriver;
        }
          catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return null;
          }
    	
    	
    }
}



