import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Storage } from '@ionic/storage-angular';


@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  token: any;
  results: any;
  isVisible: boolean = true;

  constructor(private http: HttpClient, private storage: Storage, private navCtrl: NavController, private router: Router ) {

  }

  ngOnInit(){

    this.storage.get('jwtt-token').then((data) => {
      this.token = data
      this.get_categorias()
    })

  }

  get_categorias(){

    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.token}`,
      'ngrok-skip-browser-warning': '6024'
    })

    this.http.get('https://c782-2804-14d-1c85-9052-7d5a-b48d-606b-6978.ngrok-free.app/api/v1/icust/oferta-servico/tipo', {'headers': header}).subscribe(response => {
      console.log(response)
      this.isVisible = false
      this.results = response
      
    })

  }

  goToSeach(id){

    this.router.navigate(
      ['/members/search-result'],
      { queryParams: { 'tipo': id } }
    );

  }

}
