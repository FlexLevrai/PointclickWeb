import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable, of} from "rxjs";
import {AppMessageState, MessageStateEnum} from "../../state/message.state";
import {NotificationService} from "../../../services/notification.service";
import {MatPaginator} from "@angular/material/paginator";
import {catchError, map, startWith} from "rxjs/operators";
import { Journee } from 'src/models/journee.model';
import { JourneeService } from 'src/services/journee.service';


@Component({
  selector: 'app-journee',
  templateUrl: './journee.component.html',
  styleUrls: ['./journee.component.css']
})
export class JourneeComponent implements OnInit {

  journee$:Observable<AppMessageState<Journee[]>>| null = null ;
  readonly  DataStateEnum = MessageStateEnum;
  page:number = 1;
  journee:Journee = new Journee();

  constructor( public  journeeService : JourneeService, public notificationService : NotificationService) { }

  amodifier: number = 0;

  ngOnInit(): void {
    this.OnGetAlljournee();
  }

  OnGetAlljournee()
  {
    this.journee$ = this.journeeService.getAllJournee('/api/journee/list').pipe(
      map(data=>({dataState:MessageStateEnum.LOADED,datase:data,dataLength:data.length})),
      startWith({dataState:MessageStateEnum.LOADING}),
      catchError(err=>of({dataState:MessageStateEnum.ERROR,errorMessage:err.message})),
    );
    this.OnVide();
  }

  OnSavejournee()
  {
    this.journeeService.saveJournee('/api/journee/save', this.journee)
      .subscribe(data => {
        this.OnGetAlljournee();
        this.notificationService.successNotification ('Enregitrement du journee ' +this.journee.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnUpdatejournee()
  {
    this.journeeService.updateJournee('/api/journee/save', this.journee)
      .subscribe(data => {
        this.OnGetAlljournee();
        this.notificationService.successNotification ('Modification du journee ' +this.journee.libelle + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnEditjournee(id: number)
  {
    this.journeeService.editeJournee('/api/journee/edit/' + id)
      .subscribe(data => {
        // @ts-ignore
        this.journee = data;
        this.amodifier = 1;
      }, error => {
        console.log(error);
      });
  }

  OnDeletejournee(id: number)
  {
    this.notificationService.onpenConfirmDialog('Etes-vous sure de vouloir supprimer cet enrégistrement ... ?')
      .afterClosed().subscribe(res => {
      if (res)
      {
        this.journeeService.deleteJournee('/api/journee/delete/' + id)
          .subscribe(data => {
            this.OnGetAlljournee();
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

  OnActivatejournee(id: number)
  {
    this.journeeService.activeJournee('/api/journee/active/' + id)
      .subscribe(data => {
        this.notificationService.infoNotification('Vous vennez d\'active ce journee ');
        this.OnGetAlljournee();
      }, error => {
        console.log(error);
        this.notificationService.warningNotification('Une erreur c\'est produite lors de l\'activation');
      });
  } 

  OnVide()
  {
    this.journeeService.JourneeFormGroup.reset();
    this.journee.id = null ;
    this.journeeService.initializeFormGroup();
    this.amodifier = 0;
  }

}
