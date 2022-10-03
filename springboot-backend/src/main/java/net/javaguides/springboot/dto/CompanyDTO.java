package net.javaguides.springboot.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CompanyDTO {

    private String cnpj;

    private String name;

    private List<EmployeeDTO> employees; 

}