package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Auto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {

    private final String QUERY_ALL = "SELECT * FROM Automobile";
//    private final String QUERY_GETDRIVER = "SELECT driver FROM Automobile WHERE Cod_Dispositivo = ?";
    private final String QUERY_INSERT = "insert into Automobile (Cod_Dispositivo , Targa, Telaio, Casa_Costruttrice, Modello ,Alimentazione, Tipologia, Cambio, Driver, Proprietario, Revisione, Tagliando_Data, Tagliando_Km) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String QUERY_UPDATE = "UPDATE Automobile set Targa = ?, Telaio = ?, Casa_Costruttrice = ?, Modello = ? ,Alimentazione = ?, Tipologia = ?, Cambio = ?, Proprietario = ?, Revisione = ?, Tagliando_Data = ?, Tagliando_Km = ? WHERE Cod_Dispositivo = ?";
    private final String QUERY_RESET = "DELETE from Automobile WHERE Cod_Dispositivo = ?";

    public AutoDAO() {

    }

    public List<Auto> getAllAuto () {
        List<Auto> auto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int cod_Dispositivo = resultSet.getInt("Cod_Dispositivo");
               String targa = resultSet.getString("Targa");
               int telaio = resultSet.getInt("Targa");
               String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
               String modello = resultSet.getString("Modello");
               String alimentazione = resultSet.getString("Alimentazione");
               String tipologia = resultSet.getString("Tipologia");
               String cambio = resultSet.getString("Cambio");
               int driver =  resultSet.getInt("Driver");
               int proprietario = resultSet.getInt("Proprietario");
               String revisione = resultSet.getString("Revisione");
               String tagliando_Data = resultSet.getString("Tagliando_Data");
               int tagliando_Km = resultSet.getInt("Tagliando_Km");
               auto.add(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, driver, proprietario, revisione, tagliando_Data, tagliando_Km));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

    public boolean insertAuto(Auto auto) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, auto.getCod_Dispositivo());
            preparedStatement.setString(2, auto.getTarga());
            preparedStatement.setInt(3, auto.getTelaio());
            preparedStatement.setString( 4, auto.getCasa_Costruttrice());
            preparedStatement.setString( 5, auto.getModello());
            preparedStatement.setString( 6, auto.getAlimentazione());
            preparedStatement.setString( 7, auto.getTipologia());
            preparedStatement.setString( 8, auto.getCambio());
            preparedStatement.setInt(9, auto.getDriver());
            preparedStatement.setInt( 10, auto.getProprietario());
            preparedStatement.setString( 11, auto.getRevisione());
            preparedStatement.setString( 12, auto.getTagliando_Data());
            preparedStatement.setInt( 13, auto.getTagliando_Km());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public boolean updateAuto(Auto auto) {
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, auto.getTarga());
            preparedStatement.setInt(2, auto.getTelaio());
            preparedStatement.setString( 3, auto.getCasa_Costruttrice());
            preparedStatement.setString( 4, auto.getModello());
            preparedStatement.setString( 5, auto.getAlimentazione());
            preparedStatement.setString( 6, auto.getTipologia());
            preparedStatement.setString( 7, auto.getCambio());
            preparedStatement.setInt( 8, auto.getProprietario());
            preparedStatement.setString( 9, auto.getRevisione());
            preparedStatement.setString( 10, auto.getTagliando_Data());
            preparedStatement.setInt( 11, auto.getTagliando_Km());
            preparedStatement.setInt(12, auto.getCod_Dispositivo());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public boolean resetAuto(int cod_Dispositivo) {
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RESET);
            preparedStatement.setInt(1, cod_Dispositivo);
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
