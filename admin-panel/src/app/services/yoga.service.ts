import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http"
import { Observable, throwError, Subject } from 'rxjs';
import { map, catchError } from "rxjs/operators";
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class YogaService {

  constructor(private http: HttpClient) {
  }

  private prependApiUrl(url: string): string {
    return environment.baseUrl + url;
  }

  public get(url: string, headers: HttpHeaders = this.getHeaders()): Observable<any> {
    return this.http.get(this.prependApiUrl(url), { headers }).pipe(catchError(this.handleError));
  }

  public post(url: string, body: any, headers: HttpHeaders = this.getHeaders()): Observable<any> {
    console.log("Inside service")
    return this.http.post(this.prependApiUrl(url), body, { headers }).pipe(catchError(this.handleError));
  }

  public put(url: string, body?: any, headers: HttpHeaders = this.getHeaders()): Observable<any> {
    return this.http.put(this.prependApiUrl(url), body, { headers }).pipe(catchError(this.handleError));
  }

  public delete(url: string, headers: HttpHeaders = this.getHeaders()): Observable<any> {
    return this.http.delete(this.prependApiUrl(url), { headers }).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error.message}`;
    }
    return throwError(error);
  }

  private getHeaders(): HttpHeaders {
    let headers: HttpHeaders = new HttpHeaders();
    return headers;
  }
}
