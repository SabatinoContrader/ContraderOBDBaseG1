import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { Preventivo } from '../models/Preventivo';
@Injectable()
export class PreventivoService {

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

  chiediPreventivo(email: string, dettagli: string, idauto: any): Observable<void> {
    var formdata = new FormData();
    formdata.append("email", email);
    formdata.append("dettagli", dettagli);
    formdata.append("idauto", idauto  );
    return this.http.post<void>(`${this.urlBase}inviapreventivo`, formdata).pipe(
      tap((response) => { console.log("Fetched RichiestaPreventivo"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
  
   listaPreventiviOfficina(id: any): Observable<Preventivo> {
    var formdata = new FormData();
    formdata.append("id", id);

    return this.http.post<Preventivo>(`${this.urlBase}preventiviOfficina`, formdata).pipe(
      tap((response) => { console.log("Fetched LISTA Preventivi officina"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
  
   rispondiPreventivo(dettagli: string,costoprev: any  , idprev: any): Observable<void> {
    var formdata = new FormData();
    formdata.append("dettagli", dettagli);
    formdata.append("costoprev", costoprev);
    formdata.append("idprev", idprev  );
    return this.http.post<void>(`${this.urlBase}rispondipreventivo`, formdata).pipe(
      tap((response) => { console.log("Fetched Rispondiprventivo"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
  
}
