package controller;


import java.sql.Date;
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
import utility.NotifierWorker;
import utility.Utility;
public class ControllerImpl implements IController {

	private AlertsDAO aDAO = new AlertsDAO();
	
    @Override
    public void showAlerts(Utente u) {
        // TODO Auto-generated method stub
    	
//    	//Prova con Thread che rimane in ascolto di Alert
//    	NotifierWorker worker = new NotifierWorker(u);
//    	worker.run();
    	
    	aDAO.getUserAlertsGuasti(u);
    	
    	
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
        }

        // Check Ruolo - if 0 non amministratore, 1 Amministratore Azienda
        if (u.getRuolo() == 1) {
            showAutoAzienda(u.getIdAzienda());
        }

        System.out.println("Cosa vuoi fare?");
        System.out.println("1)  Torna indietro");
        System.out.println("2)  Modifica Auto");
        System.out.println("3)  Visualizza dettagli Auto");
        if (u.getRuolo() == 1) {
            System.out.println("4)  Assegna dispositivo ad auto");
            System.out.println("5)  Visualizza storico riparazioni auto");

        }

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                //gobasck
                break;
            case "2":
                System.out.println("Inserisci ID dell'auto da modificare: ");
                String op = scanner.nextLine();
                makeUpdateAuto(Integer.parseInt(op),listauto);

                break;
            case "3":
//                showAutoDetail(idAuto);
                break;
            case "4":
                if(u.getRuolo()==1){
                    //             assignDeviceToAuto();
                }

                break;
            case "5":
                if(u.getRuolo()==1) {
                    //visualizza storico riparaizone
                }
               break;

        }

    }

    @Override
    public void showAllDevice(Utente u) {
        
    	List<Dispositivo> listaDispositivi = DispositivoDAO.showAllDevices(u.getIdAzienda());
    	
    	if(listaDispositivi.size() != 0) System.out.println("Elenco di Dispositivi dell'Azienda:\n");

    	for(int i = 0; i < listaDispositivi.size(); i ++) {

    		System.out.println("ID: "+listaDispositivi.get(i).getId()+"	Codice: "+listaDispositivi.get(i).getCodice()+"	Id Auto: "+listaDispositivi.get(i).getIdAuto()+"	Id Azienda: "+listaDispositivi.get(i).getIdAzienda()+"	Data di Installazione: "+listaDispositivi.get(i).getDataInstallazione());

    	}

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
    	System.out.println("Citta'; della Sede:");
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

    public static void makeUpdateAuto(int idAuto,List<Auto> auto){
        String s="";
      /*  String oldmarca="",oldmodello="",oldtarga="",oldtelaio="",tipologia="",s="";
        Date d=new Date(System.currentTimeMillis());
        Date oldrevisione=d,oldtagliando=d,oldbollo=d,oldassicurazione=d;
        int oldkmattuali=0,oldkminizionoleggio=0,danoleggio=0;*/
        for(int i=0;i<auto.size();i++){
            if(idAuto==auto.get(i).getID()){
                System.out.println("Vuoi modificare la marca? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci la nuova marca");
                    auto.get(i).setMarca(Utility.getInput());
                }
                System.out.println("Vuoi modificare il modello? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci il nuovo modello");
                    auto.get(i).setModello(Utility.getInput());
                }

                System.out.println("Vuoi modificare la targa? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci la nuova targa");
                    auto.get(i).setTarga(Utility.getInput());
                }

                System.out.println("Vuoi modificare il numero telaio? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci il nuovo telaio");
                    auto.get(i).setNumeroTelaio(Utility.getInput());
                }
                System.out.println("Vuoi modificare i km attuali? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci i nuovi km");
                    auto.get(i).setKmAttuali(Integer.parseInt(Utility.getInput()));
                }

                System.out.println("Vuoi modificare i km di inizio noleggio? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci i nuovi km di inizio noleggio");
                    auto.get(i).setKmInizioNoleggio(Integer.parseInt(Utility.getInput()));
                }


                System.out.println("Vuoi modificare se è da noleggio? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("E' da noleggio? y/n");
                    if(Utility.getInput().equals("y"))
                        auto.get(i).setDaNoleggio(1);
                    else if(Utility.getInput().equals("n")) auto.get(i).setDaNoleggio(0);

                }

                System.out.println("Vuoi modificare la tipologia? y/n");
                s=Utility.getInput();
                if(s.equals("y")) {
                    System.out.println("Inserisci la nuova tipologia");
                    auto.get(i).setTipologiaAuto(Utility.getInput());
                }



                CarDAO.updateAuto( auto.get(i));
                i=auto.size();
            }

        }



    }

    private static void showAutoAzienda(int idAzienda) {

        List<Auto> a =  CarDAO.getListAutoAzienda(idAzienda);

        for(int i = 0; i < a.size(); i ++) {
            System.out.println("------------------------------------");
            System.out.println("ID: " + a.get(i).getID());
            System.out.println("Marca: " + a.get(i).getMarca());
            System.out.println("Modello: " + a.get(i).getModello());
            System.out.println("Targa: " +  a.get(i).getTarga());
            System.out.println("Numero Telaio: " + a.get(i).getNumeroTelaio());

        }
    }


}
