package com.springboot.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.EmployeeStatDto;
import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;

 @RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(
			@RequestParam(name="page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name="size",required=false,defaultValue = "100") Integer size){
		if(page < 0)
			page=0;
		
		Pageable pageable=PageRequest.of(page, size);
		 
		Page<Employee> p =  employeeRepository.findAll(pageable);
		long total = p.getTotalElements();
		
		return p.getContent();
	}
	
	@GetMapping("/employee/stats")
	public List<EmployeeStatDto> getEmployeeStats() {
		List<Employee> list = employeeRepository.findAll(); 
		List<EmployeeStatDto> listDto = new ArrayList<>();
		Map<String,Integer> statMap = new HashMap<>();
		Map<String, List<Employee>> map 
					= list.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
		
		for(Map.Entry<String, List<Employee>> e: map.entrySet()) {
			EmployeeStatDto dto = new EmployeeStatDto();
			dto.setDepartment(e.getKey());
			dto.setCount(e.getValue().size());
			listDto.add(dto);
		}
		return listDto; 
	}
}






