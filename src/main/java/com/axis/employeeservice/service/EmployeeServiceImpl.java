package com.axis.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.employeeservice.entity.Employee;
import com.axis.employeeservice.exception.EmployeeNotFoundException;
import com.axis.employeeservice.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeerepository;
	
	@Override
	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOpt = employeerepository.findById(empId);
		if(!employeeOpt.isPresent())
			throw new EmployeeNotFoundException("Employee Not Found by Id "+empId);
		return employeeOpt.get();
//		return employeerepository.findById(empId).get();
	}

	@Override
	public List<Employee> getAllemployees() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}

	@Override
	public Employee addemployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeerepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		employeerepository.deleteById(empId);
		
	}

	@Override
	public Employee updateEmployeeById(Employee employee, int empId) {
		// TODO Auto-generated method stub
		Employee toUpdate = employeerepository.findById(empId).get();
		toUpdate.setEmpName(employee.getEmpName());
		toUpdate.setEmpEmail(employee.getEmpEmail());
		toUpdate.setEmpDesignation(employee.getEmpDesignation());
		toUpdate.setEmpDepartment(employee.getEmpDepartment());
		toUpdate.setEmpProjectName(employee.getEmpProjectName());
		toUpdate.setSupervisorName(employee.getSupervisorName());
		toUpdate.setEmpAddress(employee.getEmpAddress());
		toUpdate.setEmpPassword(employee.getEmpPassword());
		toUpdate.setProjectId(employee.getProjectId());
		return employeerepository.save(toUpdate);
	}

}
