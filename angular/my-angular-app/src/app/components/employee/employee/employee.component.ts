import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  page: number;
  size:number;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
      this.size = 5;
      this.employeeService.page$.subscribe(value=>{
          this.page = value;
          this.employeeService.getAllEmployees(this.page,this.size)
          .subscribe({
            next: (data)=>{
                this.employees = data;
                this.employeeService.employee$.next(this.employees);
            },
            error: (e)=>{
              //redirect to error page
            }
          });
      })


  }

}
