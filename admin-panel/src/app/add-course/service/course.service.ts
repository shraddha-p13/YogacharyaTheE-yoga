import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';
import { Course } from '../model/Course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {


  constructor(private yogaService: YogaService) { }

  addCourseDetails(course: Course) {
    return this.yogaService.post('api/course', course);
  }
}
