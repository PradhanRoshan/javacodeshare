import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-array',
  templateUrl: './array.component.html',
  styleUrls: ['./array.component.css']
})
export class ArrayComponent implements OnInit {

  arr: number[];
  tempArr:number[];

  constructor() { }

  ngOnInit(): void {
    this.arr=[2,5,1,3,6,7,9,8];
    this.tempArr = this.arr;
  }

  even(): void{
    this.reset();
    this.arr = this.arr.filter(e=>e%2 ==0);
}

odd(): void{
   this.reset();
   this.arr = this.arr.filter(e=>e%2 ==1);
}

reset(): void{
  this.arr = this.tempArr;
}
}
