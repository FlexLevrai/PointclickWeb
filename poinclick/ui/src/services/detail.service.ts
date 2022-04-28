import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AnneeModel} from "../models/annee.model";
import {RestControllerService} from "./restController.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";
import { DetailJourneeModel } from "src/models/detail.model";

@Injectable({providedIn:"root"})
export class DetailService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  detailFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    journee: new FormControl('', [Validators.required ]),
    heureArrive: new FormControl('', [Validators.required ]),
    heureDebutPause: new FormControl('', [Validators.required ]),
    heureFinPause: new FormControl('', [Validators.required ]),
    heureDepart: new FormControl('', [Validators.required ]) 
  });

  public getAllDetail(url):Observable<DetailJourneeModel[]>
  {
    return this.http.get<DetailJourneeModel[]>( this.host + url  );
  }

  public saveDetail( url, detail: DetailJourneeModel)
  {
    return this.http.post(this.host + url, detail).pipe(map(data => {})) ;
  }

  updateDetail(url,detail: DetailJourneeModel) {
    return this.http.post(this.host + url,detail).pipe(map(data => {})) ;
  }
  public editeDetail(url)
  {
    return this.http.get(this.host + url);
  }

  public deleteDetail(url)
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
    this.detailFormGroup.setValue({
        id:null,
        journee: '',
        heureArrive:'',
        heureDebutPause: '',
        heureFinPause: '',
        heureDepart:''
    });
  }

}
