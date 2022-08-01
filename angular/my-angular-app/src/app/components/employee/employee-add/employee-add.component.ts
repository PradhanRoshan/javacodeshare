import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-add-rxjs',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponentRxjs implements OnInit {

  employeeForm :FormGroup;
  employee: Employee;
  msg:string;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.msg='';
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
    this.employee = this.employeeForm.value;
     this.employeeService.postEmployee(this.employee).subscribe( {
        next: (data)=> {
          this.employee = data;
          this.msg='Employee added in the system';
          //Read the value from the Subject
          let employeeArry = this.employeeService.employee$.getValue();
          //update the value: add employee to Employee[]
          employeeArry.push(this.employee);
          //update the subject value
          this.employeeService.employee$.next(employeeArry);

          //update the value of $stat
          this.employeeService.stat$.next(true);
        },
        error: (e)=>{
          this.msg='Operation Failed';
        }
     });
  }

}
