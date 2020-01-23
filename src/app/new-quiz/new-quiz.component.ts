import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { QuizService } from '../sevices/quiz.service';

@Component({
  selector: 'app-new-quiz',
  templateUrl: './new-quiz.component.html',
  styleUrls: ['./new-quiz.component.css']
})
export class NewQuizComponent implements OnInit {
  quiz: any;
  constructor(private router: Router, private quizservice: QuizService) { }

  ngOnInit() {
  }

  onSaveQuiz(quiz) {

    this.quizservice.saveQuiz(quiz).subscribe(resp => {

      this.quiz = resp;
      this.router.navigate(['/quizes']);

    },
      err => {
        console.log(err);
      });

  }

}
