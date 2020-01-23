import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
private host = 'http://localhost:8082/apiQuestion';

  constructor(private http: HttpClient) { }

  getQuestionsByQuiz(idQuiz) {
    return this.http.get(this.host + '/findByQuiz/' + idQuiz);
}

saveQuestion(question: any, idQuiz) {
  return this.http.post(this.host + '/save/' + idQuiz, question);
}

deleteQuestion(id: number) {
  return this.http.delete(this.host + '/delete/' + id);
}
}
