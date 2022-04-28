import { Component, OnInit } from '@angular/core';
import { DashboardService } from 'src/services/dashbord.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor( public dashbordService: DashboardService) { }

  nombreHomme;
  nombreFemme;
  anneeCours;
  moisEnCours;

  ngOnInit(): void {
    this.OnGetNombreHomme();
    this.OnGetNombreFemme();
    this.OnGetAnneeEnCours();
    this.OnGetMoisEnCours();
  }

  OnGetNombreHomme() {
    this.dashbordService.getNombreHomme('/api/dashbord/homme')
    .subscribe(data => {
      this.nombreHomme = data;

    }, error => {
      console.log(error);

    });
  }
  
  OnGetNombreFemme() {
    this.dashbordService.getNombreFemme('/api/dashbord/femme')
    .subscribe(data => {
      this.nombreFemme = data;
    }, error => {
      console.log(error);

    });
  }

  OnGetAnneeEnCours() {
    this.dashbordService.getAnneeEncours('/api/dashbord/annneEncours')
    .subscribe(data => {
      this.anneeCours = data;
    }, error => {
      console.log(error);

    });
  }

  OnGetMoisEnCours() {
    this.dashbordService.getMoisEncours('/api/dashbord/moisEncours')
    .subscribe(data => {
      this.moisEnCours = data;
      console.log(data);
    }, error => {
      console.log(error);

    });
  }

}
