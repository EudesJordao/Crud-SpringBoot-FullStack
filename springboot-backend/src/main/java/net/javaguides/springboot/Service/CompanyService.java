package net.javaguides.springboot.Service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.CompanyDTO;
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
}