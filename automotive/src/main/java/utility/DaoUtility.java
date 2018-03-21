package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.ConnessioneDB;
import com.project.model.Azienda;
import com.project.model.Utente;

public class DaoUtility {

	public static List<Azienda> getListaOfficine() {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Azienda> lista = new ArrayList<>();


        String QUERY = "select * from azienda";


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Officine");
            }


            while (resultSet.next()) {

                System.out.println("Trovate Aziende!");

                Azienda a = new Azienda(resultSet.getString("Denominazione"), resultSet.getString("NomeReferente"), resultSet.getString("CognomeReferente"), resultSet.getString("Email"),
                        resultSet.getString("Telefono"), resultSet.getString("Latitudine"),
                        resultSet.getString("Longitudine"), resultSet.getString("Tipologia"), resultSet.getDate("DataInserimento"), resultSet.getString("Citta"), null);

                a.id = resultSet.getInt("ID");
                
                lista.add(a);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Officine!");
        }

    return lista;
    }
	
	
	public static List<Utente> getListaUtenti() {
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Utente> lista = new ArrayList<>();


        String QUERY = "select * from utente";


        try {
            resultSet = null;
            statement = conn.prepareStatement(QUERY);
            resultSet = statement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("\nLista Utenti");
            }


            while (resultSet.next()) {

                System.out.println("Trovati Utenti!");

                Utente u = new Utente(resultSet.getInt("ID"), resultSet.getString("Nome"), resultSet.getString("Cognome"), resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("Stato"), resultSet.getInt("IdAzienda"), resultSet.getDate("DataRegistrazione"), resultSet.getInt("Ruolo"), resultSet.getString("Telefono"), null);
                
                lista.add(u);

            }


        } catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Utenti!");
        }

    return lista;
    }
	
	
	
	
	
	
}
