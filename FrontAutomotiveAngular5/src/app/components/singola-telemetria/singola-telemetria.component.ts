import { Component, OnInit, OnDestroy } from '@angular/core';
//import { Chart } from 'chart.js';
import { Utente } from '../../models/Utente';
import { Auto } from '../../models/Auto';
import { Router, ActivatedRoute  } from '@angular/router';
import { TelemetriaService } from '../../services/telemetria.service';
import { AmChartsService, AmChart } from "@amcharts/amcharts3-angular";
import { Subscription } from 'rxjs/Subscription';
import { IMqttMessage, MqttModule, MqttService, IMqttServiceOptions  } from 'ngx-mqtt';
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
export class SingolaTelemetriaComponent implements OnInit,OnDestroy {
    private subscription: Subscription;
    public message: string;
	private amchart: AmChart;
	  chart: Chart;
	lat:number;
	lng: number;
		auto:Auto;
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
test='';
parametro=0;  //parametro selezione dati da visualizzare in grafico a sinistra
rpm_array=[];
engine_load_array = [];
coolant_temp_array= [];
fuel_pressure_array=[];
intake_map_array=[];
throttle_position_array=[];

absolute_load_value_array=[];
engine_coolant_temperature_array=[];
ignition_timing_advance_array = [];
intake_temperature_array = [];
commanded_egr_array=[];
commanded_evaporative_purge_array=[];
egr_error_array=[];
fuel_level_array=[];
evap_system_vapor_pressure_array=[];
barometric_pressure_array= [];
catalyst_temperature_bank_1_array=[];
catalyst_temperature_bank_2_array=[];
air_fuel_equiv_ratio_array=[];
relative_throttle_position_array=[];
ambient_air_temperature_array=[];
absolute_throttle_position_array=[];
absolute_pedal_position_d_array=[];
absolute_pedal_position_e_array=[];
absolute_pedal_position_f_array=[];
commanded_throttle_attuator_array=[];
ethanol_fuel_array=[];
fuel_rail_pressure_injection_array=[];
engine_oil_temperature_array=[];
engine_fuel_rate_array= [];
demand_engine_torque_array=[];
engine_reference_torque_array=[];


lastTelemetria;
showparameter=0;
par=0;
startGraph=0;
  constructor(private spinner: NgxSpinnerService,private _mqttService: MqttService,private router: Router, private route: ActivatedRoute, private telemetriaService:TelemetriaService,private AmCharts: AmChartsService) { }

    ngOnInit() {
		
		 
  this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
		
	/*	this.auto=this.telemetriaService.getAuto();
		this.idDispositivo =this.telemetriaService.getIdDispositivo();
	*/
this.auto=JSON.parse(sessionStorage.getItem('auto'));
this.idDispositivo=sessionStorage.getItem('idDispositivo');

    this.telemetriaService.getTelemetria(this.idDispositivo)
      .subscribe(
        response => {
			this.lastTelemetria=response.datiTelemetria;
		this.km =response.datiTelemetria.km;	
        this.lat  = response.datiTelemetria.latitudine;
		this.lng  = response.datiTelemetria.longitudine;
		
        }
      );
  
// this.getUltimeTelemetrie(0);
this.getDecimatedData();
/*
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
		
        }
      );
 this.getDecimatedData();
	
  });
  */
	
}

public getDecimatedData(){

var now = new Date(); // Or the date you'd like converted.
var nowDate = new Date(now.getTime() - (now.getTimezoneOffset() * 60000)).toISOString();
var nowDate_n=nowDate.replace("T"," ").split('.')[0];
var  twoyearago =new Date(now.setMonth(now.getMonth()-24));
var  twoyearagoDate = new Date(twoyearago.getTime() - (twoyearago.getTimezoneOffset() * 60000)).toISOString();
var nowDate_o=twoyearagoDate.replace("T"," ").split('.')[0];
this.updateGraph(nowDate_o,nowDate_n,this.idDispositivo);
}

