import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { TraineeService } from './service/trainee.service';

@Component({
  selector: 'app-trainee',
  templateUrl: './trainee.component.html',
  styleUrls: ['./trainee.component.css']
})
export class TraineeComponent implements OnInit {
  traineeList: any[];
  constructor(private traineeService: TraineeService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getTraineeList();
  }

  getTraineeList() {
    this.traineeService.getTraineeList().subscribe(data => {
      this.traineeList = data;
    }, error => {
      this.toastr.error(error.error.message, 'Error');
    });
  }
}
