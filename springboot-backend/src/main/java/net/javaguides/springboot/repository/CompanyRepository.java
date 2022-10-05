package net.javaguides.springboot.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query(value = 
    "SELECT new net.javaguides.springboot.model.Company(c , COUNT(e)) " +
    "FROM Company c " + 
    "LEFT JOIN Employee e ON e.company = c.cnpj " +
    "WHERE LOWER(c.name) LIKE LOWER(concat('%', concat(:name, '%'))) " +
    "OR LOWER(c.cnpj) LIKE LOWER(concat('%', concat(:name, '%'))) " +
    "GROUP BY c.cnpj, c.name ")
    Page<Company> search(
        @Param("name") String name, 
        Pageable pageable
    );

    
}
