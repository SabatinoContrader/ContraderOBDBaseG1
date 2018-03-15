package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Azienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AziendaDAO {

    private final String QUERY_INSERT = "insert into azienda (Nome, Nome_Città) values (?,?)";

    public AziendaDAO(){}

    public boolean insertAzienda(Azienda azienda) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, azienda.getNomeAzienda());
            preparedStatement.setString(2, azienda.getNomeCittà());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
