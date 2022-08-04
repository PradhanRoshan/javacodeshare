import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { CountryService } from 'src/app/service/country.service';
import { CityComponent } from '../city/city.component';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit,AfterViewInit {

  @ViewChild(CityComponent) cityComponent;

  cities: string[];
  constructor(private countryService: CountryService) { }


  ngOnInit(): void {
    this.cities = this.countryService.fetchCities();

  }

  ngAfterViewInit(): void {
    this.cityComponent.cities = this.cities;
  }

}
/*
1. cities$: tell child to subscribe to it.
2. pass as prop :   @Input("data")
3. ViewChild

AfterViewInit
*/
