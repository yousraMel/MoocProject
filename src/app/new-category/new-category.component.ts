import { Category } from './../entities/category';
import { CategoryService } from './../sevices/category.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-category',
  templateUrl: './new-category.component.html',
  styleUrls: ['./new-category.component.css']
})
export class NewCategoryComponent implements OnInit {

  constructor(private categoryservice: CategoryService) { }
  category: Category = new Category();
  submitted = false;

  categorysaveform = new FormGroup({
    category_name: new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    category_description: new FormControl('', [Validators.required, Validators.minLength(10)]),
    category_icon: new FormControl()
  });
  ngOnInit() {

    this.submitted = false;
  }
  saveCategory(saveCategory) {
    this.category = new Category();
    this.category.categoryname = this.categoryName.value;
    this.category.categorydescription = this.categoryDescription.value;
    this.category.categoryicon = this.categoryIcon.value;
    this.submitted = true;
    console.log(this.category);
    this.save();
  }

  save() {
    this.categoryservice.createCategory(this.category)
      .subscribe(data => console.log(data), error => console.log(error));
    this.category = new Category();
  }

  get categoryName() {
    return this.categorysaveform.get('category_name');
  }

  get categoryDescription() {
    return this.categorysaveform.get('category_description');
  }

  get categoryIcon() {
    return this.categorysaveform.get('category_icon');
  }
  addCategorytForm() {
    this.submitted = false;
    this.categorysaveform.reset();
  }
}
