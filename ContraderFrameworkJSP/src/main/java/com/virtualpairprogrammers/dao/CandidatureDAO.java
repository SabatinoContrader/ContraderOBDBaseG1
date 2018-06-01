package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.Candidature;
import com.virtualpairprogrammers.utils.ConnectionSingleton;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatureDAO {

    public boolean iscrizioneAnnuncio(Candidature candidatura) {

        //String QUERY_INSERT = "INSERT INTO recruitmentplatform.candidature (ID_Annunci, ID_Candidati) VALUES (( select id from annunci where id = '?'), (select id from utente where id ='?'))";
        String QUERY_INSERT = "INSERT INTO recruitmentplatform.candidature (ID_Annunci, ID_Candidati) VALUES (?, ?)";
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, candidatura.getID_Annunci());
            preparedStatement.setInt(2, candidatura.getID_Candidati());

            int a = preparedStatement.executeUpdate();

            if (a > 0)
                return true;
            else
                return false;

        } catch (SQLException e) {

            return false;

        }


    }
}