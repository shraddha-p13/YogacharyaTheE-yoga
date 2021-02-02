import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserDetails } from './model/UserDetails';
import { InstructorService } from './service/instructor.service';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-add-instructor',
  templateUrl: './add-instructor.component.html',
  styleUrls: ['./add-instructor.component.css']
})
export class AddInstructorComponent implements OnInit {

  instructorForm!: FormGroup;
  submitted = false;
  userDetails!: UserDetails;
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};

  constructor(private formBuilder: FormBuilder, private instructorService: InstructorService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getAllCoursesList();

    this.instructorForm = this.formBuilder.group(
      {
        firstName: ["", [Validators.required, ValidateFirstName]],
        lastName: ["", [Validators.required, ValidateLastName]],
        email: ["", [Validators.required, Validators.email]],
        contactNumber: ["", [Validators.required]],
        password: ["", [Validators.required, Validators.minLength(6)]],
        courses: [[], Validators.required]
      });

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  onSubmit() {
    this.submitted = true;

    // Returns false if form is invalid
    if (this.instructorForm.invalid) {
      console.log("Invalid form");
      this.instructorForm.markAllAsTouched();
      return;
    }

    let firstName = this.instructorForm.value.firstName;
    let lastName = this.instructorForm.value.lastName;
    let email = this.instructorForm.value.email;
    let contactNumber = this.instructorForm.value.contactNumber;
    let password = this.instructorForm.value.password;
    let courses = this.instructorForm.value.courses;

    let tmp = [];
    for (let i = 0; i < courses.length; i++) {
      tmp.push(courses[i].item_id);
    }
    this.userDetails = new UserDetails(firstName, lastName, email, contactNumber, password, tmp);

    this.instructorService.registerInstructorDetails(this.userDetails).subscribe(data => {
      this.toastr.success("Instructor added successfully", 'Instructor Registration Success');
      this.router.navigate(['/instructor']);
    },
      error => {
        this.toastr.error(error.error.message, 'Instructor Registration Error');
      });

  }

  onItemSelect(event: any) {

  }

  onSelectAll(event: any) {

  }

  getAllCoursesList() {
    this.instructorService.getAllCoursesList().subscribe(data => {

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

}
export function ValidateFirstName(control: AbstractControl) {
  // if (!control.value.startsWith("@")) {
  //   return { validFname: true };
  // }
  // return null;
  if (control.value.length <= 3) {
    return { validFname: true };
  }
  return null;
}

// To validate last name
export function ValidateLastName(control: AbstractControl) {
  if (control.value.length <= 3) {
    return { validLname: true };
  }
  return null;
}