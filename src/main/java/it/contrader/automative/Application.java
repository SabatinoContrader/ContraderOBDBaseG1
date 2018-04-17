package it.contrader.automative;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import it.contrader.automative.model.Appuntamento;
import it.contrader.automative.model.Auto;
import it.contrader.automative.model.Azienda;
import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Guasto;
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Preventivo;
import it.contrader.automative.model.Promozione;
import it.contrader.automative.model.TipologiaGuasto;
import it.contrader.automative.model.Utente;
import it.contrader.automative.model.Ticket;
import it.contrader.automative.model.MessaggioTicket;
import it.contrader.automative.serviceInterfaces.IAppuntamento;
import it.contrader.automative.serviceInterfaces.IAuto;
import it.contrader.automative.serviceInterfaces.IAzienda;
import it.contrader.automative.serviceInterfaces.IDatiTelemetria;
import it.contrader.automative.serviceInterfaces.IDispositivo;
import it.contrader.automative.serviceInterfaces.IGuasto;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IOfficina;
import it.contrader.automative.serviceInterfaces.IPreventivo;
import it.contrader.automative.serviceInterfaces.IPromozione;
import it.contrader.automative.serviceInterfaces.ITipologiaGuasto;
import it.contrader.automative.serviceInterfaces.IUtente;
import it.contrader.automative.serviceInterfaces.ITicket;
import it.contrader.automative.serviceInterfaces.IMessaggioTicket;
import it.contrader.dispositivo.main.WorkerThread;


