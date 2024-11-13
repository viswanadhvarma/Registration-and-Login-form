import { Component } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { TdfService } from 'src/app/services/tdf.service';

@Component({
  selector: 'app-tdf',
  templateUrl: './tdf.component.html',
  styleUrls: ['./tdf.component.css']
})
export class TdfComponent {
  constructor(private _Productservice:ProductService,private _ts:TdfService){

  }

  entry:any={};
  record;
  courses=["Java","python","Angular"];

  // userdata(data){
  //   this._Productservice.postproduct(data.value).subscribe(
  //     (res)=>{
  //       this.entry=res.products[0];
  //       console.log(this.entry);
  //     }
  //   )
  // }


  userdata(data){
    this.record=data.value;
    console.log(this.record)
    this._ts.getdata(this.record).subscribe(
      (res)=>{
        console.log(res)
        if(res)
          alert("login sucussfully");
        else
          alert("Enterd wrong details");
      }
      )
    
    
  }
}
