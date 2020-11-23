package com.cg.tca_services.services;

import com.cg.tca_services.entities.Employees;
import com.cg.tca_services.entities.TimecardDetails;

import java.util.List;
//This Interface holds the structure of EmployeeServices
public interface IEmployeeService {
	/*
	 * This method shows employees using their ID parameter passed : empId
	 */
	public Employees viewEmployeeById(long empId);

	/*
	 * This method adds or saves employees details parameter passed : empId
	 */
	public void addEmployee(Employees employee);

	/*
	 * Checks if it is non negative or not
	 */
	public boolean validateEmployeeById(long empId);

	/*
	 * Displays all employess under particular supervisor
	 */
	public List<Employees> viewEmployeesUnderSupervisor(long supervisorId);

	/*
	 * validates supervisorId
	 */
	public boolean validateSupervisor(long SupervisorId);

	/*
	 * Displays time card details of a particular employee
	 */
	public List<TimecardDetails> viewTimecardByEmpId(long empId);
}