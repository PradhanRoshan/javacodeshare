import { Component, OnInit } from '@angular/core';
import { Stat } from '../model/employee.model';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-stat',
  templateUrl: './employee-stat.component.html',
  styleUrls: ['./employee-stat.component.css']
})
export class EmployeeStatComponent implements OnInit {

  stat: Stat[];
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
      this.employeeService.stat$.subscribe(data=>{
          this.employeeService.getEmployeeStats()
          .subscribe(data=>{
            this.stat = data;
          });
      });
  }

}
