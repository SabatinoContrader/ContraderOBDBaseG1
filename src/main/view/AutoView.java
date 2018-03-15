package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Auto;
import main.service.AutoService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AutoView implements View {

    private AutoService autoService;
    private String mode;
    private String role;

  public AutoView() {
      this.autoService = new AutoService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       this.role  = (String) request.get("role");

    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
     //           List<Gomma> gomme = gommaService.getAllGomme();
     //           System.out.println("----- Gomme disponibili -----");
     //           System.out.println();
     //           gomme.forEach(gomma -> System.out.println(gomma));
                break;

            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati dell'auto:");
                System.out.println("Codice del dispositivo associato:");
                int cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("Targa");
                String targa = getInput();
                System.out.println("Num. Telaio");
                int telaio = Integer.parseInt(getInput());
                System.out.println("Casa costruttrice");
                String casa_Costruttrice = getInput();
                System.out.println("Modello");
                String modello = getInput();
                System.out.println("Alimentazione");
                String alimentazione = getInput();
                System.out.println("Tipologia");
                String tipologia = getInput();
                System.out.println("Cambio (A per automatico, M per manuale");
                String cambio = getInput();
                System.out.println("ID azienda proprietaria");
                int proprietario = Integer.parseInt(getInput());
                System.out.println("Data ultima revisione in formato GG/MM/AA");
                String revisione = getInput();
                System.out.println("Data ultimo tagliando in formato GG/MM/AA");
                String tagliando_Data = getInput();
                System.out.println("Chilometri all'ultimo tagliando");
                int tagliando_Km = Integer.parseInt(getInput());
                System.out.println("");

                int driver = 0;
                autoService.insertAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, driver, proprietario, revisione, tagliando_Data, tagliando_Km));
                break;

            case "update":
                 scanner = new Scanner(System.in);
                System.out.println("Inserisci il codice del dispositivo associato all'auto da modificare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("Targa");
                targa = getInput();
                System.out.println("Num. Telaio");
                telaio = Integer.parseInt(getInput());
                System.out.println("Casa costruttrice");
                casa_Costruttrice = getInput();
                System.out.println("Modello");
                modello = getInput();
                System.out.println("Alimentazione");
                alimentazione = getInput();
                System.out.println("Tipologia");
                tipologia = getInput();
                System.out.println("Cambio (A per automatico, M per manuale");
                cambio = getInput();
                System.out.println("ID azienda proprietaria");
                proprietario = Integer.parseInt(getInput());
                System.out.println("Data ultima revisione in formato GG/MM/AA");
                revisione = getInput();
                System.out.println("Data ultimo tagliando in formato GG/MM/AA");
                tagliando_Data = getInput();
                System.out.println("Chilometri all'ultimo tagliando");
                tagliando_Km = Integer.parseInt(getInput());
                System.out.println("");

                driver = 0;
                autoService.updateAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, driver, proprietario, revisione, tagliando_Data, tagliando_Km));
                break;

            case "reset":
                scanner = new Scanner(System.in);
                System.out.println("Inserisci il codice del dispositivo da resettare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("Verrà cancellata l'auto ad esso associata e tutti i dati relativi");
                autoService.resetAuto(cod_Dispositivo);
                break;

            case "find":
                scanner = new Scanner(System.in);
                System.out.println("Inserisci il codice del dispositivo da resettare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("Verrà cancellata l'auto ad esso associata e tutti i dati relativi");
                autoService.resetAuto(cod_Dispositivo);
                break;
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }
  /*  public Date getData() {
            Scanner scanner = new Scanner(getInput()).useDelimiter("/");
            int giorno = scanner.nextInt();
            int mese = scanner.nextInt();
            int anno = scanner.nextInt();
            Date data = new Date(giorno, mese, anno);
            DateFormat df = new SimpleDateFormat("dd/mm/yy");
            Date data = null;
            try {
                data =  df.parse(target);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return data;
        }*/
    @Override
    public void submit() {
        Request request = new Request();
        request.put("role",role);
        MainDispatcher.getInstance().callAction("Home", "doControl",   request);
    }



}