   public unsafePublish(topic: string, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 1, retain: true});
  }
  /*	  function handleZoom(event) {
    let startDate = event.startDate;
    let endDate = event.endDate;
startDate = AmCharts.formatDate(startDate, "YYYY-MM-DD HH:MM:SS");
	endDate=AmCharts.formatDate(endDate, "YYYY-MM-DD HH:MM:SS");
	 this.updateGraph(startDate,endDate,this.idDispositivo);
	  
}
*/

  initChart(arr,tit ='Km'){
	  let that=this;
	  console.log(arr.length);
	  let arr_a=[];
	  let arr_b=[];
	  for(var i=0;i<arr.length;i++){
		  console.log(arr[i]['timestamp']);
		  console.log(arr[i]['value']);
		 
		var date = new Date(arr[i]['timestamp']); // Or the date you'd like converted.
		var isoDate = new Date(date.getTime() - (date.getTimezoneOffset() * 60000)).toISOString();
			 if(i==3)
		  console.log(isoDate);
		  arr_a[i]=isoDate.replace("T"," ").split('.')[0];
		  arr_b[i]=arr[i]['value'];
		 
	  }
	   console.log("LENGTH A "+arr_a.length);
	    console.log("LENGTH B "+arr_b.length);
	   let chart = new Chart({
      chart: {
        type: 'spline',
		  zoomType: 'x',
		  resetZoomButton: {
                    theme: {
                        display: 'show'
                    }
		  }
      },
      title: {
        text: tit
      },
      credits: {
        enabled: false
      },
	  
      xAxis: {
        categories: arr_a,
		events:{
			setExtremes:function(event){
				event.preventDefault();
				let mi = arr_a[Math.round(event.min)];
				let ma = arr_a[Math.round(event.max)];
				
				that.updateGraph(mi,ma,that.idDispositivo);
				console.log("MIN: "+mi);
				console.log("MAX: "+ma);

				
			}
		}
    },
loading:{
	hideDuration:2000
},
    series: [{
        data: arr_b
    }]
    });
   // chart.addPoint(4);
   
    this.chart = chart;
	
   // chart.addPoint(5);
   /* setTimeout(() => {
      chart.addPoint(6);
    }, 2000);*/
	
  }
 
 onItemChange(event,tipo=0){

//	 console.log(this.chart.series);

	// this.chart.series[0].setData(this.rpm_array);
  
	this.par=event;
	//if(tipo==0)this.getUltimeTelemetrie();
	if(tipo==0)this.getDecimatedData();
	 else{
	 //this.getUltimeTelemetrie();
	  if(event==0)this.initChart(this.kmarray,'km');
	     else if(event==1)
		this.initChart(this.rpm_array,'rpm');
	else if(event==2)
		this.initChart(this.engine_load_array,'engine load');
	else if(event==3)
		this.initChart(this.coolant_temp_array,'coolant temperature');
	else if(event==4)
		this.initChart(this.fuel_pressure_array,'fuel pressure');
	else if(event==5)
		this.initChart(this.intake_map_array,'intake map');
	else if(event==6)
		this.initChart(this.throttle_position_array,'throttle position');
	
	else if(event==7)
		this.initChart(this.absolute_load_value_array,'absolute load value');
	else if(event==8)
		this.initChart(this.engine_coolant_temperature_array,'engine coolant temperature');
	else if(event==9)
		this.initChart(this.ignition_timing_advance_array,'ignition timing advance');
	else if(event==10)
		this.initChart(this.intake_temperature_array,'intake temperature');
	else if(event==11)
		this.initChart(this.commanded_egr_array,'commanded egr');
	else if(event==12)
		this.initChart(this.commanded_evaporative_purge_array,'commanded evaporative purge');
	
	else if(event==13)
		this.initChart(this.egr_error_array,'egr error');
	else if(event==14)
		this.initChart(this.fuel_level_array,'fuel level');
	else if(event==15)
		this.initChart(this.evap_system_vapor_pressure_array,'evap system vapor pressure');
	else if(event==16)
		this.initChart(this.barometric_pressure_array,'barometric pressure');
	else if(event==17)
		this.initChart(this.catalyst_temperature_bank_1_array,'catalyst temperature bank 1');
	else if(event==18)
		this.initChart(this.catalyst_temperature_bank_2_array,'catalyst temperature bank 2');
	
	
	else if(event==19)
		this.initChart(this.air_fuel_equiv_ratio_array,'air fuel equiv ratio');
	else if(event==20)
		this.initChart(this.relative_throttle_position_array,'relative throttle position');
	else if(event==21)
		this.initChart(this.ambient_air_temperature_array,'ambient air temperature');
	else if(event==22)
		this.initChart(this.absolute_throttle_position_array,'absolute throttle position');
	else if(event==23)
		this.initChart(this.absolute_pedal_position_d_array,'absolute pedal position d');
	else if(event==24)
		this.initChart(this.absolute_pedal_position_e_array,'absolute pedal position e');
	else if(event==25)
		this.initChart(this.absolute_pedal_position_f_array,'absolute pedal position f');
	
	else if(event==26)
		this.initChart(this.commanded_throttle_attuator_array,'commanded throttle attuator');
	else if(event==27)
		this.initChart(this.ethanol_fuel_array,'ethanol fuel');
	else if(event==28)
		this.initChart(this.fuel_rail_pressure_injection_array,'fuel rail pressure injection');
	else if(event==29)
		this.initChart(this.engine_oil_temperature_array,'engine oil temperature');
	else if(event==30)
		this.initChart(this.engine_fuel_rate_array,'engine fuel rate');
	else if(event==31)
		this.initChart(this.demand_engine_torque_array,'demand engine torque');
	else if(event==32)
		this.initChart(this.engine_reference_torque_array,'engine reference torque');
	this.spinner.hide();
	 }
  }
