package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.service.DriverService;

import java.util.Scanner;

public class AddDriverView implements View {

    private DriverService driverService;

    public AddDriverView () {
        this.driverService = new DriverService();
    }

    @Override
    public void showResults(Request request) { }

    @Override
    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------ASSEGNAZIONE AUTO A DRIVER------------------------------");
        System.out.println("Inserire i dati del Driver");
        System.out.println("Id Driver:");
        int id_Driver = Integer.valueOf(getInput());
        System.out.println("Id Dispositivo:");
        int id_Dispositivo = Integer.valueOf(getInput());

        driverService.updateAutoDriverDAO(id_Driver, id_Dispositivo);

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





