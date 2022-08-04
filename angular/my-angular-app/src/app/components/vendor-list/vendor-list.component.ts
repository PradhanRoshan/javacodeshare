import { Component, Input, OnInit } from '@angular/core';
import { Vendor } from 'src/app/model/vendor.model';

@Component({
  selector: 'app-vendor-list',
  templateUrl: './vendor-list.component.html',
  styleUrls: ['./vendor-list.component.css']
})
export class VendorListComponent implements OnInit {

  @Input("data")
  vendors: Vendor[];
  constructor() { }

  ngOnInit(): void {
  }

}
