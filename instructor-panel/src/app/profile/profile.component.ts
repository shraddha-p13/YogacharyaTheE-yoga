import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { InstructorCourseDetails } from './model/InstructorCourseDetails';
import { UserDetails } from './model/UserDetails';
import { ProfileService } from './service/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
  isCoursesPresent: boolean = false;
  userDetails!: UserDetails;
  courseList: any[];
  courseLink: string = "";
  selectedCourseId: string = "";
  instructorCourseDetails!: InstructorCourseDetails;
  constructor(private profileService: ProfileService, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.userDetails = JSON.parse(localStorage.getItem('userDetails'));

    this.getAllCoursesListForInstructor(this.userDetails['id']);

    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  onItemSelect(item: any) {
    this.selectedCourseId = item.item_id;
    this.courseList.forEach(element => {
      if (element.id == item.item_id) {
        this.courseLink = element.link;
      }
    });
  }

  onItemDeSelect(item: any) {
    this.courseLink = "";
    this.selectedCourseId = "";
  }

  updateCourseLink(courseLink: string) {

    this.instructorCourseDetails = new InstructorCourseDetails(this.selectedCourseId, this.userDetails['id'], courseLink);
    this.profileService.updateCourseLink(this.instructorCourseDetails).subscribe(data => {
      this.toastr.success(data.message, 'Success');
    }, error => {
      this.toastr.error(error.error.message, 'Error');
    })
  }

  getAllCoursesListForInstructor(id: string) {
    this.profileService.getAllCoursesListForInstructor(id).subscribe(data => {
      this.isCoursesPresent = true;
      this.courseList = data;
      let tmp = [];
      for (let i = 0; i < data.length; i++) {
        tmp.push({ item_id: data[i].id, item_text: data[i].courseName });
      }
      this.dropdownList = tmp;
    },
      error => {
        this.isCoursesPresent = false;
        this.toastr.error(error.error.message, 'Error');
      });
  }
}
