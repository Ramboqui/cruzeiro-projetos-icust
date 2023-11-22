import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, LoadingController } from '@ionic/angular';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  nome:      string;
  snome:     string;
  email:     string;
  password:  string;
  passwordc:  string;

  credentials = {
    nome: '',
    sobrenome: '',
    email: '',
    password: '',
  }


  constructor(private router: Router, private alertCtrl: AlertController, private loadCrtl: LoadingController, private auth: AuthenticationService) { }

  ngOnInit() {
  }

  login(){
    this.router.navigateByUrl('/')
  }

  async register(){

    const loading = await this.loadCrtl.create()
    
    loading.present()

    if(this.nome == undefined || this.snome == undefined || this.email == undefined || this.password == undefined || this.passwordc == undefined){
      const alert = await this.alertCtrl.create({
        header: 'Campos incompletos',
        message: 'Preencha todos os campos corretamente',
        buttons: ['OK']
      });

      loading.dismiss()
      alert.present()
    }else{

      if(this.password != this.passwordc){

        const alert = await this.alertCtrl.create({
          header: 'Senhas diferentes',
          message: 'As senhas digitadas não conferem',
          buttons: ['OK']
        });
  
        loading.dismiss()
        alert.present()
  
      }else{
        
        this.credentials.nome      = this.nome
        this.credentials.sobrenome = this.snome
        this.credentials.email     = this.email
        this.credentials.password  = this.password


        this.auth.registerUser(this.credentials).subscribe(async res => {
          if(res){
            const alert = await this.alertCtrl.create({
              header: 'Cadastrado com sucesso!',
              message: 'Usuário cadastrado com sucesso!',
              buttons: ['OK']
            });

            loading.dismiss()
            alert.present()

            this.router.navigateByUrl('/')

          }else{
            const alert = await this.alertCtrl.create({
              header: 'Falha no cadastro!',
              message: 'E-mail já cadastrado!',
              buttons: ['OK']
            });

            loading.dismiss()
            alert.present()

          }
        })

      }
    }

    }

    

}
