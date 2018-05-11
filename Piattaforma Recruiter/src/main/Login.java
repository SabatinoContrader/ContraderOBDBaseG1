package main;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String Username;
	    String Password;
	    
	    
	    Username = "nicola";
	    Password = "123456";
	    
	    System.out.println("LOGIN");
	    
	    Scanner input1 = new Scanner(System.in);
	    System.out.println("Username : ");
	    
	    String username = input1.next();

	    Scanner input2 = new Scanner(System.in);
	    System.out.println("Password : ");
	    String password = input2.next();

	
	    
	    if (username.equals(Username) && password.equals(Password)) {

	        System.out.println("Welcome!");
	    }

	    else if (username.equals(Username)) {
	        System.out.println("Invalid Password!");
	    } else if (password.equals(Password)) {
	        System.out.println("Invalid Username!");
	    } else {
	        System.out.println("Invalid Username & Password!");
	    }
	
		
		

	}

		
	}


