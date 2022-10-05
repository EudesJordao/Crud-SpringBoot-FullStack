package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = 42123123L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@Column(name = "first_name")
	@NotBlank(message = "O nome não pode ser vazio")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "O nome não pode ser vazio")
	private String lastName;
	
	@Column(name = "email_id")
	@Email
	@NotBlank(message = "Email invalido")
	private String emailId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cnpj", nullable = false)
	@JsonBackReference
	private Company company;


}
