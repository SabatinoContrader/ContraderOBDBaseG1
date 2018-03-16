package utility;

import automotive.MainApplication;
import dao.AlertsDAO;
import model.Utente;

public class NotifierWorker extends Thread{

	private Utente u;
	
	public NotifierWorker(Utente utente) { u = utente; }
	
	public void run() {
		
		AlertsDAO aDAO = new AlertsDAO();
		
		while (!MainApplication.exit) {
			
			aDAO.getUserAlertsGuasti(u);
			
			//Ogni 15 secondi controlla
			
			try {
				Thread.yield();
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
}}
