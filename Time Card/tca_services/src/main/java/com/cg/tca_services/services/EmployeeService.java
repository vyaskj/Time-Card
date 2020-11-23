package com.cg.tca_services.services;

import java.util.ArrayList;
import java.util.List;
import com.cg.tca_services.entities.Employees;
import com.cg.tca_services.entities.TimecardDetails;
import com.cg.tca_services.repository.EmployeeRepository;
import com.cg.tca_services.repository.*;

public class EmployeeService implements IEmployeeService {
	private IEmployeeRepository repo;

	public EmployeeService() {
		repo = new EmployeeRepository();
	}

	@Override
	public Employees viewEmployeeById(long empId) {
		Employees emp = repo.findEmployeeById(empId);
		return emp;
	}

	@Override
	public void addEmployee(Employees employee) {
		repo.addEmployee(employee);
	}

	@Override
	public boolean validateEmployeeById(long empId) {
		if (empId > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employees> viewEmployeesUnderSupervisor(long supervisorId) {
		List<Employees> emp = repo.findEmployeesUnderSupervisor(supervisorId);
		return emp;
	}

	@Override
	public boolean validateSupervisor(long supervisorId) {
		List<Employees> emp = new ArrayList<>();
		for (Employees e : emp) {
			if (e.getEmpId() != e.getSupervisorId()) {
				if (e.getEmpId() == supervisorId) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public List<TimecardDetails> viewTimecardByEmpId(long empId) {
		Employees emp = viewEmployeeById(empId);
		List<TimecardDetails> timecard = emp.getTimecard();
		return timecard;
	}

}