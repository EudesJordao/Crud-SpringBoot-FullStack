import { CompanyDetailsComponent } from './company-details/company-details.component';
import { UpdateCompanyComponent } from './update-company/update-company.component';
import { CreateCompanyComponent } from './create-company/create-company.component';
import { CompanyListComponent } from './company-list/company-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

const routes: Routes = [
  {path: 'employees', component: EmployeeListComponent},
  {path: 'create-employee', component: CreateEmployeeComponent},
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'update-employee/:id', component: UpdateEmployeeComponent},
  {path: 'employee-details/:id', component: EmployeeDetailsComponent},
  {path: 'companys', component: CompanyListComponent},
  {path: 'create-company', component: CreateCompanyComponent},
  {path: 'update-company/:cnpj', component: UpdateCompanyComponent},
  {path: 'company-details/:cnpj', component: CompanyDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
