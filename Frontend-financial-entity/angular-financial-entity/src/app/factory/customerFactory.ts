import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {AjaxResponse} from "rxjs/internal/ajax/AjaxResponse";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CustomerFactory {
  constructor(
    private http: HttpClient
  ) { }
  params = new HttpParams();
  private path : String = 'http://192.168.1.1:8080/customer/';

  getAllCustomer(){
    return this.http.get<Customer[]>(this.path + 'getAll');
  }
  saveCustomer(customer: Customer):Observable<any>{
    return this.http.post(this.path + 'save', customer);
  }
}
