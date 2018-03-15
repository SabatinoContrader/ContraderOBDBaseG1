package controller;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.AlertsDAO;
import dao.AziendaDAO;
import dao.CarDAO;
import dao.GestioneUtenteDAO;
import model.Auto;
import model.Azienda;
import model.Utente;
import utility.Utility;
public class ControllerImpl implements IController {

	private AlertsDAO aDAO = new AlertsDAO();
	
    @Override
    public void showAlerts(Utente u) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

    }

    @Override
    public void signUpAziende() {
    	
    	String denominazione, nomeReferente, cognomeReferente, email, telefono, citta, latitudine, longitudine, tipologia;
    	Date dataInserimento;
    	
    	System.out.println("[Registrazione Azienda]: Inserisci i campi");
    	System.out.println("---------------------------");
    	
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
    	System.out.println("Citt&agrave; della Sede:");
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
        String oldmarca="",oldmodello="",oldtarga="",oldtelaio="",tipologia="",s="";
        Date d=new Date(System.currentTimeMillis());
        Date oldrevisione=d,oldtagliando=d,oldbollo=d,oldassicurazione=d;
        int oldkmattuali=0,oldkminizionoleggio=0,danoleggio=0;
        for(int i=0;i<auto.size();i++){
            if(idAuto==auto.get(i).getID()){
                oldmarca=auto.get(i).getMarca();
                oldmodello=auto.get(i).getModello();
                oldtarga=auto.get(i).getTarga();
                oldtelaio=auto.get(i).getNumeroTelaio();
                oldrevisione=auto.get(i).getScadenzaRevisione();
                oldtagliando=auto.get(i).getScadenzaTagliando();
                oldbollo=auto.get(i).getScadenzaBollo();
                oldassicurazione=auto.get(i).getScadenzaAssicurazione();
                oldkmattuali=auto.get(i).getKmAttuali();
                oldkminizionoleggio=auto.get(i).getKmInizioNoleggio();
                danoleggio=auto.get(i).getDaNoleggio();
                tipologia=auto.get(i).getTipologiaAuto();
                i=auto.size();

            }

        }

        System.out.println("Vuoi modificare la marca? y/n");
        s=Utility.getInput();
if(s.equals("y")) {
    System.out.println("Inserisci la nuova marca");
oldmarca = Utility.getInput();
}
        System.out.println("Vuoi modificare il modello? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci il nuovo modello");
            oldmodello = Utility.getInput();
        }

        System.out.println("Vuoi modificare la targa? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci la nuova targa");
            oldtarga = Utility.getInput();
        }

        System.out.println("Vuoi modificare il numero telaio? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci il nuovo telaio");
            oldtelaio = Utility.getInput();
        }
        System.out.println("Vuoi modificare i km attuali? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci i nuovi km");
            oldkmattuali = Integer.parseInt(Utility.getInput());
        }

        System.out.println("Vuoi modificare i km di inizio noleggio? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci i nuovi km di inizio noleggio");
            oldkminizionoleggio = Integer.parseInt(Utility.getInput());
        }


        System.out.println("Vuoi modificare se è da noleggio? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("E' da noleggio? y/n");
            if(Utility.getInput().equals("y"))
            danoleggio = 1;
            else if(Utility.getInput().equals("n")) danoleggio = 0;

        }

        System.out.println("Vuoi modificare la tipologia? y/n");
        s=Utility.getInput();
        if(s.equals("y")) {
            System.out.println("Inserisci la nuova tipologia");
            tipologia = Utility.getInput();
        }

        CarDAO.updateAuto( idAuto, oldmarca, oldmodello,  oldtarga,  oldtelaio,  oldkmattuali,
                oldkminizionoleggio, oldrevisione, oldtagliando, oldbollo, oldassicurazione, tipologia, danoleggio);
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
