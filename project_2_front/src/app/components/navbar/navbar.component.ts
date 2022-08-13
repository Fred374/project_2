import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public user: User = JSON.parse(localStorage.getItem("currentUser") || "{}");
  public userRoleId: number = 0;
  public userFirstName: string = ""

  constructor() { }

  ngOnInit(): void {

  }

  ngDoCheck(): void {
    this.user = JSON.parse(localStorage.getItem("currentUser") || "{}");

    this.userRoleId = this.user.userRoleId?.userRoleId!;
    this.userFirstName = this.user.userFirstName!;
  }

  logoutPressed() {
    localStorage.removeItem('currentUser');
    this.userRoleId = 0;
  }

}
