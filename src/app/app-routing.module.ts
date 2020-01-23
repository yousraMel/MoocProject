import { QuizesComponent } from './quizes/quizes.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewQuizComponent } from './new-quiz/new-quiz.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CategoriesComponent } from './categories-list/categories.component';
import { NewCategoryComponent } from './new-category/new-category.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { QuestionsComponent } from './questions/questions.component';
import { NewAnswerComponent } from './new-answer/new-answer.component';
import { AnswersComponent } from './answers/answers.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: 'quizes', component: QuizesComponent },
  { path: 'user', component: UserComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration/:defaultRole', component: RegistrationComponent },
  { path: 'questions/:idQuiz', component: QuestionsComponent },
  { path: 'answers/:idQuestion', component: AnswersComponent },
  { path: 'new-quiz', component: NewQuizComponent },
  { path: 'new-question/:idQuiz', component: NewQuestionComponent },
  { path: 'new-answer/:idQuestion', component: NewAnswerComponent },
  { path: 'new-category', component: NewCategoryComponent },
  { path: 'categories', component: CategoriesComponent },
  {  path: 'home', component: HomeComponent},
  { path: '', redirectTo: '/app.component', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
