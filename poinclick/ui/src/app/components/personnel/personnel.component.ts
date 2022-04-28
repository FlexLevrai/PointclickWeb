import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable, of} from "rxjs";
import {AppMessageState, MessageStateEnum} from "../../state/message.state";
import {NotificationService} from "../../../services/notification.service";
import {MatPaginator} from "@angular/material/paginator";
import {catchError, map, startWith} from "rxjs/operators";
import { Personnel } from 'src/models/Personnel.model';
import { PersonnelService } from 'src/services/Personnel.service';


@Component({
  selector: 'app-Personnel',
  templateUrl: './Personnel.component.html',
  styleUrls: ['./Personnel.component.css']
})
export class PersonnelComponent implements OnInit {

  personnel$:Observable<AppMessageState<Personnel[]>>| null = null ;
  readonly  DataStateEnum = MessageStateEnum;
  page:number = 1;
  personnel:Personnel = new Personnel();

  constructor( public  personnelService : PersonnelService, public notificationService : NotificationService) { }

  amodifier: number = 0;

  ngOnInit(): void {
    this.OnGetAllPersonnel();
  }

  OnGetAllPersonnel()
  {
    this.personnel$ = this.personnelService.getAllPersonnel('/api/personnel/list').pipe(
      map(data=>({dataState:MessageStateEnum.LOADED,datase:data,dataLength:data.length})),
      startWith({dataState:MessageStateEnum.LOADING}),
      catchError(err=>of({dataState:MessageStateEnum.ERROR,errorMessage:err.message})),
    );
    this.OnVide();
  }

  OnSavePersonnel()
  {
    this.personnelService.savePersonnel('/api/personnel/save', this.personnel)
      .subscribe(data => {
        this.OnGetAllPersonnel();
        this.notificationService.successNotification ('Enregitrement du Personnel ' +this.personnel.nom + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnUpdatePersonnel()
  {
    this.personnelService.updatePersonnel('/api/personnel/save', this.personnel)
      .subscribe(data => {
        this.OnGetAllPersonnel();
        this.notificationService.successNotification ('Modification du Personnel ' +this.personnel.nom + ' éffectué avec succes');
        console.log(data);
      }, error => {
        console.log(error);
        this.notificationService.errorNotification ('Une erreur liée au serveur c\'est produite !!!!');
      });
  }

  OnEditPersonnel(id: number)
  {
    this.personnelService.editePersonnel('/api/personnel/edit/' + id)
      .subscribe(data => {
        // @ts-ignore
        this.personnel = data;
        this.amodifier = 1;
      }, error => {
        console.log(error);
      });
  }

  OnDeletePersonnel(id: number)
  {
    this.notificationService.onpenConfirmDialog('Etes-vous sure de vouloir supprimer cet enrégistrement ... ?')
      .afterClosed().subscribe(res => {
      if (res)
      {
        this.personnelService.deletePersonnel('/api/personnel/delete/' + id)
          .subscribe(data => {
            this.OnGetAllPersonnel();
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

/*   OnActivatePersonnel(id: number)
  {
    this.PersonnelService.activePersonnel('/api/Personnel/active/' + id)
      .subscribe(data => {
        this.notificationService.infoNotification('Vous vennez d\'active ce Personnel ');
        this.OnGetAllPersonnel();
      }, error => {
        console.log(error);
        this.notificationService.warningNotification('Une erreur c\'est produite lors de l\'activation');
      });
  } */

  OnVide()
  {
    this.personnelService.personnelFormGroup.reset();
    this.personnel.id = null ;
    this.personnelService.initializeFormGroup();
    this.amodifier = 0;
  }

}
