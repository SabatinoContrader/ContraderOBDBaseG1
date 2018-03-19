package controller;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.AlertsDAO;
import dao.AziendaDAO;
import dao.CarDAO;
import dao.DispositivoDAO;
import dao.GestioneUtenteDAO;
import model.Auto;
import model.Azienda;
import model.Dispositivo;
import model.Utente;
import utility.Utility;


public class ControllerImpl implements IController {

	private AlertsDAO aDAO = new AlertsDAO();
	private GestioneUtenteDAO guDAO = new GestioneUtenteDAO();
	private CarDAO cDAO = new CarDAO();
	private DispositivoDAO dDAO = new DispositivoDAO();

	@Override
	public void showAlerts(Utente u) {
		// TODO Auto-generated method stub

		//    	//Prova con Thread che rimane in ascolto di Alert
		//    	NotifierWorker worker = new NotifierWorker(u);
		//    	worker.run();
		//QUESTI SONO I GUASTI+
		aDAO.getUserAlertsGuasti(u); 	
	}

	public void alertsScadenzaRevisione(Utente u){
		aDAO.alertsScadenzaRevisione(u);
	}

	public void showAlertsKm(Utente u){
		aDAO.alertsKm(u);
	}
	public void showAllAlertsKm(Utente u){
		aDAO.allAlertsKm(u);
	}

	@Override
	public void showUserList(Utente u) {
		List<Utente> listutente;

		int idAzienda = u.getIdAzienda();
		listutente = guDAO.getListUtenti(idAzienda);

		if (listutente.size() > 0) {
			System.out.println("Lista Utenti");
		} else System.out.println("Non e' presente nessun utente");
		for (int i = 0; i < listutente.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("ID: " + listutente.get(i).getID());
			System.out.println("Nome: " + listutente.get(i).getNome());
			System.out.println("Cognome: " + listutente.get(i).getCognome());
			System.out.println("Email: " + listutente.get(i).getEmail());
			System.out.println("Telefono: " + listutente.get(i).getTelefono());
			System.out.println("Stato: " + listutente.get(i).getStato());
			System.out.println("Ruolo: " + listutente.get(i).getRuolo());
			System.out.println("Data registrazione: " + listutente.get(i).getDataRegistrazione());
		}
		System.out.println("\nCosa vuoi fare?");
		System.out.println("1)  Visualizza Auto Utente");
		System.out.println("2)  Modifica Utente");
		System.out.println("3)  Rimuovi Utente");
		System.out.println("4)  Inserisci Nuovo Utente");
		System.out.println("5)  Torna Indietro");

		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		/*SWITCH FOR OPTION ON USER OF THE LIST*/
		switch (option) {
		case "1":
			System.out.println("INSERISCI ID UTENTE: ");
			List<Auto> lauto;
			int iutente = Integer.parseInt(scanner.nextLine());
			lauto = cDAO.getListAutoUtente(iutente);
			if (lauto.size() > 0) {
				System.out.println("Lista Auto Utente");
			} else System.out.println("Non e' presente alcun'auto associata all'utente ");
			for (int i = 0; i < lauto.size(); i++) {
				System.out.println("------------------------------------");
				System.out.println("ID: " + lauto.get(i).getID());
				System.out.println("Marca: " + lauto.get(i).getMarca());
				System.out.println("Modello: " + lauto.get(i).getModello());
				System.out.println("Targa: " + lauto.get(i).getTarga());
				System.out.println("Numero Telaio: " + lauto.get(i).getNumeroTelaio());
				String dispositivo = dDAO.getDispositivo(lauto.get(i).getID());

				if (!(dispositivo).equals("no")) {
					System.out.println("Dispositivo associato: " + dispositivo);
				}
				;

			}
			System.out.println("\nCosa vuoi fare?");
			System.out.println("1)  Modificare Auto");
			System.out.println("2)  Aggiungi Auto");
			System.out.println("3)  Associa Dispositivo");
			System.out.println("4)  Torna Indietro");
			/*SWITCH FOR OPTION ON AUTO OF USER*/
			switch (scanner.nextLine()) {
			case "1":
				System.out.println("Inserisci ID dell'auto da modificare: ");
				String op = scanner.nextLine();
				makeUpdateAuto(Integer.parseInt(op), lauto);
				break;

			case "2":
				inserisciAutoUtente(iutente);

				break;
			case "3":
				// CASE ASSOCIATE DEVICE TO AUTO
				List<Dispositivo> dlist = dDAO.showAllDevices(idAzienda);
				if (dlist.size() == 0) {
					System.out.println("Non &egrave; presente alcun dispositivo");
				}
				int displiberi = 0;
				for (int i = 0; i < dlist.size(); i++) {
					if (dlist.get(i).getIdAuto() == 0) {
						System.out.println("------------------------------------");
						System.out.println("ID: " + dlist.get(i).getId());
						System.out.println("Codice: " + dlist.get(i).getCodice());

						displiberi++;
					}

				}
				if (displiberi > 0) {
					System.out.println("\nINSERISCI ID DISPOSTIVO");
					int iddisp = Integer.parseInt(Utility.getInput());
					System.out.println("\nINSERISCI ID AUTO");
					int idauto = Integer.parseInt(Utility.getInput());
					dDAO.setDispositivoAuto(iddisp, idauto);
				} else System.out.println("\nNON HAI DISPOSITIVI DISPONIBILI");
				break;

			}
			break;
		case "2":
			// CASE FOR USER UPDATE
			System.out.println("Inserisci ID dell'utente da modificare: ");
			String op = Utility.getInput();
			makeUpdateUtente(Integer.parseInt(op), listutente);
			break;
		case "3":
			//CASE REMOVE USER
			System.out.println("Inserisci ID dell'utente da rimuovere: ");

			guDAO.removeUtente(Integer.parseInt(Utility.getInput()));
			break;
		case "4":
			//CASE REGISTER NEW USER
			signUpUser();

			break;

		}
	}


