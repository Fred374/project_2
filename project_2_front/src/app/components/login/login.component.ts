import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //this variable gets filled by the user input in the login html
  public input:String="" 

  //User object
  public user:User = new User()

  //Injecting the user.service in order to access its functions/variables
  constructor(private us:UserService) { }

  //This is the login function
  login(){

    this.us.loginUser(this.user).subscribe(data => {
      this.user = data as User
      this.us.user = data
      console.log(this.user)
      console.log(this.us.user)

      //redirecting the page according to roleId{ userRoleId: 1, userRoleName: "customer" }
      if(this.us.user.userRoleId?.userRoleId == 1){

      }else if(this.us.user.userRoleId?.userRoleId == 2){

      }else{

      }



    })

    //localStorage.setItem('currentUser', JSON.stringify(user));

    //localStorage.removeItem('currentUser');



    //this.user.userRoleId.


  }
  ngOnInit(): void {
  }

}
