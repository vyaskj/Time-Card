package com.cg.tca_services.repository;

import java.util.List;
import com.cg.tca_services.entities.Employees;

//This Interface holds the structure of EmployeeRepository

public interface IEmployeeRepository {

	/*
	 * This method finds employees using their ID 
	 * parameter passed : empId
	 */
	public Employees findEmployeeById(long empId);

	/*
	 * This method is used to add or save emplyoee details in employee table
	 * parameter passed : employee
	 */
	public void addEmployee(Employees employee);

	/*
	 * This method is used to find employee details working under a particular
	 * supervisor parameter passed :supervisorId
	 */
	public List<Employees> findEmployeesUnderSupervisor(long supervisorId);

	/*
	 * Used to begin action in database
	 */
	public void beginTransaction();

	/*
	 * Used to commit the action in database
	 */
	public void commitTransaction();
}