import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.page.html',
  styleUrls: ['./profile.page.scss'],
})
export class ProfilePage implements OnInit {

  user = null

  constructor(private auth: AuthenticationService, private router: Router) { 
    this.user = this.auth.getUser()

  }

  account(){
    this.router.navigateByUrl('/account')
  }

  logout() {
    this.auth.logout()
  }

  ngOnInit() {
    
  }

}
