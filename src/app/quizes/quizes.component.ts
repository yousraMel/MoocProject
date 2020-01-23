import { QuizService } from './../sevices/quiz.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quizes',
  templateUrl: './quizes.component.html',
  styleUrls: ['./quizes.component.css']
})
export class QuizesComponent implements OnInit {
  quizes: any[] = [];
  idQuiz: number;
  constructor(private router: Router, private quizservice: QuizService, private route: ActivatedRoute) { }


  ngOnInit() {
    this.quizservice.getQuizes().subscribe((data: any[]) => {
      console.log(data);
      this.quizes = data;
    });

    this.route.params
    .subscribe(
      (params: Params) => {
        this.idQuiz = +params.idQuiz;
      });
  }
  onNewQuiz() {

this.router.navigateByUrl('/new-quiz');
  }

  onDeleteQuiz(idQuiz, index) {
        this.quizservice.deleteQuiz(idQuiz).subscribe(response => { this.quizes.splice(index, 1); }
        );
      }
      onCompleteQuiz(idQuiz) {
    this.router.navigate(['/new-question/', idQuiz]);
  }

  onQuestionsByQuiz(idQuiz) {
    this.router.navigate(['/questions/', idQuiz]);
  }
  }
