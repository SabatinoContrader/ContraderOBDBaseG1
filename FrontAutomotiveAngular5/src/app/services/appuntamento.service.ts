import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { Appuntamento } from '../models/Appuntamento';

@Injectable()
export class AppuntamentoService {

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

  chiediAppuntamento(emailapp: string, dettagliapp: string, ora: string, dataAppuntamento: string): Observable<void> {
    var formdata = new FormData();
    formdata.append("emailapp", emailapp);
    formdata.append("dettagliapp", dettagliapp);
    formdata.append("ora", ora);
    formdata.append("dataAppuntamento", dataAppuntamento);
    return this.http.post<void>(`${this.urlBase}richiediappuntamento`, formdata).pipe(
      tap((response) => { console.log("Fetched RichiestaAppuntamento"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }

  getAppuntamenti(id: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("id", id);
    return this.http.post<any>(`${this.urlBase}appuntamentiCliente`, formdata).pipe(
      tap((response) => { console.log("Fetched ListaAppuntamentiCliente"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }

}