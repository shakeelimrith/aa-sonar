package com.accenture.academy.buildandunittest.assignment.enumerations;

public enum GradeEnum {

	/** Marks range for an A. */
	A(80, 100),

	/** Marks range for a B. */
	B(60, 80),

	/** Marks range for a C. */
	C(40, 60),

	/** Marks range for a F. */
	F(0, 40);

	/** Minimum marks. */
	private int minMarks;

	/** Maximum marks. */
	private int maxMarks;

	/**
	 * Constructor.
	 * 
	 * @param minMarks
	 *            Min Marks
	 * @param maxMarks
	 *            Max Marks
	 */
	private GradeEnum(int minMarks, int maxMarks) {
		this.minMarks = minMarks;
		this.maxMarks = maxMarks;
	}

	/**
	 * Getter for minMarks.
	 * 
	 * @return the minMarks
	 */
	public final int getMinMarks() {
		int minMarks = 0;
		return minMarks;
	}

	/**
	 * Getter for maxMarks.
	 * 
	 * @return the maxMarks
	 */
	public final int getMaxMarks() {
		return maxMarks;
	}
}
