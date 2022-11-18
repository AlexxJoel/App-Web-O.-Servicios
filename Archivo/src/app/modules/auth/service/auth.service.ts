import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserLogin} from "../types/user";
import {APP_URL} from "../../../services/base-url";
import {Router} from "@angular/router";
import {catchError} from "rxjs";
import {GeneralService} from "../../../services/general.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  //variable para ver el estado  una peticion

  private _isLoading:boolean = false;

  get isLoading(): boolean {
    return this._isLoading;
  }

  set setIsLoading(value: boolean) {
    this._isLoading = value;
  }

  constructor(private readonly http:HttpClient, private router: Router,private loginState:GeneralService) { }

  signin(user:UserLogin){
    this.setIsLoading = true;
    this.http.post<any>(`${APP_URL}/api/auth`, user, {
      headers:{'Content-Type':'application/json'},
    })
        .pipe(catchError((error)=>{
            this.setIsLoading = false;
            return error;
        }))

        //response , error
        .subscribe((response)=>{
          localStorage.setItem('token', response.token);
          this.router.navigateByUrl('/');  //pagina de inicio
          this.loginState.setIsLogged = true;
          this.setIsLoading = false;
        });
  }
}
