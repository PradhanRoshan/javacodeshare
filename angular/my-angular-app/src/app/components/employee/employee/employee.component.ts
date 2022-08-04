import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit,OnDestroy {

  subscriptions: Subscription[];
  employees: Employee[];
  page: number;
  size:number;
  constructor(private employeeService: EmployeeService) { }


  ngOnInit(): void {
    this.subscriptions = [];
      this.size = 5;
      this.subscriptions.push(
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
      );
  }

  ngOnDestroy(): void {
     this.subscriptions.forEach(sub=>sub.unsubscribe());
  }

}
