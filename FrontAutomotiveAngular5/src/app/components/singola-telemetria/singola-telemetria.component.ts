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
engine_oil_temperature_array=[];
barometric_pressure_array= [];
engine_fuel_rate_array= [];
lastTelemetria;
showparameter=0;
par=0;
startGraph=0;
  constructor(private _mqttService: MqttService,private router: Router, private route: ActivatedRoute, private telemetriaService:TelemetriaService,private AmCharts: AmChartsService) { }

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
  
 this.getUltimeTelemetrie(0);

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
 this.getUltimeTelemetrie();
	
  });
  
	
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

  initChart(arr){
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
        type: 'line',
		  zoomType: 'x',
		  resetZoomButton: {
                    theme: {
                        display: 'show'
                    }
		  }
      },
      title: {
        text: 'Linechart'
      },
      credits: {
        enabled: false
      },
	  
      xAxis: {
        categories: arr_a,
		events:{
			setExtremes:function(event){
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
 
 onItemChange(event,tipo){

//	 console.log(this.chart.series);

	// this.chart.series[0].setData(this.rpm_array);
  
	this.par=event;
	if(tipo==0)this.getUltimeTelemetrie();
	
	 
	 //this.getUltimeTelemetrie();
	  if(event==0)this.initChart(this.kmarray);
	     else if(event==1)
		this.initChart(this.rpm_array);
	else if(event==2)
		this.initChart(this.engine_load_array);
	else if(event==3)
		this.initChart(this.coolant_temp_array);
	else if(event==4)
		this.initChart(this.fuel_pressure_array);
	else if(event==5)
		this.initChart(this.intake_map_array);
	else if(event==6)
		this.initChart(this.throttle_position_array);

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
}

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
