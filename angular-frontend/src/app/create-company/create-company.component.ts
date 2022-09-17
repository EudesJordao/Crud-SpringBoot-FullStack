import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from './../company';
import { CompanyService } from './../company.service';

@Component({
  selector: 'app-create-company',
  templateUrl: './create-company.component.html',
  styleUrls: ['./create-company.component.css']
})
export class CreateCompanyComponent implements OnInit {

  company: Company = new Company();

  constructor(private companyService: CompanyService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveCompany(){
    this.companyService.createCompany(this.company).subscribe( data =>{
      console.log(data);
      this.goToCompanyList();
    },
    error => alert("Erro ao preencher os campos"))
  }

  goToCompanyList(){
    this.router.navigate(['/companys']);
  }

  onSubmit(){
    console.log(this.company);
    this.saveCompany();
  }

}

function openSnackBar(message: any, string: any, action: any, string1: any): void {
  throw new Error('Função não implementada.')
}
