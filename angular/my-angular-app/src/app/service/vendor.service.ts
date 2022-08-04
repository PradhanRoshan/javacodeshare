import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendor } from '../model/vendor.model';

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  getAllVendorsApi: string;
  deleteVendorApi: string;

  constructor(private http: HttpClient) {
    this.getAllVendorsApi ='http://localhost:8282/vendor';
    this.deleteVendorApi='http://localhost:8282/vendor/';
   }

  fetchVendors() : Observable<Vendor[]>{
    return this.http.get<Vendor[]>(this.getAllVendorsApi);
  }

  deleteVendor(vid: number):Observable<any> {
    return this.http.delete<any>(this.deleteVendorApi
      + vid);
  }
}
