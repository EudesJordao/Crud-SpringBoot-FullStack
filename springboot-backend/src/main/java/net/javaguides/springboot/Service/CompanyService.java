package net.javaguides.springboot.Service;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.CompanyDTO;
import net.javaguides.springboot.exception.DataException;
import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;

@Service
public class CompanyService {


    @Autowired
    CompanyRepository repository;
    
    @Autowired
    private ModelMapper modelMapper; 

    public Page<CompanyDTO> search(
            String name,
            Pageable page) {

            Page<Company> pageCompany;
            List<CompanyDTO> listCompanyDto = new ArrayList<>();

                try {
                    if(name == null){
                        pageCompany = repository.findAll(page);
                    }else {
                        pageCompany = repository.search(name, page);
                    }
                } catch (Exception e) {
                System.out.println(e.getCause());
                return null;
                }

            pageCompany.getContent().forEach(company -> listCompanyDto.add(modelMapper.map(company, CompanyDTO.class)));
            
            Page<CompanyDTO> companyDto = new PageImpl<>(listCompanyDto);
        
        return companyDto;

    }

    private Company findByCNPJ(CompanyDTO companyDTO){
        Company obj = repository.findByCNPJ(companyDTO.getCnpj());
        if(obj != null){
            return obj;
        }else{
            return null;
        }
    }

     public Company create(CompanyDTO companyDTO){
         if(findByCNPJ(companyDTO) != null){
            throw new DataException("CNPJ já cadastrado no banco de dados.");
        }
         return repository.save(new Company(companyDTO.getCnpj(), companyDTO.getName(), null, null));
     }
}