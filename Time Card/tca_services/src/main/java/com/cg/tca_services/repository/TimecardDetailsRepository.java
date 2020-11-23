package com.cg.tca_services.repository;

import com.cg.tca_services.entities.TimecardDetails;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TimecardDetailsRepository implements ITimecardDetailsRepository {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public TimecardDetailsRepository() {
		entityManagerFactory = JPAUtil.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public TimecardDetails findTimecardDetailsById(int projectId) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class, projectId);
		return entity;
	}

	@Override
	public List<TimecardDetails> findTimecardDetailsByEmployeeId(long employeeId) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class, employeeId);
		List<TimecardDetails> timecard = new ArrayList<>();

		timecard.add(entity);
		return timecard;
	}

	@Override
	public void addTimecardDetails(TimecardDetails timecard) {
		entityManager.getTransaction().begin();
		entityManager.persist(timecard);
		entityManager.getTransaction().commit();
		// entityManager.close();
	}

	@Override
	public void updateTimecardStatus(TimecardDetails timecard, String timecardStatus) {
		TimecardDetails entity = entityManager.find(TimecardDetails.class, timecard.getProjectId());
		if (entity.getTimecardStatus().equalsIgnoreCase("Pending")) {
			entityManager.getTransaction().begin();
			entity.setTimecardStatus(timecardStatus);
			entityManager.getTransaction().commit();
		}
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