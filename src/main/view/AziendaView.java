package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Azienda;
import main.model.Login;
import main.service.AziendaService;
import main.service.LoginService;

import java.util.Scanner;

public class AziendaView implements View {

    private AziendaService aziendaService;
    private LoginService loginService;
    private String role;
    private int id;

    public AziendaView () {
        this.aziendaService = new AziendaService();
        this.loginService = new LoginService();
    }

    @Override
    public void showResults(Request request) {
        this.role=(String)request.get("role");
        this.id = (Integer)request.get("id");
    }

    @Override
    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------INSERIMENTO AZIENDA------------------------------");
        System.out.println("Inserisci il nome dell'azienda:");
        System.out.println("Nome Azienda:");
        String nomeAzienda = getInput();
        System.out.println("Città:");
        String Città = getInput();
        int id=aziendaService.insertAzienda(new Azienda(nomeAzienda, Città));
        String access = "A_0"+id;
        loginService.InsertLogin(new Login(access, access, 3, id));
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role",role);
        request.put("id", id);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }
}
