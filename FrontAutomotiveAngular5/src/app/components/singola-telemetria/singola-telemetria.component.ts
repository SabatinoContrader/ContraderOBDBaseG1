import { Component, OnInit, OnDestroy } from '@angular/core';
//import { Chart } from 'chart.js';
import { Utente } from '../../models/Utente';
import { Auto } from '../../models/Auto';
import { Router, ActivatedRoute } from '@angular/router';
import { TelemetriaService } from '../../services/telemetria.service';
import { AmChartsService, AmChart } from "@amcharts/amcharts3-angular";
import { Subscription } from 'rxjs/Subscription';
import { IMqttMessage, MqttModule, MqttService, IMqttServiceOptions } from 'ngx-mqtt';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';
import { Chart } from 'angular-highcharts';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
	selector: 'app-singola-telemetria',
	templateUrl: './singola-telemetria.component.html',
	styleUrls: ['./singola-telemetria.component.css']
})
export class SingolaTelemetriaComponent implements OnInit, OnDestroy {
	private subscription: Subscription;
	public message: string;
	private amchart: AmChart;
	chart: Chart;
	lat: number;
	lng: number;
	auto: Auto;
	utente: Utente;
	idDispositivo;
	telemetria;
	//chart = [];

	sub;
	km;
	kmarray = [];
	engine_oil_temperature = [];
	temperature_coolant = [];
	temp_array = [];  //array di oggetti {data,engine_oil_temperature,temperature_coolant}
	test = '';
	parametro = 0;  //parametro selezione dati da visualizzare in grafico a sinistra
	rpm_array = [];
	engine_load_array = [];
	coolant_temp_array = [];
	fuel_pressure_array = [];
	intake_map_array = [];
	throttle_position_array = [];

	absolute_load_value_array = [];
	engine_coolant_temperature_array = [];
	ignition_timing_advance_array = [];
	intake_temperature_array = [];
	commanded_egr_array = [];
	commanded_evaporative_purge_array = [];
	egr_error_array = [];
	fuel_level_array = [];
	evap_system_vapor_pressure_array = [];
	barometric_pressure_array = [];
	catalyst_temperature_bank_1_array = [];
	catalyst_temperature_bank_2_array = [];

	relative_throttle_position_array = [];
	ambient_air_temperature_array = [];
	absolute_throttle_position_b_array = [];
	absolute_throttle_position_c_array = [];
	absolute_pedal_position_d_array = [];
	absolute_pedal_position_e_array = [];
	absolute_pedal_position_f_array = [];
	commanded_throttle_attuator_array = [];
	ethanol_fuel_array = [];
	fuel_rail_pressure_injection_array = [];
	engine_oil_temperature_array = [];
	engine_fuel_rate_array = [];
	demand_engine_torque_array = [];
	engine_reference_torque_array = [];


	lastTelemetria;
	showparameter = 0;
	par = 0;
	startGraph = 0;
	isZoomed=false; //check if is Zoomed - 0 if not, 1 if yes
	constructor(private spinner: NgxSpinnerService, private _mqttService: MqttService, private router: Router, private route: ActivatedRoute, private telemetriaService: TelemetriaService, private AmCharts: AmChartsService) { }

	ngOnInit() {


		this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;

		/*	this.auto=this.telemetriaService.getAuto();
			this.idDispositivo =this.telemetriaService.getIdDispositivo();
		*/
		this.auto = JSON.parse(sessionStorage.getItem('auto'));
		this.idDispositivo = sessionStorage.getItem('idDispositivo');

		this.telemetriaService.getTelemetria(this.idDispositivo)
			.subscribe(
				response => {
					this.lastTelemetria = response.datiTelemetria;
					this.km = response.datiTelemetria.km;
					this.lat = response.datiTelemetria.latitudine;
					this.lng = response.datiTelemetria.longitudine;

				}
			);

		// this.getUltimeTelemetrie(0);
		this.getDecimatedData();
	
		 this.subscription = this._mqttService.observe('obd/dispositivi/measures').subscribe((message: IMqttMessage) => {
				this.message = message.payload.toString();
				console.log("MESSAGGIO DA MQTT: "+this.message);
				  this.telemetriaService.getTelemetria(this.idDispositivo)
			  .subscribe(
				response => {
					this.lastTelemetria=response.datiTelemetria;
				this.km =response.datiTelemetria.km;	
				this.lat  = response.datiTelemetria.latitudine;
				this.lng  = response.datiTelemetria.longitudine;
				if(this.isZoomed==0);
				this.addPoint(response.datiTelemetria,response.data);
				}
			  );
		
			
		  });
		  

	}

