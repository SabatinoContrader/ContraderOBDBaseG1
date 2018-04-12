import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { Auto } from '../models/Auto';
<<<<<<< HEAD
import { NotificaAutoDTO } from '../models/NotificaAutoDTO';
=======
>>>>>>> c42123ca8ee186df9c9b71b6ffca49eb276e0729

@Injectable()
export class AutoService {

  private urlBase = ENVIROMENT.url;

  constructor(private http: HttpClient) { }
<<<<<<< HEAD

  private handleError<T>(operation = 'operation', result?: T) {
=======
  
    private handleError<T>(operation = 'operation', result?: T) {
>>>>>>> c42123ca8ee186df9c9b71b6ffca49eb276e0729
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
<<<<<<< HEAD

  getNotifiche(id: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("id", id);
    return this.http.post<any>(`${this.urlBase}situazioneAuto`, formdata).pipe(
      tap((response) => {console.log("Fetched NotificheAuto"); console.log(response)},
        catchError(this.handleError("notifiche error", {})))
    );
  }

=======
  
  
// METHOD TO ADD Auto
  insertAuto(marca:string,modello:string,targa:string,numeroTelaio: string, cilindrata: any, cambio : string,potenza: string,tipologiaAuto: string,
  alimentazione:string, numeroPorte: any, kmAttuali :any, idOfficina:any, scadenzaAssicurazione:any,scadenzaBollo:any, scadenzaRevisione:any,scadenzaTagliando:any): Observable<Auto> {
    var formdata = new FormData();
    formdata.append("marca", marca);
    formdata.append("modello", modello);
	  formdata.append("targa", targa);
    formdata.append("numeroTelaio", numeroTelaio);
	  formdata.append("cilindrata", cilindrata);
    formdata.append("cambio", cambio);
	 formdata.append("potenza", potenza);
    formdata.append("tipologiaAuto", tipologiaAuto);
	  formdata.append("alimentazione", alimentazione);
    formdata.append("numeroPorte", numeroPorte);
	  formdata.append("kmAttuali", kmAttuali);
    formdata.append("idOfficina", idOfficina);
		  formdata.append("scadenzaAssicurazione", scadenzaAssicurazione);
    formdata.append("scadenzaBollo", scadenzaBollo);
	  formdata.append("scadenzaRevisione", scadenzaRevisione);
    formdata.append("scadenzaTagliando", scadenzaTagliando);
	
    return this.http.post<Auto>(`${this.urlBase}inserisciAuto`, formdata).pipe(
      tap((response) => console.log("Fetched LoginEntity"),
        catchError(this.handleError("Insert Auto error", {})))
    );
  }
  
>>>>>>> c42123ca8ee186df9c9b71b6ffca49eb276e0729
}
