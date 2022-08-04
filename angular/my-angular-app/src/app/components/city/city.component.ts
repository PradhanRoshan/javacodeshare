import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {


  cities: string[];

  constructor() { }

  ngOnInit(): void {
  }

}
