import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../sevices/authentication.service';
import { Router } from '@angular/router';
import { User } from '../entities/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  roleName: any;
  constructor(private authservice: AuthenticationService, private router: Router, private user: User) { }


  ngOnInit() {
  }

  onlogin(user) {
this.authservice.signIn(user).subscribe((data: User) => {
  this.user = data;
  if (this.user != null) {
    this.roleName = this.user.role;
  }
  switch (this.roleName) {
    case 'ADMIN':
      this.router.navigate(['/user']);
      break;
      case 'LEARNER':
      this.router.navigate(['/home']);
      break;
      case 'ORG':
      this.router.navigate(['/home']);
      break;
      case 'TRAINER':
      this.router.navigate(['/user']);
      break;
    default:
      this.router.navigate(['/home']);
      break;
  }
});

  }
}
