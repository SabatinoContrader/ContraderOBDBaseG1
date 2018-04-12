import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';

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

  chiediPreventivo(email: string, dettagli: string, idauto: any): void {
    var formdata = new FormData();
    formdata.append("email", email);
    formdata.append("dettagli", dettagli);
    formdata.append("idauto", idauto  );
    this.http.post(`${this.urlBase}inviapreventivo`, formdata).pipe(
      tap((response) => { console.log("Fetched RichiestaPreventivo"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
}
