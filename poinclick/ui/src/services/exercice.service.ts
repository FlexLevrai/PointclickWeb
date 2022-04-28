import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RestControllerService} from "./restController.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";
import { ExerciceJournalierModel } from "src/models/exercice.model";

@Injectable({providedIn:"root"})
export class ExerciceJournalierService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  exerciceFormGroup: FormGroup = new FormGroup({
    id: new FormControl(null),
    libelle: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(4) ])
  });

  public getAllExerciceJournalier(url):Observable<ExerciceJournalierModel[]>
  {
    return this.http.get<ExerciceJournalierModel[]>( this.host + url  );
  }

  public saveExerciceJournalier( url, ExerciceJournalier: ExerciceJournalierModel)
  {
    return this.http.post(this.host + url, ExerciceJournalier).pipe(map(data => {})) ;
  }

  updateExerciceJournalier(url, ExerciceJournalier: ExerciceJournalierModel) {
    return this.http.post(this.host + url, ExerciceJournalier).pipe(map(data => {})) ;
  }
  public editeExerciceJournalier(url)
  {
    return this.http.get(this.host + url);
  }

  public deleteExerciceJournalier(url)
  {
    return this.http.delete(this.host + url);
  }

  public activeExerciceJournalier(url)
  {
    return this.http.get(this.host + url);
  }

  public getExerciceJournalierTue(url)
  {
    return this.http.get(this.host + url);
  }

  initializeFormGroup()
  {
    this.exerciceFormGroup.setValue({
        id:null,
        libelle:''
    });
  }

}
