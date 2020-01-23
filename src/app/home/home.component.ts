import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = '"In fifteen years we \'ll be teaching programming just like reading and writing... and wondering why we didn\'t di it sooner."';
  constructor(private router: Router) { }

  ngOnInit() {
  }

  onRegister(defaultRole) {
    this.router.navigate(['/registration/', defaultRole]);
    }
  }
