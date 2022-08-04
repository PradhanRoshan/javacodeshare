import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Vendor } from 'src/app/model/vendor.model';

@Component({
  selector: 'app-vendor-list',
  templateUrl: './vendor-list.component.html',
  styleUrls: ['./vendor-list.component.css']
})
export class VendorListComponent implements OnInit {

  @Input("data")
  vendors: Vendor[];

  @Output()
  deleteVendorEmitter = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  onVendorDelete(vid: number){
     //emit this vid to parent
     this.deleteVendorEmitter.emit(vid);
  }
}
