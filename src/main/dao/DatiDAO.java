package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Auto;
import main.model.Dati_dispositivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatiDAO {

    private final String QUERY_ALL = "SELECT * FROM Automobile";
    private final String QUERY_DATIAUTO = "SELECT * FROM dati_dispositivo WHERE cod_dispositivo = ?";

    public DatiDAO() {

    }

    public List<Dati_dispositivo> listaDatiDispositivo (int cod_Dispositivo) {
        List<Dati_dispositivo> listaDatiAuto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DATIAUTO);
            preparedStatement.setInt(1, cod_Dispositivo);
            ResultSet resultSet = preparedStatement.executeQuery();

           while (resultSet.next()) {
               String data = resultSet.getString("Data");
               int km = resultSet.getInt("Km");
               float livello_olio = resultSet.getFloat("Livello_Olio");
               String codice_Errore = resultSet.getString("Cod_Errore");
               int stato = resultSet.getInt("Stato");
               Dati_dispositivo dato = new Dati_dispositivo(cod_Dispositivo, data, km, livello_olio, codice_Errore, stato);
               listaDatiAuto.add(dato);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDatiAuto;
    }

}
