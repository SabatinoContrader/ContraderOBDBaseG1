import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { Dispositivo } from '../models/Dispositivo';


@Injectable()
export class DispositiviService {


 private urlBase = ENVIROMENT.url;
	
	
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

    
   getDispositivi(idOfficina: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("idOfficina", idOfficina);
    return this.http.post<any>(`${this.urlBase}listaDispositiviOfficina`, formdata).pipe(
      tap((response) => { console.log("Fetched ListaDispositiviOfficina"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
 
 insertDispositivo(idOfficina:any, codice:string): Observable<any> {
    var formdata = new FormData();

    formdata.append("idOfficina", idOfficina);
	 formdata.append("codice", codice);
	
    return this.http.post<any>(`${this.urlBase}inserisciDispositivo`, formdata).pipe(
      tap((response) => console.log("Fetched INSERT DISPOSITIVO"),
        catchError(this.handleError("Insert Cliente error", {})))
    );
  }
  
  
}
