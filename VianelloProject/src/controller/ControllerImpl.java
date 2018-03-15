package controller;

import com.mysql.jdbc.Connection;
import dao.ConnessioneDB;
import dao.GestioneUtenteDAO;
import model.Utente;
import utility.Utility;
import model.Auto;
import model.Azienda;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.AziendaDAO;
import dao.CarDAO;
public class ControllerImpl implements IController {

    @Override
    public void showAlerts(Utente u) {
        // TODO Auto-generated method stub

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
        System.out.println("1)  Modifica Auto");
        System.out.println("2)  Visualizza dettagli Auto");
        if (u.getRuolo() == 1) {
            System.out.println("3)  Assegna dispositivo ad auto");
            System.out.println("4)  Visualizza storico riparazioni auto");
            System.out.println("5)  Torna indietro");
        } else
            System.out.println("3)  Torna indietro");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        //System.out.println(option);

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
    	System.out.println("Città della Sede:");
    	citta = Utility.getInput();
    	
    	System.out.println("Inserisci Latitudine:");
    	latitudine = Utility.getInput();
    	System.out.println("Inserisci Longitudine:");
    	longitudine = Utility.getInput();
    	
    	System.out.println("Tipologia (0 = Officina, 1 = Casa Locataria) :");
    	tipologia = Utility.getInput();
    	
    	dataInserimento = new Date(System.currentTimeMillis());
    	
    	Azienda a = new Azienda(denominazione, nomeReferente, cognomeReferente, email, telefono, latitudine, longitudine, tipologia, dataInserimento, citta, null);

    	
    }

    @Override
    public void signUpUser() {
        // TODO Auto-generated method stub

    	GestioneUtenteDAO.signUp();
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
