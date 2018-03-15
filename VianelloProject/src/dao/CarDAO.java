package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

           if (resultSet.isBeforeFirst()) {
                System.out.println("\nAuto dell'azienda");
            }


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
        ConnessioneDB.closeConnection();

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

        ConnessioneDB.closeConnection();
        return lista;
    }


    // INSERT AUTO PER INSERIRE AUTO IN TABELLA AUTO ED ASSEGNARLA AD UN UTENTE
    public static void insertAutoUtente(int idUtente,int MaxKmNoleggio,String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
                                        int kmInizioNoleggio, Date scadenzaRevisione,Date scadenzaTagliando, Date scadenzaBollo, Date scadenzaAssicurazione, String tipologiaAuto, int daNoleggio) {

        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        int insertOk;
        String QUERY = "INSERT INTO auto (ID,Marca,Modello,Targa,NumeroTelaio,KmAttuali,KmInizioNoleggio,ScadenzaRevisione,ScadenzaTagliando,ScadenzaBollo,ScadenzaAssicurazione,TipologiaAuto,DaNoleggio)VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{

            statement = conn.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, marca);
            statement.setString(2, modello);
            statement.setString(3, targa);
            statement.setString(4, numeroTelaio);
            statement.setInt(5, kmAttuali);
            statement.setInt(6, kmInizioNoleggio);
            statement.setDate(7, scadenzaRevisione);
            statement.setDate(8, scadenzaTagliando);
            statement.setDate(9, scadenzaBollo);
            statement.setDate(10, scadenzaAssicurazione);
            statement.setString(11, tipologiaAuto);
            statement.setInt(12, daNoleggio);
            insertOk= statement.executeUpdate();
            if(insertOk>0){

                int autoIncKeyFromApi = -1;

                resultSet = statement.getGeneratedKeys();

                if (resultSet.next()) {
                    autoIncKeyFromApi = resultSet.getInt(1);

                    String QUERYCROSS="INSERT INTO auto_utente (IdUtente,IdAuto,MaxKmNoleggio) VALUES(?,?,?)";
                    try {

                        statement = conn.prepareStatement(QUERYCROSS);
                        statement.setInt(1,idUtente );
                        statement.setInt(2,autoIncKeyFromApi );
                        statement.setInt(3,MaxKmNoleggio );
                        insertOk= statement.executeUpdate();
                        if(insertOk>0){
                            System.out.println("Auto inserita correttamente");
                        }else{
                            System.out.println("Errore nell'inserimento auto");
                        }
                    }catch(SQLException e){
                        System.out.println(e);
                    }

                } else {

                    // throw an exception from here
                }

//                System.out.println("Key returned from getGeneratedKeys():"                        + autoIncKeyFromApi);


            }
            else System.out.println("Errore nell'inserimento auto");

        }catch(SQLException e){
            System.out.println(e);
        }

        ConnessioneDB.closeConnection();

    }

    //INSERT AUTO AZIENDA
    public static void insertAutoAzienda(int idAzienda,String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
                                        int kmInizioNoleggio, Date scadenzaRevisione,Date scadenzaTagliando, Date scadenzaBollo, Date scadenzaAssicurazione, String tipologiaAuto, int daNoleggio) {

        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        int insertOk;
        String QUERY = "INSERT INTO auto (ID,Marca,Modello,Targa,NumeroTelaio,KmAttuali,KmInizioNoleggio,ScadenzaRevisione,ScadenzaTagliando,ScadenzaBollo,ScadenzaAssicurazione,TipologiaAuto,DaNoleggio)VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{

            statement = conn.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, marca);
            statement.setString(2, modello);
            statement.setString(3, targa);
            statement.setString(4, numeroTelaio);
            statement.setInt(5, kmAttuali);
            statement.setInt(6, kmInizioNoleggio);
            statement.setDate(7, scadenzaRevisione);
            statement.setDate(8, scadenzaTagliando);
            statement.setDate(9, scadenzaBollo);
            statement.setDate(10, scadenzaAssicurazione);
            statement.setString(11, tipologiaAuto);
            statement.setInt(12, daNoleggio);
            insertOk= statement.executeUpdate();
            if(insertOk>0){

                int autoIncKeyFromApi = -1;

                resultSet = statement.getGeneratedKeys();

                if (resultSet.next()) {
                    autoIncKeyFromApi = resultSet.getInt(1);

                    String QUERYCROSS="INSERT INTO auto_azienda (IdAzienda,IdAuto) VALUES(?,?)";
                    try {

                        statement = conn.prepareStatement(QUERYCROSS);
                        statement.setInt(1,idAzienda );
                        statement.setInt(2,autoIncKeyFromApi );

                        insertOk= statement.executeUpdate();
                        if(insertOk>0){
                            System.out.println("Auto inserita correttamente");
                        }else{
                            System.out.println("Errore nell'inserimento auto");
                        }
                    }catch(SQLException e){
                        System.out.println(e);
                    }

                } else {

                    // throw an exception from here
                }

//                System.out.println("Key returned from getGeneratedKeys():"                        + autoIncKeyFromApi);


            }
            else System.out.println("Errore nell'inserimento auto");

        }catch(SQLException e){
            System.out.println(e);
        }

        ConnessioneDB.closeConnection();

    }

