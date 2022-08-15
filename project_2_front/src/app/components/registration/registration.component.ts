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
  
  //
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

  ngOnInit(): void {
    localStorage.removeItem('currentUser');
  }

  //
  createUser(){
    this.us.createUser(this.user, this.input).subscribe(data => {
      console.log(data);
      this.isSuccessful = true;
      this.isSignUpFailed = false;

      console.log(JSON.stringify(data));
      console.log(data.userRoleId?.userRoleId);
      console.log(JSON.stringify(data.userRoleId?.userRoleId));
      localStorage.setItem('currentUserId', JSON.stringify(data.userId));
      localStorage.setItem('currentUserRoleId', JSON.stringify(data.userRoleId?.userRoleId));
  
      // conditional routing
      if(data.userRoleId?.userRoleId == 1) {
      // if user is a customer send them to choose Restaurant
        this.router.navigate(['/mood']);
    
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
    // the easy thing to do is on successful login
    // simply transport the user to the login page
    // localStorage.setItem('currentUserId', JSON.stringify(this.user.userId));
    // let currentUserRoleId = localStorage.getItem('currentUserRoleId');
    // let currentUserId = localStorage.getItem('currentUserId');

    
    // 
    // localStorage.getItem('currentUser');
    
    
    // psuedo code and thoughts
    /* What could happen once the user logs in is automatically storing their values into a session
    
    However I would want to log the user with their credentials before storing anything in the session.
    
    potential logout function() would work by clearing the localStorage of the currentUser
    logout() {
      localStorage.removeItem('currentUser');
    }
    
    */
  }

}