@SpringBootApplication
@ComponentScan(basePackages = {"it.contrader.automative"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
      List<Thread> threads = new ArrayList();
		
		for(int i = 0; i<5; i++) {
			
			threads.add(new WorkerThread(i+1)); 
			threads.get(i).start();
			
			}
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    
	private IAuto autoService;
	private IAzienda aziendaService;
	private INoleggio noleggioService;
	private IUtente utenteService;
	private IOfficina officinaService;
	private IDatiTelemetria datiTelemetriaService;
	private IDispositivo dispositivoService;
	private IGuasto guastoService;
	private ITipologiaGuasto tipologiaGuastoService;
	private IPreventivo preventivoService;
	private IAppuntamento appuntamentoService;
	private IPromozione promozioneService;
	private ITicket ticketService;
	private IMessaggioTicket messaggioTicketService;

	@Autowired
	public Application(ITicket ticketService,IMessaggioTicket messaggioTicketService,IPromozione promozioneService, IAuto autoService, IAzienda aziendaService, INoleggio noleggioService, IUtente utenteService, IOfficina officinaService, IDatiTelemetria datiTelemetriaService, IDispositivo dispositivoService, IGuasto guastoService, ITipologiaGuasto tipologiaGuastoService, IPreventivo preventivoService, IAppuntamento appuntamentoService) {
		this.autoService = autoService;
		this.noleggioService = noleggioService;
		this.utenteService = utenteService;
		this.officinaService = officinaService;
		this.datiTelemetriaService = datiTelemetriaService;
		this.dispositivoService = dispositivoService;
		this.guastoService = guastoService;
		this.tipologiaGuastoService = tipologiaGuastoService;
		this.promozioneService = promozioneService;
		
		this.aziendaService = aziendaService;
	
		this.preventivoService=preventivoService;
		this.appuntamentoService=appuntamentoService;
		this.ticketService=ticketService;
		this.messaggioTicketService = messaggioTicketService;
	}
    
    
    @PostConstruct
	public void inizializzazioneDB(){
		//PROCEDURA PER POPOLARE IL DB
    	
    	
    	Calendar calendar = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	Calendar calendar3 = Calendar.getInstance();
    	Calendar calendar4 = Calendar.getInstance();
    	
    	
    	calendar.set(2016, 3, 1);
    	Date data1 = calendar.getTime();
    	
    	calendar2.set(2018, 9, 1);
    	Date data2 = calendar2.getTime();
    	
    	calendar3.set(2018, 3, 29);			//ATTENZIONE: in questo modo "3" non significa Marzo ma Aprile, ogni mese va messo così: (mese desiderato)-1
    	Date data3 = calendar3.getTime();
    	
    	calendar4.set(2018, 1, 15);
    	Date data4 = calendar4.getTime();
    	
    	
    	
    	
    	
    	Azienda inserimentoAziende[] = new Azienda[1];
    	inserimentoAziende[0] = new Azienda(1, "Contrader", "Sabatino", "Autorino", "923019301", "via dei Longobardi, 9", "Benevento");
    	
    	Officina inserimentoOfficine[] = new Officina[1];
    	//denominazione, nomereferente, cognome ref, email, telefono, latitudine, longitudine, data inserimento, citta
    	inserimentoOfficine[0] = new Officina(1, "Officina Meccanica Di Carmine Villano", "Carmine", "Villano", "officinacarminevillano@gmail.com", "08296524351", "via Torre della Catena, 76", data1, "Benevento");
    	
    	Promozione inserimentoPromozioni[] = new Promozione[1];
    	inserimentoPromozioni[0] = new Promozione(1, "Promozione 1", "Descrizione promozione .........", data4, data2, inserimentoOfficine[0]);
    	
    	Utente inserimentoUtenti [] = new Utente[6];
    	//id nome cognome email pass stato officina azienda datareg ruolo telefono citta
    	inserimentoUtenti[0] = new Utente(1, "Lorenzo", "Vitale", "lv@contrader.it", "password", 0, inserimentoOfficine[0], null, data1, 0, "3356724938", "Benevento");
    	inserimentoUtenti[1] = new Utente(2, "Carmine", "Villano", "officina1", "password", 0, inserimentoOfficine[0], null, data1, 1, "3372198453", "Benevento");
    	inserimentoUtenti[2] = new Utente(3, "Camste", "Vizzo", "cv@contrader.it", "password", 0, inserimentoOfficine[0], null, data1, 0, "3359824938", "Benevento");
    	inserimentoUtenti[3] = new Utente(4, "Antonio", "Pratico'", "ap@contrader.it", "password", 0, inserimentoOfficine[0], inserimentoAziende[0], data1, 0, "3356793648", "Benevento");
    	inserimentoUtenti[4] = new Utente(5, "Domenico", "Zollo", "dz@contrader.it", "password", 0, inserimentoOfficine[0], inserimentoAziende[0], data1, 0, "33987624938", "Roma");
    	inserimentoUtenti[5] = new Utente(6, "Sabatino", "Autorino", "sabatino@contrader.it", "password", 0, inserimentoOfficine[0], inserimentoAziende[0], data1, 2, "33952624938", "Benevento");

    	
    	Auto inserimentoAuto[] = new Auto[8];
    	//id marca modello targa num telaio cilindrata num porte alimentazione kmattuali kminiz noleggio datascadrev datascadtagl scadass scadbollo tipolauto danolegg officina
    	inserimentoAuto[0] = new Auto(1,"Fiat", "Panda", "AN374MP", "ANRH7348AMGO", 1600, 80, "Manuale", 5, "Benzina", 32131, 1233, data3, data2, data2, data2, "berlina", 1, inserimentoOfficine[0]);

    	inserimentoAuto[1] = new Auto(2,"Opel", "Corsa", "AC8744UP", "ANTU76737AMJO", 1600, 80, "Automatico", 5, "Benzina", 32131, 1233, data2, data2, data3, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[2] = new Auto(3,"Alfa Romeo", "Giulietta", "AC8923KP", "UIE7G7637AMJO", 1600, 80, "Automatico", 5, "Benzina", 10250, 1233, data2, data2, data2, data3, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[3] = new Auto(4,"Lancia", "Y", "YR7922KP", "UIEG764764UMJO", 1600, 80, "Manuale", 5, "Benzina", 10250, 1233, data2, data2, data3, data3, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[4] = new Auto(5,"Fiat", "500L", "YU93R1KP", "UJSA4664U5MJO", 1600, 80, "Manuale", 5, "Benzina", 10250, 1233, data2, data2, data3, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[5] = new Auto(6,"Volvo", "XC60", "OIE152KP", "UWEB7664UMJO", 1600, 80, "Manuale", 5, "Benzina", 10250, 1233, data2, data2, data3, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[6] = new Auto(7,"Fiat", "Punto", "YR784SW", "LAEB16642UMJO", 1600, 80, "Manuale", 5, "Benzina", 10250, 1233, data2, data2, data3, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	inserimentoAuto[7] = new Auto(8,"Fiat", "500", "YN284SW", "JWEB16641LMJO", 1600, 80, "Automatico", 5, "Diesel", 10250, 1233, data2, data2, data2, data2, "Utilitaria", 1, inserimentoOfficine[0]);
    	
    	Noleggio inserimentoNoleggio[] = new Noleggio[5];
    	inserimentoNoleggio[0] = new Noleggio(1, inserimentoUtenti[0], inserimentoAuto[0], inserimentoOfficine[0], null, data1,  data2, 84010, 82100,60000);
    	inserimentoNoleggio[1] = new Noleggio(2, inserimentoUtenti[0], inserimentoAuto[2], inserimentoOfficine[0], null, data1,  data2, 84010, 82100,10000);
    	inserimentoNoleggio[2] = new Noleggio(3, inserimentoUtenti[5], inserimentoAuto[3], inserimentoOfficine[0], inserimentoAziende[0], data1,  data2, 84010, 82100,10000);
    	inserimentoNoleggio[3] = new Noleggio(4, inserimentoUtenti[4], inserimentoAuto[4], inserimentoOfficine[0], inserimentoAziende[0], data1,  data4, 84010, 82100,10000);
    	inserimentoNoleggio[4] = new Noleggio(5, inserimentoUtenti[3], inserimentoAuto[1], inserimentoOfficine[0], null, data1,  data2, 84010, 82100,10000);
    	
    	Dispositivo inserimentoDispositivi[] = new Dispositivo[5];
    	inserimentoDispositivi[0] = new Dispositivo(1, "A0972", inserimentoAuto[0], data1, inserimentoOfficine[0]);
    	inserimentoDispositivi[1] = new Dispositivo(2, "A0973", inserimentoAuto[1], data1, inserimentoOfficine[0]);
    	inserimentoDispositivi[2] = new Dispositivo(3, "A0974", inserimentoAuto[2], data1, inserimentoOfficine[0]);
    	inserimentoDispositivi[3] = new Dispositivo(4, "A0975", inserimentoAuto[3], data1, inserimentoOfficine[0]);
    	inserimentoDispositivi[4] = new Dispositivo(5, "A0976", inserimentoAuto[4], data1, inserimentoOfficine[0]);
    	
    	TipologiaGuasto inserimentoTipologieGuasti[] = new TipologiaGuasto[3];
    	inserimentoTipologieGuasti[0] = new TipologiaGuasto("C0004", "Cinghia di Trasmissione...");
    	inserimentoTipologieGuasti[1] = new TipologiaGuasto("A0004", "Pompa Idraulica...");
    	inserimentoTipologieGuasti[2] = new TipologiaGuasto("B0003", "Danno meccenico Idraulica...");
    	
    	DatiTelemetria inserimentoDatiTelemetria[] = new DatiTelemetria[3];
    	inserimentoDatiTelemetria[0] = new DatiTelemetria(1, 41.1230199, 14.7376701, 12,12, 13, 11, 11, 2, 3, 32, 123, 33, 1, 2, 12, 221, 112, 1, 2, 3, 4, 1, 32, 3, 54, 3, 23, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 2, 3, 1, 1, 2, 3, 7, 8, 1, 2, 12, 11, 12);
    	inserimentoDatiTelemetria[1] = new DatiTelemetria(2, 41.9102415, 12.3959117, 12,12, 13, 11, 11, 2, 3, 32, 123, 33, 1, 2, 12, 221, 112, 1, 2, 3, 4, 1, 32, 3, 54, 3, 23, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 2, 3, 1, 1, 2, 3, 7, 8, 1, 2, 12, 11, 12);
    	inserimentoDatiTelemetria[2] = new DatiTelemetria(3, 45.4022409, 8.8486533, 12,12, 13, 11, 11, 2, 3, 32, 123, 33, 1, 2, 12, 221, 112, 1, 2, 3, 4, 1, 32, 3, 54, 3, 23, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 2, 3, 1, 1, 2, 3, 7, 8, 1, 2, 12, 11, 12);

    	Guasto inserimentoGuasti[] = new Guasto[3];
    	inserimentoGuasti[0] = new Guasto(1, inserimentoTipologieGuasti[0], inserimentoDatiTelemetria[0], data2, inserimentoDispositivi[0], "Non Risolto");
    	inserimentoGuasti[1] = new Guasto(2, inserimentoTipologieGuasti[1], inserimentoDatiTelemetria[1], data2, inserimentoDispositivi[0], "Non Risolto");
    	inserimentoGuasti[2] = new Guasto(3, inserimentoTipologieGuasti[2], inserimentoDatiTelemetria[2], data2, inserimentoDispositivi[0], "Risolto");

    	Preventivo inserimentoPreventivi[] = new Preventivo[1];
    	inserimentoPreventivi[0] = new Preventivo(1, inserimentoAuto[0], inserimentoUtenti[0],  inserimentoOfficine[0], data1,"agjiej",1,8,"ooo");
    	
    	Appuntamento inserimentoAppuntamenti[] = new Appuntamento[1];
    	inserimentoAppuntamenti[0] = new Appuntamento(1, inserimentoUtenti[0],  inserimentoOfficine[0], data3,"10:00","dettagli appuntamento",0,"");
    	
    	
    	Ticket inserimentoTicket[] = new Ticket[2];
    	inserimentoTicket[0] = new Ticket(1,data1,"Ticket guasto auto",inserimentoOfficine[0],inserimentoUtenti[0]);
    	inserimentoTicket[1] = new Ticket(2,data2,"Ehi auto",inserimentoOfficine[0],inserimentoUtenti[3]);
    	
    	MessaggioTicket inserimentoMessaggioTicket[] = new MessaggioTicket[4];
    	inserimentoMessaggioTicket[0] = new MessaggioTicket(1,data2,0,inserimentoTicket[0],"Ciao");
    	inserimentoMessaggioTicket[1] = new MessaggioTicket(2,data3,1,inserimentoTicket[0],"Heila'");
    	inserimentoMessaggioTicket[2] = new MessaggioTicket(3,data2,0,inserimentoTicket[1],"Ehi");
    	inserimentoMessaggioTicket[3] = new MessaggioTicket(4,data3,1,inserimentoTicket[1],"Grande");
    	
    	//Effettuo gli inserimenti effettivi
    	
    	for(int i=0;i<inserimentoAziende.length;i++){
    		inserimentoAziende[i] = aziendaService.insert(inserimentoAziende[i]);
		}
    	
    	for(int i=0;i<inserimentoOfficine.length;i++){
    		inserimentoOfficine[i] = officinaService.insert(inserimentoOfficine[i]);
		}
    	
    	for(int i=0;i<inserimentoPromozioni.length;i++){
    		inserimentoPromozioni[i] = promozioneService.insert(inserimentoPromozioni[i]);
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
    	for(int i=0;i<inserimentoAppuntamenti.length;i++){
    		inserimentoAppuntamenti[i] = appuntamentoService.insert(inserimentoAppuntamenti[i]);
		}
    	 	for(int i=0;i<inserimentoTicket.length;i++){
    		inserimentoTicket[i] = ticketService.insert(inserimentoTicket[i]);
		}
    	for(int i=0;i<inserimentoMessaggioTicket.length;i++){
    		inserimentoMessaggioTicket[i] = messaggioTicketService.insert(inserimentoMessaggioTicket[i]);
		}
	}
    
}
