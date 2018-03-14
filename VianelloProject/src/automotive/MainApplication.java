package automotive;

import java.util.Date;

import model.Utente;
import view.HomeView;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Utente user = new Utente();
		
		user.setId(1);
		user.setNome("Mario");
		user.setCognome("Saponara");
		user.setEmail("email");
		user.setPassword("q23");
		user.setDataRegistrazione(new Date(System.currentTimeMillis()));
		user.setRuolo(1);
		
		HomeView.runHomeView(user);
		
	}

}
