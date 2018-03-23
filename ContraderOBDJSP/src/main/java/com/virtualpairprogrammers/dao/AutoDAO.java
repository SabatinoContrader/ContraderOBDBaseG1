package com.virtualpairprogrammers.dao;
import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AutoDAO {
    private final String QUERY_INSERT = "INSERT into automobile (Cod_Dispositivo , Targa, Telaio, Casa_Costruttrice, Modello ,Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, id_driver) values (?,?,?,?,?,?,?,?,?,?,?,?, null)";
    private final String QUERY_ALL_WITH = "update automobile set id_driver=? where cod_dispositivo=?";
    private final String QUERY_UPDATE = "UPDATE Automobile set Targa = ?, Telaio = ?, Casa_Costruttrice = ?, Modello = ? ,Alimentazione = ?, Tipologia = ?, Cambio = ?, Proprietario = ?, Revisione = ?, Tagliando_Data = ?, Tagliando_Km = ? WHERE Cod_Dispositivo = ?";
    private final String QUERY_RESET = "DELETE from Automobile WHERE Cod_Dispositivo = ?";
    private final String QUERY_DELETEDATI = "DELETE from dati_dispositivo WHERE Cod_Dispositivo = ?;";
    private final String QUERY_AUTODRIVER = "SELECT * FROM Automobile WHERE id_driver = ?";
    private final String QUERY_FIND = "SELECT * from automobile WHERE Cod_Dispositivo = ?;";

    public AutoDAO() {

    }

    public boolean insertAuto(Auto auto) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, auto.getCod_Dispositivo());
            preparedStatement.setString(2, auto.getTarga());
            preparedStatement.setInt(3, auto.getTelaio());
            preparedStatement.setString(4, auto.getCasa_Costruttrice());
            preparedStatement.setString(5, auto.getModello());
            preparedStatement.setString(6, auto.getAlimentazione());
            preparedStatement.setString(7, auto.getTipologia());
            preparedStatement.setString(8, auto.getCambio());
            preparedStatement.setString(9, auto.getProprietario());
            preparedStatement.setString(10, auto.getRevisione());
            preparedStatement.setString(11, auto.getTagliando_Data());
            preparedStatement.setInt(12, auto.getTagliando_Km());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public boolean updateAutoDriver(int Cod_Dispositivo, int Cod_Driver){
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_WITH);
            preparedStatement.setInt(1, Cod_Driver);
            preparedStatement.setInt(2, Cod_Dispositivo);
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
            preparedStatement.setString( 8, auto.getProprietario());
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
            PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_DELETEDATI);
            preparedStatement1.setInt(1, cod_Dispositivo);
            preparedStatement1.execute();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RESET);
            preparedStatement.setInt(1, cod_Dispositivo);
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public List<Auto> listaAutoDriver(int id_driver) {
        List<Auto> listaAutoDriver = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_AUTODRIVER);
            preparedStatement.setInt(1, id_driver);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                System.out.println("Non ci sono auto");
            }

            do {
                int cod_Dispositivo = resultSet.getInt("cod_dispositivo");
                String targa = resultSet.getString("Targa");
                int telaio = resultSet.getInt("Telaio");
                String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
                String modello = resultSet.getString("Modello");
                String alimentazione = resultSet.getString("Alimentazione");
                String tipologia = resultSet.getString("Tipologia");
                String cambio = resultSet.getString("Cambio");
                String proprietario = resultSet.getString("Proprietario");
                String revisione = resultSet.getString("Revisione");
                String tagliando_Data = resultSet.getString("Tagliando_Data");
                int tagliando_Km = resultSet.getInt("Tagliando_Km");
                int driver =  resultSet.getInt("id_driver");
                Auto auto = new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver  );
                listaAutoDriver.add(auto);
            } while (resultSet.next());

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutoDriver;
    }

    public Auto findAuto(int cod_Dispositivo) {

        Connection connection = ConnectionSingleton.getInstance();
        Auto auto = null;

        System.out.println("Sei nella DAO auto");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
            preparedStatement.setInt(1, cod_Dispositivo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String targa = resultSet.getString("Targa");
                int telaio = resultSet.getInt("Telaio");
                String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
                String modello = resultSet.getString("Modello");
                String alimentazione = resultSet.getString("Alimentazione");
                String tipologia = resultSet.getString("Tipologia");
                String cambio = resultSet.getString("Cambio");
                String proprietario = resultSet.getString("Proprietario");
                String revisione = resultSet.getString("Revisione");
                String tagliando_Data = resultSet.getString("Tagliando_Data");
                int tagliando_Km = resultSet.getInt("Tagliando_Km");
                int driver = resultSet.getInt("id_Driver");
                auto = new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

}





