package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Azienda;

import java.sql.*;

public class AziendaDAO {

    private final String QUERY_INSERT = "insert into azienda (Nome, Città) values (?,?)";
    private final String QUERY_SELECTID = "select Id_Azienda from azienda order by Id_Azienda Desc limit 1";


    public AziendaDAO(){}

    public int insertAzienda(Azienda azienda) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, azienda.getNomeAzienda());
            preparedStatement.setString(2, azienda.getCittà());
            preparedStatement.execute();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(QUERY_SELECTID);
            resultset.next();
            return resultset.getInt("Id_Azienda");

        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return 0;
        }
    }


}
