import { User } from './entities/user';

import { QuestionService } from './sevices/question.service';
import { CategoryService } from './sevices/category.service';
import { JwtModule } from '@auth0/angular-jwt';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {DataTablesModule} from 'angular-datatables';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewQuizComponent } from './new-quiz/new-quiz.component';
import { QuizesComponent } from './quizes/quizes.component';
import { QuizService } from './sevices/quiz.service';
import { HomeComponent } from './home/home.component';
import { NewCategoryComponent } from './new-category/new-category.component';
import { CategoriesComponent } from './categories-list/categories.component';
import { NewQuestionComponent } from './new-question/new-question.component';
import { NewAnswerComponent } from './new-answer/new-answer.component';
import { QuestionsComponent } from './questions/questions.component';
import { AnswersComponent } from './answers/answers.component';
import { AuthenticationService } from './sevices/authentication.service';
import { RegistrationComponent } from './registration/registration.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { AppHeaderComponent } from './app-header/app-header.component';
@NgModule({
  declarations: [
    AppComponent,
    NewQuizComponent,
    QuizesComponent,
    HomeComponent,
    NewCategoryComponent,
    CategoriesComponent,
    NewQuestionComponent,
    NewAnswerComponent,
    QuestionsComponent,
    AnswersComponent,
    RegistrationComponent,
    UserComponent,
    LoginComponent,
    AppHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    JwtModule,
    ReactiveFormsModule,
    DataTablesModule
  ],
  providers: [QuizService, CategoryService, QuestionService, AuthenticationService, User],
  bootstrap: [AppComponent]
})
export class AppModule { }
