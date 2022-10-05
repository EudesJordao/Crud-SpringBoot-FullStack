package net.javaguides.springboot.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.EmployeeDTO;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper; 


    public List<EmployeeDTO> listEmployee(){

        List<Employee> employees;

        employees = repository.findAll();

        List<EmployeeDTO> listEmployeeDto = new ArrayList<>();

        employees.forEach(employee -> listEmployeeDto.add(modelMapper.map(employee, EmployeeDTO.class)));

        return listEmployeeDto;
    }
}
