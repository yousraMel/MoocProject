import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-app-header',
  templateUrl: './app-header.component.html',
  styleUrls: ['./app-header.component.css']
})
export class AppHeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onHome() {
    this.router.navigateByUrl('/home');
  }

  onQuizesButton() {
    this.router.navigateByUrl('/quizes');
  }

  onAddQuizesButton() {
    this.router.navigateByUrl('/new-quiz');
  }

}
