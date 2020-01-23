import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {
  private host = 'http://localhost:8082/apiAnswer';
  constructor(private http: HttpClient) { }

  getAnswersByQuestion(idQuestion) {
    return this.http.get(this.host + '/findByQuestion/' + idQuestion);
}

saveAnswer(answer: any, idQuestion) {
  return this.http.post(this.host + '/save/' + idQuestion, answer);
}

deleteAnswer(id: number) {
  return this.http.delete(this.host + '/delete/' + id);
}
}
