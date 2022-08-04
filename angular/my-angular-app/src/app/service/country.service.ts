import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor() { }

  fetchCities() : string[]{
     let cities : string[] =['london', 'new york','mexico city'];
     return cities;
  }
}
