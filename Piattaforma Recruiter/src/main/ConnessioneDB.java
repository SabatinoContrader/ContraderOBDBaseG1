package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//CONNESSIONE A DB prova

public class ConnessioneDB {
	
	public static String indirizzoIp = "localhost";
	public static int porta = 3306;
	public static String nomeDB = "prova";
	public static String username = "root";
	public static String password = "root";

	private static Connection conn = null;
	
	protected static int istanze = 0;
	
	public static Connection getInstance() throws SQLException {
		
		if(istanze == 0) {
			
			try {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+indirizzoIp+":"+porta+"/"+nomeDB+"", username, password);
				
				if(conn!=null) {
					System.out.println("Connessione avvenuta con SUCCESSO!");
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
	
	public static void query() {
		
		
		
	}
}
