package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.domain.Azienda;

import java.sql.*;

public class AziendaDAO {

    private final String QUERY_INSERT = "insert into azienda (nome, citta) values (?,?)";
    private final String QUERY_SELECTID = "select Id_Azienda from azienda order by Id_Azienda Desc limit 1";


    public AziendaDAO(){}

    public int insertAzienda(Azienda azienda) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement prepstatement = connection.prepareStatement(QUERY_INSERT);
            prepstatement.setString(1, azienda.getNomeAzienda());
            prepstatement.setString(2, azienda.getCitta());
            prepstatement.execute();
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





