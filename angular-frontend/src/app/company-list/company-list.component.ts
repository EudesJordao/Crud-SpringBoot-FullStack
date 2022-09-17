import { Content } from './../content';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from './../company';
import { CompanyService } from './../company.service';


@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

  contents: Content[];
  totalLength: any;
  page: number = 0;
  nameParm: string;


  constructor(private companyService: CompanyService,
    private router: Router) { }


  ngOnInit(): void {
    this.getCompany();
  }

  private getCompany(){
    this.companyService.getCompanyList(this.nameParm).subscribe(data => {
      this.contents = data;

      this.totalLength = data.length;
    },
    error => alert("Erro ao preencher os campos"))
  }

  onSubmit(){
    console.log(this.contents);
    this.getCompany();
  }

  companyDetails(cnpj: number){
    this.router.navigate(['company-details', cnpj]);
  }

  updateCompany(cnpj: number){
    this.router.navigate(['update-company', cnpj]);
  }

  deleteCompany(cnpj: number){
    this.companyService.deleteCompany(cnpj).subscribe( data => {
      console.log(data);
      this.getCompany();
    })
  }
}
