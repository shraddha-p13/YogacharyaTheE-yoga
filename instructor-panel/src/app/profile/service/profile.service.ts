import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';
import { InstructorCourseDetails } from '../model/InstructorCourseDetails';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private yogaService: YogaService) { }

  getAllCoursesListForInstructor(id: string) {
    return this.yogaService.get('api/instructor/course/list/' + id);
  }

  updateCourseLink(instructorCourseDetails: InstructorCourseDetails) {
    return this.yogaService.post('api/instructor/course', instructorCourseDetails);
  }

}
