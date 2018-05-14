package main;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String Username;
	    String Password;
	    
	    System.out.println("LOGIN");
	    
	    Scanner input1 = new Scanner(System.in);
	    System.out.println(" inserisci Username : ");
	    
	    String username = input1.next();

	    Scanner input2 = new Scanner(System.in);
	    System.out.println("Password : ");
	    String password = input2.next();

	    Tabella tab = loginquery.login(username, password);
	    if(tab != null) 
	    	{
	    	System.out.println("Login effettuato!");
	    	System.out.println("ID: "+tab.getID()+" Username: "+ tab.getUsername());
	    	} else System.out.println("Log in fallito");
//	    
//	    if (username.equals(Username) && password.equals(Password)) {
//
//	        System.out.println("Welcome!");
//	    }
//
//	    else if (username.equals(Username)) {
//	        System.out.println("Invalid Password!");
//	    } else if (password.equals(Password)) {
//	        System.out.println("Invalid Username!");
//	    } else {
//	        System.out.println("Invalid Username & Password!");
//	    }
	
		
		

	}



	}


