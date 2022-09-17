package net.javaguides.springboot.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Company;
import net.javaguides.springboot.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    CompanyRepository repository;

    public Page<Company> search(
            String name,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC,
            "name");

       return repository.search(
            name.toLowerCase(),
           pageRequest);
    }

    public Page<Company> findAll(){
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC,
            "name");
        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size);
    }
        
    }