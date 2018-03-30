package it.contrader.automative;


import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Guasto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Preventivo;
import it.contrader.automative.model.TipologiaGuasto;
import it.contrader.automative.model.Utente;
import it.contrader.automative.serviceInterfaces.IAuto;
import it.contrader.automative.serviceInterfaces.IDatiTelemetria;
import it.contrader.automative.serviceInterfaces.IDispositivo;
import it.contrader.automative.serviceInterfaces.IGuasto;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IOfficina;
import it.contrader.automative.serviceInterfaces.IPreventivo;
import it.contrader.automative.serviceInterfaces.ITipologiaGuasto;
import it.contrader.automative.serviceInterfaces.IUtente;


@SpringBootApplication
@ComponentScan(basePackages = {"it.contrader.automative"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    
	private IAuto autoService;
	private INoleggio noleggioService;
	private IUtente utenteService;
	private IOfficina officinaService;
	private IDatiTelemetria datiTelemetriaService;
	private IDispositivo dispositivoService;
	private IGuasto guastoService;
	private ITipologiaGuasto tipologiaGuastoService;
	private IPreventivo preventivoService;

	@Autowired
	public Application(IAuto autoService, INoleggio noleggioService, IUtente utenteService, IOfficina officinaService, IDatiTelemetria datiTelemetriaService, IDispositivo dispositivoService, IGuasto guastoService, ITipologiaGuasto tipologiaGuastoService, IPreventivo preventivoService) {
		this.autoService = autoService;
		this.noleggioService = noleggioService;
		this.utenteService = utenteService;
		this.officinaService = officinaService;
		this.datiTelemetriaService = datiTelemetriaService;
		this.dispositivoService = dispositivoService;
		this.guastoService = guastoService;
		this.tipologiaGuastoService = tipologiaGuastoService;
		this.preventivoService=preventivoService;
	}
    
    
    @PostConstruct
	public void inizializzazioneDB(){
		//PROCEDURA PER POPOLARE IL DB
    	
    	
    	Calendar calendar = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	
    	calendar.set(2016, 3, 1);
    	Date data1 = calendar.getTime();
    	
    	calendar2.set(2018, 9, 1);
    	Date data2 = calendar2.getTime();
    	
    	
    	
    	Officina inserimentoOfficine[] = new Officina[1];
    	inserimentoOfficine[0] = new Officina(1, "Officina del Cazzo", "sda", "dasuid", "dgajsd", "36872136", "4124215", "73294", data1, "dhdkjas");
    	
    	Utente inserimentoUtenti [] = new Utente[2];
    	inserimentoUtenti[0] = new Utente(1, "dsad", "daj", "pippo", "paperino", 0, null, data1, 0, "4712384");
    	inserimentoUtenti[1] = new Utente(2, "dsad", "daj", "admin", "admin", 0, inserimentoOfficine[0], data1, 1, "4712384");

    	
    	Auto inserimentoAuto[] = new Auto[2];

    	inserimentoAuto[0] = new Auto(1,"Fiat", "Panda", "AN374MP", "ANRH7348AMGO", 1600, 4, "dgasjh", 32131, 1233, data2, data2, data2, data2, "berlina", 1, inserimentoOfficine[0]);

    	inserimentoAuto[1] = new Auto(2,"BMW", "dgaj", "dgsajd", "dgsajd", 1600, 4, "dgasjh", 32131, 1233, data2, data2, data2, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	Noleggio inserimentoNoleggio[] = new Noleggio[1];
    	inserimentoNoleggio[0] = new Noleggio(1, inserimentoUtenti[0], inserimentoAuto[0],  data1,  data2, 84010, 82100,60000);
    	
    	Dispositivo inserimentoDispositivi[] = new Dispositivo[1];
    	inserimentoDispositivi[0] = new Dispositivo(1, "A0972", inserimentoAuto[0], data1, inserimentoOfficine[0]);

    	TipologiaGuasto inserimentoTipologieGuasti[] = new TipologiaGuasto[3];
    	inserimentoTipologieGuasti[0] = new TipologiaGuasto("C0004", "Cinghia di Trasmissione...");
    	inserimentoTipologieGuasti[1] = new TipologiaGuasto("A0004", "Pompa Idraulica...");
    	inserimentoTipologieGuasti[2] = new TipologiaGuasto("B0003", "Danno meccenico Idraulica...");
    	
    	DatiTelemetria inserimentoDatiTelemetria[] = new DatiTelemetria[3];
    	inserimentoDatiTelemetria[0] = new DatiTelemetria(1, "36871231v 312371 23gy31t3 7881238 2313");
    	inserimentoDatiTelemetria[1] = new DatiTelemetria(2, "12V 5A 59Watt");
    	inserimentoDatiTelemetria[2] = new DatiTelemetria(3, "12V 5A 59Watt");
    	Guasto inserimentoGuasti[] = new Guasto[3];
    	inserimentoGuasti[0] = new Guasto(1, inserimentoTipologieGuasti[0], inserimentoDatiTelemetria[0], data2, inserimentoDispositivi[0], "Non Risolto");
    	inserimentoGuasti[1] = new Guasto(2, inserimentoTipologieGuasti[1], inserimentoDatiTelemetria[1], data2, inserimentoDispositivi[0], "Non Risolto");
    	inserimentoGuasti[2] = new Guasto(3, inserimentoTipologieGuasti[2], inserimentoDatiTelemetria[2], data2, inserimentoDispositivi[0], "Risolto");

    	Preventivo inserimentoPreventivi[] = new Preventivo[1];
    	inserimentoPreventivi[0] = new Preventivo(1, inserimentoAuto[0], inserimentoUtenti[0],  inserimentoOfficine[0], data1,"agjiej",0,8,"ooo");
    	
    	
    	//Effettuo gli inserimenti effettivi
    	
    	
    	for(int i=0;i<inserimentoOfficine.length;i++){
    		inserimentoOfficine[i] = officinaService.insert(inserimentoOfficine[i]);
		}
    	
    	for(int i=0;i<inserimentoUtenti.length;i++){
    		inserimentoUtenti[i] = utenteService.insert(inserimentoUtenti[i]);
		}
    	
    	for(int i=0;i<inserimentoAuto.length;i++){
    		inserimentoAuto[i] = autoService.insert(inserimentoAuto[i]);
		}
    	
    	for(int i=0;i<inserimentoNoleggio.length;i++){
    		inserimentoNoleggio[i] = noleggioService.insert(inserimentoNoleggio[i]);
		}
    	
    	for(int i=0;i<inserimentoDispositivi.length;i++){
    		inserimentoDispositivi[i] = dispositivoService.insert(inserimentoDispositivi[i]);
		}
    	
    	for(int i=0;i<inserimentoTipologieGuasti.length;i++){
    		inserimentoTipologieGuasti[i] = tipologiaGuastoService.insert(inserimentoTipologieGuasti[i]);
		}
    	
    	for(int i=0;i<inserimentoDatiTelemetria.length;i++){
    		inserimentoDatiTelemetria[i] = datiTelemetriaService.insert(inserimentoDatiTelemetria[i]);
		}
    	
    	for(int i=0;i<inserimentoGuasti.length;i++){
    		inserimentoGuasti[i] = guastoService.insert(inserimentoGuasti[i]);
		}
    	for(int i=0;i<inserimentoPreventivi.length;i++){
    		inserimentoPreventivi[i] = preventivoService.insert(inserimentoPreventivi[i]);
		}
    	
	}
    
}
