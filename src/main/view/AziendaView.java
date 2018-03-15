package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Azienda;
import main.service.AziendaService;

import java.util.Scanner;

public class AziendaView implements View {

    private AziendaService aziendaService;

    public AziendaView () {
        this.aziendaService = new AziendaService();
    }

    @Override
    public void showResults(Request request) {



    }

    @Override
    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------INSERIMENTO AZIENDA------------------------------");
        System.out.println("Inserisci il nome dell'azienda:");
        System.out.println("Nome Azienda:");
        String nomeAzienda = getInput();
        System.out.println("Città:");
        String nomeCittà = getInput();
        aziendaService.insertAzienda(new Azienda(nomeAzienda, nomeCittà));


    }




    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }
}
