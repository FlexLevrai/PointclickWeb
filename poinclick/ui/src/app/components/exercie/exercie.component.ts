import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, startWith } from 'rxjs/operators';
import { AppMessageState, MessageStateEnum } from 'src/app/state/message.state';
import { ExerciceJournalierModel } from 'src/models/exercice.model';
import { ExerciceJournalierService } from 'src/services/exercice.service';
import { JourneeService } from 'src/services/journee.service';
import { NotificationService } from 'src/services/notification.service';
import { PersonnelService } from 'src/services/Personnel.service';

@Component({
  selector: 'app-exercie',
  templateUrl: './exercie.component.html',
  styleUrls: ['./exercie.component.css']
})
export class ExercieComponent implements OnInit {

  exercice$:Observable<AppMessageState<ExerciceJournalierModel[]>>| null = null ;
  readonly  DataStateEnum = MessageStateEnum;
  page:number = 1;
  exercice:ExerciceJournalierModel = new ExerciceJournalierModel();

  constructor( public  exercieService : ExerciceJournalierService, public peronnelService : PersonnelService,
    public journeeService: JourneeService, public notificationService : NotificationService) { }

  amodifier: number = 0;
  listPersonnel;
  listJournee;

  ngOnInit(): void {
    this.OnGetPernonnel();
    this.OnGetJournee();
  }

  OnGetPernonnel()
  {
    this.peronnelService.getAllPersonnel('/api/personnel/list')
      .subscribe ( data => {
        this.listPersonnel = data;
        console.log(data);
      }, error => {
        console.log (error);
      });
  }

  OnGetJournee()
  {
    this.journeeService.getAllJournee('/api/journee/list')
      .subscribe ( data => {
        this.listJournee = data;
        console.log(data);
      }, error => {
        console.log (error);
      });
  }

  OnGetHeureArriver(id: number)
  {
    this.exercice$ = this.exercieService.getAllExerciceJournalier('/api/detail_journee/list/personnel/'+ id).pipe(
      map(data=>({dataState:MessageStateEnum.LOADED,datase:data,dataLength:data.length})),
      startWith({dataState:MessageStateEnum.LOADING}),
      catchError(err=>of({dataState:MessageStateEnum.ERROR,errorMessage:err.message})),
    );
    this.OnVide();
  }

/*   OnSaveDetailJournee()
  {
    this.detailService.saveDetail('/api/detail_journee/save', this.detail)
      .subscribe(data => {
        this.OnGetAllDetailJournee(this.detail.personnel.id);
        this.notificationService.successNotification ('Enregitrement de l\'affection horaire de ' +this.detail.personnel.nom + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  } */

/*   OnUpdateDetailournee()
  {
    this.detailService.updateDetail('/api/detail_journee/save', this.detail)
      .subscribe(data => {
        this.OnGetAllDetailJournee(this.detail.personnel.id);
        this.notificationService.successNotification ('Modification de l\'affection horaire dee ' +this.detail.personnel.nom  + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnEditDetailJournee(id: number)
  {
    this.detailService.editeDetail('/api/detail_journee/edit/' + id)
      .subscribe(data => {
        // @ts-ignore
        this.detail = data;
        this.amodifier = 1;
      }, error => {
        console.log(error);
      });
  } */

  // OnDeleteDetailJournee(id: number)
  // {
  //   this.notificationService.onpenConfirmDialog('Etes-vous sure de vouloir supprimer cet enrégistrement ... ?')
  //     .afterClosed().subscribe(res => {
  //     if (res)
  //     {
  //       this.detailService.deleteDetail('/api/detail_journee/delete/' + id)
  //         .subscribe(data => {
  //           this.OnGetAllDetailJournee(this.detail.personnel.id);
  //           this.notificationService.infoNotification('Enrégistrement supprimer avec success !!!!');
  //         }, error => {
  //           console.log(error);
  //           this.notificationService.warningNotification('Impossible de Supprimer, Erreur liée au seveur');
  //         });
  //     }
  //     else
  //     {
  //       this.notificationService.infoNotification('Opération de suppression annulée !');
  //     }
  //   });
  // }

/*   OnActivatejournee(id: number)
  {
    this.journeeService.activejournee('/api/journee/active/' + id)
      .subscribe(data => {
        this.notificationService.infoNotification('Vous vennez d\'active ce journee ');
        this.OnGetAlljournee();
      }, error => {
        console.log(error);
        this.notificationService.warningNotification('Une erreur c\'est produite lors de l\'activation');
      });
  } */

  OnVide()
  {
    this.exercieService.exerciceFormGroup.reset();
    this.exercice.id = null ;
    this.exercieService.initializeFormGroup();
    this.amodifier = 0;
  }
}
