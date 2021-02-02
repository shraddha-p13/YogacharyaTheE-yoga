import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { InstructorService } from '../add-instructor/service/instructor.service';
import { InstructorListService } from './service/instructor-list.service';

@Component({
  selector: 'app-instructor',
  templateUrl: './instructor.component.html',
  styleUrls: ['./instructor.component.css']
})
export class InstructorComponent implements OnInit {

  instructorList: any[];
  constructor(private instructorListService: InstructorListService, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllInstructorList();
  }

  getAllInstructorList() {
    this.instructorListService.getAllInstructorList().subscribe(data => {
      this.instructorList = data;
    }, error => {
      this.toastr.error(error.error.message, 'Error');
    })
  }

  deleteInstructorDetails(id: any) {
    this.instructorListService.deleteInstructorDetails(id).subscribe(data => {
      this.getAllInstructorList();
      this.toastr.success(data.message, 'Success');
    }, error => {
      this.toastr.error(error.error.message, 'Error');
    })
  }
}
