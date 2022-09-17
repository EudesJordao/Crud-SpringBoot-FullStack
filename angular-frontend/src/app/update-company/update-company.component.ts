import { ActivatedRoute, Router } from '@angular/router';
import { CompanyService } from './../company.service';
import { Company } from './../company';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {

  cnpj: number;
  company: Company = new Company();
  constructor(private companyService: CompanyService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.cnpj = this.route.snapshot.params['cnpj'];

    this.companyService.getCompanyByCnpj(this.cnpj).subscribe(data =>{
      this.company = data;
    }, error => console.log(error));
  }


  onSubmit(){
    this.companyService.updateCompany(this.cnpj, this.company).subscribe(data =>{
      this.goToCompanyList();
    }
    , error => alert("Erro ao preencher os campos"));
  }

  goToCompanyList(){
    this.router.navigate(['/companys']);
  }
}
