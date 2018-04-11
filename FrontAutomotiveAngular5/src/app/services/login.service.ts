import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import { ENVIROMENT } from '../models/enviroment';
import { LoginEntity } from '../models/LoginEntity';

@Injectable()
export class LoginService {

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

  isLogged():boolean{
    if(typeof(Storage)!=="undefined"){
      if(sessionStorage.getItem("loginEntity")){
        return true;
      }
    }return false;
  }

   login(email: string, pwd: string): Observable<LoginEntity> {
    var formdata = new FormData();
    formdata.append("email", email);
    formdata.append("pwd", pwd);
    return this.http.post<LoginEntity>(`${this.urlBase}login`, formdata).pipe(
      tap((response) => console.log("Fetched LoginEntity"),
        catchError(this.handleError("login error", {})))
    );
  }

}
