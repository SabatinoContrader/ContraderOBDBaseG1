package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Auto;
import main.model.Dati_dispositivo;
import main.service.AutoService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class AutoView implements View {

    private AutoService autoService;
    private String mode;
    private String role;
    private String id_azienda;

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
                System.out.println("");
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
                autoService.insertAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver));
                break;

            case "update":
                 scanner = new Scanner(System.in);
                System.out.println("");
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
                autoService.updateAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, driver));
                break;

            case "reset":
                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Inserisci il codice del dispositivo da resettare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("Verrà cancellata l'auto ad esso associata e tutti i dati relativi");
                autoService.resetAuto(cod_Dispositivo);
                break;

            case "find":
                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Inserisci il codice dell'auto da ricercare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                System.out.println("");
                HashMap autoDati = new HashMap(autoService.findAuto(cod_Dispositivo));
                Auto auto = (Auto) autoDati.get("Auto");
                List<Dati_dispositivo> dati = (List<Dati_dispositivo>) autoDati.get("Dati");
                System.out.println("Codice dispositivo: " + auto.getCod_Dispositivo());
                System.out.println("Targa: " + auto.getTarga());
                System.out.println("Num. telaio: " + auto.getTelaio());
                System.out.println("Modello: " + auto.getCasa_Costruttrice() + " " + auto.getModello());
                System.out.println("Alimentazione: " + auto.getAlimentazione());
                System.out.println("Cambio: " + auto.getCambio());
                System.out.println("Ultima revisione: " + auto.getRevisione());
                System.out.println("Ultimo tagliando: " + auto.getTagliando_Data() + " a " + auto.getTagliando_Km() + " km");
                System.out.println("");

                System.out.println("Dati del dispositivo:");
                System.out.println("    Data      Km       Liv. olio     Cod. Errore");
                Iterator i = dati.iterator();
                while(i.hasNext())
                {
                    Dati_dispositivo dato = (Dati_dispositivo) i.next();
                    System.out.println("  " + dato.getData() + "    " + dato.getKm() + "         " + dato.getLivello_olio() + "           "  + dato.getCodice_Errore());
                }
                break;

            case "listauto":
                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Stai per vedere la lista delle auto con driver:");

                List<Auto> listAuto = autoService.getAllAuto();
                for(Auto automo : listAuto){
                    System.out.print(automo.getCambio()+ " ");
                    System.out.print(automo.getAlimentazione()+" ");
                    System.out.print(automo.getCasa_Costruttrice()+" ");
                    System.out.print(automo.getModello()+" ");
                    System.out.print(automo.getRevisione()+" ");
                    System.out.println();
                }


            case "assegna_auto_driver":
                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Inserire la Id del Driver");
                int IdDriver = Integer.valueOf(getInput());
                System.out.println("Inserire la Id della Auto");
                int IdDAuto = Integer.valueOf(getInput());
                autoService.updateAutoDriver(IdDAuto, IdDriver);
                break;

            case "lista_errori_non_risolti":

                scanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Stai per vedere la lista degli errori non risolti:");

                HashMap<Dati_dispositivo, Auto> mappaErrori = autoService.findAutoWithError();
                Set set = mappaErrori.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()){
                    Map.Entry mentry = (Map.Entry)iterator.next();

                    Dati_dispositivo dati_dispositivo =  (Dati_dispositivo) mentry.getKey();
                    Auto auto_1 = (Auto)mentry.getValue();
                    System.out.print("");
                    System.out.print("Cod_Dispositivo: "+dati_dispositivo.getCod_Dispositivo()+";");
                    System.out.print(" ");
                    System.out.print("Km: "+dati_dispositivo.getKm()+";");
                    System.out.print(" ");
                    System.out.print("Codice Errore: "+dati_dispositivo.getCodice_Errore()+";");
                    System.out.print(" ");
                    System.out.print("Stato: "+dati_dispositivo.getStato()+";");
                    System.out.print(" ");
                    System.out.print("Livello: "+dati_dispositivo.getLivello_olio()+";");
                    System.out.print(" ");
                    System.out.print("Targa: "+auto_1.getTarga()+";");
                    System.out.println();
                }

            case "azzerare_driver":

                System.out.println("INSERIRE IL CODICE DISPOSITIVO");
                int cod_dispositivo = Integer.valueOf(getInput());

                autoService.azzeraDriver(cod_dispositivo);


                System.out.println("DRIVER AZZERATO CON SUCCESSO");

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
