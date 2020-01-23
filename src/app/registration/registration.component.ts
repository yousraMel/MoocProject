import { Router, ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../sevices/authentication.service';
import { FormBuilder, FormControlName, FormControl } from '@angular/forms';
import { User } from '../entities/user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  defaultRole: any;
  authform = this.fb.group({
    email: [''],
    password: [''],
    passwordConfirm: [''],
  });
  constructor(private fb: FormBuilder, private authservice: AuthenticationService,
              private router: Router, private user: User, private aroute: ActivatedRoute) {}


  ngOnInit() {
    this.aroute.params
      .subscribe(
        (params: Params) => {
          this.defaultRole = params.defaultRole;
          console.log(this.defaultRole);
        }
      );
  }

  onRegistartion() {
    if (this.authform.value.password !== this.authform.value.passwordConfirm) {
      this.authform.reset();
      this.router.navigate(['/registration/', this.defaultRole]);
    } else { this.user.email = this.authform.value.email;
             this.user.password = this.authform.value.password;
             this.user.passwordConfirm = this.authform.value.passwordConfirm;
             this.user.role = this.defaultRole;
             this.authservice.registration(this.user).subscribe((data: User) => {
        this.user = data;
        this.router.navigate(['/login']);
      }); }


  }

}
