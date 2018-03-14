package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "SELECT ruolo FROM login WHERE username = ? and password = ?";

    public String login (String username, String password) {

        String ruolo;
        ruolo = "";

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getInt("ruolo") == 1) {
                    ruolo = "owner";
                }
                else if(resultSet.getInt("ruolo") == 2) {
                    ruolo = "officina";
                }
                else if(resultSet.getInt("ruolo") == 3) {
                    ruolo = "azienda";
                }
                else if(resultSet.getInt("ruolo") == 4) {
                    ruolo = "driver";
                }

            }
            return ruolo;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return "";
        }
    }
}
