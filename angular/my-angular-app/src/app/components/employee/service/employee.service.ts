import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  postApi: string;
  getAllApi: string;

  employee$ = new BehaviorSubject<Employee[]>([]);
  page$ = new BehaviorSubject<number>(0);

  constructor(private http: HttpClient) {
    this.postApi='http://localhost:8282/employee';
    this.getAllApi='http://localhost:8282/employee';
   }

  public postEmployee(employee: Employee)
          :Observable<Employee>{
     return this.http.post<Employee>
                (this.postApi, employee);
  }

  getAllEmployees(page: number,size: number) : Observable<Employee[]>{
    return  this.http.get<Employee[]>(this.getAllApi + '?page='+page+'&size='+size);
  }

}
