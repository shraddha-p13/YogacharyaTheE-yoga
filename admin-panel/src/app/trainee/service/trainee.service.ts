import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';

@Injectable({
  providedIn: 'root'
})
export class TraineeService {

  constructor(private yogaService: YogaService) { }

  getTraineeList() {
    return this.yogaService.get('api/trainee/list');
  }
}
