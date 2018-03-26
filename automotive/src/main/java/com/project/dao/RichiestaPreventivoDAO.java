package com.project.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.model.RichiestaPreventivo;
import org.apache.log4j.Logger;


import com.project.model.Auto;
import com.project.model.Utente;
import utility.Utility;

public class RichiestaPreventivoDAO {


    public static boolean inviaRichiesta(String descrizione,int idutente,int idazienda,int idauto) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        int insertOk=0;
        String QUERY = "INSERT INTO richiesta_preventivo (ID,Descrizione,IdUtente,IdAuto,IdAzienda)VALUES(NULL,?,?,?,?)";
        try {


            statement = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, descrizione);
            statement.setInt(2, idutente);
            statement.setInt(3, idauto);
            statement.setInt(4, idazienda);

            insertOk = statement.executeUpdate();
        } catch (SQLException e) {
           System.out.println("ERRORE in inviaRichiesta: "+e);
        }
        if(insertOk>0)return true;else return false;
    }

    public static List <RichiestaPreventivo> getAllRichiestePreventivoUtente(int idutente) {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        int insertOk=0;
        List <RichiestaPreventivo> richieste = new ArrayList<>();
        String QUERY = "SELECT * FROM richiesta_preventivo WHERE IdUtente=?";
        try {


            statement = conn.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, idutente);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {

                //System.out.println("Trovate Auto Associate!");

                RichiestaPreventivo r = new RichiestaPreventivo(resultSet.getInt("ID"), resultSet.getString("Descrizione"),
                        resultSet.getInt("IdUtente"),resultSet.getInt("IdAuto"),
                        resultSet.getInt("IdAzienda"));

                richieste.add(r);

            }
        } catch (SQLException e) {
            System.out.println("ERRORE in getAllRichiestePreventivoUtente: "+e);
        }
       return richieste;
    }


}