	testPoint(){
		this.addPoint(
	}
	
	public addPoint(dati,data){
		
		var b = new Date(data);
		//	var point =[dati,data];
		var d = b.getTime() - (b.getTimezoneOffset() * 60000);
		//var point =[d,2000];
		if(this.par==0){
				var point =[d,dati.km];
			}
		else if(this.par==1){
				var point =[d,dati.rpm];
			}
		else if(this.par==2){
				var point =[d,dati.engine_load];
			}
		else if(this.par==3){
				var point =[d,dati.coolant_temp];
			}
		else if(this.par==4){
				var point =[d,dati.fuel_pressure];
			}
		else if(this.par==5){
				var point =[d,dati.intake_map];
			}
		else if(this.par==6){
				var point =[d,dati.throttle_position];
			}
		else if(this.par==7){
				var point =[d,dati.absolute_load_value];
		}
		else if(this.par==9){
				var point =[d,dati.ignition_timing_advance];
		}
		else if(this.par==10){
				var point =[d,dati.intake_temperature];
		}
		else if(this.par==11){
				var point =[d,dati.commanded_egr];
		}
		else if(this.par==12){
				var point =[d,dati.commanded_evaporative_purge];
		}
		else if(this.par==13){
				var point =[d,dati.egr_error];
		}
		else if(this.par==14){
				var point =[d,dati.fuel_level];
		}
		else if(this.par==15){
				var point =[d,dati.evap_system_vapor_pressure];
		}
		else if(this.par==16){
				var point =[d,dati.barometric_pressure];
		}
		else if(this.par==17){
				var point =[d,dati.catalyst_temperature_bank_1];
		}
		else if(this.par==18){
				var point =[d,dati.catalyst_temperature_bank_2];
		}
		else if(this.par==20){
				var point =[d,dati.relative_throttle_position];
		}
		else if(this.par==21){
				var point =[d,dati.ambiant_air_temperaturent];
		}
		else if(this.par==22){
				var point =[d,dati.absolute_throttle_position_B];
		}
		else if(this.par==23){
				var point =[d,dati.asolute_pedal_position_D];
		}
		else if(this.par==24){
				var point =[d,dati.asolute_pedal_position_E];
		}
		else if(this.par==25){
				var point =[d,dati.asolute_pedal_position_F];
		}
		else if(this.par==26){
				var point =[d,dati.commanded_throttle_attuator];
		}
		else if(this.par==27){
				var point =[d,dati.ethanol_fuel];
		}
		else if(this.par==28){
				var point =[d,dati.fuel_rail_pressure_injection];
		}
		else if(this.par==29){
				var point =[d,dati.engine_oil_temperature];
		}
		else if(this.par==30){
				var point =[d,dati.engine_fuel_rate];
		}
		else if(this.par==31){
				var point =[d,dati.demand_engine_torque];
		}
		else if(this.par==32){
				var point =[d,dati.engine_reference_torque];
		}
		else if(this.par==33){
				var point =[d,dati.absolute_throttle_position_C];
		}
		
	
				this.chart.addPoint(point);
			}
	
	
			

	public getDecimatedData() {

		var now = new Date(); // Or the date you'd like converted.
		var nowDate = new Date(now.getTime() - (now.getTimezoneOffset() * 60000)).toISOString();
		var nowDate_n = nowDate.replace("T", " ").split('.')[0];
		var twoyearago = new Date(now.setMonth(now.getMonth() - 24));
		var twoyearagoDate = new Date(twoyearago.getTime() - (twoyearago.getTimezoneOffset() * 60000)).toISOString();
		var nowDate_o = twoyearagoDate.replace("T", " ").split('.')[0];
		this.updateGraph(nowDate_o, nowDate_n, this.idDispositivo);
	}

	public unsafePublish(topic: string, message: string): void {
		this._mqttService.unsafePublish(topic, message, { qos: 1, retain: true });
	}
	/*	  function handleZoom(event) {
	  let startDate = event.startDate;
	  let endDate = event.endDate;
  startDate = AmCharts.formatDate(startDate, "YYYY-MM-DD HH:MM:SS");
	  endDate=AmCharts.formatDate(endDate, "YYYY-MM-DD HH:MM:SS");
	   this.updateGraph(startDate,endDate,this.idDispositivo);
	    
  }
  */

	initChart(arr, tit = 'Km',unit='km') {
		let that = this;
		console.log(arr.length);
		let arr_a = [];
		let arr_b = [];
		let ar = arr;
		let chart = new Chart({
			chart: {
				type: 'spline',
				zoomType: 'x',
				resetZoomButton: {
					theme: {
						display: 'none'
					},
					 position: {
                // align: 'right', // by default
                // verticalAlign: 'top', // by default
                x: -10,
                y: 10
            },
            relativeTo: 'chart'
				}
			},
			tooltip:{
				pointFormat:'Valore: {point.y} '+unit
				xDateFormat:'%Y-%m-%d %H:%M:%S'
			},
			title: {
				text: tit
			},
			credits: {
				enabled: false
			},
			yAxis:{
					title:{
						text:unit
					}
			},
			xAxis: {
			//	categories: arr_a,
			type:'datetime',
			/*title:{
			text:'data'
			},*/
				events: {
					setExtremes: function (event) {
						event.preventDefault();
						/*console.log(event);
						let mi = ar[Math.round(event.min)][x];
						let ma = ar[Math.round(event.max)][x];
*/
					
						var datemin = new Date(Math.round(event.min)); // Or the date you'd like converted.
						var isoDatemin = new Date(datemin.getTime() - (datemin.getTimezoneOffset() * 60000)).toISOString();
						var parisoDatemin = isoDatemin.replace("T", " ").split('.')[0];
						var datemax = new Date(Math.round(event.max)); // Or the date you'd like converted.
						var isoDatemax = new Date(datemax.getTime() - (datemax.getTimezoneOffset() * 60000)).toISOString();
						var parisoDatemax = isoDatemax.replace("T", " ").split('.')[0];
					
						
						that.updateGraph(parisoDatemin,parisoDatemax, that.idDispositivo,1);
						/*console.log("MIN: " + mi);
						console.log("MAX: " + ma);
*/

					}
				}
			},
			/* plotOptions: {
        series: {
            dataLabels: {
				
                enabled: true,
                borderRadius: 5,
                backgroundColor: 'rgba(252, 255, 0, 0.7)',
                borderWidth: 1,
                borderColor: '#AAA',
                y: -6
               /* formatter: function () {
                var label = "AAAA"+this.xaxis.defaultLabelFormatter.call(this).split('.')[0];
				console.log("LABEL: "+label);
               
                return label;
            }
            
        }
    }
			 },*/
        loading: {
				hideDuration: 2000
			},
			
			series: [{
				showInLegend: false,
				data: arr
			}]
		});
		// chart.addPoint(4);

		this.chart = chart;

		// chart.addPoint(5);
		/* setTimeout(() => {
		   chart.addPoint(6);
		 }, 2000);*/

	}



	onItemChange(event, tipo = 0) {

		//	 console.log(this.chart.series);

		// this.chart.series[0].setData(this.rpm_array);

		this.par = event;
		//if(tipo==0)this.getUltimeTelemetrie();
		if (tipo == 0){
		this.isZoomed=false;
		this.getDecimatedData();
		}
		else {
			//this.getUltimeTelemetrie();
			if (event == 0) this.initChart(this.kmarray, 'km','km');
			else if (event == 1)
				this.initChart(this.rpm_array, 'rpm','rpm');
			else if (event == 2)
				this.initChart(this.engine_load_array, 'engine load','%');
			else if (event == 3)
				this.initChart(this.coolant_temp_array, 'coolant temperature','°c');
			else if (event == 4)
				this.initChart(this.fuel_pressure_array, 'fuel pressure','kPa');
			else if (event == 5)
				this.initChart(this.intake_map_array, 'intake map','kPa');
			else if (event == 6)
				this.initChart(this.throttle_position_array, 'throttle position','%');
			else if (event == 7)
				this.initChart(this.absolute_load_value_array, 'absolute load value','%');
			else if (event == 9)
				this.initChart(this.ignition_timing_advance_array, 'ignition timing advance','°');
			else if (event == 10)
				this.initChart(this.intake_temperature_array, 'intake temperature','°c');
			else if (event == 11)
				this.initChart(this.commanded_egr_array, 'commanded egr','%');
			else if (event == 12)
				this.initChart(this.commanded_evaporative_purge_array, 'commanded evaporative purge','%');
			else if (event == 13)
				this.initChart(this.egr_error_array, 'egr error','%');
			else if (event == 14)
				this.initChart(this.fuel_level_array, 'fuel level','%');
			else if (event == 15)
				this.initChart(this.evap_system_vapor_pressure_array, 'evap system vapor pressure','%');
			else if (event == 16)
				this.initChart(this.barometric_pressure_array, 'barometric pressure','kPa');
			else if (event == 17)
				this.initChart(this.catalyst_temperature_bank_1_array, 'catalyst temperature bank 1','°c');
			else if (event == 18)
				this.initChart(this.catalyst_temperature_bank_2_array, 'catalyst temperature bank 2','°c');

			else if (event == 20)
				this.initChart(this.relative_throttle_position_array, 'relative throttle position','%');
			else if (event == 21)
				this.initChart(this.ambient_air_temperature_array, 'ambient air temperature','°c');
			else if (event == 22)
				this.initChart(this.absolute_throttle_position_b_array, 'absolute throttle position','%');
			else if (event == 23)
				this.initChart(this.absolute_pedal_position_d_array, 'absolute pedal position d','%');
			else if (event == 24)
				this.initChart(this.absolute_pedal_position_e_array, 'absolute pedal position e','%');
			else if (event == 25)
				this.initChart(this.absolute_pedal_position_f_array, 'absolute pedal position f','%');
			else if (event == 26)
				this.initChart(this.commanded_throttle_attuator_array, 'commanded throttle attuator','%');
			else if (event == 27)
				this.initChart(this.ethanol_fuel_array, 'ethanol fuel','%');
			else if (event == 28)
				this.initChart(this.fuel_rail_pressure_injection_array, 'fuel rail pressure injection','kPa');
			else if (event == 29)
				this.initChart(this.engine_oil_temperature_array, 'engine oil temperature','°c');
			else if (event == 30)
				this.initChart(this.engine_fuel_rate_array, 'engine fuel rate','%');
			else if (event == 31)
				this.initChart(this.demand_engine_torque_array, 'demand engine torque','%');
			else if (event == 32)
				this.initChart(this.engine_reference_torque_array, 'engine reference torque','%');
			else if (event == 33)
				this.initChart(this.absolute_throttle_position_c_array, 'absolute throttle position','%');
			this.spinner.hide();
		}
	}
	getUltimeTelemetrie(tipo = 1) {
		console.log("TIPO : " + tipo);
		this.telemetriaService.getUltimeTelemetria(this.idDispositivo)
			.subscribe(
				response => {

					this.telemetria = response;
					//this.test+='[';

						
						
					this.kmarray = [];
					this.temp_array = [];
					this.rpm_array = [];
					this.engine_load_array = [];
					this.coolant_temp_array = [];
					this.fuel_pressure_array = [];
					this.intake_map_array = [];
					this.throttle_position_array = [];
					this.engine_oil_temperature_array = [];
					this.barometric_pressure_array = [];
					this.engine_fuel_rate_array = [];
					this.absolute_load_value_array = [];
	this.engine_coolant_temperature_array = [];
	this.ignition_timing_advance_array = [];
	this.intake_temperature_array = [];
	this.commanded_egr_array = [];
	this.commanded_evaporative_purge_array = [];
	this.egr_error_array = [];
	this.fuel_level_array = [];
	this.evap_system_vapor_pressure_array = [];
	this.barometric_pressure_array = [];
	this.catalyst_temperature_bank_1_array = [];
	this.catalyst_temperature_bank_2_array = [];
	
	this.relative_throttle_position_array = [];
	this.ambient_air_temperature_array = [];
	this.absolute_throttle_position_b_array = [];
	this.absolute_throttle_position_c_array = [];
	this.absolute_pedal_position_d_array = [];
	this.absolute_pedal_position_e_array = [];
	this.absolute_pedal_position_f_array = [];
	this.commanded_throttle_attuator_array = [];
	this.ethanol_fuel_array = [];
	this.fuel_rail_pressure_injection_array = [];
	this.engine_oil_temperature_array = [];
	this.engine_fuel_rate_array = [];
	this.demand_engine_torque_array = [];
	this.engine_reference_torque_array = [];
					
					for (var i = this.telemetria.length - 1; i >= 0; i--) {
						var dat = new Date(this.telemetria[i].data); // Or the date you'd like converted.
						var parisoDat = new Date(dat.getTime() - (dat.getTimezoneOffset() * 60000)).getTime();
						this.kmarray.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.km });
						this.temp_array.push({ x: parisoDat, "engine_oil_temperature": this.telemetria[i].datiTelemetria.engine_oil_temperature, "temperature_coolant":this.telemetria[i].datiTelemetria.temperature_coolant });
						this.rpm_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.rpm });
						this.engine_load_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.calculated_engine_load });
						this.coolant_temp_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.temperature_coolant });
						this.fuel_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_pressure });
						this.intake_map_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.intake_map });
						this.throttle_position_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.throttle_position });
						this.engine_oil_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_oil_temperature });
						this.barometric_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.barometric_pressure });
						this.engine_fuel_rate_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_fuel_rate });
						this.absolute_load_value_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_load_value });
						
						this.ignition_timing_advance_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ignition_timing_advance });
						this.intake_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.intake_temperature });
						this.commanded_egr_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_egr });
						this.commanded_evaporative_purge_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_evaporative_purge });
						this.egr_error_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.egr_error });
						this.fuel_level_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_level_input });
						this.evap_system_vapor_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.evap_system_vapor_pressure });
						this.catalyst_temperature_bank_1_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.catalyst_temperature_bank_1 });
						this.catalyst_temperature_bank_2_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.catalyst_temperature_bank_2 });
				
						this.relative_throttle_position_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.relative_throttle_position });
						this.ambient_air_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ambiant_air_temperature });
						this.absolute_throttle_position_b_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_throttle_position_B });
						this.absolute_throttle_position_c_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_throttle_position_C });
						this.absolute_pedal_position_d_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_D });
						this.absolute_pedal_position_e_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_E });
						this.absolute_pedal_position_f_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_F });
						this.commanded_throttle_attuator_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_throttle_attuator });
						this.ethanol_fuel_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ethanol_fuel });
						this.fuel_rail_pressure_injection_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_rail_pressure_injection });
						this.engine_oil_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_oil_temperature });
						this.engine_fuel_rate_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_fuel_rate });
						this.demand_engine_torque_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.demand_engine_torque });
						this.engine_reference_torque_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_reference_torque });

					}

					//this.initChart(this.kmarray);
					//this.onItemChange(this.par);
					if (tipo == 0) this.initChart(this.kmarray);
				});
	}

	gotoTelemetria(): void {
		this.router.navigate(['telemetria']);
	}

	ngOnDestroy() {
	//	this.subscription.unsubscribe();
		/*  if (this.amchart) {
			this.AmCharts.destroyChart(this.amchart);
		  }   */
	}



	public updateGraph(startDate, endDate, idDispositivo,origin=0) {
		if (startDate > endDate) {
			var temp = endDate;
			endDate = startDate;
			startDate = temp;
		}
		
		/*
console.log("INIZIO: "+startDate);
	  console.log("FINE: "+endDate);*/
		this.spinner.show();
		this.telemetriaService.getIntervalTelemetrie(startDate, endDate, idDispositivo)
			.subscribe(
				response => {
					this.spinner.hide();
					console.log(response);
					if (response === undefined || response.length == 0) {
			
						swal("", "Nessun dato nell'intervallo selezionato", "info");
						console.log('Nessun dato nell\'intervallo selezionato');
					}
					else {

if(origin==1)this.isZoomed=true;


						this.telemetria = response;
						//this.test+='[';

						this.kmarray = [];
						this.temp_array = [];
						this.rpm_array = [];
						this.engine_load_array = [];
						this.coolant_temp_array = [];
						this.fuel_pressure_array = [];
						this.intake_map_array = [];
						this.throttle_position_array = [];
						this.engine_oil_temperature_array = [];
						this.barometric_pressure_array = [];
						this.engine_fuel_rate_array = [];
						this.absolute_load_value_array = [];
	this.engine_coolant_temperature_array = [];
	this.ignition_timing_advance_array = [];
	this.intake_temperature_array = [];
	this.commanded_egr_array = [];
	this.commanded_evaporative_purge_array = [];
	this.egr_error_array = [];
	this.fuel_level_array = [];
	this.evap_system_vapor_pressure_array = [];
	this.barometric_pressure_array = [];
	this.catalyst_temperature_bank_1_array = [];
	this.catalyst_temperature_bank_2_array = [];

	this.relative_throttle_position_array = [];
	this.ambient_air_temperature_array = [];
	this.absolute_throttle_position_b_array = [];
	this.absolute_throttle_position_c_array = [];
	this.absolute_pedal_position_d_array = [];
	this.absolute_pedal_position_e_array = [];
	this.absolute_pedal_position_f_array = [];
	this.commanded_throttle_attuator_array = [];
	this.ethanol_fuel_array = [];
	this.fuel_rail_pressure_injection_array = [];
	this.engine_oil_temperature_array = [];
	this.engine_fuel_rate_array = [];
	this.demand_engine_torque_array = [];
	this.engine_reference_torque_array = [];
						//for(var i =this.telemetria.length-1;i>=0;i--){
						for (var i = 0; i < this.telemetria.length; i++) {
							//console.log("INDEX : "+i+"----VALUE : "+this.telemetria[i].data);
						var dat = new Date(this.telemetria[i].data); // Or the date you'd like converted.
						var parisoDat = new Date(dat.getTime() - (dat.getTimezoneOffset() * 60000)).getTime();
						
						this.kmarray.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.km });
						this.temp_array.push({ x: parisoDat, "engine_oil_temperature": this.telemetria[i].datiTelemetria.engine_oil_temperature, "temperature_coolant":this.telemetria[i].datiTelemetria.temperature_coolant });
						this.rpm_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.rpm });
						this.engine_load_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.calculated_engine_load });
						this.coolant_temp_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.temperature_coolant });
						this.fuel_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_pressure });
						this.intake_map_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.intake_map });
						this.throttle_position_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.throttle_position });
						this.engine_oil_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_oil_temperature });
						this.barometric_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.barometric_pressure });
						this.engine_fuel_rate_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_fuel_rate });
						this.absolute_load_value_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_load_value });
						
						this.ignition_timing_advance_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ignition_timing_advance });
						this.intake_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.intake_temperature });
						this.commanded_egr_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_egr });
						this.commanded_evaporative_purge_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_evaporative_purge });
						this.egr_error_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.egr_error });
						this.fuel_level_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_level_input });
						this.evap_system_vapor_pressure_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.evap_system_vapor_pressure });
						this.catalyst_temperature_bank_1_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.catalyst_temperature_bank_1 });
						this.catalyst_temperature_bank_2_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.catalyst_temperature_bank_2 });
					
						this.relative_throttle_position_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.relative_throttle_position });
						this.ambient_air_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ambiant_air_temperature });
						this.absolute_throttle_position_b_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_throttle_position_B });
						this.absolute_throttle_position_c_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.absolute_throttle_position_C });
						this.absolute_pedal_position_d_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_D });
						this.absolute_pedal_position_e_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_E });
						this.absolute_pedal_position_f_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.asolute_pedal_position_F });
						this.commanded_throttle_attuator_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.commanded_throttle_attuator });
						this.ethanol_fuel_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.ethanol_fuel });
						this.fuel_rail_pressure_injection_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.fuel_rail_pressure_injection });
						this.engine_oil_temperature_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_oil_temperature });
						this.engine_fuel_rate_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_fuel_rate });
						this.demand_engine_torque_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.demand_engine_torque });
						this.engine_reference_torque_array.push({ x: parisoDat, y: this.telemetria[i].datiTelemetria.engine_reference_torque });
						}

						this.onItemChange(this.par, 1);
					}
				});

	}


public resetZoom(){
this.onItemChange(this.par);
}
}
	/*
	 if(this.tempchart){
		  this.AmCharts.destroyChart(this.tempchart);
	 }
 
  }
}
*/
