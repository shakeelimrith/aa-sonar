package com.accenture.academy.buildandunittest.assignment.student;

public class StudentBean {

	/** Id. */
	private Integer studentId;

	/** First Name. */
	private String studentFirstName;

	/** Last Name. */
	private String studentLastName;

	/** Marks for the assignment on a total of 100 marks (Example : 82/100). */
	private Double assignmentMarks;

	/** Marks for the exams on a total of 100 marks (Example : 92/100). */
	private Double examsMarks;

	/** The total marks calculated as 40% of assignment + 60% of exams. */
	private Double totalMarks;

	/** The Grade. */
	private Character grade;

	/**
	 * Getter for studentId.
	 * 
	 * @return the studentId
	 */
	public final Integer getStudentId() {
		return studentId;
	}

	/**
	 * Setter for studentId.
	 * 
	 * @param studentId
	 *            the studentId to set
	 */
	public final void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * Getter for studentFirstName.
	 * 
	 * @return the studentFirstName
	 */
	public final String getStudentFirstName() {
		return studentFirstName;
	}

	/**
	 * Setter for studentFirstName.
	 * 
	 * @param studentFirstName
	 *            the studentFirstName to set
	 */
	public final void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	/**
	 * Getter for studentLastName.
	 * 
	 * @return the studentLastName
	 */
	public final String getStudentLastName() {
		return studentLastName;
	}

	/**
	 * Setter for studentLastName.
	 * 
	 * @param studentLastName
	 *            the studentLastName to set
	 */
	public final void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	/**
	 * Getter for assignmentMarks.
	 * 
	 * @return the assignmentMarks
	 */
	public final Double getAssignmentMarks() {
		return assignmentMarks;
	}

	/**
	 * Setter for assignmentMarks.
	 * 
	 * @param assignmentMarks
	 *            the assignmentMarks to set
	 */
	public final void setAssignmentMarks(Double assignmentMarks) {
		this.assignmentMarks = assignmentMarks;
	}

	/**
	 * Getter for examsMarks.
	 * 
	 * @return the examsMarks
	 */
	public final Double getExamsMarks() {
		return examsMarks;
	}

	/**
	 * Setter for examsMarks.
	 * 
	 * @param examsMarks
	 *            the examsMarks to set
	 */
	public final void setExamsMarks(Double examsMarks) {
		this.examsMarks = examsMarks;
	}

	/**
	 * Getter for totalMarks.
	 * 
	 * @return the totalMarks
	 */
	public final Double getTotalMarks() {
		return totalMarks;
	}

	/**
	 * Setter for totalMarks.
	 * 
	 * @param totalMarks
	 *            the totalMarks to set
	 */
	public final void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}

	/**
	 * Getter for grade.
	 * 
	 * @return the grade
	 */
	public final Character getGrade() {
		return grade;
	}

	/**
	 * Setter for grade.
	 * 
	 * @param grade
	 *            the grade to set
	 */
	public final void setGrade(Character grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return studentId + studentFirstName + studentLastName;
	}

	@Override
	public int hashCode() {
		return studentId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StudentBean) {
			final StudentBean bean = (StudentBean) obj;

			return studentId == bean.getStudentId();
		}
		return false;
	}

}