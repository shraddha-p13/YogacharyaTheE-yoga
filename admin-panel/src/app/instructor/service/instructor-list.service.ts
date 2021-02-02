import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';

@Injectable({
  providedIn: 'root'
})
export class InstructorListService {
  deleteInstructorDetails(id: any) {
    return this.yogaService.delete('api/instructor/' + id);
  }

  constructor(private yogaService: YogaService) { }

  getAllInstructorList() {
    return this.yogaService.get('api/instructor/list')
  }
}
