package it.contrader.dispositivo.main;

import it.contrader.automative.model.Auto;
import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Officina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Random;

import it.contrader.automative.controller.TelemetriaController;

@NoArgsConstructor
@AllArgsConstructor

public class WorkerThread extends Thread{

	private int id;
	
	public void run() {
		
		while(true) {
			
			inserisciTelemetria(id);
			System.out.println("[Thread - "+this.getId()+"]: Inserito Telemetria per Dispositivo = "+id);
			
			
			try {
				Thread.sleep((10000));
			} catch (InterruptedException e) {
				System.out.println("\n\n[Thread - "+this.getId()+"]: Errore nell'attesa!!!\n\n");
				//e.printStackTrace();
			}
			
		}
		
	}
	
	private void inserisciTelemetria(int id) {
		
		DatiTelemetria datiTelemetria = new DatiTelemetria();
		
		Random random = new Random();
		
		datiTelemetria.setLatitudine(random.nextDouble()+40.72);
		datiTelemetria.setLongitudine(random.nextDouble()+14.50);
		
		TelemetriaController.inserisciTelemetria(datiTelemetria, id);
		
	}
	
	
	private void inserisciDatiTelemetria(DatiTelemetria datiTelemetria) {
		
		datiTelemetria.setTemperature(231);	
		datiTelemetria.setEngine_oil_temperature(36821);
		datiTelemetria.setFuel_pressure(318);					
		//datiTelemetria.set
		
	}
}
