package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;

    public void showResults(Request request) {
        if (request!=null) {
            role = request.get("role").toString();
        }
    }


    public void showOptions() {
        switch (role)
        {
            case "owner":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU OWNER-------");
                System.out.println("1) Aggiungi officina");
                System.out.println("2) Logout");
                this.choice = Integer.parseInt(getInput());
                break;

            case "officina":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU OFFICINA-------");
                System.out.println("");
                System.out.println("1) Inserisci auto");
                System.out.println("9) Logout");
                this.choice = Integer.parseInt(getInput());
                break;

            case "azienda":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU AZIENDA-------");
                System.out.println("");
                System.out.println("9) Logout");
                this.choice = Integer.parseInt(getInput());
                break;

            case "driver":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU DRIVER-------");
                System.out.println("");
                System.out.println("9) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
        }

    }

    public void submit() {
        switch (role)
        {
            case "owner":
                switch (choice)
                {
                    case 1:
                        Request request= new Request();
                        request.put("choice",choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Officina", "doControl", request);
                        break;
                    case 2:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;
                }
            /*case "officina":
                switch (choice)
                {
                    case 1:
                        Request request = new Request();
                        String mode = "insert";
                        request.put("mode", mode);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 9:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        MainDispatcher.getInstance().callAction("Home", "doControl", null);
                }
            case "azienda":
                switch (choice)
                {
                    case 9:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        MainDispatcher.getInstance().callAction("Home", "doControl", null);
                }
            case "driver":
                switch (choice)
                {
                    case 9:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        MainDispatcher.getInstance().callAction("Home", "doControl", null);
                }*/
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
