package com.virtualpairprogrammers.dao;
import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import java.sql.*;


public class AutoDAO {
    private final String QUERY_INSERT = "INSERT into automobile (Cod_Dispositivo , Targa, Telaio, Casa_Costruttrice, Modello ,Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, id_driver) values (?,?,?,?,?,?,?,?,?,?,?,?, null)";
    private final String QUERY_ALL_WITH = "update automobile set id_driver=? where cod_dispositivo=?";
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
}





