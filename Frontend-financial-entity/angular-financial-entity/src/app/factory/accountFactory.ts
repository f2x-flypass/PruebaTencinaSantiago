import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {AjaxResponse} from "rxjs/internal/ajax/AjaxResponse";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {Account} from "../model/account";


@Injectable({
  providedIn: 'root'
})
export class AccountFactory {
  constructor(
    private http: HttpClient
  ) { }
  params = new HttpParams();
  private path : String = 'http://192.168.1.1:8080/account/';

  getAll(customerId:any){
    return this.http.get<Customer[]>(this.path + 'getAll/'+customerId);
  }
  save(account: Account):Observable<any>{
    return this.http.post(this.path + 'save', account);
  }
}
