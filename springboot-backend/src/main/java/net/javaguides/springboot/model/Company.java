package net.javaguides.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

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
public class Company implements Serializable{
    
    private static final long serialVersionUID = 112312312L;
    
    @Id
    @Column(length = 14, nullable = false, name = "cnpj", unique = true)
    @CNPJ
    private String cnpj;


    @Column(name = "name")
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 25)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true , mappedBy = "company")
    private List<Employee> employees;

    @Transient
    private Long quantidade;

    public Company(Company company, Long count){
        this.name = company.getName();
        this.cnpj = company.getCnpj();


        this.quantidade = count;
    }


}
