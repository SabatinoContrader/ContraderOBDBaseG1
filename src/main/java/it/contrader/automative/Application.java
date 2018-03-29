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
import it.contrader.automative.model.Noleggio;
import it.contrader.automative.model.Officina;
import it.contrader.automative.model.Utente;
import it.contrader.automative.serviceInterfaces.IAuto;
import it.contrader.automative.serviceInterfaces.INoleggio;
import it.contrader.automative.serviceInterfaces.IOfficina;
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

	@Autowired
	public Application(IAuto autoService, INoleggio noleggioService, IUtente utenteService, IOfficina officinaService) {
		this.autoService = autoService;
		this.noleggioService = noleggioService;
		this.utenteService = utenteService;
		this.officinaService = officinaService;
	}
    
    
    @PostConstruct
	public void initializeDB(){
		//PROCEDURA PER INSERIRE GLI ASSETS_CLASS NEL DB
    	
    	
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
    	inserimentoAuto[0] = new Auto(1,"daj", "dgaj", "dgsajd", "dgsajd", 1600, 4, "dgasjh", 32131, 1233, data2, data2, data2, data2, "berlina", 1, inserimentoOfficine[0]);
    	inserimentoAuto[1] = new Auto(2,"BMW", "dgaj", "dgsajd", "dgsajd", 1600, 4, "dgasjh", 32131, 1233, data2, data2, data2, data2, "berlina", 1, inserimentoOfficine[0]);
    	
    	Noleggio inserimentoNoleggio[] = new Noleggio[1];
    	inserimentoNoleggio[0] = new Noleggio(1, inserimentoUtenti[0], inserimentoAuto[0],  data1,  data2, 84010, 82100,60000);
    	
    	
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
    	
    	
	}
    
}
