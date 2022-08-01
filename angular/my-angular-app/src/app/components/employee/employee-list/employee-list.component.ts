import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-list-rxjs',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponentRxjs implements OnInit {

  employees: Employee[];
  page:number;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.employee$.subscribe(data=>{
        this.employees = data;
    });
  }

  prev(){
       //read the value of page from subject

        let page = this.employeeService.page$.getValue();
       //update the value of page
       if(page >0){
        this.page = page-1;
        //attach the updated value to the subject
         this.employeeService.page$.next(this.page);
       }

  }

  next(){
      //read the value of page from subject
      let page = this.employeeService.page$.getValue();
      //update the value of page
      this.page = page + 1;
      //attach the updated value to the subject
      this.employeeService.page$.next(this.page);
  }
}
