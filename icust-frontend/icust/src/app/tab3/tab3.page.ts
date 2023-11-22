import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Storage } from '@ionic/storage-angular';
import { catchError, map, of, switchMap, take } from 'rxjs';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  token: String;
  results: any;
  isVisible: boolean = true;

  constructor(private http: HttpClient, private auth: AuthenticationService, private storage: Storage) {}

  ngOnInit(){
    this.storage.get('jwtt-token').then((data) => {
      this.token = data
      this.get_pedidos()
    })
    
  }



  get_pedidos(){

    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.token}`,
      'ngrok-skip-browser-warning': '6024'
    })

    this.http.get('https://c782-2804-14d-1c85-9052-7d5a-b48d-606b-6978.ngrok-free.app/api/v1/icust/order', {'headers': header}).subscribe(response => {
      this.results = response
      this.isVisible = false
    })

  }
  
}

