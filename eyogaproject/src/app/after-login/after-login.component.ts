import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AfterLoginService } from './service/after-login.service';

@Component({
  selector: 'app-after-login',
  templateUrl: './after-login.component.html',
  styleUrls: ['./after-login.component.css']
})
export class AfterLoginComponent implements OnInit {

  dropdownList: any[] = [];
  selectedItems = [];
  dropdownSettings = {};
  selectedCourseId = "";
  instructorList!: any[];
  isInstructorListPresent: boolean = false;
  constructor(private afterLoginService: AfterLoginService, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllCoursesList();
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: false
    };
  }

  onItemSelect(item: any) {
    this.selectedCourseId = item.item_id;
    this.getCourseWiseInstructorList(this.selectedCourseId);
  }

  onItemDeSelect(item: any) {
    this.selectedCourseId = "";
    this.instructorList = [];
    this.isInstructorListPresent = false;
  }

  getAllCoursesList() {
    this.afterLoginService.getAllCoursesList().subscribe(data => {

      let tmp = [];
      for (let i = 0; i < data.length; i++) {
        tmp.push({ item_id: data[i].id, item_text: data[i].courseName });
      }
      this.dropdownList = tmp;
    },
      error => {
        this.toastr.error(error.error.message, 'Error');
      });
  }

  getCourseWiseInstructorList(courseId: any) {
    this.afterLoginService.getCourseWiseInstructorList(courseId).subscribe(data => {
      this.instructorList = data;
      this.isInstructorListPresent = true;
    }, error => {
      this.instructorList = [];
      this.isInstructorListPresent = false;
      this.toastr.error(error.error.message, 'Error');
    });

  }
}
