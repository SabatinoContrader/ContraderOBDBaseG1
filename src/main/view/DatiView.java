package main.view;


import main.MainDispatcher;
import main.controller.Request;
import main.model.Auto;
import main.model.Dati_dispositivo;
import main.model.Driver;
import main.service.AutoService;
import main.service.DatiService;
import main.service.DriverService;

import java.util.List;
import java.util.Scanner;

public class DatiView implements View{

    private DatiService datiService;
    private String mode;
    private String role;
    private int id;
    private int cod_dispositivo;
    private List<Dati_dispositivo> listaDatiAuto;
    private Auto auto;
    private AutoService autoService;

    public DatiView() {
        this.datiService = new DatiService();
        this.autoService = new AutoService();
    }

    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        this.role  = (String) request.get("role");
        Scanner scanner = new Scanner(request.get("id").toString());
        this.id = scanner.nextInt();
        Scanner scanner2 = new Scanner(request.get("cod_dispositivo").toString());
        this.cod_dispositivo = scanner2.nextInt();

    }

    @Override
    public void showOptions() {
        switch (mode)
        {
            case "listaAutoDriver":
                listaDatiAuto = datiService.listaDatiAuto(cod_dispositivo);
                auto = autoService.findAuto(cod_dispositivo);

                int errore = 0;
                for(int i = 0; i < listaDatiAuto.size(); i++)
                {
                    Dati_dispositivo dato = listaDatiAuto.get(i);
                    if(dato.getCodice_Errore() != null)
                    {
                        errore = 1;
                        System.out.println("");
                        System.out.println("ALERT! Errore: " + dato.getCodice_Errore() + " ricevuto in data " + dato.getData());
                    }
                }
                if(errore == 0)
                {
                    System.out.println("");
                    System.out.println("Nessun errore rilevato su quest'auto");
                }

                if(listaDatiAuto.size() != 0) {
                    Dati_dispositivo dato = listaDatiAuto.get(listaDatiAuto.size() - 1);
                    Scanner scanner = new Scanner(auto.getRevisione()).useDelimiter("/");
                    int gg_revisione = scanner.nextInt();
                    int mm_revisione = scanner.nextInt();
                    int aa_revisione = scanner.nextInt();
                    scanner = new Scanner(auto.getTagliando_Data()).useDelimiter("/");
                    int gg_tagliando = scanner.nextInt();
                    int mm_tagliando = scanner.nextInt();
                    int aa_tagliando = scanner.nextInt();
                    scanner = new Scanner(dato.getData()).useDelimiter("/");
                    int gg_dato = scanner.nextInt();
                    int mm_dato = scanner.nextInt();
                    int aa_dato = scanner.nextInt();
                    int revisione = gg_revisione + mm_revisione * 365 / 12 + aa_revisione * 365;
                    int tagliando = gg_tagliando + mm_tagliando * 365 / 12 + aa_tagliando * 365;
                    int data = gg_dato + mm_dato * 365 / 12 + aa_dato * 365;

                    int km = dato.getKm() - auto.getTagliando_Km();

                    if (data - revisione > 365 + 365 / 12 * 11) {
                        System.out.println("");
                        System.out.println("La revisione scadrà tra meno di 1 mese!");
                        System.out.println("");
                    }
                    else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) {
                        System.out.println("");
                        System.out.println("Il tagliando è in scadenza!");
                        System.out.println("");
                    }
                    else
                    {
                        System.out.println("");
                        System.out.println("Nessuna prossima scadenza su quest'auto");
                        System.out.println("");
                    }
                }
                else
                {
                    System.out.println("");
                    System.out.println("Nessun dato rilevato per quest'auto");
                    System.out.println("");
                }
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
        Request request=new Request();
        request.put("role",role);
        request.put("id",id);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }
}