getUltimeTelemetrie(tipo=1){
	console.log("TIPO : "+tipo);
	 this.telemetriaService.getUltimeTelemetria(this.idDispositivo)
      .subscribe(
        response => {
			
		this.telemetria = response;
		//this.test+='[';
		
this.kmarray=[];
this.temp_array=[];	
this.rpm_array=[];
this.engine_load_array = [];
this.coolant_temp_array= [];
this.fuel_pressure_array=[];
this.intake_map_array=[];
this.throttle_position_array=[];
this.engine_oil_temperature_array=[];
this.barometric_pressure_array= [];
this.engine_fuel_rate_array= [];
			for(var i =this.telemetria.length-1;i>=0;i--){
			console.log("INDEX : "+i+"----VALUE : "+this.telemetria[i].data);
	this.kmarray.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.km});
	this.temp_array.push({"timestamp":this.telemetria[i].data,"engine_oil_temperature":this.telemetria[i].datiTelemetria.engine_oil_temperature,"temperature_coolant":this.telemetria[i].datiTelemetria.temperature_coolant});
	this.rpm_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.rpm});
	this.engine_load_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.calculated_engine_load});
	this.coolant_temp_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.temperature_coolant});
	this.fuel_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_pressure});
	this.intake_map_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.intake_map});
	this.throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.throttle_position});
	this.engine_oil_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_oil_temperature});
	this.barometric_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.barometric_pressure});
	this.engine_fuel_rate_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_fuel_rate});
	this.absolute_load_value_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_load_value});
	this.engine_coolant_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_coolant_temperature});
	this.ignition_timing_advance_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ignition_timing_advance});
	this.intake_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.intake_temperature});
	this.commanded_egr_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_egr});
	this.commanded_evaporative_purge_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_evaporative_purge});
	this.egr_error_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.egr_error});
	this.fuel_level_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_level});
	this.evap_system_vapor_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.evap_system_vapoer});
	this.catalyst_temperature_bank_1_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.catalyst_temperature_bank_1});
	this.catalyst_temperature_bank_2_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.catalyst_temperature_bank_2});
	this.air_fuel_equiv_ratio_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.air_fuel_equiv_ratio});
	this.relative_throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.relative_throttle_position});
	this.ambient_air_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ambient_air_temperature});
	this.absolute_throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_throttle_position});
	this.absolute_pedal_position_d_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_d});
	this.absolute_pedal_position_e_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_e});
	this.absolute_pedal_position_f_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_f});
	this.commanded_throttle_attuator_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_throttle_attuator});
	this.ethanol_fuel_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ethanol_fuel});
	this.fuel_rail_pressure_injection_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_rail_pressure_injection});
	this.engine_oil_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_oil_temperature});
	this.engine_fuel_rate_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_fuel_rate});
	this.demand_engine_torque_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.demand_engine_torque});
	this.engine_reference_torque_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_reference_torque});



}

