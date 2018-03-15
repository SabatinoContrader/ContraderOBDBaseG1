package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import model.Auto;

public class CarDAO {

    public static List<Auto> getListAutoAzienda(int IdAzienda){
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Auto> lista = new ArrayList<>();
        String QUERY ="select a.* from auto a,auto_azienda az  where az.IdAzienda = ? and az.IdAuto=a.ID ";
        
        
        try {
            statement = conn.prepareStatement(QUERY);
            statement.setInt(1, IdAzienda);
            resultSet = statement.executeQuery();

         /*   if (resultSet.isBeforeFirst()) {
                System.out.println("Auto dell'azienda con Id "+IdAzienda);
            }
*/

            while(resultSet.next()) {

                //System.out.println("Trovate Auto Associate!");

                Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
                        resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
                        resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
                        resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
                        resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

                lista.add(a);

            }



        }
        catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Auto Azienda!");
        }


        return lista;
    }


    //Ottengo lista delle Auto di un Utente che non sono io
    public static List<Auto> getListAutoUtente(int IdUtente){
        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        List<Auto> lista = new ArrayList<>();
        String QUERY ="select a.* from auto a,auto_utente au  where au.IdUtente = ? and au.IdAuto=a.ID ";

        try {
            statement = conn.prepareStatement(QUERY);
            statement.setInt(1, IdUtente);
            resultSet = statement.executeQuery();

       /*     if (resultSet.isBeforeFirst()) {
                System.out.println("Auto dell'azienda con Id "+IdAzienda);
            }*/


            while(resultSet.next()) {

                //System.out.println("Trovate Auto Associate!");

                Auto a = new Auto(resultSet.getInt("ID"), resultSet.getString("Marca"), resultSet.getString("Modello"), resultSet.getString("Targa"),
                        resultSet.getString("NumeroTelaio"), resultSet.getInt("KmAttuali"),
                        resultSet.getInt("KmInizioNoleggio"), resultSet.getDate("ScadenzaRevisione"),
                        resultSet.getDate("ScadenzaTagliando"), resultSet.getDate("ScadenzaAssicurazione"),
                        resultSet.getDate("ScadenzaBollo"), resultSet.getString("TipologiaAuto"), resultSet.getInt("DaNoleggio"));

                lista.add(a);

            }



        }
        catch (SQLException e) {
            System.out.println("Errore di Recupero Lista Auto Azienda!");
        }


        return lista;
    }
}
