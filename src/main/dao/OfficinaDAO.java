package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Officina;


import java.sql.*;


public class OfficinaDAO {

    private final String QUERY_INSERT = "insert into officina (Nome_Officina, Indirizzo, Nome_Città) values (?,?,?)";

    public OfficinaDAO(){

    }

    public boolean insertOfficina(Officina officina) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, officina.getNome_Officina());
            preparedStatement.setString(2, officina.getIndirizzo());
            preparedStatement.setString(3, officina.getNome_Città());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

}
