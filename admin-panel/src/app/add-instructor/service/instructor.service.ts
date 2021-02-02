import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';
import { UserDetails } from '../model/UserDetails';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {


  constructor(private yogaService: YogaService) { }

  registerInstructorDetails(userDetails: UserDetails) {
    return this.yogaService.post('api/register/instructor', userDetails);
  }

  getAllCoursesList() {
    return this.yogaService.get('api/course/list');
  }
}
