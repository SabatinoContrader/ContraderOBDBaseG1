package com.virtualpairprogrammers.dao;
import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import java.sql.*;


public class AutoDAO {
    private final String QUERY_INSERT = "INSERT into automobile (Cod_Dispositivo , Targa, Telaio, Casa_Costruttrice, Modello ,Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, id_driver) values (?,?,?,?,?,?,?,?,?,?,?,?, null)";
    private final String QUERY_ALL_WITH = "update automobile set id_driver=? where cod_dispositivo=?";
    private final String QUERY_UPDATE = "UPDATE Automobile set Targa = ?, Telaio = ?, Casa_Costruttrice = ?, Modello = ? ,Alimentazione = ?, Tipologia = ?, Cambio = ?, Proprietario = ?, Revisione = ?, Tagliando_Data = ?, Tagliando_Km = ? WHERE Cod_Dispositivo = ?";
    private final String QUERY_RESET = "DELETE from Automobile WHERE Cod_Dispositivo = ?";
    private final String QUERY_DELETEDATI = "DELETE from dati_dispositivo WHERE Cod_Dispositivo = ?;";
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
            preparedStatement.setInt(9, auto.getProprietario());
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

}





