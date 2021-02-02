import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { InstructorService } from '../add-instructor/service/instructor.service';
import { CoursesService } from './service/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courseList: any[];
  constructor(private instructorService: InstructorService, private toastr: ToastrService, private coursesService: CoursesService) { }

  ngOnInit() {
    this.getCoursesList();
  }

  getCoursesList() {
    this.instructorService.getAllCoursesList().subscribe(data => {
      this.courseList = data;
    },
      error => {
        this.toastr.error(error.error.message, 'Error');
      });
  }

  deleteCourse(id) {
    this.coursesService.deleteCourse(id).subscribe(data => {
      this.toastr.success(data.message, 'Success');
      this.getCoursesList();
    }, error => {
      this.toastr.error(error.error.message, 'Error');
    });
  }
}
