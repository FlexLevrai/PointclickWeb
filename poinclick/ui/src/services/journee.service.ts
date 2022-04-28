import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RestControllerService} from "./restController.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";
import { Journee } from "src/models/journee.model";

@Injectable({providedIn:"root"})
export class JourneeService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  JourneeFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    libelle: new FormControl('', [Validators.required, Validators.minLength(4)])
  });

  public getAllJournee(url):Observable<Journee[]>
  {
    return this.http.get<Journee[]>( this.host + url  );
  }

  public saveJournee( url, jour: Journee)
  {
    return this.http.post(this.host + url, jour).pipe(map(data => {})) ;
  }

  public updateJournee(url, jour: Journee)
  {
    return this.http.post(this.host + url, jour).pipe(map(data => {})) ;
  }
  public editeJournee(url)
  {
    return this.http.get(this.host + url);
  }

  public getJourneeTue(url)
  {
    return this.http.get(this.host + url);
  }

  public deleteJournee(url)
  {
    return this.http.delete(this.host + url);
  }

  public activeJournee(url)
  {
    return this.http.get(this.host + url);
  }

  initializeFormGroup()
  {
    this.JourneeFormGroup.setValue({
        id:null,
        libelle:''
    });
  }

}
