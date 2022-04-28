import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {AnneeModel} from "../../../models/annee.model";
import {Observable, of} from "rxjs";
import {catchError, map, startWith} from "rxjs/operators";
import {AppMessageState, MessageStateEnum} from "../../state/message.state";
import {NotificationService} from "../../../services/notification.service";
import {errorObject} from "rxjs/internal-compatibility";
import { AnneeService } from 'src/services/annee.service';


@Component({
  selector: 'app-annees',
  templateUrl: './annees.component.html',
  styleUrls: ['./annees.component.css']
})

export class AnneesComponent implements OnInit, AfterViewInit{

  annees$:Observable<AppMessageState<AnneeModel[]>>| null = null ;
  readonly  DataStateEnum = MessageStateEnum;
  page:number = 1;
  annee:AnneeModel = new AnneeModel();

  constructor( public  anneeService : AnneeService, public notificationService : NotificationService) { }

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  amodifier: number = 0;

  ngOnInit(): void {
    this.OnGetAllAnnee();
  }

  OnGetAllAnnee()
  {
    this.annees$ = this.anneeService.getAllAnnee('/api/annee/list').pipe(
        map(data=>({dataState:MessageStateEnum.LOADED,datase:data,dataLength:data.length})),
        startWith({dataState:MessageStateEnum.LOADING}),
        catchError(err=>of({dataState:MessageStateEnum.ERROR,errorMessage:err.message})),
    );
    this.OnVide();
  }

  OnSaveAnnee()
  {
    this.anneeService.saveAnnee('/api/annee/save', this.annee)
      .subscribe(data => {
        this.OnGetAllAnnee();
        this.notificationService.successNotification ('Enregitrement de l\'année ' +this.annee.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnUpdateAnnee()
  {
    this.anneeService.updateAnnee('/api/annee/save', this.annee)
      .subscribe(data => {
        this.OnGetAllAnnee();
        this.notificationService.successNotification ('Modification de l\'année ' +this.annee.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnEditAnnee(id: number)
  {
    this.anneeService.editeAnnee('/api/annee/edit/' + id)
      .subscribe(data => {
        // @ts-ignore
        this.annee = data;
        this.amodifier = 1;
      }, error => {
        console.log(error);
      });
  }

  OnDeleteAnnee(id: number)
  {
    this.notificationService.onpenConfirmDialog('Etes-vous sure de vouloir supprimer cet enrégistrement ... ?')
      .afterClosed().subscribe(res => {
      if (res)
      {
        this.anneeService.deleteAnnee('/api/annee/delete/' + id)
          .subscribe(data => {
            this.OnGetAllAnnee();
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

  OnActivateAnnee(id: number)
  {
    this.anneeService.activeAnnee('/api/annee/active/' + id)
      .subscribe(data => {
        this.notificationService.infoNotification('Vous vennez d\'active cette année ');
        this.OnGetAllAnnee();
      }, error => {
        console.log(error);
        this.notificationService.warningNotification('Une erreur c\'est produite lors de l\'activation');
      });
  }

  OnVide()
  {
    this.anneeService.anneFormGroup.reset();
    this.annee.id = null ;
    this.anneeService.initializeFormGroup();
    this.amodifier = 0;
  }

  ngAfterViewInit(): void {

  }

}
