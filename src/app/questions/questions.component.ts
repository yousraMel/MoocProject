import { QuestionService } from './../sevices/question.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  questions: any[] = [];
  question: any;
  idQuiz: number;
  idQuestion: number;
  constructor(private questionservice: QuestionService, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.rout.params
      .subscribe(
        (params: Params) => {
          this.idQuiz = +params.idQuiz;
        }
      );
    this.questionservice.getQuestionsByQuiz(this.idQuiz).subscribe((data: any[]) => {
        console.log(data);
        this.questions = data;
      });
  }
  onNewQuestion(idQuiz) {
    this.router.navigate(['/new-question/', idQuiz]);
  }

  onDeleteQuestion(idQuestion, index) {
        this.questionservice.deleteQuestion(idQuestion).subscribe(response => { this.questions.splice(index, 1); }
        );
      }
      onCompleteQuestion(idQuestion) {
    this.router.navigate(['/new-answer/' + idQuestion]);
  }
  onAnswersByQuestion(idQuestion) {
    this.router.navigate(['/answers/', idQuestion]);
  }
  }
