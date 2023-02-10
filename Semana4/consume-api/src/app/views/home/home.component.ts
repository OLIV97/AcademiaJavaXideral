import { Component, OnInit } from '@angular/core';
import { PersonalService } from 'src/app/services/personal.service';
import { lastValueFrom } from 'rxjs';
import { Personal } from 'src/app/interfaces/personal';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private personalService: PersonalService,private router:Router) { }

  all_personal!:Personal[];
  loading_personal:number[]=[0,1,2,3,4,5,6,7,8,9];
  id:number = 0;

  async  ngOnInit(){
    let response;
    try {
      response = await lastValueFrom(this.personalService.all_personal());
      this.all_personal=response;

      // console.log(this.all_personal);
    } catch (error) {
      console.log(error);
    }
  }

  set_id( person_id:number){
    this.id = person_id;
  }
  async  delete_personal(){
    
    // console.log(id);
    let response;
    
    try {
      await lastValueFrom(this.personalService.personal_delete(this.id));
      response = await lastValueFrom(this.personalService.all_personal());
      this.all_personal=response;
      // console.log(this.all_personal);
    } catch (error) {
      console.log(error);
    }
  }

  async checkPersonal( id:number,type:string){

    let response ;
    try {
        await lastValueFrom(this.personalService.check_personal(id,type));
      response = await lastValueFrom(this.personalService.all_personal());
      this.all_personal=response;
     
    } catch (error) {
      console.log(error);
    }

  }
  
  


}
