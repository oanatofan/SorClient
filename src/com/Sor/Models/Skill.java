package com.Sor.Models;

import java.util.Objects;

public class Skill {
	private String skillId = null;
	private String skillName = null;
	private String jobId = null;
	private String experience = null;

	/**
	 * Unique identifier.
	 **/

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	/**
	 * the name of the skill
	 **/

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * for what jobs is this skill asked(can be empty)
	 **/

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * 1 for beginner, 2 for advance, 3 for expert
	 **/

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Skill knowledge = (Skill) o;
		return Objects.equals(skillId, knowledge.skillId)
				&& Objects.equals(skillName, knowledge.skillName) && Objects.equals(jobId, knowledge.jobId)
				&& Objects.equals(experience, knowledge.experience);
	}

	@Override
	public int hashCode() {
		return Objects.hash(skillId, skillName, jobId, experience);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Knowledge {\n");

		sb.append("    skillId: ").append(toIndentedString(skillId)).append("\n");
		sb.append("    skillName: ").append(toIndentedString(skillName)).append("\n");
		sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
		sb.append("    experience: ").append(toIndentedString(experience)).append("\n");
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
