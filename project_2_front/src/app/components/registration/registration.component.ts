import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  // user input for roleId
  public input: number = 0;

  user: User = new User();

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  
  constructor(
    private us:UserService,
    private router: Router
    ) { }

  ngOnInit(): void {}

  //
  createUser(){
    this.us.createUser(this.user, this.input).subscribe(data => {
      console.log(data);
      this.isSuccessful = true;
      this.isSignUpFailed = false;

      // tests
      //console.log(JSON.stringify(data));
      //console.log(data.userRoleId?.userRoleId);
      //console.log(JSON.stringify(data.userRoleId?.userRoleId));
      //localStorage.setItem('currentUser', JSON.stringify(data));
      //localStorage.setItem('currentUserRoleId', JSON.stringify(data.userRoleId?.userRoleId));

      // The following code sets the 
      var user_id = data.userId;
      localStorage.setItem("user_id", JSON.stringify(user_id));

      var user_FN = data.userFirstName;
      localStorage.setItem("user_FN", JSON.stringify(user_FN));

      var user_LN = data.userLastName;
      localStorage.setItem("user_LN", JSON.stringify(user_LN));

      var user_RoleId = data.userRoleId?.userRoleId;
      localStorage.setItem("user_RoleId", JSON.stringify(user_RoleId));

      /* If the creds are desired in the implementation of your methods
      Below is an example of how you would collect the creds from the browser storage in your component file
    
      export class AhmadtestComponent implements OnInit {

        public U_Id = localStorage.getItem('user_id');

        public U_FN = localStorage.getItem('user_FN');

        public U_LN = localStorage.getItem('user_LN');

        public U_Role_ID = localStorage.getItem('user_RoleId');
  */
      // conditional routing based on User inputs
      if(data.userRoleId?.userRoleId == 1) {
      // if user is a customer send them to choose Restaurant
        this.router.navigate(['/chooseRestaurant']);
    
      } else if (data.userRoleId?.userRoleId == 2) {
        // if user is a driver send them to ... not sure yet
        // I think the orders table
        this.router.navigate(['/driver/orders']);

      } else {
        // send the restaurant to view their orders 
        this.router.navigate(['/restaurant/orders']); 
    }
    },
    err => {
      this.errorMessage = "Pleasee enter any missed values and try again";
      this.isSignUpFailed = true;
    }
    );

     /*
    -------------------------- logout function if desired
    logout() {
      localStorage.removeItem('currentUser');
    }
    
    */
  }

}