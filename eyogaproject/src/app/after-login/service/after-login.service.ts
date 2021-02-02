import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';

@Injectable({
  providedIn: 'root'
})
export class AfterLoginService {

  constructor(private yogaService: YogaService) { }

  getAllCoursesList() {
    return this.yogaService.get('api/course/list');
  }

  getCourseWiseInstructorList(courseId: any) {
    return this.yogaService.get('api/course/instructor/list/' + courseId);
  }
}
