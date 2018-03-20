package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Officina;


import java.sql.*;


public class OfficinaDAO {

    private final String QUERY_INSERT = "insert into officina (Nome_Officina, Indirizzo, Città) values (?,?,?)";
    private final String QUERY_SELECTID = "select Id_Officina from officina order by Id_Officina Desc limit 1";

    public OfficinaDAO(){

    }

    public int insertOfficina(Officina officina) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, officina.getNome_Officina());
            preparedStatement.setString(2, officina.getIndirizzo());
            preparedStatement.setString(3, officina.getCittà());
            preparedStatement.execute();
            Statement statement = connection.createStatement ();
            ResultSet resultSet = statement.executeQuery(QUERY_SELECTID);
            resultSet.next();
            return resultSet.getInt("Id_Officina");
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return 0;
        }

    }

}
