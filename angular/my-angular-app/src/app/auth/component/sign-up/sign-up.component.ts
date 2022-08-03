import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserDto } from '../../model/user.model';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup;
  userDto: UserDto;

  constructor() { }
  ngOnInit(): void {
    this.signUpForm = new FormGroup({
      name: new FormControl(''),
      username: new FormControl(''),
      password: new FormControl(''),
      role: new FormControl(''),
      securityQuestion: new FormControl(''),
      securityAnswer: new FormControl('')
    });
  }
  onFormSubmit(){

      this.userDto={
        name: this.signUpForm.value.name,
        role: this.signUpForm.value.role,
        securityAnswer: this.signUpForm.value.securityAnswer,
        securityQuestion: this.signUpForm.value.securityQuestion,
        encodedCredentials: btoa(this.signUpForm.value.username
          + '+=+' + this.signUpForm.value.password)
      }
      //aGFycnkrPStwb3R0ZXI=
      console.log(this.userDto);


  }
}
