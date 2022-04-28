import {Component, OnInit} from '@angular/core';
import {AuthentificationService} from "../../../services/authentification.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor( private authentificationService: AuthentificationService,
               private router: Router) { }

               err = 0;

  ngOnInit(): void {
  }

  onLogin(user): void {
    this.authentificationService.seLoger(user).subscribe(resp => {
      const jwt = resp.headers.get('Authorization');
      this.authentificationService.saveToken(jwt);
      this.router.navigateByUrl('dashboard').then(() => window.location.reload());
      console.log('valide');
    },(err) => {
      this.err = 1;
    });
  }
}
