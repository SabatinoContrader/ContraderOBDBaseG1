package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Officina;
import main.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginDAO {

    private final String QUERY_LOGIN = "SELECT ruolo, id FROM login WHERE username = ? and password = ?";
    private final String QUERY_INSERT = "INSERT Login (Username, Password, Ruolo, Id) values (?,?,?,?)";

    public HashMap login (String username, String password) {
        HashMap login = new HashMap();
        String role;
        role = "";

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getInt("ruolo") == 1) {
                    role = "owner";
                }
                else if(resultSet.getInt("ruolo") == 2) {
                    role = "officina";
                }
                else if(resultSet.getInt("ruolo") == 3) {
                    role = "azienda";
                }
                else if(resultSet.getInt("ruolo") == 4) {
                    role = "driver";
                }

            login.put("role", role);
            login.put("id",resultSet.getInt("id"));
            return login;
            }
            else
            {
                System.out.println("");
                System.out.println("Dati di accesso errati, riprovare");
                return login;
            }

        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }

    public boolean insertLogin(Login login) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());
            preparedStatement.setInt(3, login.getRuolo());
            preparedStatement.setInt(4, login.getId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }



}
