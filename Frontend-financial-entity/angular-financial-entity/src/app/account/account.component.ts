import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Account} from "../model/account";
import {AccountFactory} from "../factory/accountFactory";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit{
  accountForm;
  constructor(
    private formBuilder: FormBuilder,
    private accountFactory : AccountFactory,
    private route: ActivatedRoute,
  ) {
    this.accountForm = this.formBuilder.group({
      accountType: '0',
      state: '0',
      balance: '0',
      gmf: false,
      customerId: this.customerId
    });
  }

  customerId: string | null = '0';
  account: Account | undefined;
  accounts:Account[] = [];

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.customerId = params.get('customerId');
    });

    this.accountFactory.getAll(this.customerId).subscribe(
      (data:any)=>{
        this.accounts = data;
      }
    )
  }
  save(account:any){
   // account.controls["customerId"].setValue(this.customerId);
    //this.account = this.accountForm.value;
    this.account = account;

    this.accountFactory.save(account).subscribe(resp => {
      console.log(resp);
    });
  }
}
