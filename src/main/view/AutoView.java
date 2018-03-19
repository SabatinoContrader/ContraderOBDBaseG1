package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Auto;
import main.model.Dati_dispositivo;
import main.service.AutoService;
import main.service.DatiService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class AutoView implements View {

    private AutoService autoService;
    private DatiService datiService;
    private String mode;
    private String role;
    private int id;
    private int choice;
    private List<Auto> listaAutoDriver;
    private List<Dati_dispositivo> listaDatiAuto;


    public AutoView() {
      this.autoService = new AutoService();
      this.datiService = new DatiService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       this.role  = (String) request.get("role");
       this.id = (Integer)request.get("id");

    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "insert":
                System.out.println("");
                System.out.println("-----INSERIMENTO AUTO-----");
                System.out.println("");
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
                autoService.insertAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, null));
                break;

            case "update":
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
                autoService.updateAuto(new Auto(cod_Dispositivo, targa, telaio, casa_Costruttrice, modello, alimentazione, tipologia, cambio, proprietario, revisione, tagliando_Data, tagliando_Km, null));
                break;
            case "reset":
                System.out.println("");
                System.out.println("Verrà cancellata l'auto ad esso associata e tutti i dati relativi");
                System.out.println("Inserisci il codice del dispositivo da resettare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                autoService.resetAuto(cod_Dispositivo);
                break;
            case "find":
                System.out.println("");
                System.out.println("Inserisci il codice dell'auto da ricercare:");
                cod_Dispositivo = Integer.parseInt(getInput());
                Auto auto = autoService.findAuto(cod_Dispositivo);
                listaDatiAuto = datiService.listaAllDatiDispositivo(cod_Dispositivo);
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
                if(listaDatiAuto.size() == 0) System.out.println("Nessun dato presente per quest'auto");
                else {
                    System.out.println("    Data       Km        Liv. olio   Cod. Errore");
                    for(int i = 0; i < listaDatiAuto.size(); i++)
                    {
                        Dati_dispositivo dato = listaDatiAuto.get(i);
                        System.out.println("  " + dato.getData() + "    " + dato.getKm() + "         " + dato.getLivello_olio() + "           "  + dato.getCodice_Errore());
                    }
                }
                break;
            case "listauto":
                System.out.println("");
                System.out.println("---Lista auto---");
                System.out.println("");
                List<Auto> listAuto = autoService.getAllAuto(id);
                if(listAuto.isEmpty()){
                    System.out.println("NON CI SONO AUTO ASSEGNATE");
                }
                for(Auto automo : listAuto){
                    System.out.println(automo.getCasa_Costruttrice()+ " " + automo.getModello() + " targata " + automo.getTarga());
                    System.out.println("Ultima revisione: " + automo.getRevisione() + " ");
                    System.out.println("Ultimo tagliando: " + automo.getTagliando_Data() + " a " + automo.getTagliando_Km() + " km");
                    if(automo.getDriver() == 0)
                        System.out.println("In noleggio: libera");
                    else
                        System.out.println("In noleggio: Driver Id " + automo.getDriver());
                    System.out.println();
                }
                break;
            case "assegna_auto_driver":
                System.out.println("----NOLEGGIA AUTO----");
                System.out.println("");
                System.out.println("Inserire la Id del Driver");
                int IdDriver = Integer.valueOf(getInput());
                System.out.println("Inserire la Id della Auto");
                int IdDAuto = Integer.valueOf(getInput());
                autoService.updateAutoDriver(IdDAuto, IdDriver);
                System.out.println("AUTO ASSEGNATA A DRIVER CON SUCCESSO");
                break;
            case "lista_errori_non_risolti":
                System.out.println("");
                System.out.println("Stai per vedere la lista degli errori non risolti:");
                List<String> result = datiService.listaDatiDispositivo(id);;
                for(String val: result) {
                    System.out.println(val);
                }
                break;
            case "azzerare_driver":
                System.out.println("---TERMINA NOLEGGIO---");
                System.out.println("");
                System.out.println("Inserisci il codice del dispositivo dell'auto");
                int cod_dispositivo = Integer.valueOf(getInput());
                autoService.azzeraDriver(cod_dispositivo);
                System.out.println("Noleggio terminato");
                break;
            case "listaAutoDriver":
                listaAutoDriver = autoService.listaAutoDriver(id);
                for(int j = 0; j < listaAutoDriver.size(); j++ ) {
                    Auto autodriver = listaAutoDriver.get(j);
                    System.out.println(j+1 + ") " + autodriver.getCasa_Costruttrice() + " " + autodriver.getModello() + " targata " + autodriver.getTarga());
                }
                this.choice = Integer.parseInt(getInput());
                break;
        }
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

        switch (role) {
            case "owner":
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;

            case "officina":
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;

            case "azienda":
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;

            case "driver":
                switch (mode) {
                    case "listaAutoDriver":
                        int cod_dispositivo = listaAutoDriver.get(choice-1).getCod_Dispositivo();
                        request.put("cod_dispositivo", cod_dispositivo);
                        request.put("mode", mode);
                        MainDispatcher.getInstance().callAction("Dati", "doControl", request);
                        break;
                }

        }

    }



}
