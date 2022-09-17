import { CompanyService } from './../company.service';
import { ActivatedRoute } from '@angular/router';
import { Company } from './../company';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {

  cnpj: number;
  company: Company;

  constructor(private route: ActivatedRoute, private companyService: CompanyService) { }

  ngOnInit(): void {
    this.cnpj = this.route.snapshot.params['cnpj'];

    this.company = new Company();
    this.companyService.getCompanyByCnpj(this.cnpj).subscribe( data =>{
      this.company = data;
    });
  }

}
