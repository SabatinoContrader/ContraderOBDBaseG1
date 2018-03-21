package com.virtualpairprogrammers.dao;



import com.virtualpairprogrammers.domain.Officina;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfficinaDAO {

    private final String QUERY_ADD = "insert into officina (Nome_Officina, Indirizzo, Citta) values (?,?,?)";
    private final String QUERY_LIST = "SELECT * from officina";
    private final String QUERY_LISTCITTA = "SELECT * from officina WHERE citta = ?";

    public boolean addOfficina(Officina officina) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD);
            statement.setString(1, officina.getNome());
            statement.setString(2, officina.getIndirizzo());
            statement.setString(3, officina.getCitta());
            return statement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return true;
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
            return lista;

        }
        catch (SQLException e) {
            e.printStackTrace();
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }
}
