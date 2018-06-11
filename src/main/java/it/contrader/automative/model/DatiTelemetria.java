package it.contrader.automative.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.contrader.automative.utils.Posizione;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "dati_telemetria")
public class DatiTelemetria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//latitudine, longitudine
	
	//	<Inventati/Aggiunti>
	
	@Column
	private double latitudine;
	
	@Column
	private double longitudine;
	
//	@Column
//	private int pressionePneumatici;
	
	//	</Inventati/Aggiunti>
	
	@Column
	private int rpm; //engine rpm
	
	@Column
	private int kmh; // vehicule speed
	
	@Column
	private int alv; // absolute load value
	
	@Column
	private int temperature; // engine temperature
	
	@Column
	private int temperature_coolant; // engine coolant temperature
	
	@Column
	private int kpa; // intake air temperature
	
	@Column
	private int vlt;  // control volume voltage
	
	@Column
	private int time;   // time sinse engine start
	
	@Column
	private int km;  // distance travelled with mil
	
	@Column
	private int time_warn; // time sinse warn up code
	
	@Column
	private int kmh_warn; // distance travelled sence warn up code
	
	@Column
	private int time_run_mil; // time run with mil
	
	@Column
	private int time_code_closed; // time since trouble code closed
	
	@Column
	private int throuttle_position; // mesured in %
	
	@Column
	private int ignition_timing_advance; // 
	
	@Column
	private int calculated_engine_load; 
	
	@Column
	private int absolute_load_value; // 
	
	@Column
	private int engine_oil_temperature; 
	
	@Column
	private int demand_engine_torque; // 
	
	@Column
	private int actual_engine_torque; 
	
	@Column
	private int engine_reference_torque; 
	
	@Column
	private int throttle_position; 
	
	@Column
	private int relative_throttle_position; 
	
	@Column
	private int absolute_throttle_position_B; 
	
	@Column
	private int absolute_throttle_position_C; 
	
	@Column
	private int asolute_pedal_position_D; 
	
	@Column
	private int asolute_pedal_position_E;
	
	@Column
	private int asolute_pedal_position_F;
	
	@Column
	private int commanded_throttle_attuator;
	
	@Column
	private int relative_accelerator_pedal_position;
	
	@Column
	private int intake_map; // mesured in kpa
	
	@Column
	private int maf_air_flow_rate; // in %
	
	@Column
	private int barometric_pressure; // in kpa
	
	@Column
	private int fuel_pressure;
	
	@Column
	private int fuel_level_input; // in %
	
	@Column
	private int ethanol_fuel; // in %
	
	@Column
	private int fuel_injection_timing;
	
	@Column
	private int engine_fuel_rate;
	
	@Column
	private int fuel_rail_pressure_relative; // in kpa
	
	@Column
	private int fuel_rail_pressure_injection; // in kpa
	
	@Column
	private int commanded_egr; // in %
	
	@Column
	private int egr_error; // in %
	
	@Column
	private int commanded_evaporative_purge; // in %
	
	@Column
	private int evap_system_vapor_pressure; // in %
	
	@Column
	private int exhaust_gas_temperature;  // in celsius
	
	@Column
	private int ambiant_air_temperature; // in celsius
	
	@Column
	private int catalyst_temperature_bank_1;
	
	@Column
	private int catalyst_temperature_bank_2;
	
	@Column
	private int dtc_count;
}
