package it.contrader.automative.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.automative.model.Dispositivo;
import it.contrader.automative.model.Telemetria;
import it.contrader.automative.repositories.DispositivoRepository;
import it.contrader.automative.serviceInterfaces.IDatiDispositivo;
import it.contrader.automative.serviceInterfaces.IDispositivo;

public class DatiDispositivoImpl implements IDatiDispositivo {

	
	private DispositivoRepository dispositivoRepository;
	private IDispositivo IDispositivo;
	
	@Autowired
	public DatiDispositivoImpl(DispositivoRepository dispositivoRepository, IDispositivo IDispositivo) {
		this.IDispositivo = IDispositivo;
		this.dispositivoRepository = dispositivoRepository;
	}
	
	@Override
	public Telemetria getTelemetria(String dati) {
		// TODO Auto-generated method stub
		return null;
	}

	private Telemetria tokenizzazioneStringa(String dati) {
		
		String[] obd_array = dati.split("$");
		
		Telemetria telemetria = new Telemetria();
		
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
		//telemetria.getDatiTelemetria().setLatitudine(latitudine);
		//telemetria.getDatiTelemetria().setLongitudine(longitudine);
		
		
		telemetria.getDatiTelemetria().setRpm(Integer.getInteger(obd_array[14]));
		telemetria.getDatiTelemetria().setThrottle_position(Integer.getInteger(obd_array[19]));	
		telemetria.getDatiTelemetria().setIgnition_timing_advance(Integer.getInteger(obd_array[16]));
		telemetria.getDatiTelemetria().setCalculated_engine_load(Integer.getInteger(obd_array[6]));
		telemetria.getDatiTelemetria().setEngine_oil_temperature(Integer.getInteger(obd_array[51]));
		telemetria.getDatiTelemetria().setAbsolute_load_value(Integer.getInteger(obd_array[36]));
		telemetria.getDatiTelemetria().setActual_engine_torque(Integer.getInteger(obd_array[55]));
		telemetria.getDatiTelemetria().setDemand_engine_torque(Integer.getInteger(obd_array[54]));
		telemetria.getDatiTelemetria().setEngine_reference_torque(Integer.getInteger(obd_array[56]));
		telemetria.getDatiTelemetria().setRelative_throttle_position(Integer.getInteger(obd_array[38]));
		telemetria.getDatiTelemetria().setAbsolute_throttle_position_B(Integer.getInteger(obd_array[40]));
		telemetria.getDatiTelemetria().setAbsolute_throttle_position_C(Integer.getInteger(obd_array[41]));
		telemetria.getDatiTelemetria().setAsolute_pedal_position_D(Integer.getInteger(obd_array[42]));
		telemetria.getDatiTelemetria().setAsolute_pedal_position_F(Integer.getInteger(obd_array[44]));
		telemetria.getDatiTelemetria().setAsolute_pedal_position_E(Integer.getInteger(obd_array[43]));
		telemetria.getDatiTelemetria().setCommanded_throttle_attuator(Integer.getInteger(obd_array[45]));
		//telemetria.getDatiTelemetria().setRelative_accelerator_pedal_position(Integer.getInteger(nm)); Mancante
		telemetria.getDatiTelemetria().setIntake_map(Integer.getInteger(obd_array[13]));
		telemetria.getDatiTelemetria().setMaf_air_flow_rate(Integer.getInteger(obd_array[37]));
		telemetria.getDatiTelemetria().setBarometric_pressure(Integer.getInteger(obd_array[30]));
		telemetria.getDatiTelemetria().setFuel_pressure(Integer.getInteger(obd_array[12]));
		telemetria.getDatiTelemetria().setFuel_level_input(Integer.getInteger(obd_array[26]));
		telemetria.getDatiTelemetria().setEthanol_fuel(Integer.getInteger(obd_array[48]));
		telemetria.getDatiTelemetria().setFuel_injection_timing(Integer.getInteger(obd_array[52]));
		telemetria.getDatiTelemetria().setEngine_fuel_rate(Integer.getInteger(obd_array[53]));
		telemetria.getDatiTelemetria().setFuel_rail_pressure_injection(Integer.getInteger(obd_array[49])); //messa come injection
		telemetria.getDatiTelemetria().setCommanded_egr(Integer.getInteger(obd_array[23]));
		telemetria.getDatiTelemetria().setEgr_error(Integer.getInteger(obd_array[24]));
		telemetria.getDatiTelemetria().setCommanded_evaporative_purge(Integer.getInteger(obd_array[25]));
		telemetria.getDatiTelemetria().setEvap_system_vapor_pressure(Integer.getInteger(obd_array[29]));
		//telemetria.getDatiTelemetria().setExhaust_gas_temperature(exhaust_gas_temperature); mancante
		telemetria.getDatiTelemetria().setTemperature_coolant(Integer.getInteger(obd_array[7]));
		telemetria.getDatiTelemetria().setAmbiant_air_temperature(Integer.getInteger(obd_array[39]));
		telemetria.getDatiTelemetria().setCatalyst_temperature_bank_1(Integer.getInteger(obd_array[31]));
		telemetria.getDatiTelemetria().setCatalyst_temperature_bank_2(Integer.getInteger( obd_array[32]));
		telemetria.getDatiTelemetria().setTemperature(Integer.getInteger(obd_array[17]));	//strano
		
		
//        // ok - Mancante o dupl
//        etemperature.Text = ETemperature.ToString();
//        etemperature.Text = "Mancante o dupl";
//
//        // ok [Mancante]
//        frpressurea.Text = Frpressurea.ToString();
//        frpressurea.Text = "Mancante";

		return telemetria;
	}
}
