import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { Utente } from '../models/Utente';

@Injectable()
export class ClientiService {

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
  
  
   
   getClienti(id: any): Observable<any> {
    var formdata = new FormData();
    formdata.append("id", id);
    return this.http.post<any>(`${this.urlBase}clientiOfficina`, formdata).pipe(
      tap((response) => { console.log("Fetched ListaClientiOfficina"); console.log(response) },
        catchError(this.handleError("notifiche error", {})))
    );
  }
 
 insertCliente(nome:string, cognome:string, email:string, password: string,idOfficina:any, telefono:string): Observable<Auto> {
    var formdata = new FormData();

    formdata.append("cognome", cognome);
	 formdata.append("nome", nome);
	  formdata.append("email", email);
	  formdata.append("password", password);
    formdata.append("idOfficina", idOfficina);
	  formdata.append("telefono", telefono);
    
    return this.http.post<Auto>(`${this.urlBase}inserisciCliente`, formdata).pipe(
      tap((response) => console.log("Fetched INSERT CLIENTE"),
        catchError(this.handleError("Insert Cliente error", {})))
    );
  }
  
}
