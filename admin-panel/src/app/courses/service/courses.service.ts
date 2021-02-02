import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  constructor(private yogaService: YogaService) { }

  deleteCourse(id: any) {
    return this.yogaService.delete('api/course/' + id);
  }
}
