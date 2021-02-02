import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Course } from './model/Course';
import { CourseService } from './service/course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  courseForm!: FormGroup;
  submitted = false;
  course!: Course;
  constructor(private formBuilder: FormBuilder, private router: Router, private toastr: ToastrService, private courseService: CourseService) { }

  ngOnInit() {
    this.courseForm = this.formBuilder.group(
      {
        courseName: ["", [Validators.required]]
      });
  }

  onSubmit() {
    this.submitted = true;

    // Returns false if form is invalid
    if (this.courseForm.invalid) {
      console.log("Invalid form");
      this.courseForm.markAllAsTouched();
      return;
    }
    let courseName = this.courseForm.value.courseName;
    this.course = new Course(courseName);
    this.courseService.addCourseDetails(this.course).subscribe(data => {
      this.toastr.success(data.message, 'Course Registration Success');
      this.router.navigate(['/courses']);
    },
      error => {
        this.toastr.error(error.error.message, 'Course Registration Error');
      });
  }
}
