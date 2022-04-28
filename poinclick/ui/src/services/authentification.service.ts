import {Injectable} from "@angular/core";
import {RestControllerService} from "./restController.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({providedIn:"root"})
export class AuthentificationService extends RestControllerService{

  constructor(public http:HttpClient) { super(http); }

  private jwtToken = null;
  public isLongin = false;

  loadToken(){
    this.jwtToken = localStorage.getItem('token');
  }

  public seLoger(user)
  {
    return this.http.post(this.host+"/login",user,{observe:'response'});
  }

  public saveToken(jwt:string){
    localStorage.setItem('token',jwt);
  }

  public getAlwd(url)
  {
    if (this.jwtToken == null) this.loadToken();
    return this.http.get( this.host + "/api/security/liste/users" ,{headers:new HttpHeaders({'Authorization':this.jwtToken})} );
  }
  public connexion (){
    this.isLongin = true;
  }
}
