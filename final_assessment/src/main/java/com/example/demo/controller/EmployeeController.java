package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeIdNotFound;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping //used to retrieve the details using getEmployee method
	public String getEmployee() {
		
		return "this is get";
	}
	
	@GetMapping("/all")  //retrieving details of all the employees present inthe database
	public List<Employee> getAllEmployees() throws Exception {
		
		List list = this.employeeRepository.findAll();
		return Optional.ofNullable(list.isEmpty()? null :list).orElseThrow(()->
		new NoDataFoundException("No data found"));	
	}
	
	
	@GetMapping("/{id}")   // retrieving the data based on the ID which is an primary key
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Integer id) throws EmployeeIdNotFound
{
	Optional<Employee> optional=employeeRepository.findById(id);
	if(optional.isPresent())
	{
		return ResponseEntity.ok(optional.get());
	}
	else
	{
		throw new EmployeeIdNotFound("Resources not found");
	}
}

@PostMapping  // to add the details of new employees in to the database
public Employee addEmployee(@RequestBody @Valid Employee employee) throws EmployeeIdNotFound
{
	if(employee.getEmployeeId()==null)
	{
		throw new EmployeeIdNotFound("cannot add employee");
	}
	return employeeRepository.save(employee);
}

@DeleteMapping("/delete/{id}")  // to delete the details of the particualar employee based on ID
public String deleteEmployee(@PathVariable("id") Integer id) throws EmployeeIdNotFound
{
Optional<Employee> optional=employeeRepository.findById(id);
if(optional.isPresent())
{
	employeeRepository.deleteById(id);
	return "employee deleted successfully";
}
else
{
	throw new EmployeeIdNotFound("Resources not found");
}
}

@PutMapping("/{Id}") // to update or to manipulate the fields of the employees
public ResponseEntity<Employee> updateAccount(@PathVariable("Id") Integer id,@Valid @RequestBody Employee 
		resourceDetails) throws EmployeeIdNotFound {	
	Employee acc = employeeRepository.findById(id).orElseThrow(()->new EmployeeIdNotFound("record not found"));
	
	acc.setFirstName(resourceDetails.getFirstName());
	acc.setLastName(resourceDetails.getLastName());
	acc.setEmail(resourceDetails.getEmail());
	acc.setDepartment(resourceDetails.getDepartment());
	acc.setGender(resourceDetails.getGender());
	
	final Employee newDetails=employeeRepository.save(acc);
	return ResponseEntity.ok(newDetails);
}
}
