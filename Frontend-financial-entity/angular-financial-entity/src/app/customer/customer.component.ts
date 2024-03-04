import {Component, OnInit} from '@angular/core';
import {CustomerFactory} from "../factory/customerFactory";
import {Customer} from "../model/customer";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  checkoutForm;
  constructor(
     private formBuilder: FormBuilder,
    private customerFactory : CustomerFactory
  ) {
   this.checkoutForm = this.formBuilder.group({
     name: '',
     lastname: '',
     identificationType: '',
     identificationNumber: '',
     birthDate: '',
     mail: '',
   });
 }
  title:string ="";
  customer:Customer | undefined;
  customers:Customer[] = [];



  ngOnInit(): void {

  }
  getAllCustomer(){
    this.title = "prueba";
    this.customerFactory.getAllCustomer().subscribe(
      (data:any)=>{
        this.customers = data;
      }
    )
  }
  save(customer:any){
    this.title = "save";
    this.customer = customer;
    this.customerFactory.saveCustomer(customer);
  }
}
