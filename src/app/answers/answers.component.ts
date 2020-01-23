import { AnswerService } from './../sevices/answer.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-answers',
  templateUrl: './answers.component.html',
  styleUrls: ['./answers.component.css']
})
export class AnswersComponent implements OnInit {
  answers: any[] = [];
  answer: any;
  idQuestion: number;
  idAnswer: number;
  constructor(private answerservice: AnswerService, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.rout.params
      .subscribe(
        (params: Params) => {
          this.idQuestion = +params.idQuestion;
        }
      );
    this.answerservice.getAnswersByQuestion(this.idQuestion).subscribe((data: any[]) => {
        console.log(data);
        this.answers = data;
      });
  }
  onNewAnswer(idQuestion) {
    this.router.navigate(['/new-question/', idQuestion]);
  }

  onDeleteAnswer(idAnswer, index) {
        this.answerservice.deleteAnswer(idAnswer).subscribe(response => { this.answers.splice(index, 1); }
        );
      }
    }
