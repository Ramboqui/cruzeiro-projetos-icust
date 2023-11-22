import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { AlertController, LoadingController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  email: string;
  password: string;

  credentials = {
    email: '',
    password: ''
  }
  


  constructor(public auth: AuthenticationService, public loadingCrtl: LoadingController, private router: Router, private alertCtrl: AlertController) { }

  ngOnInit() {
  }

  async login(){

    
    this.credentials.email = this.email
    this.credentials.password = this.password

    console.log(this.credentials)

    const loading = await this.loadingCrtl.create()
    await loading.present()

    this.auth.loginUser(this.credentials).subscribe(async res => {
      if(res) {
        this.router.navigateByUrl('/members')
        await loading.dismiss()
      }else{
        const alert = await this.alertCtrl.create({
          header: 'Falha no login',
          message: 'Credenciais Inválidas',
          buttons: ['OK']
        });
        await loading.dismiss()
        await alert.present()
      }
    })

  }

  register(){
    this.router.navigateByUrl('/register')
  }

}
