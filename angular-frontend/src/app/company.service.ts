import { Content } from './content';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from './company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private companyURL = "http://localhost:8080/api/v1/companys";

  constructor(private httpClient: HttpClient) { }

  getCompanyList(name: string): Observable<Content[]>{
    let params = new HttpParams()
    .set('name', name);
    return this.httpClient.get<Content[]>(`${this.companyURL}`,{params: params});
  }

  createCompany(company: Company): Observable<Object>{
    return this.httpClient.post(`${this.companyURL}`, company);
  }

  getCompanyByCnpj(cnpj: number): Observable<Company>{
    return this.httpClient.get<Company>(`${this.companyURL}/${cnpj}`);
  }

  updateCompany(cnpj: number, company: Company): Observable<Object>{
    return this.httpClient.put(`${this.companyURL}/${cnpj}`, company);
  }

  deleteCompany(cnpj: number): Observable<Object>{
    return this.httpClient.delete(`${this.companyURL}/${cnpj}`);
  }


}
