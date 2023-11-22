import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Storage } from '@ionic/storage-angular';

@Component({
  selector: 'app-serach-result',
  templateUrl: './serach-result.page.html',
  styleUrls: ['./serach-result.page.scss'],
})
export class SerachResultPage implements OnInit {

  categorry: any;
  token: any;
  results: any;
  id_serach: any;

  isVisible: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient, private storage: Storage,) { 
    route.queryParams.subscribe(({next: (query) => {
      this.results = []
      this.isVisible = true
    }}))
    
  }

  

  ngOnInit() {

    this.route.queryParams
      .subscribe(params => {

        this.id_serach = params

        this.storage.get('jwtt-token').then((data) => {
          this.token = data
          this.get_search_result()
        })
      }
    );
    
  }

  get_search_result(){

    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.token}`,
      'ngrok-skip-browser-warning': '6024'
    })

    console.log(this.id_serach)

    this.http.get(`https://c782-2804-14d-1c85-9052-7d5a-b48d-606b-6978.ngrok-free.app/api/v1/icust/oferta-servico?tipo=${this.id_serach.tipo}`, {'headers': header}).subscribe(response => {
      this.isVisible = false
      this.results = response
      console.log(response)
    })

  }

}
