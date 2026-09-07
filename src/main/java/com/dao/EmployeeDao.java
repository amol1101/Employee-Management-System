package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {
	public int addEmployee(Employee addEmp);
	public int deleteEmployee(int id);
	public int updateEmployee(Employee updateEmp);
	public List<Employee> showEmpList();
	public Employee findEmp(int id);
	
		
}
