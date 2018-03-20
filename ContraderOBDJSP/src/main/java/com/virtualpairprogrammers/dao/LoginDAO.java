package com.virtualpairprogrammers.dao;



import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from login where username = ? and password = ?";

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
}