	@Override
	public void showCarList(Utente u) {
		// TODO Auto-generated method stub
		List<Auto> listauto = u.getAuto();

		if (listauto.size() > 0) {
			System.out.println("Auto dell'utente");
		}
		for (int i = 0; i < listauto.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("ID: " + listauto.get(i).getID());
			System.out.println("Marca: " + listauto.get(i).getMarca());
			System.out.println("Modello: " + listauto.get(i).getModello());
			System.out.println("Targa: " + listauto.get(i).getTarga());
			System.out.println("Numero Telaio: " + listauto.get(i).getNumeroTelaio());
			String dispositivo = dDAO.getDispositivo(listauto.get(i).getID());

			if (!(dispositivo).equals("no")) {
				System.out.println("Dispositivo associato: " + dispositivo);
			}
			;

		}

		// Check Ruolo - if 0 non amministratore, 1 Amministratore Azienda
		if (u.getRuolo() == 1) {
			showAutoAzienda(u.getIdAzienda());
			showAutoAziendaClienti(u.getIdAzienda());
		}


		System.out.println("\nCosa vuoi fare?");
		System.out.println("1)  Torna indietro");
		System.out.println("2)  Modifica Auto");
		System.out.println("3)  Visualizza dettagli Auto");
		if (u.getRuolo() == 1) {
			System.out.println("4)  Assegna dispositivo ad auto");
			//   System.out.println("5)  Visualizza Dispositivi");
			//     System.out.println("5)  Visualizza storico riparazioni auto");

		}

		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":

			break;
		case "2":
			Utility.clearConsole();
			System.out.println("Inserisci ID dell'auto da modificare: ");
			String op = scanner.nextLine();
			makeUpdateAuto(Integer.parseInt(op), listauto);

			break;
		case "3":
			System.out.println("Inserisci ID dell'auto di cui vuoi vedere i dettagli: ");
			showAutoDetail(Integer.parseInt(scanner.nextLine()));
			break;
		case "4":
			if (u.getRuolo() == 1) {
				List<Dispositivo> dlist = dDAO.showAllDevices(u.getIdAzienda());
				if (dlist.size() == 0) {
					System.out.println("Non e presente alcun dispositivo");
				}
				int displiberi = 0;
				for (int i = 0; i < dlist.size(); i++) {
					if (dlist.get(i).getIdAuto() == 0) {
						System.out.println("------------------------------------");
						System.out.println("ID: " + dlist.get(i).getId());
						System.out.println("Codice: " + dlist.get(i).getCodice());

						displiberi++;
					}

				}
				if (displiberi > 0) {
					System.out.println("\nINSERISCI ID DISPOSTIVO");
					int iddisp = Integer.parseInt(Utility.getInput());
					System.out.println("\nINSERISCI ID AUTO");
					int idauto = Integer.parseInt(Utility.getInput());
					dDAO.setDispositivoAuto(iddisp, idauto);
				} else System.out.println("\nNON HAI DISPOSITIVI DISPONIBILI");
			}
			break;
			/*  case "5":
                if (u.getRuolo() == 1) {
                    //visualizza dispositivi
                    List<Dispositivo> newlistdispositivo = dDAO.showAllDevices(u.getIdAzienda());
                    if (newlistdispositivo.size() > 0) {
                        System.out.println("Lista dispositivi");
                    }
                    for (int i = 0; i < newlistdispositivo.size(); i++) {
                        System.out.println("------------------------------------");
                        System.out.println("ID: " + newlistdispositivo.get(i).getId());
                        System.out.println("Codice: " + newlistdispositivo.get(i).getCodice());
                        if (newlistdispositivo.get(i).getIdAuto() > 0)
                            System.out.println("ID Auto: " + newlistdispositivo.get(i).getIdAuto());
                        else System.out.println("ID Auto: Ancora non è installato su nessuna auto");
                       /* if(newlistdispositivo.get(i).getDataInstallazione())
                        System.out.println("Data Installazione: " + newlistdispositivo.get(i).getDataInstallazione());
			 */
			/*

                    }

                    Utility.clearConsole();
                    if (u.getRuolo() == 1) {
                        //visualizza storico riparaizone
                    }

                }
                break; */
		}

	}

	@Override
	public void showAllDevice(Utente u) {

		/*     List<Dispositivo> listaDispositivi = DispositivoDAO.showAllDevices(u.getIdAzienda());

        if (listaDispositivi.size() != 0) System.out.println("Elenco di Dispositivi dell'Azienda:\n");

        for (int i = 0; i < listaDispositivi.size(); i++) {

            System.out.println("ID: " + listaDispositivi.get(i).getId() + "	Codice: " + listaDispositivi.get(i).getCodice() + "	Id Auto: " + listaDispositivi.get(i).getIdAuto() + "	Id Azienda: " + listaDispositivi.get(i).getIdAzienda() + "	Data di Installazione: " + listaDispositivi.get(i).getDataInstallazione());

        }
		 */
		List<Dispositivo> newlistdispositivo = dDAO.showAllDevices(u.getIdAzienda());
		if (newlistdispositivo.size() > 0) {
			System.out.println("Lista dispositivi");
		}
		for (int i = 0; i < newlistdispositivo.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("ID: " + newlistdispositivo.get(i).getId());
			System.out.println("Codice: " + newlistdispositivo.get(i).getCodice());
			if (newlistdispositivo.get(i).getIdAuto() > 0)
				System.out.println("ID Auto: " + newlistdispositivo.get(i).getIdAuto());
			else System.out.println("ID Auto: Ancora non è installato su nessuna auto");
			/* if(newlistdispositivo.get(i).getDataInstallazione())
                        System.out.println("Data Installazione: " + newlistdispositivo.get(i).getDataInstallazione());
			 */


		}
		System.out.println();
	}

	@Override
	public void signUpAziende() {

		String denominazione, nomeReferente, cognomeReferente, email, telefono, citta, latitudine, longitudine, tipologia;
		Date dataInserimento;

		System.out.println("[Registrazione Azienda]: Inserisci i campi");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.println("Denominazione:");
		denominazione = Utility.getInput();
		System.out.println("Nome Referente:");
		nomeReferente = Utility.getInput();
		System.out.println("Cognome Referente:");
		cognomeReferente = Utility.getInput();
		System.out.println("Telefono:");
		telefono = Utility.getInput();
		System.out.println("Email:");
		email = Utility.getInput();
		System.out.println("Citta' della Sede:");
		citta = Utility.getInput();

		System.out.println("Inserisci Latitudine:");
		latitudine = Utility.getInput();
		System.out.println("Inserisci Longitudine:");
		longitudine = Utility.getInput();

		System.out.println("Tipologia (0 = Officina, 1 = Casa Locataria) :");
		tipologia = Utility.getInput();

		dataInserimento = new Date(System.currentTimeMillis());

		Azienda a = new Azienda(denominazione, nomeReferente, cognomeReferente, email, telefono, latitudine, longitudine, tipologia, dataInserimento, citta, null);

		AziendaDAO.setAzienda(a);
	}

	@Override
	public void signUpUser() {
		// TODO Auto-generated method stub

		GestioneUtenteDAO.signUp();
	}

	public static void makeUpdateAuto(int idAuto, List<Auto> auto) {
		String s = "";
		/*  String oldmarca="",oldmodello="",oldtarga="",oldtelaio="",tipologia="",s="";
        Date d=new Date(System.currentTimeMillis());
        Date oldrevisione=d,oldtagliando=d,oldbollo=d,oldassicurazione=d;
        int oldkmattuali=0,oldkminizionoleggio=0,danoleggio=0;*/
		for (int i = 0; i < auto.size(); i++) {
			if (idAuto == auto.get(i).getID()) {
				System.out.println("Vuoi modificare la marca? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci la nuova marca");
					auto.get(i).setMarca(Utility.getInput());
				}
				System.out.println("Vuoi modificare il modello? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo modello");
					auto.get(i).setModello(Utility.getInput());
				}

				System.out.println("Vuoi modificare la targa? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci la nuova targa");
					auto.get(i).setTarga(Utility.getInput());
				}

				System.out.println("Vuoi modificare il numero telaio? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo telaio");
					auto.get(i).setNumeroTelaio(Utility.getInput());
				}
				System.out.println("Vuoi modificare i km attuali? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci i nuovi km");
					auto.get(i).setKmAttuali(Integer.parseInt(Utility.getInput()));
				}

				System.out.println("Vuoi modificare i km di inizio noleggio? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci i nuovi km di inizio noleggio");
					auto.get(i).setKmInizioNoleggio(Integer.parseInt(Utility.getInput()));
				}


				System.out.println("Vuoi modificare se è da noleggio? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("E' da noleggio? y/n");
					if (Utility.getInput().equals("y"))
						auto.get(i).setDaNoleggio(1);
					else {
						auto.get(i).setDaNoleggio(0);
					}

				}

				System.out.println("Vuoi modificare la tipologia? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci la nuova tipologia");
					auto.get(i).setTipologiaAuto(Utility.getInput());
				}


				CarDAO.updateAuto(auto.get(i));
				i = auto.size();
			}

		}


	}

	public void makeUpdateUtente(int idUtente, List<Utente> utente) {
		String s = "";
		int res = 0;
		/*  String oldmarca="",oldmodello="",oldtarga="",oldtelaio="",tipologia="",s="";
        Date d=new Date(System.currentTimeMillis());
        Date oldrevisione=d,oldtagliando=d,oldbollo=d,oldassicurazione=d;
        int oldkmattuali=0,oldkminizionoleggio=0,danoleggio=0;*/
		for (int i = 0; i < utente.size(); i++) {
			if (idUtente == utente.get(i).getID()) {
				System.out.println("Vuoi modificare il nome? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo nome");
					utente.get(i).setNome(Utility.getInput());
				}
				System.out.println("Vuoi modificare il cognome? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo cognome");
					utente.get(i).setCognome(Utility.getInput());
				}

				System.out.println("Vuoi modificare l'email? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci la nuova email");
					utente.get(i).setEmail(Utility.getInput());
				}

				System.out.println("Vuoi modificare la password? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci la nuova password");
					utente.get(i).setPassword(Utility.getInput());
				}
				System.out.println("Vuoi modificare lo stato? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo stato: 0 - non bloccato, 1 - utente bloccato");
					utente.get(i).setStato(Integer.parseInt(Utility.getInput()));
				}
				/*
                System.out.println("Vuoi modificare il ruolo y/n");
                s = Utility.getInput();
                if (s.equals("y")) {
                    System.out.println("Inserisci i nuovi km di inizio noleggio");
                    utente.get(i).setKmInizioNoleggio(Integer.parseInt(Utility.getInput()));
                }
				 */

				System.out.println("Vuoi modificare il telefono? y/n");
				s = Utility.getInput();
				if (s.equals("y")) {
					System.out.println("Inserisci il nuovo telefono");
					utente.get(i).setTelefono(Utility.getInput());
				}


				res = guDAO.updateUtente(utente.get(i));
				if (res > 0) System.out.println("Utente aggiornato correttamente\n");
				i = utente.size();
			}

		}


	}

	private void showAutoAzienda(int idAzienda) {


		List<Auto> a = CarDAO.getListAutoAzienda(idAzienda);

		for (int i = 0; i < a.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("ID: " + a.get(i).getID());
			System.out.println("Marca: " + a.get(i).getMarca());
			System.out.println("Modello: " + a.get(i).getModello());
			System.out.println("Targa: " + a.get(i).getTarga());
			System.out.println("Numero Telaio: " + a.get(i).getNumeroTelaio());
			String dispositivo = dDAO.getDispositivo(a.get(i).getID());

			if (!(dispositivo).equals("no")) {
				System.out.println("Dispositivo associato: " + dispositivo);
			}


		}
	}

	private void showAutoAziendaClienti(int idAzienda) {


		List<Auto> a = CarDAO.getListAutoAziendaClienti(idAzienda);

		for (int i = 0; i < a.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("ID: " + a.get(i).getID());
			System.out.println("Marca: " + a.get(i).getMarca());
			System.out.println("Modello: " + a.get(i).getModello());
			System.out.println("Targa: " + a.get(i).getTarga());
			System.out.println("Numero Telaio: " + a.get(i).getNumeroTelaio());
			String dispositivo = dDAO.getDispositivo(a.get(i).getID());

			if (!(dispositivo).equals("no")) {
				System.out.println("Dispositivo associato: " + dispositivo);
			}
			;

		}
	}

	public void alertsRevisioneGarageAdmin(Utente u){
		aDAO.alertsRevisioneGarageAdmin(u);
	}

	private static void inserisciAutoUtente(int idutente) {
		String marca = "", modello = "", targa = "", numeroTelaio = "", tipologia = "";
		int maxKmNoleggio = 0, kmInizioNoleggio = 0, kmAttuali = 0, daNoleggio = 0;
		Date d = new Date(System.currentTimeMillis());
		Date scadenzaRevisione = d, scadenzaTagliando = d, scadenzaBollo = d, scadenzaAssicurazione = d;
		System.out.print("Inserisci marca: ");
		marca = Utility.getInput();
		System.out.print("Inserisci modello: ");
		modello = Utility.getInput();
		System.out.print("Inserisci targa: ");
		targa = Utility.getInput();
		System.out.print("Inserisci numero di telaio: ");
		numeroTelaio = Utility.getInput();

		System.out.print("Inserisci Km Attuali: ");
		kmAttuali = Integer.parseInt(Utility.getInput());
		System.out.println("E' un auto noleggiata? y/n");
		if (Utility.getInput().equals("y")) {
			daNoleggio = 1;

			System.out.print("Inserisci Massimo km noleggio: ");
			maxKmNoleggio = Integer.parseInt(Utility.getInput());

			System.out.print("Inserisci km inizio noleggio: ");
			kmInizioNoleggio = Integer.parseInt(Utility.getInput());
		}


		CarDAO.insertAutoUtente(idutente, maxKmNoleggio, marca, modello, targa, numeroTelaio, kmAttuali,
				kmInizioNoleggio, scadenzaRevisione, scadenzaTagliando, scadenzaBollo, scadenzaAssicurazione, tipologia, daNoleggio);
	}
	//INSERISCI NUOVA AUTO AZIENDA
	public  void inserisciAutoAzienda(int idazienda) {
		String marca = "", modello = "", targa = "", numeroTelaio = "", tipologia = "";
		int maxKmNoleggio = 0, kmInizioNoleggio = 0, kmAttuali = 0, daNoleggio = 0;
		Date d = new Date(System.currentTimeMillis());
		Date scadenzaRevisione = d, scadenzaTagliando = d, scadenzaBollo = d, scadenzaAssicurazione = d;
		System.out.print("Inserisci marca: ");
		marca = Utility.getInput();
		System.out.print("Inserisci modello: ");
		modello = Utility.getInput();
		System.out.print("Inserisci targa: ");
		targa = Utility.getInput();
		System.out.print("Inserisci numero di telaio: ");
		numeroTelaio = Utility.getInput();

		System.out.print("Inserisci Km Attuali: ");
		kmAttuali = Integer.parseInt(Utility.getInput());
		System.out.println("E' un auto da noleggio? y/n");
		if (Utility.getInput().equals("y")) {
			daNoleggio = 1;
/*
			System.out.print("Inserisci Massimo km noleggio: ");
			maxKmNoleggio = Integer.parseInt(Utility.getInput());

			System.out.print("Inserisci km inizio noleggio: ");
			kmInizioNoleggio = Integer.parseInt(Utility.getInput());*/
		}


		CarDAO.insertAutoAzienda(idazienda, marca, modello, targa, numeroTelaio, kmAttuali,
				kmInizioNoleggio, scadenzaRevisione, scadenzaTagliando, scadenzaBollo, scadenzaAssicurazione, tipologia, daNoleggio);
	}

	private void showAutoDetail(int idAuto) {
		ResultSet resultSet = cDAO.getAutoDetail(idAuto);
		try {
			while (resultSet.next()) {
				System.out.println("AUTO: " + resultSet.getString("Marca") + " " + resultSet.getString("Modello"));
				System.out.println("TARGA: " + resultSet.getString("Targa"));
				System.out.println("TELAIO: " + resultSet.getString("NumeroTelaio"));
				System.out.println("KM ATTUALI: " + resultSet.getInt("KmAttuali"));
				if (resultSet.getInt("DaNoleggio") == 1)
					System.out.println("KM INIZIO NOLEGGIO: " + resultSet.getString("KmInizioNoleggio"));
				System.out.println("SCADENZA REVISIONE: " + resultSet.getDate("ScadenzaRevisione"));
				System.out.println("SCADENZA TAGLIANDO: " + resultSet.getDate("ScadenzaTagliando"));
				System.out.println("SCADENZA ASSICURAZIONE: " + resultSet.getDate("ScadenzaAssicurazione"));
				System.out.println("SCADENZA BOLLO: " + resultSet.getDate("ScadenzaBollo"));
				System.out.println("CLIENTE: " + resultSet.getString("Nome") + " " + resultSet.getString("Cognome"));
				System.out.println("EMAIL: " + resultSet.getString("Email"));
				System.out.println("TELEFONO : " + resultSet.getString("Telefono"));

				//System.out.println("Trovate Auto Associate!");


			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	/*private static void goBack(Utente u) {
        HomeView.runHomeView(u);
    }*/
}

