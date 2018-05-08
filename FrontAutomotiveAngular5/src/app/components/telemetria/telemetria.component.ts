import { Component, OnInit, OnDestroy } from '@angular/core';
import { Chart } from 'chart.js';
import { Utente } from '../../models/Utente';
import { Auto } from '../../models/Auto';
import { Router, ActivatedRoute } from '@angular/router';
import { TelemetriaService } from '../../services/telemetria.service';
import { AmChartsService, AmChart } from "@amcharts/amcharts3-angular";
import { Subscription } from 'rxjs/Subscription';
import { IMqttMessage, MqttModule, MqttService, IMqttServiceOptions  } from 'ngx-mqtt';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';

@Component({
    selector: 'app-telemetria',
    templateUrl: './telemetria.component.html',
    styleUrls: ['./telemetria.component.css']
})

export class TelemetriaComponent implements OnInit,OnDestroy {
    private subscription: Subscription;
    public message: string;
	private amchart: AmChart;
	private tempchart: AmChart;
	private first_bottom_chart: AmChart;
    private second_bottom_chart: AmChart;
	private third_bottom_chart: AmChart;
	
	lat:number;
	lng: number;
	auto:Auto;
	 utente: Utente;
	 idDispositivo;
	 telemetria;
  chart = [];
  showgrafici=false;
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
engine_oil_temperature_array=[];
barometric_pressure_array= [];
engine_fuel_rate_array= [];
lastTelemetria;
showparameter=0; //What parameter to display
  constructor(private _mqttService: MqttService,private router: Router, private route: ActivatedRoute, private telemetriaService:TelemetriaService,private AmCharts: AmChartsService) { 
   
  }

  
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
  
this.telemetriaService.getUltimeTelemetria(this.idDispositivo)
      .subscribe(
        response => {
			
		this.telemetria = response;
		//this.test+='[';
			for(var i =this.telemetria.length-1;i>=0;i--){
			
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
}	 
});

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
  });
  }
  
  
  changeTab(id){
	  this.showparameter=id;
  }

  public unsafePublish(topic: string, message: string): void {
    this._mqttService.unsafePublish(topic, message, {qos: 1, retain: true});
  }
 
ngOnDestroy() {
    this.subscription.unsubscribe();
   /* if (this.amchart) {
      this.AmCharts.destroyChart(this.amchart);
    }*/
	/*
	 if(this.tempchart){
		  this.AmCharts.destroyChart(this.tempchart);
	 }
	*/ 
  }
    }

}
