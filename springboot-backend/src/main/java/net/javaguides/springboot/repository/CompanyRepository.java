package net.javaguides.springboot.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


    @Query(value = "SELECT C FROM Company C WHERE C.name LIKE '%:name%' or C.cnpj LIKE '%:name%'")
    Page<Company> search(
        @Param("name") String name,
        Pageable pageable);
        
}
