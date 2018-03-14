package dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//CONNESSIONE A DB SINGLETON

public class ConnessioneDB {
	
	public static String indirizzoIp = "127.0.0.1";
	public static int porta = 3306;
	public static String nomeDB = "db";
	public static String username = "root";
	public static String password = "root";

	private static Connection conn = null;
	
	protected static int istanze = 0;
	
	public static Connection getInstance() {
		
		if(istanze == 0) {
			
			try {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+indirizzoIp+":"+porta+"/"+nomeDB+"", username, password);
				
				if(conn!=null) {
					System.out.println("Connessione al DB avvenuta con SUCCESSO!");
				}
				
				istanze ++;
				
				return conn;
			
			} catch (SQLException e) {
				System.out.println("Connessione con DB Fallita!");
				//e.printStackTrace();
			}
			
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Chiusura Connessione FALLITA!");
			//e.printStackTrace();
		}
		
		
	}
}
