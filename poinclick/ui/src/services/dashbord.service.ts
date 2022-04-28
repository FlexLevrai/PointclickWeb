import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RestControllerService } from './restController.service';

@Injectable({
  providedIn: 'root'
})
export class DashboardService extends RestControllerService {

  constructor(http: HttpClient) {super(http) }

  public getNombreHomme(url) {
    return this.http.get(this.host + url);
  }

  public getNombreFemme(url) {
    return this.http.get(this.host + url);
  }

  public getAnneeEncours(url) {
    return this.http.get(this.host + url);
  }

  public getMoisEncours(url) {
    return this.http.get(this.host + url);
  }


}
