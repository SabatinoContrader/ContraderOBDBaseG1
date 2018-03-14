package automotive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import dao.ConnessioneDB;
import dao.LogInDAO;
import model.Auto;
import model.Utente;
import view.HomeView;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email;
		String password;
		
		
		System.out.println("Benvenuto...\n");
		
		System.out.println("Log In...\n");
		
		System.out.println("Email:");
		email = getInput();
		
		System.out.println("Password:");
		password = getInput();
		
		System.out.println("Accesso in Corso...");
		
		Utente o =  LogInDAO.logIn(email, password);
		
		for(int i = 0; i < o.getAuto().size(); i ++) System.out.println(o.getAuto().get(i).getID());
	
		HomeView.runHomeView(o);
		
		
		
		
		
		ConnessioneDB.closeConnection();
		
	}

	
	public static String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
	
}
