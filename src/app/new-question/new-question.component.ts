import { Router, Params, ActivatedRoute } from '@angular/router';
import { QuestionService } from './../sevices/question.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-new-question',
  templateUrl: './new-question.component.html',
  styleUrls: ['./new-question.component.css']
})
export class NewQuestionComponent implements OnInit {
  [x: string]: any;
  question: any;
  idQuiz: number;
  constructor(private questionservice: QuestionService, private router: Router, private rout: ActivatedRoute) { }
  ngOnInit() {
    this.rout.params
      .subscribe(
        (params: Params) => {
          this.idQuiz = +params.idQuiz;
        }
      );
  }
  onSaveQuestion(question) {
    this.rout.params
    .subscribe(
      (params: Params) => {
        this.idQuiz = +params.idQuiz;
        this.questionservice.saveQuestion(question, this.idQuiz).subscribe(resp => {
          this.question = resp;
          this.router.navigate(['/quizes']);
        },
          err => {
          });
      }
    );
  }
}
