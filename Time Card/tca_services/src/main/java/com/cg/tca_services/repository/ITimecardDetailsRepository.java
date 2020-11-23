package com.cg.tca_services.repository;

import java.util.List;
import com.cg.tca_services.entities.TimecardDetails;

//This Interface holds the structure of EmployeeRepository
public interface ITimecardDetailsRepository {

	/*
	 * This method finds time card entry details using projectId 
	 * parameter passed : projectId
	 */
	public TimecardDetails findTimecardDetailsById(int projectId);

	/*
	 * This method is used to add or save time card entry details in time card
	 * details table parameter passed : timecard
	 */
	public void addTimecardDetails(TimecardDetails timecard);

	/*
	 * This method finds time card details of an employee using employeeId parameter
	 * passed : employeeId
	 */
	public List<TimecardDetails> findTimecardDetailsByEmployeeId(long employeeId);

	/*
	 * This method updates time card entry details and manages time card status
	 */
	public void updateTimecardStatus(TimecardDetails timecard, String timecardStatus);

	/*
	 * Used to begin action in database
	 */
	public void beginTransaction();

	/*
	 * Used to commit action in database
	 */
	public void commitTransaction();
}