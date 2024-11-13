import { state } from '@angular/animations';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ReactformService } from 'src/app/services/reactform.service';
import { DataComponent } from '../data/data.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reactform',
  templateUrl: './reactform.component.html',
  styleUrls: ['./reactform.component.css']
})
export class ReactformComponent {
data: any;

  constructor(private _formBulider:FormBuilder,private _rf:ReactformService,private _router:Router){
    

  }
  registrationForm = this._formBulider.group({
    firstname:[],
    lastname:[],
    eamil:[],
    password:[],
    mobile:[],
    age:[],
    gender:[],
    dob:[]
  })



  // registrationForm= new FormGroup({
  //   username: new FormControl(),
  //   password: new FormControl(),
  //   cpassword: new FormControl(),
  //   city: new FormControl(),
  //   state: new FormControl(),
  //   pincode: new FormControl(),
  // })
  
  postdata(){
    this.data=this.registrationForm.value
    this._rf.postdata(this.data).subscribe(
      (res)=>{
        console.log(res+"uploaded")
        alert("Registration Sucussfull.")
        this._router.navigate(["/tdf"])
      }

    );
    // console.log(this.registrationForm.value)
  
  }
  
}
