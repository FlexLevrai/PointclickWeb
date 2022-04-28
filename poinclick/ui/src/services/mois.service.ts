import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RestControllerService} from "./restController.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";
import {MoisModel} from "../models/mois.model";

@Injectable({providedIn:"root"})
export class MoisService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  moisFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    libelle: new FormControl('', [Validators.required] )
  });

  public getAllMois(url):Observable<MoisModel[]>
  {
    return this.http.get<MoisModel[]>( this.host + url  );
  }

  public saveMois( url, mois: MoisModel)
  {
    return this.http.post(this.host + url, mois).pipe(map(data => {})) ;
  }

  public updateMois(url, mois: MoisModel)
  {
    return this.http.post(this.host + url, mois).pipe(map(data => {})) ;
  }
  public editeMois(url)
  {
    return this.http.get(this.host + url);
  }

  public getMoisTue(url)
  {
    return this.http.get(this.host + url);
  }

  public deleteMois(url)
  {
    return this.http.delete(this.host + url);
  }

  public activeMois(url)
  {
    return this.http.get(this.host + url);
  }

  initializeFormGroup()
  {
    this.moisFormGroup.setValue({
        id:null,
        libelle:''
    });
  }

}
