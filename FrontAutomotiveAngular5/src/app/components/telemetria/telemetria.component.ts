import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-telemetria',
  templateUrl: './telemetria.component.html',
  styleUrls: ['./telemetria.component.css']
})

export class TelemetriaComponent implements OnInit {
  lat: number = 41.134769;
  lng: number = 14.780548;

  chart = [];

  constructor() { }

  ngOnInit() {

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
