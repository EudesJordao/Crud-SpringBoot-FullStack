package net.javaguides.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmployeeDTO {
    
	private long id;

	private String firstName;

	private String lastName;

	private String emailId;

}
