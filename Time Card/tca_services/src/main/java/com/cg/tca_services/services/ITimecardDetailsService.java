package com.cg.tca_services.services;

import com.cg.tca_services.entities.TimecardDetails;
import java.util.List;

//This Interface holds the structure of Time card details service
public interface ITimecardDetailsService {
	/*
	 * Calling add time card details method
	 */
	public void addTimecardDetails(TimecardDetails timecard);

	/*
	 * calling update time card status method
	 */
	public void updateTimecardStatus(TimecardDetails timecard, String timecardStatus);

	/*
	 * Calling time card details of an employee by his/her Id
	 */
	public List<TimecardDetails> viewTimecardDetailsByEmployeeId(long employeeId);
}