//this.initChart(this.kmarray);
//this.onItemChange(this.par);
if(tipo==0)this.initChart(this.kmarray);
});
}
  

ngOnDestroy() {
    this.subscription.unsubscribe();
  /*  if (this.amchart) {
      this.AmCharts.destroyChart(this.amchart);
	}   */
   }
   


public updateGraph(startDate,endDate,idDispositivo){
if(startDate>endDate){
	var temp = endDate;
	endDate=startDate;
	startDate=temp;
}/*
console.log("INIZIO: "+startDate);
	  console.log("FINE: "+endDate);*/
	  this.spinner.show();
	  this.telemetriaService.getIntervalTelemetrie(startDate,endDate,idDispositivo)
      .subscribe(
        response => {
			
			console.log(response);
			if( response=== undefined || response.length == 0)console.log('Nessun dato nell\'intervallo selezionato');
			else{
				
			
  
  
		this.telemetria = response;
		//this.test+='[';
		
this.kmarray=[];
this.temp_array=[];	
this.rpm_array=[];
this.engine_load_array = [];
this.coolant_temp_array= [];
this.fuel_pressure_array=[];
this.intake_map_array=[];
this.throttle_position_array=[];
this.engine_oil_temperature_array=[];
this.barometric_pressure_array= [];
this.engine_fuel_rate_array= [];
			//for(var i =this.telemetria.length-1;i>=0;i--){
				for(var i =0;i<this.telemetria.length;i++){
			//console.log("INDEX : "+i+"----VALUE : "+this.telemetria[i].data);
	this.kmarray.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.km});
	this.temp_array.push({"timestamp":this.telemetria[i].data,"engine_oil_temperature":this.telemetria[i].datiTelemetria.engine_oil_temperature,"temperature_coolant":this.telemetria[i].datiTelemetria.temperature_coolant});
	this.rpm_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.rpm});
	this.engine_load_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.calculated_engine_load});
	this.coolant_temp_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.temperature_coolant});
	this.fuel_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_pressure});
	this.intake_map_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.intake_map});
	this.throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.throttle_position});
	this.engine_oil_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_oil_temperature});
	this.barometric_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.barometric_pressure});
	this.engine_fuel_rate_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_fuel_rate});
	this.absolute_load_value_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_load_value});
	this.engine_coolant_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_coolant_temperature});
	this.ignition_timing_advance_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ignition_timing_advance});
	this.intake_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.intake_temperature});
	this.commanded_egr_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_egr});
	this.commanded_evaporative_purge_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_evaporative_purge});
	this.egr_error_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.egr_error});
	this.fuel_level_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_level});
	this.evap_system_vapor_pressure_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.evap_system_vapoer});
	this.catalyst_temperature_bank_1_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.catalyst_temperature_bank_1});
	this.catalyst_temperature_bank_2_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.catalyst_temperature_bank_2});
	this.air_fuel_equiv_ratio_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.air_fuel_equiv_ratio});
	this.relative_throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.relative_throttle_position});
	this.ambient_air_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ambient_air_temperature});
	this.absolute_throttle_position_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_throttle_position});
	this.absolute_pedal_position_d_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_d});
	this.absolute_pedal_position_e_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_e});
	this.absolute_pedal_position_f_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.absolute_pedal_position_f});
	this.commanded_throttle_attuator_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.commanded_throttle_attuator});
	this.ethanol_fuel_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.ethanol_fuel});
	this.fuel_rail_pressure_injection_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.fuel_rail_pressure_injection});
	this.engine_oil_temperature_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_oil_temperature});
	this.engine_fuel_rate_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_fuel_rate});
	this.demand_engine_torque_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.demand_engine_torque});
	this.engine_reference_torque_array.push({"timestamp":this.telemetria[i].data,"value":this.telemetria[i].datiTelemetria.engine_reference_torque});
}

this.onItemChange(this.par,1);
}
});

}

	 

}
	/*
	 if(this.tempchart){
		  this.AmCharts.destroyChart(this.tempchart);
	 }
 
  }
}
*/