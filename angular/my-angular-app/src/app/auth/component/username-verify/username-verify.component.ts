import { Component, OnInit } from '@angular/core';
import { UserSecurityDto } from '../../model/user.model';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-username-verify',
  templateUrl: './username-verify.component.html',
  styleUrls: ['./username-verify.component.css']
})
export class UsernameVerifyComponent implements OnInit {

  username: string;
  error_msg:string;
  dto: UserSecurityDto;
  status: boolean;
  answer: string;
  showSecurityBox: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.error_msg='';
    this.status=true;
    this.showSecurityBox = false;
  }

  onSubmit(){
      //call the API and pass username
      this.authService
          .getUserSecurityDetailsByUsername(this.username)
          .subscribe({
            next: (data)=>{
                this.dto = data;
                this.status=false;
                console.log(this.dto);
                this.showSecurityBox=true;
            } ,
            error: (e)=>{
              this.error_msg='Username Invalid';
            }
          });
  }

  onQuestionSubmit(){

  }
}
