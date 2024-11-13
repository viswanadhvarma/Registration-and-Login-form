import { Component } from '@angular/core';
import { TdfService } from 'src/app/services/tdf.service';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent {
  data;
  ce;
  del;
constructor(private _dc:TdfService){}
private ngOnInit(){
  this.getdata(this.data);
}

public getdata(data){
    this._dc.getalldata(data).subscribe(
      (res)=>{
        this.data=res;
        
      }
    )
  }
public deletedata(eamil){
  
  this._dc.deleteddata(eamil).subscribe(
    (res)=>{
      console.log(res+" deleted")
      this.del=res;
      this.del.reset();
      console.log(res)
    }
  )
}
change(eamil){
  
  this.ce=eamil;
  console.log(this.ce)
}

}
