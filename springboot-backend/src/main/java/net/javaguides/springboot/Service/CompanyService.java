package net.javaguides.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public Page<Company> search(
            String name,
            Pageable page) {
                try {
                    if(name == null){
                        return repository.findAll(page);
                    }else {
                        return repository.search(name, page);
                    }
                } catch (Exception e) {
                   System.out.println(e.getCause());
                   return null;
                }
    }
}