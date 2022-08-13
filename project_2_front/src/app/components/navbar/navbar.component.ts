import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  // User Info
  public user: User = JSON.parse(localStorage.getItem('currentUser') || '{}');
  public userRoleId: number = 0;
  public userFirstName: string = '';

  // Home Page for user
  public homePage: string = '';

  constructor() {}

  ngOnInit(): void {}

  ngDoCheck(): void {
    this.user = JSON.parse(localStorage.getItem('currentUser') || '{}');

    this.userRoleId = this.user.userRoleId?.userRoleId!;
    this.userFirstName = this.user.userFirstName!;

    this.setUserHomePage();
  }

  setUserHomePage() {
    // Setting home page depending on userRoleId
    if (this.userRoleId == 1) {
      this.homePage = '/mood';
    } else if (this.userRoleId == 2) {
      this.homePage = '/driver/orders';
    } else if (this.userRoleId == 3) {
      this.homePage = '/restaurant/orders';
    } else {
      this.homePage = '/asdafasfs';
    }
  }

  logoutPressed() {
    localStorage.removeItem('currentUser');
    this.userRoleId = 0;
  }
}
