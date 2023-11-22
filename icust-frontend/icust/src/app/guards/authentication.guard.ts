import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable, take, map } from 'rxjs';
import { AuthenticationService } from '../authentication.service';
import { AlertController, Platform } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {

  constructor(private auth: AuthenticationService, private router: Router, private alertCtrl: AlertController, private plt: Platform){}

  canActivate(route: ActivatedRouteSnapshot): Observable<boolean>{
    return this.auth.user.pipe(
      take(1),
      map(user => {
        console.log('Usuario em ativacao', user);
        if(!user){

          this.alertCtrl.create({
            header: 'Não Autorizado',
            message: 'Você não tem permissão para acessar está área',
            buttons: ['OK']
          }).then(alert => alert.present())
          this.router.navigateByUrl('/');
          return false
        }else{
          return true
        }
      })
    )
  }
  
}
