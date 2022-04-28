import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable, of} from "rxjs";
import {AppMessageState, MessageStateEnum} from "../../state/message.state";
import {NotificationService} from "../../../services/notification.service";
import {MatPaginator} from "@angular/material/paginator";
import {catchError, map, startWith} from "rxjs/operators";
import {MoisService} from "../../../services/mois.service";
import {MoisModel} from "../../../models/mois.model";

@Component({
  selector: 'app-mois',
  templateUrl: './mois.component.html',
  styleUrls: ['./mois.component.css']
})
export class MoisComponent implements OnInit {

  mois$:Observable<AppMessageState<MoisModel[]>>| null = null ;
  readonly  DataStateEnum = MessageStateEnum;
  page:number = 1;
  mois:MoisModel = new MoisModel();

  constructor( public  moisService : MoisService, public notificationService : NotificationService) { }

  amodifier: number = 0;

  ngOnInit(): void {
    this.OnGetAllMois();
  }

  OnGetAllMois()
  {
    this.mois$ = this.moisService.getAllMois('/api/mois/list').pipe(
      map(data=>({dataState:MessageStateEnum.LOADED,datase:data,dataLength:data.length})),
      startWith({dataState:MessageStateEnum.LOADING}),
      catchError(err=>of({dataState:MessageStateEnum.ERROR,errorMessage:err.message})),
    );
    this.OnVide();
  }

  OnSaveMois()
  {
    this.moisService.saveMois('/api/mois/save', this.mois)
      .subscribe(data => {
        this.OnGetAllMois();
        this.notificationService.successNotification ('Enregitrement du mois ' +this.mois.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnUpdateMois()
  {
    this.moisService.updateMois('/api/mois/save', this.mois)
      .subscribe(data => {
        this.OnGetAllMois();
        this.notificationService.successNotification ('Modification du mois ' +this.mois.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnEditMois(id: number)
  {
    this.moisService.editeMois('/api/mois/edit/' + id)
      .subscribe(data => {
        // @ts-ignore
        this.mois = data;
        this.amodifier = 1;
      }, error => {
        console.log(error);
      });
  }

  OnDeleteMois(id: number)
  {
    this.notificationService.onpenConfirmDialog('Etes-vous sure de vouloir supprimer cet enrégistrement ... ?')
      .afterClosed().subscribe(res => {
      if (res)
      {
        this.moisService.deleteMois('/api/mois/delete/' + id)
          .subscribe(data => {
            this.OnGetAllMois();
            this.notificationService.infoNotification('Enrégistrement supprimer avec success !!!!');
          }, error => {
            console.log(error);
            this.notificationService.warningNotification('Impossible de Supprimer, Erreur liée au seveur');
          });
      }
      else
      {
        this.notificationService.infoNotification('Opération de suppression annulée !');
      }
    });
  }

  OnActivateMois(id: number)
  {
    this.moisService.activeMois('/api/mois/active/' + id)
      .subscribe(data => {
        this.notificationService.infoNotification('Vous vennez d\'active ce mois ');
        this.OnGetAllMois();
      }, error => {
        console.log(error);
        this.notificationService.warningNotification('Une erreur c\'est produite lors de l\'activation');
      });
  }

  OnVide()
  {
    this.moisService.moisFormGroup.reset();
    this.mois.id = null ;
    this.moisService.initializeFormGroup();
    this.amodifier = 0;
  }

}
