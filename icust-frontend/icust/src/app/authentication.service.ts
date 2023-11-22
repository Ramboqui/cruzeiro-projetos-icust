import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AlertController, Platform } from '@ionic/angular';
import { Router } from '@angular/router';
import { Storage } from '@ionic/storage-angular';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, catchError, from, map, of, switchMap, take } from 'rxjs';


const helper    = new JwtHelperService()
const TOKEN_KEY = 'jwtt-token'

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public user: Observable<any>;
  private userData = new BehaviorSubject(null);

  constructor(public http: HttpClient, private storage: Storage, private plt: Platform, private router: Router, private alertCtrl: AlertController) { 
    this.storage.create();
    this.loadStorageToken();

  }


  loadStorageToken(){
    let platformObs = from(this.plt.ready())
    
    this.user = platformObs.pipe(
      switchMap(() => {
        return from(this.storage.get(TOKEN_KEY))
      }),
      map(token => {
        console.log('Token', token);
        if(token){
          let decoded = helper.decodeToken(token)
          console.log('Token Decode', decoded)
          this.userData.next(decoded)
          return true
        }else{
          return null
        }
      })
    );
  }

  loginUser(credentials: {email:String, password:String}): Observable<any>{

    return this.http.post('https://c782-2804-14d-1c85-9052-7d5a-b48d-606b-6978.ngrok-free.app/api/v1/auth/cliente-login', credentials).pipe(
      catchError(() => {
        /* return of({'success': true, 'token': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibm9tZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.em2OmSYOORKC3sHPaUWOWswSRVeuSuomgYMnAJa6Jd0'}) */
        return of({'success': false})
      }),
      take(1),
      map(res => {
        /* return {'success': true, 'token': 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibm9tZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.em2OmSYOORKC3sHPaUWOWswSRVeuSuomgYMnAJa6Jd0'} */
        return res
      }),
      switchMap(response => {
        console.log(response)
        if(response['success']){
          let decoded = helper.decodeToken(response['token'])
          console.log('Login Token Decode', decoded)
          this.userData.next(decoded)
  
          let storageObs = from(this.storage.set(TOKEN_KEY, response['token']))
          return storageObs
        }else{
          return of(null)
        }

       
      })
    )
  }

  registerUser(credentials: {nome: String, sobrenome: String, email:String, password:String }): Observable<any>{
    return this.http.post('https://c782-2804-14d-1c85-9052-7d5a-b48d-606b-6978.ngrok-free.app/api/v1/auth/cliente-register', credentials).pipe(
      catchError(() => {
        return of(false)
      }),
      take(1),
      map(res => {
        return res['success']
        
      }),
      switchMap(resgitered => {
        if(!resgitered){
          return of(false)
        }
        return of(true)
      })
    )
  }

  getUser(){
    return this.userData.getValue()
  }


  logout(){
    this.storage.remove(TOKEN_KEY).then(() => {
      this.router.navigateByUrl('/')
      this.userData.next(null)
    })
  }

  async getProfile(token:String){
    return ''
  }

  


}
