import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { AlertComponent } from 'src/app/components/shared/alert/alert.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // Giving access to alert component's methods from here
  @ViewChild(AlertComponent) alertComponent! : AlertComponent;

  //this variable gets filled by the user input in the login html
  public input:String="" 

  //User object
  public user:User = new User()

  //Injecting the user.service in order to access its functions/variables
  constructor(private us:UserService, private router: Router) { }

  //This is the login function
  login(){

    this.us.loginUser(this.user).subscribe(
      data => {
      this.user = data as User
      this.us.user = data
      console.log(this.user)
      console.log(this.us.user)

      localStorage.setItem('currentUser', JSON.stringify(this.user));

    //localStorage.removeItem('currentUser');
      console.log(this.us.user.userUsername); //just trying to see what that gives! It prints in console of web

      //redirecting the page according to roleId{ userRoleId: 1, userRoleName: "customer" }
      if(this.us.user.userRoleId?.userRoleId == 1){
        this.router.navigate(['/mood']);

      }else if(this.us.user.userRoleId?.userRoleId == 2){
        this.router.navigate(['/driver/orders'])

      }else if(this.us.user.userRoleId?.userRoleId == 3){
        this.router.navigate(['/restaurant/orders'])

      }
    },
    error => {
      this.alertComponent.displayAlert("Incorrect username/password. Please check your credentials and try again.", "danger");
    }
    
    );    


  }
  ngOnInit(): void {
    // Logging any existing user out when visiting login page
    localStorage.removeItem('currentUser');
  }

}
