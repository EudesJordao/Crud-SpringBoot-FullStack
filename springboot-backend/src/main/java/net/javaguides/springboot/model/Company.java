package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "companys")
public class Company {
    
    @Id
    @Column(length = 14, nullable = false, name = "cnpj", unique = true)
    @CNPJ
    private String cnpj;


    @Column(name = "name")
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 25)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @JsonManagedReference
    public List<Employee> getEmployees(){
        return employees;
    }

}
