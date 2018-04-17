import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { Utente } from '../../models/Utente';
import { Auto } from '../../models/Auto';
import { Router, ActivatedRoute  } from '@angular/router';
import { TelemetriaService } from '../../services/telemetria.service';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';

@Component({
  selector: 'app-telemetria',
  templateUrl: './telemetria.component.html',
  styleUrls: ['./telemetria.component.css']
})

export class TelemetriaComponent implements OnInit {
  lat:number;
  lng: number;
	auto:Auto;
	 utente: Utente;
	 idDispositivo;
	 telemetria;
  chart = [];
sub;
km;
kmarray = [];
  constructor(private router: Router, private route: ActivatedRoute, private telemetriaService:TelemetriaService) { }

  ngOnInit() {
	  
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
		
		this.auto=this.telemetriaService.getAuto();
		this.idDispositivo =this.telemetriaService.getIdDispositivo();
	
	console.log(this.auto);
	console.log(this.idDispositivo);
	
    this.telemetriaService.getTelemetria(this.idDispositivo)
      .subscribe(
        response => {
		this.km =response.datiTelemetria.km;	
        this.lat  = response.datiTelemetria.latitudine;
		this.lng  = response.datiTelemetria.longitudine;
        }
      );
  
this.telemetriaService.getUltimeTelemetria(this.idDispositivo)
      .subscribe(
        response => {
			
		this.telemetria = response;
		for(var i=0;i<this.telemetria.length;i++){
	this.kmarray.push(this.telemetria[i].datiTelemetria.km);
}	 

    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: ["1", "2", "3", "4", "5"],
        datasets: [
          {
            data: this.kmarray,
            borderColor: "#3cba9f",
            fill: false,
            lineTension: 0
          },
          {
            data: [5, 2, 5, 3, 4],
            borderColor: "#5566ff",
            fill: false,
            lineTension: 0
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
    })
		
        }
      );
	

;

    this.chart = new Chart('canvas2', {
      type: 'line',
      data: {
        labels: [1,2,3,4,5,6,7,8,9,10,11],
        datasets: [
          {
            data: [1,0,1,0,1,0,1,0,1,0,1],
            borderColor: "#3cba9f",
            fill: true,
            lineTension: 0,
          },
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
  }

}
