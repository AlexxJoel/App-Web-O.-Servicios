import { Injectable } from '@angular/core';
import {Personal} from "../types/personal";

@Injectable({
  providedIn: 'root'
})
export class PersonalService {
  private loadign:Boolean = false;
  private personal: Personal[] = [];

  get getPersonal(): Personal[] {
    return [...this.personal];
  }

  set addPersonal(person: Personal) {
    this.personal.push(person) ;
  }

   get isLoadding(){
    return this.loadign;
   }
  constructor( private  http:HttpClient) { }

  getAllPersonal(){
      this.loadign = true;
      this.http.get<any>(`${APP_URL}api/personal/`)
          .pipe(
              catchError((error)=>{
                  this.loadign = false;
                  return error;
              })
          ).suscribe((response: Personal[])=>{
              this.loadign = false;
              this.personal = response;
      })
  }
}
