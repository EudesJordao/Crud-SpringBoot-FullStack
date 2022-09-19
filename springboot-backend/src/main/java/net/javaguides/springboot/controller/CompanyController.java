package net.javaguides.springboot.controller;


import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;
import net.javaguides.springboot.Service.CompanyService;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    CompanyService service;
   
  
    // get all companys
    @GetMapping("/companys")
    public Page<Company> search(
        @RequestParam(required = false) String name,
        Pageable page) {
          return service.search(name, page);
    }

    // creat company rest api
    @PostMapping("/companys")
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    // get company by id rest api
    @GetMapping("/companys/{cnpj}")
    public ResponseEntity<Company> getCompanyByCnpj(@PathVariable Long cnpj) {
        Company company = companyRepository.findById(cnpj)
        .orElseThrow(() -> new ResourceNotFoundException("Company not exist with cnpj: " + cnpj));
        return ResponseEntity.ok(company);
    }

    // update company rest api
    @PutMapping("/companys/{cnpj}")
    public ResponseEntity<Company>updateCompany(@PathVariable Long cnpj, @RequestBody Company companyDetails){
        Company company = companyRepository.findById(cnpj)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + cnpj));

        company.setName(companyDetails.getName());


        Company updateCompany = companyRepository.save(company);
        return ResponseEntity.ok(updateCompany);
    }

    // delete company rest api
    @DeleteMapping("/companys/{cnpj}")
    public ResponseEntity<Map<String, Boolean>> deleteCompany(@PathVariable Long cnpj){
        Company company = companyRepository.findById(cnpj)
        .orElseThrow(() -> new ResourceNotFoundException("Company not exist with id :" + cnpj));

    companyRepository.delete(company);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }
}
