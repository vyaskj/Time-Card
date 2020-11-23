package com.cg.tca_services.exceptions;

public class EmployeeCannotBeOwnSupervisor extends Exception {
	private static final long serialVersionUID = 1L;

	public EmployeeCannotBeOwnSupervisor() {
		super();
	}

	public EmployeeCannotBeOwnSupervisor(String message) {
		super(message);
	}

}
