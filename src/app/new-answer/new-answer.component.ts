import { AnswerService } from './../sevices/answer.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-new-answer',
  templateUrl: './new-answer.component.html',
  styleUrls: ['./new-answer.component.css']
})
export class NewAnswerComponent implements OnInit {
  answer: any;
  idQuestion: number;
  constructor(private answerservice: AnswerService, private router: Router, private rout: ActivatedRoute) { }
  ngOnInit() {
    this.rout.params
      .subscribe(
        (params: Params) => {
          this.idQuestion = +params.idQuestion;
        }
      );
  }
  onSaveAnswer(answer) {
    this.rout.params
    .subscribe(
      (params: Params) => {
        this.idQuestion = +params.idQuestion;
        this.answerservice.saveAnswer(answer, this.idQuestion).subscribe(resp => {
          this.answer = resp;
          this.router.navigate(['/quizes']);
        },
          err => {
          });
      }
    );
  }
}