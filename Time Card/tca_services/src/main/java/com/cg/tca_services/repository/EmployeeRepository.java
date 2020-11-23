package com.cg.tca_services.repository;

import com.cg.tca_services.entities.Employees;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EmployeeRepository implements IEmployeeRepository {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EmployeeRepository() {
		entityManagerFactory = JPAUtil.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Employees findEmployeeById(long empId) {
		entityManager.getTransaction().begin();
		Employees entity = entityManager.find(Employees.class, empId);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public void addEmployee(Employees employee) {
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<Employees> findEmployeesUnderSupervisor(long Id) {

		Query q = entityManager.createNativeQuery("SELECT a.* FROM Employees a where a.supervisorId = ? ",
				Employees.class);
		q.setParameter(1, Long.valueOf(Id));
		List<Employees> employees = q.getResultList();

		return employees;
	}

	@Override
	public void beginTransaction() {

		entityManager.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}
}