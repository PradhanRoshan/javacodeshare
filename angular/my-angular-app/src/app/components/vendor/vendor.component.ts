import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Vendor } from 'src/app/model/vendor.model';
import { VendorService } from 'src/app/service/vendor.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit,OnDestroy {

  vendors: Vendor[]; //2
  subscriptions: Subscription[]=[];
  constructor(private vendorService: VendorService) {
    console.log('constructor');
  }


  ngOnInit(): void {
    console.log('ng on init');
    this.subscriptions.push(
      this.vendorService.fetchVendors().subscribe({
        next: (data)=> {
          this.vendors = data;
        }
      })
    );

  }

  onVendorDelete(vid : number){
     this.vendorService.deleteVendor(vid).subscribe({
      next: (data)=>{
          this.vendors = this.vendors.filter(v=>v.id != vid);
       },
      error: (e)=>{}
     });
  }

  ngOnDestroy(): void {
    console.log('ng on destroy');
    this.subscriptions.forEach(s=> s.unsubscribe());
  }

}
