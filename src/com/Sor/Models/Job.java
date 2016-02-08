package com.Sor.Models;

import java.util.Objects;

public class Job {
	private String jobId = null;
	private String jobName = null;
	private String jobCareerLevel = null;
	private String jobSalary = null;

	/**
	 * Unique identifier.
	 **/

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * the name of the job
	 **/

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * 1 for beginner, 2 for advance, 3 for expert
	 **/

	public String getJobCareerLevel() {
		return jobCareerLevel;
	}

	public void setJobCareerLevel(String jobCareerLevel) {
		this.jobCareerLevel = jobCareerLevel;
	}

	/**
	 * min-max salary wanted(can be empty)
	 **/

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Job job = (Job) o;
		return Objects.equals(jobId, job.jobId) && Objects.equals(jobName, job.jobName)
				&& Objects.equals(jobCareerLevel, job.jobCareerLevel) && Objects.equals(jobSalary, job.jobSalary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobId, jobName, jobCareerLevel, jobSalary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Job {\n");

		sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
		sb.append("    jobName: ").append(toIndentedString(jobName)).append("\n");
		sb.append("    jobCareerLevel: ").append(toIndentedString(jobCareerLevel)).append("\n");
		sb.append("    jobSalary: ").append(toIndentedString(jobSalary)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
