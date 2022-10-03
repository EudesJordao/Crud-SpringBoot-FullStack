import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Company } from '../company';

import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {
    this.employee.company = new Company();
  }

  saveEmployee(){
    console.log(this.employee);
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => alert("Erro ao preencher os campos"));
  }



  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
function openSnackBar(message: any, string: any, action: any, string1: any): void {
  throw new Error('Função não implementada.');
}

