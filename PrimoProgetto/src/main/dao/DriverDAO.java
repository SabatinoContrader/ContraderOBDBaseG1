package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Driver;

import java.sql.*;

public class DriverDAO {
    private final String QUERY_INSERT = "insert into driver (Id_driver, Nome, Cognome, cf,  Residenza) values (?,?,?,?,?)";
    private  final String QUERY_GET = "select * from dati_dispositivo where  Codice_Errore = NULL";

    public DriverDAO(){}

    public boolean insertDriver(Driver driver) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, driver.getId());
            preparedStatement.setString(2, driver.getNome());
            preparedStatement.setString(3, driver.getCognome());
            preparedStatement.setString(4, driver.getCf());
            preparedStatement.setString(5, driver.getResidenza());
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
            preparedStatement.setInt(1, Id_Driver );
            preparedStatement.setInt(2, Id_Auto );
            return  preparedStatement.executeUpdate();

        }
        catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return 1000;   }

    }


    public ResultSet getAllDriverConErrori(){

        Connection connection = ConnectionSingleton.getInstance();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET);
            return  preparedStatement.executeQuery();
        }
          catch (SQLException i){
            GestoreEccezioni.getInstance().gestisciEccezione(i);
            return null;
          }


    }

}



