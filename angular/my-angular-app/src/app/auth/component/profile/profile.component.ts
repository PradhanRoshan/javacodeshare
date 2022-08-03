import { Component, OnInit } from '@angular/core';
import { UserEditDto } from '../../model/user.model';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  credentials: string;
  userEditDto: UserEditDto;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
      this.credentials = localStorage.getItem('credentials');
      this.authService.getUserByUsername(this.credentials).subscribe({
        next: (data)=>{ this.userEditDto = data;
        console.log(this.userEditDto);
        },
        error: (e)=>{  }
      });
  }

}
