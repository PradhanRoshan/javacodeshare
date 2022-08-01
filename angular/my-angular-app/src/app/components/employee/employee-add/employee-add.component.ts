import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-add-rxjs',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponentRxjs implements OnInit {

  employeeForm :FormGroup;
  constructor() { }

  ngOnInit(): void {
    this.employeeForm = new FormGroup({
      name: new FormControl('', [Validators.required,
                                 Validators.pattern(/^[a-zA-Z ]+$/)]),
      city: new FormControl('', [Validators.required,
                                 Validators.pattern(/^[a-zA-Z ]+$/)]),
      salary: new FormControl('', [Validators.required,
                                  Validators.minLength(4),
                                  Validators.maxLength(10),
                                  Validators.pattern(/^[0-9]+$/)]),
      department: new FormControl('',[Validators.required,
                                      Validators.pattern(/^[a-zA-Z ]+$/)])
    });
  }

  onFormSubmit(){
    console.log(this.employeeForm.value);
  }

}
