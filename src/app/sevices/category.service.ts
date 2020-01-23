import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private host = 'http://localhost:8082/apiCategory';
  constructor(private http: HttpClient) { }

  getCategoriestList(): Observable<any> {
    return this.http.get(this.host + '/getAll');
  }

  createCategory(category: any) {
    return this.http.post(this.host + '/savecategory', category);
  }

  deleteCategory(id: number): Observable<any> {
    return this.http.delete(`${this.host}/delete/${id}`, { responseType: 'text' });
  }

  getCategory(id: number): Observable<object> {
    return this.http.get(`${this.host}/get/${id}`);
  }

  updateCategory(id: number, value: any): Observable<object> {
    return this.http.post(`${this.host}/update/${id}`, value);
  }


}
