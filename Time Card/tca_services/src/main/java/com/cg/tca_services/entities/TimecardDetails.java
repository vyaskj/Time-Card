package com.cg.tca_services.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Annotation Entity : to represent objects in the database*/
@Entity
public class TimecardDetails {
	/*
	 * Annotation @Id: Specifies the primary key of an entity
	 */
	@Id
	/*
	 * Provides for the specification of generation strategies for the values of
	 * primary keys
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private int hours;
	private String date;
	private String projectName;
	private String taskName;
	private String timecardStatus;

	/*
	 * cardinality that refers to the relationship between two entities
	 */
	@ManyToOne

	/*
	 * This annotation helps us specify the column we'll use for joining an entity
	 * association or element collection
	 */ @JoinColumn(name = "empId")
	private Employees employee;

	/*
	 * Create getters and Setters
	 */
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTimecardStatus() {
		return timecardStatus;
	}

	public void setTimecardStatus(String timecardStatus) {
		this.timecardStatus = timecardStatus;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TimecardDetails [projectId=" + projectId + ", hours=" + hours + ", date=" + date + ", projectName="
				+ projectName + ", taskName=" + taskName + ", timecardStatus=" + timecardStatus + ", employee="
				+ employee + "]";
	}
}