package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.*;
import com.virtualpairprogrammers.domain.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    private final String QUERY_INSERT = "insert into driver (Id_driver, Nome, Cognome, cf, email, cellulare,  Residenza, id_azienda) values (?,?,?,?,?,?,?,?)";
    private  final String QUERY_LISTADRIVER = "select * from Driver WHERE id_azienda = ?";

    public DriverDAO(){}

    public boolean insertDriver(Driver driver) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, driver.getId());
            preparedStatement.setString(2, driver.getNome());
            preparedStatement.setString(3, driver.getCognome());
            preparedStatement.setString(4, driver.getCf());
            preparedStatement.setString(5, driver.getEmail());
            preparedStatement.setString(6, driver.getCellulare());
            preparedStatement.setString(7, driver.getResidenza());
            if(driver.getId_azienda() == null) preparedStatement.setString(8, null);
            else preparedStatement.setInt(8, driver.getId_azienda());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return true;
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
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_LISTADRIVER);
            return  preparedStatement.executeQuery();
        }
          catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return null;
          }
      }
    
    public List<Driver> getAllDriver(int id_azienda){
    	Connection connection = ConnectionSingleton.getInstance();
    	List<Driver> listaDriver = new ArrayList<>();
    	try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_LISTADRIVER);
            preparedStatement.setInt(1, id_azienda);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                int id_driver = resultSet.getInt("id_driver");
            	String nome = resultSet.getString("nome");
            	String cognome = resultSet.getString("cognome");
            	String cf = resultSet.getString("cf");
            	String email = resultSet.getString("email");
            	String cellulare = resultSet.getString("cellulare");
            	String residenza = resultSet.getString("residenza");
            	listaDriver.add(new Driver(id_driver, nome, cognome, cf, email, cellulare, residenza, id_azienda));
            }
            return listaDriver;
        }
          catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return null;
          }
    	
    	
    }
}



