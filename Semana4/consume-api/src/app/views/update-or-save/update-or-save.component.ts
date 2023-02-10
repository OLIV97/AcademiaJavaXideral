import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonalService } from 'src/app/services/personal.service';
import { lastValueFrom } from 'rxjs';
import { Personal } from 'src/app/interfaces/personal';

@Component({
  selector: 'app-update-or-save',
  templateUrl: './update-or-save.component.html',
  styleUrls: ['./update-or-save.component.scss']
})
export class UpdateOrSaveComponent implements OnInit {

  apellidos:string = "";
  nombres:string = "";
  type_mode:string = "";
  id:number = 0;
  PersonalUpdate!:Personal;
  constructor(private activatedRoute: ActivatedRoute,private router:Router,private personalService: PersonalService) { }

  async  ngOnInit(){
    this.type_mode = this.activatedRoute.snapshot.params["type"];
    if(this.type_mode == "actualizar"){
      this.id = this.activatedRoute.snapshot.params["id"];
      try {
   
          this.PersonalUpdate = await lastValueFrom(this.personalService.personal(this.id));
        
          this.nombres = this.PersonalUpdate.nombres;
          this.apellidos =this.PersonalUpdate.apellidos;

      } catch (error) {
        console.log(error);
  
      }
    }
    // console.log(this.type_mode);
  }

  
  async saveOrUpdatePersonal(){

    try {
      if(this.type_mode == "guardar"){
        await lastValueFrom(this.personalService.save_personal(this.nombres,this.apellidos));
      
      }else if(this.type_mode == "actualizar"){
        this.PersonalUpdate.nombres = this.nombres;
        this.PersonalUpdate.apellidos = this.apellidos;
        
        await lastValueFrom(this.personalService.update_personal(this.PersonalUpdate));
            
      }
      this.router.navigate(['/']);
    } catch (error) {
      console.log(error);

    }

  }

}
