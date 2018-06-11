import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';

@Injectable()
export class GuastiService {
	
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

  
  getGuasti(id: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("id", id);
	
    return this.http.post<any>(`${this.urlBase}getGuasti`, formdata).pipe(
      tap((response) => {console.log("Fetched lista guasti"); console.log(response)},
        catchError(this.handleError("notifiche error", {})))
    );
  }
  
  risolviGuasto(idguasto:any):  Observable<any> {
    var formdata = new FormData();
  
	formdata.append("idguasto",idguasto);
	
    return this.http.post<any>(`${this.urlBase}setrisoltoguasto`, formdata).pipe(
      tap((response) => console.log("Fetched Guasto Risolto"),
        catchError(this.handleError("Guasto Risoltoerror", {})))
    );
  }
  
}
