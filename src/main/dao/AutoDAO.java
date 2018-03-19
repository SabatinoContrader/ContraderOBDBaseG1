package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Auto;
import main.model.Dati_dispositivo;
import main.model.Dati_dispositivo;
import org.omg.CORBA.DATA_CONVERSION;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AutoDAO {
    private final String AZZERA_DRIVER = "UPDATE automobile set Driver=? where Cod_Dispositivo = ?";
    //private final String AZZERA_DRIVER_DRIVER = "UPDATE Driver set Id=? where"
    private final String DRIVER_WITH_ERROR = "SELECT * FROM dati_dispositivo d join automobile a on (d.Cod_Dispositivo = a.Cod_Dispositivo) where d.Stato = ?";
    private final String QUERY_ALL = "SELECT * FROM Automobile";
    private final String QUERY_ALL_AZIENDA = "SELECT * FROM Automobile WHERE proprietario = ? and id_driver != 0";
    private final String QUERY_ALL_WITH = "update Automobile set Driver=? where Cod_Dispositivo=?";
    private final String QUERY_AUTODRIVER = "SELECT * FROM Automobile WHERE id_driver = ?";
    private final String QUERY_INSERT = "INSERT into Automobile (Cod_Dispositivo , Targa, Telaio, Casa_Costruttrice, Modello ,Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, id_driver) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String QUERY_UPDATE = "UPDATE Automobile set Targa = ?, Telaio = ?, Casa_Costruttrice = ?, Modello = ? ,Alimentazione = ?, Tipologia = ?, Cambio = ?, Proprietario = ?, Revisione = ?, Tagliando_Data = ?, Tagliando_Km = ? WHERE Cod_Dispositivo = ?";
    private final String QUERY_RESET = "DELETE from Automobile WHERE Cod_Dispositivo = ?";
    private final String QUERY_FIND = "SELECT * from automobile WHERE Cod_Dispositivo = ?;";
    private final String QUERY_DELETEDATI = "DELETE from dati_dispositivo WHERE Cod_Dispositivo = ?;";

    public AutoDAO() {

    }

    public List<Auto> getAllAuto () {
        List<Auto> auto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int cod_Dispositivo = resultSet.getInt("Cod_Dispositivo");
               String targa = resultSet.getString("Targa");
               int telaio = resultSet.getInt("Tel   aio");
               String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
               String modello = resultSet.getString("Modello");
               String alimentazione = resultSet.getString("Alimentazione");
               String tipologia = resultSet.getString("Tipologia");
               String cambio = resultSet.getString("Cambio");
               int driver =  resultSet.getInt("id_Driver");
               int proprietario = resultSet.getInt("Proprietario");
               String revisione = resultSet.getString("Revisione");
               String tagliando_Data = resultSet.getString("Tagliando_Data");
               int tagliando_Km = resultSet.getInt("Tagliando_Km");
               auto.add(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

    public List<Auto> getAllAuto (int id) {
        List<Auto> auto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_AZIENDA);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cod_Dispositivo = resultSet.getInt("Cod_Dispositivo");
                String targa = resultSet.getString("Targa");
                int telaio = resultSet.getInt("Telaio");
                String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
                String modello = resultSet.getString("Modello");
                String alimentazione = resultSet.getString("Alimentazione");
                String tipologia = resultSet.getString("Tipologia");
                String cambio = resultSet.getString("Cambio");
                int driver =  resultSet.getInt("id_Driver");
                int proprietario = resultSet.getInt("Proprietario");
                String revisione = resultSet.getString("Revisione");
                String tagliando_Data = resultSet.getString("Tagliando_Data");
                int tagliando_Km = resultSet.getInt("Tagliando_Km");
                auto.add(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

    public HashMap<Dati_dispositivo, Auto> getDatiDispositiviWithError(){
        List<Dati_dispositivo> dati_Dispositivi = new ArrayList<>();
        HashMap<Dati_dispositivo, Auto> mappaErrori = new HashMap<Dati_dispositivo, Auto>();

        Connection connection = ConnectionSingleton.getInstance();

        try {
            int val = 1;
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVER_WITH_ERROR);
            preparedStatement.setInt(1, 1);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

               int Cod_Dispositivo =  resultSet.getInt("Cod_Dispositivo");
               String data = resultSet.getString("data");
               int Km =  resultSet.getInt("Km");
               String Codice_Errore =  resultSet.getString("Codice_Errore");
               int Stato =  resultSet.getInt("Stato");
               float Livello_Olio =  resultSet.getFloat("Livello_Olio");


               String Targa =  resultSet.getString("Targa");
               int Telaio =  resultSet.getInt("Telaio");
               String Casa_Costruttrice =  resultSet.getString("Casa_Costruttrice");
               String Modello =  resultSet.getString("Modello");
               String Alimentazione =  resultSet.getString("Alimentazione");
               String Tipologia =  resultSet.getString("Tipologia");
               String Cambio =  resultSet.getString("Cambio");
               int Driver =  resultSet.getInt("Driver");
               int Proprietario =  resultSet.getInt("Proprietario");
               String Revisione = resultSet.getString("Revisione");
               String Tagliando_Data =  resultSet.getString("Tagliando_Data");
               int Tagliando_Km =  resultSet.getInt("Tagliando_Km");


                new Dati_dispositivo(Cod_Dispositivo, data, Km, Livello_Olio, Codice_Errore, Stato);
                mappaErrori.put(new Dati_dispositivo(Cod_Dispositivo, data, Km, Livello_Olio, Codice_Errore, Stato),
                        new Auto (Cod_Dispositivo, Targa, Telaio, Casa_Costruttrice, Modello, Alimentazione, Tipologia, Cambio,  Proprietario, Revisione, Tagliando_Data, Tagliando_Km, Driver)
                );

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return mappaErrori;
    }


    public boolean insertAuto(Auto auto) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, auto.getCod_Dispositivo());
            preparedStatement.setString(2, auto.getTarga());
            preparedStatement.setInt(3, auto.getTelaio());
            preparedStatement.setString( 4, auto.getCasa_Costruttrice());
            preparedStatement.setString( 5, auto.getModello());
            preparedStatement.setString( 6, auto.getAlimentazione());
            preparedStatement.setString( 7, auto.getTipologia());
            preparedStatement.setString( 8, auto.getCambio());
            preparedStatement.setInt(9, auto.getDriver());
            preparedStatement.setInt( 10, auto.getProprietario());
            preparedStatement.setString( 11, auto.getRevisione());
            preparedStatement.setString( 12, auto.getTagliando_Data());
            preparedStatement.setInt( 13, auto.getTagliando_Km());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }


    }

    public boolean updateAuto(Auto auto) {
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, auto.getTarga());
            preparedStatement.setInt(2, auto.getTelaio());
            preparedStatement.setString( 3, auto.getCasa_Costruttrice());
            preparedStatement.setString( 4, auto.getModello());
            preparedStatement.setString( 5, auto.getAlimentazione());
            preparedStatement.setString( 6, auto.getTipologia());
            preparedStatement.setString( 7, auto.getCambio());
            preparedStatement.setInt( 8, auto.getProprietario());
            preparedStatement.setString( 9, auto.getRevisione());
            preparedStatement.setString( 10, auto.getTagliando_Data());
            preparedStatement.setInt( 11, auto.getTagliando_Km());
            preparedStatement.setInt(12, auto.getCod_Dispositivo());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public int updateAutoDriver(int Cod_Dispositivo, int Cod_Driver){
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_WITH);
            preparedStatement.setInt(1, Cod_Driver);
            preparedStatement.setInt(2, Cod_Dispositivo);

            return preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return 1000;
        }


    }

    public boolean resetAuto(int cod_Dispositivo) {
        Connection connection = ConnectionSingleton.getInstance();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RESET);
            preparedStatement.setInt(1, cod_Dispositivo);
            preparedStatement.execute();
            PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_DELETEDATI);
            preparedStatement1.setInt(1, cod_Dispositivo);
            return preparedStatement1.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public Auto findAuto(int cod_Dispositivo) {

        Connection connection = ConnectionSingleton.getInstance();
        Auto auto = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
            preparedStatement.setInt(1, cod_Dispositivo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String targa = resultSet.getString("Targa");
                int telaio = resultSet.getInt("Telaio");
                String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
                String modello = resultSet.getString("Modello");
                String alimentazione = resultSet.getString("Alimentazione");
                String tipologia = resultSet.getString("Tipologia");
                String cambio = resultSet.getString("Cambio");
                int proprietario = resultSet.getInt("Proprietario");
                String revisione = resultSet.getString("Revisione");
                String tagliando_Data = resultSet.getString("Tagliando_Data");
                int tagliando_Km = resultSet.getInt("Tagliando_Km");
                int driver = resultSet.getInt("id_Driver");
                auto = new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            return auto;
    }

    public List<Auto> listaAutoDriver(int id) {
        List<Auto> listaAutoDriver = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_AUTODRIVER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                int cod_Dispositivo = resultSet.getInt("cod_dispositivo");
                String targa = resultSet.getString("Targa");
                int telaio = resultSet.getInt("Telaio");
                String casa_Costruttrice = resultSet.getString("Casa_Costruttrice");
                String modello = resultSet.getString("Modello");
                String alimentazione = resultSet.getString("Alimentazione");
                String tipologia = resultSet.getString("Tipologia");
                String cambio = resultSet.getString("Cambio");
                int proprietario = resultSet.getInt("Proprietario");
                String revisione = resultSet.getString("Revisione");
                String tagliando_Data = resultSet.getString("Tagliando_Data");
                int tagliando_Km = resultSet.getInt("Tagliando_Km");
                int driver =  resultSet.getInt("id_driver");
                Auto auto = new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver  );
                listaAutoDriver.add(auto);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutoDriver;
    }


    public boolean azzeraDriver(int cod_dispositivo){
        Connection connection = ConnectionSingleton.getInstance();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(AZZERA_DRIVER);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, cod_dispositivo);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

        }
       return true;
    }
}
