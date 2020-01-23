import { Category } from '../entities/category';
import { CategoryService } from '../sevices/category.service';
import { Component, OnInit } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  constructor(private categoryservice: CategoryService) { }

  categoriesArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  categories: Observable<Category[]>;
  category: Category = new Category();
  deleteMessage = false;
  categorylist: any;
  isupdated = false;

  categoryupdateform = new FormGroup({
    category_id: new FormControl(),
    category_name: new FormControl(),
    category_description: new FormControl(),
    category_icon: new FormControl()
  });


  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [[6, 16, 20, -1], [6, 16, 20, 'All']],
      processing: true
    };
    this.categoryservice.getCategoriestList().subscribe(data => {
      console.log(data),
    this.categories = data;
      this.dtTrigger.next();
    });
  }

  deleteCategory(id: number) {
    this.categoryservice.deleteCategory(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.categoryservice.getCategoriestList().subscribe(resp => {
            this.categories = resp;
            });
        },
        error => console.log(error));
  }

  updateCategory(id: number) {
    this.categoryservice.getCategory(id)
      .subscribe(
        data => {
          this.categorylist = data;
        },
        error => console.log(error));
  }

  updateStu(updstu) {
    this.category = new Category();
    this.category.categoryid = this.CategoryId.value;
    this.category.categoryname = this.CategoryName.value;
    this.category.categorydescription = this.CategoryDescription.value;
    this.category.categoryicon = this.CategoryIcon.value;


    this.categoryservice.updateCategory(this.category.categoryid, this.category).subscribe(
    data => {
      this.isupdated = true;
      this.categoryservice.getCategoriestList().subscribe(resp => {
        this.categories = resp;
        });
    },
    error => console.log(error));
  }

  get CategoryName() {
    return this.categoryupdateform.get('category_name');
  }

  get CategoryDescription() {
    return this.categoryupdateform.get('categoryt_description');
  }

  get CategoryIcon() {
    return this.categoryupdateform.get('category_icon');
  }

  get CategoryId() {
    return this.categoryupdateform.get('category_id');
  }

  changeisUpdate() {
    this.isupdated = false;
  }
}
