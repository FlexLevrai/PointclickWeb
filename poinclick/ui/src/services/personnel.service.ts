import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Personnel } from 'src/models/personnel.model';
import { RestControllerService } from './restController.service';

@Injectable({
  providedIn: 'root'
})
export class PersonnelService extends RestControllerService {

  constructor(public http:HttpClient) { super(http); }

  personnelFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    nom: new FormControl('', [Validators.required ]),
    prenom: new FormControl('', [Validators.required ]),
    sexe: new FormControl('', [Validators.required]),
    contact: new FormControl('', [Validators.required]),
    adresse: new FormControl('', [Validators.required ]),
    dateNaissance: new FormControl('', [Validators.required]),
    lieuNaissance: new FormControl('', [Validators.required ])
  });

  public getAllPersonnel(url):Observable<Personnel[]>
  {
    return this.http.get<Personnel[]>( this.host + url  );
  }

  public savePersonnel( url, personnel: Personnel)
  {
    return this.http.post(this.host + url, personnel).pipe(map(data => {})) ;
  }

  updatePersonnel(url, personnel: Personnel) {
    return this.http.post(this.host + url, personnel).pipe(map(data => {})) ;
  }
  public editePersonnel(url)
  {
    return this.http.get(this.host + url);
  }

  public deletePersonnel(url)
  {
    return this.http.delete(this.host + url);
  }

  public activePersonnel(url)
  {
    return this.http.get(this.host + url);
  }

  public getPersonnelTue(url)
  {
    return this.http.get(this.host + url);
  }

  initializeFormGroup()
  {
    this.personnelFormGroup.setValue({
        id:null,
        nom:'',
        prenom:'',
        sexe:'',
        contact:'',
        adresse:'',
        dateNaissance:'',
        lieuNaissance:''
    });
  }
}
