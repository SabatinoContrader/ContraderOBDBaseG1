import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';


@Injectable()
export class NoleggiService {

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

    
   getNoleggi(idOfficina: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("id", idOfficina);
    return this.http.post<any>(`${this.urlBase}noleggiOfficina`, formdata).pipe(
      tap((response) => { console.log("Fetched ListaNoleggiOfficina"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
 
 insertNoleggio(idOfficina:any, idAuto:any, CapLuogoDiRiconsegna:any, CapLuogoDiRitiro:any, DataInizioNoleggio:string, DataFineNoleggio:string,maxKmNoleggio:any, idUtente:any): Observable<any> {
    var formdata = new FormData();

    formdata.append("idOfficina", idOfficina);
	formdata.append("idAuto", idAuto);
	formdata.append("CapLuogoDiRiconsegna", CapLuogoDiRiconsegna);
	formdata.append("CapLuogoDiRitiro", CapLuogoDiRitiro);
	formdata.append("DataInizioNoleggio", DataInizioNoleggio);
	formdata.append("DataFineNoleggio", DataFineNoleggio);
	formdata.append("MaxKmNoleggio",maxKmNoleggio);
	formdata.append("idUtente",idUtente);
	
    return this.http.post<any>(`${this.urlBase}inserisciNoleggio`, formdata).pipe(
      tap((response) => console.log("Fetched INSERT NOLEGGIO"),
        catchError(this.handleError("Insert Cliente error", {})))
    );
  }
  

}
