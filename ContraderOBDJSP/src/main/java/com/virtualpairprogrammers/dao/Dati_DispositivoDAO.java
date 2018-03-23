package com.virtualpairprogrammers.dao;
import com.virtualpairprogrammers.domain.Auto;
import javax.servlet.http.HttpSession;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dati_DispositivoDAO {
    private final String AUTO_WITH_ERROR = "select* from dati_dispositivo d join automobile a on (d.cod_dispositivo=a.cod_dispositivo) where cod_errore is null and proprietario=?";
    
    
    public Dati_DispositivoDAO() {

    }

    public ResultSet listaAutoErrori(String proprietario) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(AUTO_WITH_ERROR);
            preparedStatement.setString(1, proprietario);
            return preparedStatement.executeQuery();
            
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }

    }

    
    	
    
}





