import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
  showAddress:boolean;
  lbladdress:string;

  ngOnInit(): void {
    this.showAddress=false;
    this.lbladdress="Show Address";
  }

  toggleAddress():void{
    this.showAddress = !this.showAddress;
    if(this.showAddress == true)
        this.lbladdress="Hide Address";
    else
        this.lbladdress="Show Address";
  }

}
