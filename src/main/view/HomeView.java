package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    private int id;

    Request request = new Request();
    String mode;


    public void showResults(Request request) {
        if (request!=null) {
            role = request.get("role").toString();
            Scanner scanner = new Scanner(request.get("id").toString());
            id = scanner.nextInt();
        }
    }

    public void showOptions() {
        switch (role)
        {
            case "owner":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("-------MENU OWNER-------");
                System.out.println("1) Aggiungi officina");
                System.out.println("2) Aggiungi azienda");
                System.out.println("3) Logout");
                break;

            case "officina":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("-------MENU OFFICINA-------");
                System.out.println("");
                System.out.println("1) Inserisci auto");
                System.out.println("2) Modifica auto");
                System.out.println("3) Reset dispositivo");
                System.out.println("4) Cerca auto");
                System.out.println("5) Logout");
                break;

            case "azienda":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("-------MENU AZIENDA-------");
                System.out.println("");
                System.out.println("1) Inserire Driver");
                System.out.println("2) Lista auto assegnate");
                System.out.println("3) Assegna Auto a Driver");
                System.out.println("4) Vedi lista Errori non risolti");
                System.out.println("5) Terminare noleggio ");
                System.out.println("6) Logout");
                break;

            case "driver":
                System.out.println("Benvenuto in ContraderOBDBase");
                System.out.println("");
                System.out.println("-------MENU DRIVER-------");
                System.out.println("1) Elenco auto");
                System.out.println("2) Logout");
                break;
        }

        boolean flag;
        do{
            flag=false;
            try{
                System.out.println("Inserisci il numero corrispondente alla tua scelta e premi invio");
                this.choice = Integer.parseInt(getInput());
            }
            catch(NumberFormatException e){
                flag=true;
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("id", id);
                System.out.println("Scelta non valida\nRiprova");
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
            }
        }while(flag);

    }

    public void submit() {
        Request request= new Request();
        request.put("choice",choice);
        request.put("role", role);
        request.put("id", id);

        switch (role)
        {
            case "owner":
                switch (choice)
                {
                    case 1:
                        request.put("mode","insert");
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
                        mode = "insert";
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 2:
                        mode = "update";
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 3:
                        mode = "reset";
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 4:
                        mode = "find";
                        request.put("mode", mode);
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
                        MainDispatcher.getInstance().callAction("Driver", "doControl", request);
                        break;
                    case 2:
                        mode = "listauto";
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;
                    case 3:
                        mode = "assegna_auto_driver";
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;
                    case 4:
                        mode = "lista_errori_non_risolti";
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;
                    case 5:
                        mode = "azzerare_driver";
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;
                    case 6:
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
                    case 1:
                        String mode = "listaAutoDriver";
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Auto", "doControl", request);
                        break;

                    case 2:
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
