package it.contrader.automative.serviceImpl;

import java.util.Date;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.contrader.automative.model.DatiTelemetria;
import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Telemetria;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.repositories.TelemetriaRepository;
import it.contrader.automative.serviceInterfaces.IDatiDispositivo;
import it.contrader.automative.serviceInterfaces.IDispositivo;

@Service
public class DatiDispositivoImpl implements IDatiDispositivo {

	
	private DispositivoRepository dispositivoRepository;
	private IDispositivo IDispositivo;
	private TelemetriaRepository telemetriaRepository;
	
	@Autowired
	public DatiDispositivoImpl(DispositivoRepository dispositivoRepository, IDispositivo IDispositivo, TelemetriaRepository telemetriaRepository) {
		this.IDispositivo = IDispositivo;
		this.dispositivoRepository = dispositivoRepository;
		this.telemetriaRepository = telemetriaRepository;
	}
	
	@Override
	public Telemetria getTelemetria(String dati) {
		return tokenizzazioneStringa(dati);
	}

	private Telemetria tokenizzazioneStringa(String dati) {
		
		StringTokenizer Tokenizer = new StringTokenizer(dati, "$");
		String[] obd_array = new String[Tokenizer.countTokens()];
		int k = 0;
		while(Tokenizer.hasMoreTokens()) {obd_array[k] = Tokenizer.nextToken(); k++;}
		
		
//		String[] obd_array = StringUtils.split(dati, "$");
		
		
		
		
		Telemetria telemetria = new Telemetria();
		
		System.out.println("Numero Dati Telemetria Tokenizzati = "+obd_array.length);
//		for(int i = 0; i<obd_array.length; i++) System.out.println(obd_array[i]+ "   i="+i);
		
		if(obd_array.length > 56) {
			
		//Devo identificare il dispositivo
		String vin = obd_array[0];
		if(dispositivoRepository.findByCodice(vin) == null) {
			Dispositivo d = new Dispositivo();
			d.setCodice(vin);
			d.setDataInstallazione(new Date(System.currentTimeMillis()));
			IDispositivo.insert(d);
		}
		
		telemetria.setDispositivo(dispositivoRepository.findByCodice(vin));
		
		telemetria.setData(new Date(System.currentTimeMillis()));
		
		DatiTelemetria datiTelemetria = new DatiTelemetria();
		
		//datiTelemetria.setLatitudine(latitudine);
		//datiTelemetria.setLongitudine(longitudine);
		datiTelemetria.setLatitudine(Double.parseDouble(obd_array[3]));
		datiTelemetria.setLongitudine(Double.parseDouble(obd_array[4]));
		
		datiTelemetria.setRpm(Integer.parseInt(obd_array[14]));
		datiTelemetria.setThrottle_position(Integer.parseInt(obd_array[19]));	
		datiTelemetria.setIgnition_timing_advance(Integer.parseInt(obd_array[16]));
		datiTelemetria.setCalculated_engine_load(Integer.parseInt(obd_array[6]));
		datiTelemetria.setEngine_oil_temperature(Integer.parseInt(obd_array[51]));
		datiTelemetria.setAbsolute_load_value(Integer.parseInt(obd_array[36]));
		datiTelemetria.setActual_engine_torque(Integer.parseInt(obd_array[55]));
		datiTelemetria.setDemand_engine_torque(Integer.parseInt(obd_array[54]));
		datiTelemetria.setEngine_reference_torque(Integer.parseInt(obd_array[56]));
		datiTelemetria.setRelative_throttle_position(Integer.parseInt(obd_array[38]));
		datiTelemetria.setAbsolute_throttle_position_B(Integer.parseInt(obd_array[40]));
		datiTelemetria.setAbsolute_throttle_position_C(Integer.parseInt(obd_array[41]));
		datiTelemetria.setAsolute_pedal_position_D(Integer.parseInt(obd_array[42]));
		datiTelemetria.setAsolute_pedal_position_F(Integer.parseInt(obd_array[44]));
		datiTelemetria.setAsolute_pedal_position_E(Integer.parseInt(obd_array[43]));
		datiTelemetria.setCommanded_throttle_attuator(Integer.parseInt(obd_array[45]));
		//datiTelemetria.setRelative_accelerator_pedal_position(Integer.parseInt(nm)); Mancante
		datiTelemetria.setIntake_map(Integer.parseInt(obd_array[13]));
		datiTelemetria.setMaf_air_flow_rate(Integer.parseInt(obd_array[37]));
		datiTelemetria.setBarometric_pressure(Integer.parseInt(obd_array[30]));
		datiTelemetria.setFuel_pressure(Integer.parseInt(obd_array[12]));
		datiTelemetria.setFuel_level_input(Integer.parseInt(obd_array[26]));
		datiTelemetria.setEthanol_fuel(Integer.parseInt(obd_array[48]));
		datiTelemetria.setFuel_injection_timing(Integer.parseInt(obd_array[52]));
		datiTelemetria.setEngine_fuel_rate(Integer.parseInt(obd_array[53]));
		datiTelemetria.setFuel_rail_pressure_injection(Integer.parseInt(obd_array[49])); //messa come injection
		datiTelemetria.setCommanded_egr(Integer.parseInt(obd_array[23]));
		datiTelemetria.setEgr_error(Integer.parseInt(obd_array[24]));
		datiTelemetria.setCommanded_evaporative_purge(Integer.parseInt(obd_array[25]));
		datiTelemetria.setEvap_system_vapor_pressure(Integer.parseInt(obd_array[29]));
		//datiTelemetria.setExhaust_gas_temperature(exhaust_gas_temperature); mancante
		datiTelemetria.setTemperature_coolant(Integer.parseInt(obd_array[7]));
		datiTelemetria.setAmbiant_air_temperature(Integer.parseInt(obd_array[39]));
		datiTelemetria.setCatalyst_temperature_bank_1(Integer.parseInt(obd_array[31]));
		datiTelemetria.setCatalyst_temperature_bank_2(Integer.parseInt( obd_array[32]));
		datiTelemetria.setTemperature(Integer.parseInt(obd_array[17]));	//strano
		
		
//        // ok - Mancante o dupl
//        etemperature.Text = ETemperature.ToString();
//        etemperature.Text = "Mancante o dupl";
//
//        // ok [Mancante]
//        frpressurea.Text = Frpressurea.ToString();
//        frpressurea.Text = "Mancante";
		
		int ultimaDecimazione = 0;
		int decimazioneAttuale = 0;
		
		try {
			ultimaDecimazione = telemetriaRepository.ultimaDecimazione(telemetria.getDispositivo().getId());
			System.out.println("\n\nultima decimazione: "+ultimaDecimazione+"\n"+telemetria.getDispositivo().getId()+"\n\n");
			decimazioneAttuale = ultimaDecimazione + 1;
		}catch(Exception e) { decimazioneAttuale = 1;}
		
		telemetria.setDecimazione(decimazioneAttuale);
		
		telemetria.setDatiTelemetria(datiTelemetria);
		
		}
		
		return telemetria;
	}
}
