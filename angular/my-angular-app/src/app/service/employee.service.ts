import { Injectable } from "@angular/core";
import { employeeData } from "../data";
import { Employee } from "../model/employee.model";

@Injectable({
  providedIn: "root"
})
export class EmployeeService{

  employees: Employee[];

  constructor(){
    this.employees = employeeData;
  }

  fetchEmployees(): Employee[] {
       return this.employees;
  }

  public sortSalary(employees:  Employee[], flag: number): Employee[] {
    if(flag == 1)
       employees = employees.sort( (e1, e2)=>e1.salary - e2.salary );
    else
      employees = employees.sort( (e1, e2)=>e2.salary - e1.salary );

     return employees;
  }

}
