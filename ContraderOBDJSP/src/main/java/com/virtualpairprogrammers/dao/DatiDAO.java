package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.AutoConErrore;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.domain.Dati_dispositivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatiDAO {

    private final String QUERY_ERROR= "select dd.cod_dispositivo, casa_costruttrice, modello, targa, cod_errore from  dati_dispositivo dd join automobile a on (dd.cod_dispositivo=a.cod_dispositivo) where dd.stato=0  and proprietario=?";
    private final String QUERY_DATIAUTO = "SELECT * FROM dati_dispositivo WHERE  Cod_Dispositivo=?";
    private final String AUTO_WITH_ERROR = "select * from dati_dispositivo dd join automobile a on (dd.cod_dispositivo=a.cod_dispositivo) join driver d on (a.id_driver=d.id_driver) where cod_errore is not null and proprietario=?";

    public DatiDAO() {

    }

    public List<Dati_dispositivo> listaAllDatiDispositivo (int cod_Dispositivo) {
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

    public List<String> listaDatiDispositivo (int id_proprietario) {
        List<String> listaDatiAuto = new ArrayList<String>();
        String result="";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ERROR);
            preparedStatement.setInt(1, id_proprietario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    result += resultSet.getString("cod_dispositivo") + " ";
                    result += resultSet.getString("casa_costruttrice") + " ";
                    result += resultSet.getString("modello") + " ";
                    result += resultSet.getString("targa") + " ";
                    result += resultSet.getString("cod_errore") + "\n";
                    listaDatiAuto.add(result);
                }
            }else{

                listaDatiAuto.add("NON CI SONO AUTO CON ERRORI");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDatiAuto;
    }

    public List<AutoConErrore> listaAutoErrori(String proprietario) {
        Connection connection = ConnectionSingleton.getInstance();
        List<AutoConErrore> listaAutoConErrore = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(AUTO_WITH_ERROR);
            preparedStatement.setString(1, proprietario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String casa_Costruttrice = resultSet.getString("casa_Costruttrice");
                String modello = resultSet.getString("modello");
                String targa = resultSet.getString("targa");
                String data = resultSet.getString("data");
                String cod_errore = resultSet.getString("cod_errore");
                String nome_driver = resultSet.getString("nome");
                String cognome_driver = resultSet.getString("cognome");
                AutoConErrore auto = new AutoConErrore(casa_Costruttrice, modello, targa, data, cod_errore, nome_driver, cognome_driver);
                listaAutoConErrore.add(auto);
                auto.toString();
            }

            return listaAutoConErrore;


        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return listaAutoConErrore;
        }

    }

}
