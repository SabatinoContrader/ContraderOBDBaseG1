import { Component, OnInit } from '@angular/core';
import { AutoLocation } from '../../models/AutoLocation';
import { TelemetriaService } from '../../services/telemetria.service'
import { Observable } from 'rxjs/Observable';
import { IntervalObservable } from 'rxjs/observable/intervalObservable';
import 'rxjs/add/operator/takeWhile';

@Component({
  selector: 'app-all-auto',
  templateUrl: './all-auto.component.html',
  styleUrls: ['./all-auto.component.css']
})
export class AllAutoComponent implements OnInit {
  autoLocation: AutoLocation[];
  lat: number = 41.134769;
  lng: number = 14.780548;
  private alive: boolean;
	infoWindowOpened;
  constructor(private telemetriaService: TelemetriaService) {
    this.alive = true;
  }

  ngOnInit() {

    this.telemetriaService.getAutoLocation()
      .subscribe(
        response => { this.autoLocation = response }
      );

 /*   IntervalObservable.create(10000)
      .takeWhile(() => this.alive)
      .subscribe(() => {
        this.telemetriaService.getAutoLocation()
          .subscribe(
            response => { this.autoLocation = response; console.log(this.autoLocation) }
          );
      }); */
    

  }
    
	
clickedMarker(label: string, infoWindow, marker, index: number) {
    if (this.infoWindowOpened === infoWindow) {
        console.log("window already opened");
        return;
    }

    if (this.infoWindowOpened !== null && this.infoWindowOpened !== undefined) {
        this.infoWindowOpened.close();
    }
    this.infoWindowOpened = infoWindow;
}

  ngOnDestroy(){
    this.alive = false;
  }

}