package com.project.dao;
import java.sql.Connection;
import java.sql.SQLException;

//import main.controller.GestoreEccezioni;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class ConnessioneDB {

    private static Connection connection = null;

    private ConnessioneDB() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                String vendor="mysql";
                String driver="com.mysql.jdbc.Driver";
                String host="sql2.freemysqlhosting.net";
                String port="3306";
                String dbName="sql2226824";
                String username="sql2226824";
                String password ="kR2%yA7!";
                Class c = Class.forName(driver);
                System.out.println("Ho caricato: " + c.getName());
                String myUrl = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName;
                DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
                dataSource.setDriverClassName(driver);
                connection = dataSource.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
	public static void closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Chiusura Connessione FALLITA!");
			//e.printStackTrace();
		}
		
		
	}
}
