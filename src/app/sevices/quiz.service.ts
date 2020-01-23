import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private host = 'http://localhost:8082/apiQuiz';
  constructor(private http: HttpClient) { }

 getQuizes() {
    return this.http.get(this.host + '/findAll');
}
saveQuiz(quiz: any) {
  return this.http.post(this.host + '/save', quiz);
}

deleteQuiz(id: number) {
  return this.http.delete(this.host + '/delete/' + id);
}

}
