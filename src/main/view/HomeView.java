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
                System.out.println("2) Aggiungi azienda");
                System.out.println("3) Logout");
                System.out.println("Scelta:");
                break;

            case "officina":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU OFFICINA-------");
                System.out.println("");
                System.out.println("1) Inserisci auto");
                System.out.println("2) Modifica auto");
                System.out.println("3) Reset dispositivo");
                System.out.println("4) Cerca auto");
                System.out.println("5) Logout");
                System.out.println("Scelta:");
                break;

            case "azienda":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU AZIENDA-------");
                System.out.println("");
                System.out.println("1) Inserire Driver");
                System.out.println("2) Lista auto assegnate per Driver");
                System.out.println("3) Logout");
                System.out.println("Scelta:");
                break;

            case "driver":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU DRIVER-------");
                System.out.println("");
                System.out.println("9) Logout");
                System.out.println("Scelta:");
                break;
        }

        boolean flag;
        do{
            flag=false;
            try{
                this.choice = Integer.parseInt(getInput());
            }
            catch(NumberFormatException e){
                flag=true;
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                System.out.println("Scelta non valida\nRiprova");
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
            }
        }while(flag);

    }

    public void submit() {
        Request request = new Request();
        switch (role)
        {
            case "owner":
                switch (choice)
                {
                    case 1:
                        request.put("choice",choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Officina", "doControl", request);
                        break;
                    case 2:
                        request.put("choice",choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Azienda", "doControl", request);
                        break;
                    case 3:{
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;}
                    default:
                        System.out.println("Scelta non valida\nRiprova");
                        request.put ("choice", choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Home", "doControl", request);

                }
            case "officina":
                switch (choice)
                {
                    case 1:
                        String mode = "insert";
                        request.put("mode", mode);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 2:
                        mode = "update";
                        request.put("mode", mode);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 3:
                        mode = "reset";
                        request.put("mode", mode);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 4:
                        mode = "find";
                        request.put("mode", mode);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 5:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        System.out.println("Scelta non valida\nRiprova");
                        request.put("choice", choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Home", "doControl",request);
                }
            case "azienda":
                switch (choice)
                {
                    case 1:
                        request.put("choice",choice);
                        request.put("role", role);
                        MainDispatcher.getInstance().callAction("Driver", "doControl", request);
                        break;

                    case 2:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;


                    case 3:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        System.out.println("Scelta non valida\nRiprova");
                        request.put("choice", choice);
                        request.put("role",role);
                        MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }


            case "driver":
                switch (choice)
                {
                    case 9:
                        MainDispatcher.getInstance().callAction("Login", "doControl", null);
                        break;

                    default:
                        System.out.println("Scelta non valida\nRiprova");
                        request.put("choice", choice);
                        request.put("role",role);
                        MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
