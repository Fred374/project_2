import { Component, OnInit } from '@angular/core';
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
  
  constructor(private us:UserService) { }

  ngOnInit(): void {}

  //
  createUser(){
    console.log(this.user);
    this.us.createUser(this.user, this.input).subscribe();
  }

}