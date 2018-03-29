package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.domain.Azienda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AziendaDAO {

    private final String QUERY_INSERT = "insert into azienda (nome, citta) values (?,?)";
    private final String QUERY_SELECTID = "select Id_Azienda from azienda order by Id_Azienda Desc limit 1";
    private final String QUERY_LIST = "SELECT * from azienda";


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

    public List<Azienda> listAzienda() {

        Connection connection = ConnectionSingleton.getInstance();
        List<Azienda> lista = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String nome = resultSet.getString("nome");
                String citta = resultSet.getString("citta");
                Azienda azienda = new Azienda( nome, citta);
                lista.add(azienda);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }
        return lista;
    }


}





