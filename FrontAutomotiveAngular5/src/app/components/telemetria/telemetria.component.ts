import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { Utente } from '../../models/Utente';
import { Router, ActivatedRoute  } from '@angular/router';
declare var jquery: any;
declare var $: any;
import swal from 'sweetalert2';

@Component({
  selector: 'app-telemetria',
  templateUrl: './telemetria.component.html',
  styleUrls: ['./telemetria.component.css']
})

export class TelemetriaComponent implements OnInit {
  lat: number = 41.134769;
  lng: number = 14.780548;

  chart = [];

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
	  
	   this.utente = JSON.parse(sessionStorage.getItem("loginEntity")).utente;
	  this.sub = this.route.queryParams.subscribe(params => {
     
	 // Prendere paremetro per visualizzare solo preventivi che voglio, se non ci sta imopsto a 0.
	 // 0 - tutti, 1 - in attesa di risposta, 2 - risposti, 3 - accettati, 4 - rifiutati
	 this.stato = +params['stato'] || 0; 
	 if(this.stato==0)this.filtropreventivi="Tutti";
	 else if(this.stato==1)this.filtropreventivi="In Attesa Di Risposta";
	 else if(this.stato==2)this.filtropreventivi="Risposti";
	 else if(this.stato==3)this.filtropreventivi="Accettati";
	 else if(this.stato==4)this.filtropreventivi="Rifiutati";
	 this.loadPreventiviOfficina();

    });
	
	
	
	

    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: ["1", "2", "3", "4", "5"],
        datasets: [
          {
            data: [2, 2, 3, 4, 5],
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
    });

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
