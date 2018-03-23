package com.virtualpairprogrammers.dao;



import com.virtualpairprogrammers.domain.Officina;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficinaDAO {

    private final String QUERY_ADD = "insert into officina (Nome_Officina, Indirizzo, Citta) values (?,?,?)";
    private final String QUERY_LIST = "SELECT * from officina";
    private final String QUERY_LISTCITTA = "SELECT * from officina WHERE citta = ?";
    private final String QUERY_SELECTID = "select Id_Officina from officina order by Id_Officina Desc limit 1";


    public int addOfficina(Officina officina) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparestatement = connection.prepareStatement(QUERY_ADD);
            preparestatement.setString(1, officina.getNome());
            preparestatement.setString(2, officina.getIndirizzo());
            preparestatement.setString(3, officina.getCitta());
            preparestatement.execute();
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

    public List<Officina> listOfficina() {

        Connection connection = ConnectionSingleton.getInstance();
        List<Officina> lista = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String nome = resultSet.getString("nome_officina");
                String indirizzo = resultSet.getString("indirizzo");
                String citta = resultSet.getString("citta");
                Officina officina = new Officina( nome, indirizzo, citta);
                lista.add(officina);
            }
            return lista;

        }
        catch (SQLException e) {
            e.printStackTrace();
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }

    public List<Officina> listOfficina(String citta) {

        Connection connection = ConnectionSingleton.getInstance();
        List<Officina> lista = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LISTCITTA);
            statement.setString(1, citta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String nome = resultSet.getString("nome_officina");
                String indirizzo = resultSet.getString("indirizzo");
                Officina officina = new Officina( nome, indirizzo, citta);
                lista.add(officina);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            GestoreEccezioni.getInstance().gestisciEccezione(e);
        }
        return lista;
    }
}
