package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Employee;
import com.util.DBUtility;

public class EmployeeDaoImpl  implements EmployeeDao{

	@Override
	public int addEmployee(Employee addEmp) {
		int res=0;
		try {
		Connection con = DBUtility.getConnection();
		
		String sql = "INSERT INTO employee (id,name,salery) VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, addEmp.getId());
		ps.setString(2, addEmp.getName());
		ps.setDouble(3, addEmp.getSalery());
		
		 res = ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return res;
	}

	@Override
	public int deleteEmployee(int id) {
		int res=0;
		try {
		Connection con = DBUtility.getConnection();
		
		String sql = "DELETE FROM employee WHERE id =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		res = ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return res;
	}
	@Override
	public int updateEmployee(Employee updateEmp) {
		int res=0;
		try {
		Connection con = DBUtility.getConnection();

		String sql = "UPDATE employee SET name = ?, salery = ?  WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, updateEmp.getName());
		ps.setDouble(2, updateEmp.getSalery());
		ps.setInt(3, updateEmp.getId());
		
		 res = ps.executeUpdate();

		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return res;
	}

	@Override
	public List<Employee> showEmpList() {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			Connection con = DBUtility.getConnection();
			
			String sql = "SELECT * FROM employee";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalery(rs.getDouble(3));
				
				empList.add(emp);
			}
		}catch (SQLException e) {
			e.getStackTrace();
			
		}
	
		return empList;
	}

	@Override
	public Employee findEmp(int id) {
		Employee  emp = new Employee();
		
		try {
			Connection con = DBUtility.getConnection();
			String sql = "SELECT * FROM employee WHERE id = ?";
			PreparedStatement ps =  con.prepareStatement(sql);
		
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {			
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalery(rs.getDouble(3));
			}
			else 
				return null;
			
			
		}catch(SQLException e) {
			e.getStackTrace();
		}
		
		 return emp;
	}
	
	
	

}
