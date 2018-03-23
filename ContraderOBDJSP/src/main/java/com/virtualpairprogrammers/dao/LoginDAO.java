package com.virtualpairprogrammers.dao;



import com.virtualpairprogrammers.domain.Login;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from login where username = ? and password = ?";
    private final String QUERY_INSERT = "INSERT Login (Username, Password, Ruolo, Id) values (?,?,?,?)";


    public String login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            String role = "";
            if (resultSet.next())
            {
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
                String result= role + ":" + resultSet.getString("id");
                return result;
            }
            else
                return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
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
