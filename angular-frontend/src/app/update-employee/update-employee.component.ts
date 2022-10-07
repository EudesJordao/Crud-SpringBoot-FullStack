import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from '../company';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number;
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getEmployeeById();
  }

  getEmployeeById() {
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
        this.employee.company = new Company();
    }, error => console.log(error));
  }

  onSubmit(){
    console.log(this.employee)
    this.employeeService.updateEmployee(this.id, this.employee).subscribe( data =>{
      this.goToEmployeeList();
    }
    , error => alert("Erro ao preencher os campos"));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
}
