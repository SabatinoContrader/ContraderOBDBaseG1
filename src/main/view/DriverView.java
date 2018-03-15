package main.view;


import main.service.DriverService;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Driver;
import main.service.DriverService;

import java.util.Scanner;

public class DriverView implements View{

    private DriverService driverService;
    private String role;

    public DriverView() {
        this.driverService = new DriverService();
    }

    @Override
    public void showResults(Request request) {
        this.role=(String)request.get("role");
    }

    @Override
    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------INSERIMENTO DRIVER------------------------------");
        System.out.println("Inserisci il nome del driver:");
        System.out.println("Id:");
        Integer id = Integer.parseInt(getInput());
        System.out.println("Nome Driver:");
        String nome = getInput();
        System.out.println("Cognome:");
        String cognome = getInput();
        System.out.println("Cf:");
        String cf = getInput();
        System.out.println("Residenza:");
        String residenza = getInput();
        driverService.insertDriver(new Driver(nome, cognome, cf, residenza, id));

    }


    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request=new Request();
        request.put("role",role);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }
}