import { Component, OnInit, OnDestroy } from '@angular/core';
import { Chart } from 'chart.js';
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
  /*

 this.amchart = this.AmCharts.makeChart("chartdiv", {
      "type": "serial",
      "theme": "light",
	   "legend": {
        "useGraphSettings": true
    },
		"mouseWheelZoomEnabled": true,
	     "dataProvider": this.kmarray,
   "synchronizeGrid":true,
    "valueAxes": [{
        "id":"v1",
        "axisColor": "#FF6600",
        "axisThickness": 2,
        "axisAlpha": 1,
        "position": "left"
    }],
	"graphs": [{
        "valueAxis": "v1",
        "lineColor": "#FF6600",
		"balloonText": "[[value]]",
        "bullet": "round",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "Km",
        "valueField": "value",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    }],
	"chartScrollbar": {
        "autoGridCount": true,
        "graph": "v1",
        "scrollbarHeight": 40
    },
    "chartCursor": {
       "limitToGraph":"v1"
    },
    "categoryField": "timestamp",
	"categoryAxis": {
		"parseDates":true,
	    "minPeriod": "fff"
		
	}     
    });
	
}
	
	
	 this.tempchart = this.AmCharts.makeChart("tempchart", {
      "type": "serial",
      "theme": "light",
	  "legend": {
        "useGraphSettings": true
    }, 
	"mouseWheelZoomEnabled": true,
   "dataProvider": this.temp_array,
   "synchronizeGrid":true,
    "valueAxes": [{
        "id":"v1",
        "axisColor": "#FF6600",
        "axisThickness": 2,
        "axisAlpha": 1,
        "position": "left"
    },
	{
        "id":"v2",
        "axisColor": "#B0DE09",
        "axisThickness": 2,
        "gridAlpha": 0,
        "offset": 50,
        "axisAlpha": 1,
        "position": "left"
    }],
	"graphs": [{
        "valueAxis": "v1",
        "lineColor": "#FF6600",
		"balloonText": "[[engine_oil_temperature]]",
        "bullet": "round",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "engine_oil_temperature",
        "valueField": "engine_oil_temperature",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    },
	{
        "valueAxis": "v2",
        "lineColor": "#B0DE09",
		"balloonText": "[[temperature_coolant]]",
        "bullet": "triangleUp",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "temperature_coolant",
        "valueField": "temperature_coolant",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    }],
	"chartScrollbar": {
        "autoGridCount": true,
        "graph": "v1",
        "scrollbarHeight": 40
    },
    "chartCursor": {
       "limitToGraph":"v1"
    },
	 "categoryField": "timestamp",
	"categoryAxis": {
		"parseDates":true,
	    "minPeriod": "fff"
	} 
    });
	
	
	 this.first_bottom_chart = this.AmCharts.makeChart("chartfirstbottom", {
      "type": "serial",
      "theme": "light",
	   "legend": {
        "useGraphSettings": true
    },
		"mouseWheelZoomEnabled": true,
	     "dataProvider": this.engine_oil_temperature_array,
   "synchronizeGrid":true,
    "valueAxes": [{
        "id":"v1",
        "axisColor": "#FF6600",
        "axisThickness": 2,
        "axisAlpha": 1,
        "position": "left"
    }],
	"graphs": [{
        "valueAxis": "v1",
        "lineColor": "#FF6600",
		"balloonText": "[[value]]",
        "bullet": "round",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "Engine Oil Temperature",
        "valueField": "value",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    }],
	"chartScrollbar": {
        "autoGridCount": true,
        "graph": "v1",
        "scrollbarHeight": 40
    },
    "chartCursor": {
       "limitToGraph":"v1"
    },
    "categoryField": "timestamp",
	"categoryAxis": {
		"parseDates":true,
	    "minPeriod": "fff"
		
	}     
    });
	
	
	 this.second_bottom_chart = this.AmCharts.makeChart("chartsecondbottom", {
      "type": "serial",
      "theme": "light",
	   "legend": {
        "useGraphSettings": true
    },
		"mouseWheelZoomEnabled": true,
	     "dataProvider": this.barometric_pressure_array,
   "synchronizeGrid":true,
    "valueAxes": [{
        "id":"v1",
        "axisColor": "#FF6600",
        "axisThickness": 2,
        "axisAlpha": 1,
        "position": "left"
    }],
	"graphs": [{
        "valueAxis": "v1",
        "lineColor": "#FF6600",
		"balloonText": "[[value]]",
        "bullet": "round",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "Barometric Pressure",
        "valueField": "value",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    }],
	"chartScrollbar": {
        "autoGridCount": true,
        "graph": "v1",
        "scrollbarHeight": 40
    },
    "chartCursor": {
       "limitToGraph":"v1"
    },
    "categoryField": "timestamp",
	"categoryAxis": {
		"parseDates":true,
	    "minPeriod": "fff"
		
	}     
    });
	
	 this.third_bottom_chart = this.AmCharts.makeChart("chartthirdbottom", {
      "type": "serial",
      "theme": "light",
	   "legend": {
        "useGraphSettings": true
    },
		"mouseWheelZoomEnabled": true,
	     "dataProvider": this.engine_fuel_rate_array,
   "synchronizeGrid":true,
    "valueAxes": [{
        "id":"v1",
        "axisColor": "#FF6600",
        "axisThickness": 2,
        "axisAlpha": 1,
        "position": "left"
    }],
	"graphs": [{
        "valueAxis": "v1",
        "lineColor": "#FF6600",
		"balloonText": "[[value]]",
        "bullet": "round",
        "bulletBorderThickness": 1,
        "hideBulletsCount": 30,
        "title": "Engine Fuel Rate",
        "valueField": "value",
		"fillAlphas": 0,
		"balloon":{
            "drop":true
        }
    }],
	"chartScrollbar": {
        "autoGridCount": true,
        "graph": "v1",
        "scrollbarHeight": 40
    },
    "chartCursor": {
       "limitToGraph":"v1"
    },
    "categoryField": "timestamp",
	"categoryAxis": {
		"parseDates":true,
	    "minPeriod": "fff"
		
	}     
    });
	
	//this.tempchart.addListener("dataUpdated", this.zoomChart);
	
 
    this.chart = new Chart('canvas3', {
      type: 'line',
      data: {
        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        datasets: [
          {
            label: "Relax",
            data: [0, 0, 0, 0, 1, 3, 5],
            borderColor: "#3cba9f",
            fill: true
          },
          {
            label: "Enojy",
            data: [0, 0, 0, 0, 0, 6, 0],
            borderColor: "#5566ff",
            fill: true
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
            display: true
          }],
        }
      }
    });

    this.chart = new Chart('canvas4', {
      type: 'line',
      data: {
        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        datasets: [
          {
            label: "Relax",
            data: [0, 0, 0, 0, 1, 3, 5],
            borderColor: "#3cba9f",
            fill: true
          },
          {
            label: "Enojy",
            data: [0, 0, 0, 0, 0, 6, 0],
            borderColor: "#5566ff",
            fill: true
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
            display: true
          }],
        }
      }
    });

    this.chart = new Chart('canvas5', {
      type: 'line',
      data: {
        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        datasets: [
          {
            label: "Relax",
            data: [0, 0, 0, 0, 1, 3, 5],
            borderColor: "#3cba9f",
            fill: true
          },
          {
            label: "Enojy",
            data: [0, 0, 0, 0, 0, 6, 0],
            borderColor: "#5566ff",
            fill: true
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
            display: true
          }],
        }
      }
    });
  });
  
      });
  }
  /* zoomChart(){
	  if(this.tempchart)
    this.tempchart.zoomToIndexes(this.tempchart.dataProvider.length - 20, this.tempchart.dataProvider.length - 1);
}*/
 
  /*FUNCTION TO CHANGE DATA IN GRAFICO*/
/*  onItemChange(event){
	  if(event==0)
	 this.amchart.dataProvider = this.kmarray;
    else if(event==1)
		this.amchart.dataProvider = this.rpm_array;
	else if(event==2)
		this.amchart.dataProvider = this.engine_load_array;
	else if(event==3)
		this.amchart.dataProvider = this.coolant_temp_array;
	else if(event==4)
		this.amchart.dataProvider = this.fuel_pressure_array;
	else if(event==5)
		this.amchart.dataProvider = this.intake_map_array;
	else if(event==6)
		this.amchart.dataProvider = this.throttle_position_array;
	
  }*/
  
  
  
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
