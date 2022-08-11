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
  
  constructor(
    private us:UserService,
    private router: Router
    ) { }

  ngOnInit(): void {}

  //
  createUser(){
    this.us.createUser(this.user, this.input).subscribe();
    console.log(this.user);
    console.log(this.user.userUsername);
    console.log(this.user.userPassword);
    // the easy thing to do is on successful login
    // simply transport the user to the login page
    this.router.navigate(['/login']);
    
    
    // psuedo code and thoughts
    /* What could happen once the user logs in is automatically storing their values into a session
    localStorage.setItem('currentUser', JSON.stringify(user));
    However I would want to log the user with their credentials before storing anything in the session.
    
    potential logout function() would work by clearing the localStorage of the currentUser
    logout() {
      localStorage.removeItem('currentUser');
    }
    
    */
  }

}