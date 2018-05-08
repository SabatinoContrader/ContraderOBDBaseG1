package main;

import main.controller.Controller;

public class MainDispatcher {
	
	 private MainDispatcher() {
	    }

	    private static MainDispatcher instance;

	    public static MainDispatcher getInstance() {
	        if (instance == null) {
	            instance = new MainDispatcher();
	        }
	        return instance;
	    }

}
