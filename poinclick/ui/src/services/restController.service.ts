import {HttpClient, HttpHeaders} from "@angular/common/http";

export class RestControllerService {


  protected host : String = "http://pointclick.de1.mondomainegratuit.com/";
  // protected host : String ="http://localhost:8081"; 

  protected httpOpions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin':'*'
    })
  };
  constructor( public http: HttpClient ) {}
}
