package main.view;


import main.model.Login;
import main.service.DriverService;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Driver;
import main.service.DriverService;
import main.service.LoginService;

import java.util.Scanner;

public class DriverView implements View{

    private DriverService driverService;
    private LoginService loginService;
    private String role;
    private int id;

    public DriverView() {
        this.driverService = new DriverService();
        this.loginService= new LoginService();
    }

    @Override
    public void showResults(Request request) {
        this.role=(String)request.get("role");
        this.id=(Integer)request.get("id");
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
        String access = "D_00"+id;
        loginService.InsertLogin(new Login(access, access, 4, id));
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
        request.put("id",id);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }
}