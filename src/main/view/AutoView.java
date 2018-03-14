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

  public AutoView() {
      this.autoService = new AutoService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
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
                Date revisione = getData();
                System.out.println("Data ultimo tagliando in formato GG/MM/AA");
                Date tagliando_Data = getData();
                System.out.println("Chilometri all'ultimo tagliando");
                int tagliando_Km = Integer.parseInt(getInput());
                System.out.println("");

                int driver = 0;
                autoService.insertAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, driver, proprietario, revisione, tagliando_Data, tagliando_Km));
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }
    public Date getData() {
            String target = getInput();
            DateFormat df = new SimpleDateFormat("dd/mm/yy");
            Date data = null;
            try {
                data =  df.parse(target);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return data;
        }
    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
