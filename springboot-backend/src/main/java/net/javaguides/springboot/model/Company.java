package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
    @Column(length = 14, nullable = false, unique = true, name = "cnpj")
    private long cnpj;


    @Column(name = "name")
    @NotBlank(message = "O nome não pode ser vazio")
    private String name;


    public Company(String name, long cnpj){
        super();
        this.name = name;
        this.cnpj = cnpj;
    }

    public long getCnpj() {
        return cnpj;
    }
    public void setCnpj(long cnpj){
       this.cnpj = cnpj; 
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