// AGGIORNAMENTO AUTO
public static void updateAuto(int idAuto,String marca, String modello, String targa, String numeroTelaio, int kmAttuali,
                                     int kmInizioNoleggio, Date scadenzaRevisione,Date scadenzaTagliando, Date scadenzaBollo, Date scadenzaAssicurazione, String tipologiaAuto, int daNoleggio) {

    Connection conn = ConnessioneDB.getInstance();
    PreparedStatement statement;
    ResultSet resultSet = null;
    int insertOk;
    String QUERY = "UPDATE auto SET Marca=?,Modello=?,Targa=?,NumeroTelaio=?,KmAttuali=?,KmInizioNoleggio=?,ScadenzaRevisione=?,ScadenzaTagliando=?,ScadenzaAssicurazione=?,ScadenzaBollo=?,TipologiaAuto=?,DaNoleggio=? WHERE ID=?";
    try{

        System.out.println(QUERY);

        statement = conn.prepareStatement(QUERY);



        statement.setString(1, marca);
        statement.setString(2, modello);
        statement.setString(3, targa);
        statement.setString(4, numeroTelaio);
        statement.setInt(5, kmAttuali);
        statement.setInt(6, kmInizioNoleggio);
        statement.setDate(7, scadenzaRevisione);
        statement.setDate(8, scadenzaTagliando);
        statement.setDate(9, scadenzaBollo);
        statement.setDate(10, scadenzaAssicurazione);
        statement.setString(11, tipologiaAuto);
        statement.setInt(12, daNoleggio);
        statement.setInt(13, idAuto);
        insertOk= statement.executeUpdate();
      /*  if(insertOk>0){

            int autoIncKeyFromApi = -1;

            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                autoIncKeyFromApi = resultSet.getInt(1);

                String QUERYCROSS="INSERT INTO auto_azienda (IdAzienda,IdAuto) VALUES(?,?)";
                try {

                    statement = conn.prepareStatement(QUERYCROSS);
                    statement.setInt(1,idAzienda );
                    statement.setInt(2,autoIncKeyFromApi );

                    insertOk= statement.executeUpdate();
                    if(insertOk>0){
                        System.out.println("Auto inserita correttamente");
                    }else{
                        System.out.println("Errore nell'inserimento auto");
                    }
                }catch(SQLException e){
                    System.out.println(e);
                }

            } else {

                // throw an exception from here
            }

//                System.out.println("Key returned from getGeneratedKeys():"                        + autoIncKeyFromApi);


        }
        else System.out.println("Errore nell'inserimento auto");*/

    }catch(SQLException e){
        System.out.println(e);
    }



}

    //RIMUOVI AUTO CON RIMOZIONE CROSS REFERENCE E UPDATE DISPOSITIVO
    public static void removeAuto(int idAuto) {

        Connection conn = ConnessioneDB.getInstance();
        PreparedStatement statement;
        ResultSet resultSet = null;
        int insertOk;
        String QUERY = "DELETE FROM auto_azienda WHERE IdAuto=?";

        try{

            statement = conn.prepareStatement(QUERY);
            statement.setInt(1, idAuto);
            statement.executeUpdate();

            try {
                String QUERYCROSS = "DELETE FROM auto_utente WHERE IdAuto=?";

                statement = conn.prepareStatement(QUERYCROSS);
                statement.setInt(1, idAuto);


                statement.executeUpdate();
            }catch(SQLException e){
                System.out.println("1: "+e);
            }
                  try{
            String QUERYCROSS3="UPDATE dispositivo SET IdAuto=NULL WHERE IdAuto=?";


            statement = conn.prepareStatement(QUERYCROSS3);
            statement.setInt(1, idAuto);
            statement.executeUpdate();
                  }catch(SQLException e){
                      System.out.println("2: "+e);
                  }
                  try {
                      String QUERYCROSS2 = "DELETE FROM auto WHERE ID=?";


                      statement = conn.prepareStatement(QUERYCROSS2);
                      statement.setInt(1, idAuto);
                     int res= statement.executeUpdate();
                     if(res==0){System.out.println("Auto non presente");}else{
                         System.out.println("Auto eliminata correttamente");
                     }

                     }catch(SQLException e){
            System.out.println("3: "+e);
        }


    }catch(SQLException e){
            System.out.println(e);
        }

        ConnessioneDB.closeConnection();

    }


}
