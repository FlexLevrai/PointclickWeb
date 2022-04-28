import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AnneeModel} from "../models/annee.model";
import {RestControllerService} from "./restController.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";

@Injectable({providedIn:"root"})
export class AnneeService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  anneFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    libelle: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(4) ])
  });

  public getAllAnnee(url):Observable<AnneeModel[]>
  {
    return this.http.get<AnneeModel[]>( this.host + url  );
  }

  public saveAnnee( url, annee: AnneeModel)
  {
    return this.http.post(this.host + url, annee).pipe(map(data => {})) ;
  }

  updateAnnee(url, annee: AnneeModel) {
    return this.http.post(this.host + url, annee).pipe(map(data => {})) ;
  }
  public editeAnnee(url)
  {
    return this.http.get(this.host + url);
  }

  public deleteAnnee(url)
  {
    return this.http.delete(this.host + url);
  }

  public activeAnnee(url)
  {
    return this.http.get(this.host + url);
  }

  public getAnneeTue(url)
  {
    return this.http.get(this.host + url);
  }

  initializeFormGroup()
  {
    this.anneFormGroup.setValue({
        id:null,
        libelle:''
    });
  }

}
