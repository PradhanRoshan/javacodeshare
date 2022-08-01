import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Employee, Stat } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  postApi: string;
  getAllApi: string;
  getStatsApi: string;

  employee$ = new BehaviorSubject<Employee[]>([]);
  page$ = new BehaviorSubject<number>(0);
  stat$ = new BehaviorSubject<Boolean>(false);

  constructor(private http: HttpClient) {
    this.postApi='http://localhost:8282/employee';
    this.getAllApi='http://localhost:8282/employee';
    this.getStatsApi='http://localhost:8282/employee/stats';
   }

  public postEmployee(employee: Employee)
          :Observable<Employee>{
     return this.http.post<Employee>
                (this.postApi, employee);
  }

  getAllEmployees(page: number,size: number) : Observable<Employee[]>{
    return  this.http.get<Employee[]>
    (this.getAllApi + '?page='+page+'&size='+size);
  }

  getEmployeeStats():Observable<Stat[]> {
     return  this.http.get<Stat[]>
     (this.getStatsApi);
  }


}
